package com.doctorManagement.DoctorManagement.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;


@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Long CRM;

    private Long landline;

    private Long cellPhone;
    private Long cep;

    private String medicalSpecialty;

    public Doctor(){

    }
    public Doctor(Integer id, String name, Long CRM, Long landline, Long cellPhone, Long cep, String medicalSpecialty) {
        this.id = id;
        this.name = name;
        this.CRM = CRM;
        this.landline = landline;
        this.cellPhone = cellPhone;
        this.cep = cep;
        this.medicalSpecialty = medicalSpecialty;
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

    public Long getCRM() {
        return CRM;
    }

    public void setCRM(Long CRM) {
        this.CRM = CRM;
    }

    public Long getLandline() {
        return landline;
    }

    public void setLandline(Long landline) {
        this.landline = landline;
    }

    public Long getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(Long cellPhone) {
        this.cellPhone = cellPhone;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public String getMedicalSpecialty() {
        return medicalSpecialty;
    }

    public void setMedicalSpecialty(String medicalSpecialty) {
        this.medicalSpecialty = medicalSpecialty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return id.equals(doctor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
