package com.Tc_traveler.PDSDS.service;

import com.Tc_traveler.PDSDS.entity.Administrator;
import com.Tc_traveler.PDSDS.entity.Doctor;
import com.Tc_traveler.PDSDS.entity.Patient;

public interface UserService {
    Doctor findByDoctorName(String username);

    void registerDoctor(String username, String password);

    Patient findByPatientName(String username);

    void registerPatient(String username, String password);

    Administrator findByAdministratorName(String username);
}
