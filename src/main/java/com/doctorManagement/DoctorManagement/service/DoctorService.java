package com.doctorManagement.DoctorManagement.service;

import com.doctorManagement.DoctorManagement.domain.Doctor;
import com.doctorManagement.DoctorManagement.repository.DoctorRepository;
import com.doctorManagement.DoctorManagement.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    public DoctorRepository doctorRepository;

    public Doctor find(Integer id){
        Optional<Doctor> obj = doctorRepository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException(
                "Objeto não encontrado! Id: "+id+", Tipo: "+Doctor.class.getName()));
    }

    public List<Doctor> findAll(){
        return doctorRepository.findAll();
    }

}
