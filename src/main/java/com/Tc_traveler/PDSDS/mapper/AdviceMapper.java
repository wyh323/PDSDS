package com.Tc_traveler.PDSDS.mapper;

import com.Tc_traveler.PDSDS.entity.Advice;
import com.Tc_traveler.PDSDS.entity.AdviceBack;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdviceMapper {

    @Insert("insert into advice(title, content, photo) "+"values (#{title},#{content},#{downloadUrl})")
    void addAdvice(String title, String content, String downloadUrl);

    @Select("select id,title,photo from advice")
    List<AdviceBack> getAllAdvice();

    @Select("select * from advice where id=#{id}")
    Advice getAdvice(int id);

    @Delete("delete from advice where id=#{id}")
    void deleteAdvice(int id);

    @Update("update advice set title=#{title} where id=#{id}")
    void updateTitle(int id, String title);

    @Update("update advice set content=#{content} where id=#{id}")
    void updateContent(int id, String content);

    @Update("update advice set photo=#{newUrl} where id=#{id}")
    void updatePhoto(int id, String newUrl);
}
