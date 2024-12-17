package com.Tc_traveler.PDSDS.service;

import com.Tc_traveler.PDSDS.entity.Doctor;

public interface MailService {
    Doctor findByDoctorEmail(String email);

    void getCode(String email);
}
