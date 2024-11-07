package com.Tc_traveler.PDSDS.service;

import com.Tc_traveler.PDSDS.entity.Doctor;
import com.Tc_traveler.PDSDS.entity.Patient;

public interface UserService {
    Doctor findByDoctorName(String username);

    void registerUser(String username, String password);

    Patient findByPatientName(String username);
}
