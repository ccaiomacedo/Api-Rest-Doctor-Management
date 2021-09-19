package com.doctorManagement.DoctorManagement.domain;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "tb_doctor")
@SQLDelete(sql = "update tb_doctor SET deleted = true WHERE id=?")
@Where(clause ="deleted=false")
public class Doctor implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer crm;

    private long landline;

    private long cellPhone;

    private Integer cep;

    private boolean deleted = Boolean.FALSE;

    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;



    @ManyToMany()
    @JoinTable(name = "tb_doctor_medicalSpecialty", joinColumns = @JoinColumn(name = "doctor_id"), inverseJoinColumns = @JoinColumn(name = "medicalSpecialty_id"))
    private Set<MedicalSpecialty> medicalSpecialty= new HashSet<>();

    public Doctor(){

    }

    public Doctor(Integer id, String name, Integer crm, long landline, long cellPhone, Integer cep, String logradouro,String bairro, String localidade, String uf) {
        this.id = id;
        this.name = name;
        this.crm = crm;
        this.landline = landline;
        this.cellPhone = cellPhone;
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
    }

    public Doctor(Integer id, String name, Integer crm, long landline, long cellPhone, Integer cep,Set<MedicalSpecialty> medicalSpecialty) {
        this.id = id;
        this.name = name;
        this.crm = crm;
        this.landline = landline;
        this.cellPhone = cellPhone;
        this.cep = cep;
        this.medicalSpecialty = medicalSpecialty;
    }

    public Doctor(Integer id, String name, Integer crm, long landline, long cellPhone, Integer cep) {
        this.id = id;
        this.name = name;
        this.crm = crm;
        this.landline = landline;
        this.cellPhone = cellPhone;
        this.cep = cep;
    }

    public boolean isDeleted() {
        return deleted;
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

    public Integer getCrm() {
        return crm;
    }

    public void setCrm(Integer crm) {
        this.crm = crm;
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

    public void setMedicalSpecialty(Set<MedicalSpecialty> medicalSpecialty) {
        this.medicalSpecialty = medicalSpecialty;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }


    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
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
