package com.Tc_traveler.PDSDS.service;

import com.Tc_traveler.PDSDS.dto.Result;
import com.Tc_traveler.PDSDS.entity.*;
import com.Tc_traveler.PDSDS.entity.table.CES_D;
import com.Tc_traveler.PDSDS.entity.table.MADRS;
import com.Tc_traveler.PDSDS.entity.table.SDS;
import jakarta.validation.constraints.Pattern;
import lombok.NonNull;
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

    Patient findPatientByUsernameAndDoctorId(@Pattern(regexp = "^\\S{1,15}$") String username, Integer doctorId);

    void deletePatient(@Pattern(regexp = "^\\S{1,15}$") String username, Integer doctorId);

    Patient findByPatientId();

    List<Patient> findAllPatient();

    void deleteDoctor(@Pattern(regexp = "^\\S{1,15}$") String username);

    List<Patient> getLastPatient();

    void choosePatient(Patient patient);

    void addOrder(@NonNull Integer id, String order);

    Consequence findConsequenceByPatientId(int patientId);

    void updateOrder(@NonNull Integer id, String order);

    Doctor findByDoctor_1Name(@Pattern(regexp = "^\\S{1,15}$") String username);

    List<Doctor> getAllDoctor_1();

    void deleteDoctor_1(String username);

    void checkDoctor(Doctor doctor);

    Mail findMailByEmail(String email);

    void deleteMail(String email);

    void resetPwd(String email, String newPwd);
}
