package com.doctorManagement.DoctorManagement.domain;



import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


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



    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "tb_doctor_medicalSpecialty", joinColumns = @JoinColumn(name = "doctor_id"), inverseJoinColumns = @JoinColumn(name = "medicalSpecialty_id"))
    private Set<MedicalSpecialty> medicalSpecialty= new HashSet<>();

    public Doctor(){

    }
    public Doctor(Integer id, String name, long CRM, long landline, long cellPhone,Set<MedicalSpecialty> medicalSpecialty) {
        this.id = id;
        this.name = name;
        this.CRM = CRM;
        this.landline = landline;
        this.cellPhone = cellPhone;
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


    public Set<MedicalSpecialty> getMedicalSpecialty() {
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
