package com.doctorManagement.DoctorManagement.repository;

import com.doctorManagement.DoctorManagement.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Integer>{


    List<Doctor> findByNameIgnoreCase(String name);

    Doctor findByCrm(Integer crm);

    Doctor findByCellPhone(Long cellPhone);

    Doctor findByLandline(Long landline);

    List<Doctor> findByLogradouroIgnoreCase(String logradouro);

    List<Doctor>  findByCep(Integer cep);

    List<Doctor> findByUfIgnoreCase(String uf);

    List<Doctor>  findByLocalidadeIgnoreCase(String localidade);

    List<Doctor>  findByBairroIgnoreCase(String bairro);

}
