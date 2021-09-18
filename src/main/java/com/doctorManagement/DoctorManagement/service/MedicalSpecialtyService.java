package com.doctorManagement.DoctorManagement.service;

import com.doctorManagement.DoctorManagement.domain.MedicalSpecialty;
import com.doctorManagement.DoctorManagement.repository.MedicalSpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalSpecialtyService {

    @Autowired
    MedicalSpecialtyRepository medicalSpecialtyRepository;


    public List<MedicalSpecialty> findAll(){
        return medicalSpecialtyRepository.findAll();
    }


}
