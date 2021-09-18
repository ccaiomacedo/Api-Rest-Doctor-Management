package com.doctorManagement.DoctorManagement.repository;

import com.doctorManagement.DoctorManagement.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;


//derived query
public interface DoctorRepository extends JpaRepository<Doctor,Integer>{

}
