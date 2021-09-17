package com.doctorManagement.DoctorManagement.service;

import com.doctorManagement.DoctorManagement.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {

    @Autowired
    DoctorRepository doctorRepository;

    public void instantiateTestDatabase(){


    }

}
