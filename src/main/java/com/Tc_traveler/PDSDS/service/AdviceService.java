package com.Tc_traveler.PDSDS.service;

import com.Tc_traveler.PDSDS.entity.Advice;
import com.Tc_traveler.PDSDS.entity.AdviceBack;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface AdviceService {

    void addAdvice(String title, String content, MultipartFile photo) throws IOException;

    List<AdviceBack> getAllAdvice();

    Advice getAdvice(int id);

    void deleteAdvice(int id, String photo);

    void updateAdvice(int id, String title, String content, MultipartFile photo, Advice advice) throws IOException;

}
