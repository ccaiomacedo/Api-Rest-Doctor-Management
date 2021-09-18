package com.doctorManagement.DoctorManagement.repository;

import com.doctorManagement.DoctorManagement.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor,Integer>{


    Optional<Doctor> findByNameIgnoreCase(String name);

    Doctor findByCrm(Integer crm);

    Doctor findByCellPhone(Long cellPhone);

    Doctor findByLandline(Long landline);

    Optional<Doctor> findByLogradouroIgnoreCase(String logradouro);

    Optional<Doctor>  findByCep(Integer cep);

    Optional<Doctor> findByUfIgnoreCase(String uf);

    Optional<Doctor>  findByLocalidadeIgnoreCase(String localidade);

    Optional<Doctor>  findByBairroIgnoreCase(String bairro);


}
