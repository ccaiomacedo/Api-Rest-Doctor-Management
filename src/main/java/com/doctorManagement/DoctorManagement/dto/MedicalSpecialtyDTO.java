package com.doctorManagement.DoctorManagement.dto;

import com.doctorManagement.DoctorManagement.domain.MedicalSpecialty;

public class MedicalSpecialtyDTO {

    private Integer id;
    private String name;

    public MedicalSpecialtyDTO(){

    }

    public MedicalSpecialtyDTO(MedicalSpecialty medicalSpecialty) {
        id = medicalSpecialty.getId();
        name = medicalSpecialty.getName();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
