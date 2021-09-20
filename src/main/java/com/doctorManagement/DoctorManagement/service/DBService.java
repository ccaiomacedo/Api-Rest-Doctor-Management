package com.doctorManagement.DoctorManagement.service;

import com.doctorManagement.DoctorManagement.domain.Doctor;
import com.doctorManagement.DoctorManagement.domain.MedicalSpecialty;
import com.doctorManagement.DoctorManagement.dto.DoctorDTO;
import com.doctorManagement.DoctorManagement.repository.MedicalSpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

//Testes pra mandar dados pro banco de dados
@Service
public class DBService {

    @Autowired
    DoctorService doctorService;

    @Autowired
    MedicalSpecialtyRepository medicalSpecialtyRepository;


    public void instantiateTestDatabase(){

        Set<MedicalSpecialty> medicalSpecialtySet1 = new HashSet<>();
        Set<MedicalSpecialty> medicalSpecialtySet2 = new HashSet<>();

        MedicalSpecialty medicalSpecialty = new MedicalSpecialty(null,"Alergologia");
        MedicalSpecialty medicalSpecialty2 = new MedicalSpecialty(null,"Angiologia");
        MedicalSpecialty medicalSpecialty3 = new MedicalSpecialty(null,"Buco maxilo");
        MedicalSpecialty medicalSpecialty4 = new MedicalSpecialty(null,"Cardiologia clínica");
        MedicalSpecialty medicalSpecialty5 = new MedicalSpecialty(null,"Cardiologia infantil");
        MedicalSpecialty medicalSpecialty6 = new MedicalSpecialty(null,"Cirurgia cabeça e pescoço");
        MedicalSpecialty medicalSpecialty7 = new MedicalSpecialty(null,"Cirurgia cardiaca");
        MedicalSpecialty medicalSpecialty8 = new MedicalSpecialty(null,"Cirurgia de toráx");


        medicalSpecialtySet1.add(medicalSpecialty);
        medicalSpecialtySet1.add(medicalSpecialty2);
        medicalSpecialtySet1.add(medicalSpecialty3);
        medicalSpecialtySet1.add(medicalSpecialty4);

        medicalSpecialtySet2.add(medicalSpecialty5);
        medicalSpecialtySet2.add(medicalSpecialty6);
        medicalSpecialtySet2.add(medicalSpecialty7);
        medicalSpecialtySet2.add(medicalSpecialty8);

        medicalSpecialtyRepository.save(medicalSpecialty);
        medicalSpecialtyRepository.save(medicalSpecialty2);
        medicalSpecialtyRepository.save(medicalSpecialty3);
        medicalSpecialtyRepository.save(medicalSpecialty4);
        medicalSpecialtyRepository.save(medicalSpecialty5);
        medicalSpecialtyRepository.save(medicalSpecialty6);
        medicalSpecialtyRepository.save(medicalSpecialty7);
        medicalSpecialtyRepository.save(medicalSpecialty8);


        Doctor doctor = new Doctor(null,"Caio", 4234, 33423424, 999568540,41720100);
        DoctorDTO doctorDTO= new DoctorDTO(doctor,medicalSpecialtySet1);

        Doctor doctor2 = new Doctor(null,"Leonardo", 5435, 33978976, 995976459, 60874648);
        DoctorDTO doctorDTO2 = new DoctorDTO(doctor2,medicalSpecialtySet2);

        doctorService.insert(doctorDTO);
        doctorService.insert(doctorDTO2);

    }

}
