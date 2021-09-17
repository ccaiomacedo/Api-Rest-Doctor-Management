package com.doctorManagement.DoctorManagement.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class MedicalSpecialty implements Serializable {
    private static final long serialVersionUID=1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany( mappedBy = "medicalSpecialty")
    private Set<Doctor> doctors = new HashSet<>();


    public MedicalSpecialty(){

    }

    public MedicalSpecialty(Integer id, String name,Set<Doctor> doctors) {
        this.id = id;
        this.name = name;
        this.doctors = doctors;
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

    public Set<Doctor> getDoctors() {
        return doctors;
    }
}
