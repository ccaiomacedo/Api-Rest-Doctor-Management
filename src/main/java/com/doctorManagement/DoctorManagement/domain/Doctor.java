package com.doctorManagement.DoctorManagement.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
public class Doctor implements Serializable {
    private static final long serialVersionUID=1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private long CRM;

    private long landline;

    private long cellPhone;

    private Cep cep;

    @OneToMany()
    @JoinColumn(name="medicalSpecialty_id")
    private List<MedicalSpecialty> medicalSpecialty = new ArrayList<>();

    public Doctor(){

    }
    public Doctor(Integer id, String name, long CRM, long landline, long cellPhone, Cep cep) {
        this.id = id;
        this.name = name;
        this.CRM = CRM;
        this.landline = landline;
        this.cellPhone = cellPhone;
        this.cep = cep;
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

    public long getCRM() {
        return CRM;
    }

    public void setCRM(long CRM) {
        this.CRM = CRM;
    }

    public long getLandline() {
        return landline;
    }

    public void setLandline(long landline) {
        this.landline = landline;
    }

    public long getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(long cellPhone) {
        this.cellPhone = cellPhone;
    }

    public Cep getCep() {
        return cep;
    }

    public void setCep(Cep cep) {
        this.cep = cep;
    }

    public List<MedicalSpecialty> getMedicalSpecialty() {
        return medicalSpecialty;
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
