package com.Tc_traveler.PDSDS.service.impl;

import cn.hutool.core.codec.Base64;
import cn.hutool.http.HttpUtil;
import cn.hutool.http.Method;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.Tc_traveler.PDSDS.entity.Advice;
import com.Tc_traveler.PDSDS.entity.AdviceBack;
import com.Tc_traveler.PDSDS.mapper.AdviceMapper;
import com.Tc_traveler.PDSDS.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class AdviceServiceImpl implements AdviceService {

    @Value("${gitee.ACCESS_TOKEN}")
    private String accessToken;

    @Value("${gitee.OWNER}")
    private String owner;

    @Value("${gitee.REPO}")
    private String repo;

    @Value("${gitee.ADD_MESSAGE}")
    private String addMessage;

    @Value("${gitee.DEL_MESSAGE}")
    private String delMessage;

    @Autowired
    private AdviceMapper adviceMapper;

    private Map<String,Object> getUploadBodyMap(byte[] multipartFile){
        HashMap<String,Object> map = new HashMap<>(3);
        map.put("access_token",accessToken);
        map.put("message",addMessage);
        map.put("content", Base64.encode(multipartFile));
        return map;
    }

    private String createUploadFileUrl(MultipartFile file) {
        String filename = file.getOriginalFilename();
        if (filename != null) {
            String suffix = filename.substring(filename.lastIndexOf("."));
            String newFileName = System.currentTimeMillis()+"_"+ UUID.randomUUID() +suffix;
            return "https://gitee.com/api/v5/repos/"+owner+"/"+repo+"/contents/"+newFileName;
        }
        return null;
    }

    private String createDelFileUrl(String path) {
        return "https://gitee.com/api/v5/repos/"+owner+"/"+repo+"/contents/"+path;
    }

    private Map<String,Object> getCommonBodyMap(HashMap<String,Object> map,String message){
        HashMap<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("access_token", accessToken);
        bodyMap.put("message", message);
        if (map != null){
            bodyMap.putAll(map);
        }
        return bodyMap;
    }

    private String getSha(String path){
        String getShaUrl = createDelFileUrl(path);
        return HttpUtil.createRequest(Method.GET,getShaUrl).form(getCommonBodyMap(null,"get sha!")).execute().body();
    }

    private String deleteFile(String path,String sha){
        String delFileUrl = createDelFileUrl(path);
        HashMap<String, Object> needMap = new HashMap<>(1);
        needMap.put("sha",sha);//添加sha参数
        return HttpUtil.createRequest(Method.DELETE, delFileUrl)
                .form(getCommonBodyMap(needMap,"del file!"))  //构建请求表单
                .execute().body();
    }

    @Override
    public void addAdvice(String title, String content, MultipartFile photo) throws IOException {
        String url = createUploadFileUrl(photo);
        Map<String,Object> uploadBodyMap = getUploadBodyMap(photo.getBytes());
        String JSONResult = HttpUtil.post(url,uploadBodyMap);
        JSONObject jsonObject = JSONUtil.parseObj(JSONResult);
        if (jsonObject.getObj("commit") == null){
            throw new RuntimeException("请求失败");
        }
        String downloadUrl = (String) JSONUtil.parseObj(jsonObject.getObj("content")).getObj("download_url");
        adviceMapper.addAdvice(title,content,downloadUrl);
    }

    @Override
    public List<AdviceBack> getAllAdvice() {
        return adviceMapper.getAllAdvice();
    }

    @Override
    public Advice getAdvice(int id) {
        return adviceMapper.getAdvice(id);
    }

    @Override
    public void deleteAdvice(int id, String photo) {
        String path = photo.substring(photo.indexOf("master/")+7);
        String shaResult = getSha(path);
        JSONObject jsonObject = JSONUtil.parseObj(shaResult);
        String sha = jsonObject.getStr("sha");
        String JSONResult = deleteFile(path,sha);
        jsonObject = JSONUtil.parseObj(JSONResult);
        if(jsonObject.getObj("commit") == null){
            throw new RuntimeException("删除图片失败");
        }
        adviceMapper.deleteAdvice(id);
    }

    @Override
    public void updateAdvice(int id, String title, String content, MultipartFile photo, Advice advice) throws IOException {
        if(title!=null&& !title.isEmpty()){
            adviceMapper.updateTitle(id,title);
        }
        if(content!=null&&!content.isEmpty()) {
            adviceMapper.updateContent(id,content);
        }
        if(photo!=null) {
            if(!photo.isEmpty()) {
                String photoPath = advice.getPhoto();
                String path = photoPath.substring(photoPath.indexOf("master/")+7);
                String shaResult = getSha(path);
                JSONObject jsonObject1 = JSONUtil.parseObj(shaResult);
                String sha = jsonObject1.getStr("sha");
                String JSONResult1 = deleteFile(path,sha);
                jsonObject1 = JSONUtil.parseObj(JSONResult1);
                if(jsonObject1.getObj("commit") == null){
                    throw new RuntimeException("删除图片失败");
                }
                String url = createUploadFileUrl(photo);
                Map<String,Object> uploadBodyMap = getUploadBodyMap(photo.getBytes());
                String JSONResult2 = HttpUtil.post(url,uploadBodyMap);
                JSONObject jsonObject2 = JSONUtil.parseObj(JSONResult2);
                if (jsonObject2.getObj("commit") == null){
                    throw new RuntimeException("请求失败");
                }
                String newUrl = (String) JSONUtil.parseObj(jsonObject2.getObj("content")).getObj("download_url");
                adviceMapper.updatePhoto(id,newUrl);
            }
        }
    }
    
}
