package com.Tc_traveler.PDSDS.service;

import com.Tc_traveler.PDSDS.entity.Administrator;
import com.Tc_traveler.PDSDS.entity.Doctor;
import com.Tc_traveler.PDSDS.entity.Patient;
import com.Tc_traveler.PDSDS.entity.table.CES_D;
import com.Tc_traveler.PDSDS.entity.table.MADRS;
import com.Tc_traveler.PDSDS.entity.table.SDS;
import org.hibernate.validator.constraints.URL;

import java.util.List;

public interface UserService {
    Doctor findByDoctorName(String username);

    void registerDoctor(String username, String password);

    List<Doctor> findAllDoctor();

    Patient findByPatientName(String username);

    void registerPatient(String username, String password);

    Administrator findByAdministratorName(String username);

    List<Patient> myPatientsInfo(int id);

    void update(Doctor doctor);

    void update(Patient patient);

    void updateDoctorAvatar(@URL String avatarUrl);

    void updatePatientAvatar(@URL String avatarUrl);

    void updateDoctorPwd(String newPwd);

    void updatePatientPwd(String newPwd);

    void sds(SDS sds);

    SDS findSDSByPatientId(int patient_id);

    SDS findSDSByPatientId();

    CES_D findCES_DByPatientId();

    CES_D findCES_DByPatientId(int patient_id);

    void ces_d(CES_D cesD);

    MADRS findMADRSByPatientId();

    MADRS findMADRSByPatientId(int patient_id);

    void madrs(MADRS madrs);
}
