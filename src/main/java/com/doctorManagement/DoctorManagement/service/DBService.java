package com.doctorManagement.DoctorManagement.service;

import com.doctorManagement.DoctorManagement.domain.Doctor;
import com.doctorManagement.DoctorManagement.domain.MedicalSpecialty;
import com.doctorManagement.DoctorManagement.repository.DoctorRepository;
import com.doctorManagement.DoctorManagement.repository.MedicalSpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {

    @Autowired
    MedicalSpecialtyRepository medicalSpecialtyRepository;

    @Autowired
    DoctorRepository doctorRepository;

    public void instantiateTestDatabase(){

        MedicalSpecialty medicalSpecialty = new MedicalSpecialty(null,"Alergologia");
        MedicalSpecialty medicalSpecialty2 = new MedicalSpecialty(null,"Angiologia");
        MedicalSpecialty medicalSpecialty3= new MedicalSpecialty(null,"Buco maxilo");
        MedicalSpecialty medicalSpecialty4 = new MedicalSpecialty(null,"Cardiologia clínica");
        MedicalSpecialty medicalSpecialty5= new MedicalSpecialty(null,"Cardiologia infantil");
        MedicalSpecialty medicalSpecialty6 = new MedicalSpecialty(null,"Cirurgia cardíaca");
        MedicalSpecialty medicalSpecialty7 = new MedicalSpecialty(null,"Cirurgia cabeça e pescoço");
        MedicalSpecialty medicalSpecialty8 = new MedicalSpecialty(null,"Cirurgia de tórax");

        medicalSpecialtyRepository.save(medicalSpecialty);
        medicalSpecialtyRepository.save(medicalSpecialty2);
        medicalSpecialtyRepository.save(medicalSpecialty3);
        medicalSpecialtyRepository.save(medicalSpecialty4);
        medicalSpecialtyRepository.save(medicalSpecialty5);
        medicalSpecialtyRepository.save(medicalSpecialty6);
        medicalSpecialtyRepository.save(medicalSpecialty7);
        medicalSpecialtyRepository.save(medicalSpecialty8);

        Doctor doctor = new Doctor(null,"José",4234234,78426786,43234234);
        Doctor doctor2 = new Doctor(null,"Caio",867868,786254353,432349234);

        doctorRepository.save(doctor);
        doctorRepository.save(doctor2);



    }


}
