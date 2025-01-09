package com.Tc_traveler.PDSDS.service;

import com.Tc_traveler.PDSDS.entity.Doctor;

public interface MailService {
    Doctor findDoctorByUsernameAndEmail(String username,String email);

    void getCode(String email);
}
