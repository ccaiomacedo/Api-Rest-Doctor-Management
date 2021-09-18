package com.doctorManagement.DoctorManagement.dto;

import com.doctorManagement.DoctorManagement.domain.Doctor;
import com.doctorManagement.DoctorManagement.domain.MedicalSpecialty;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class DoctorDTO implements Serializable {
    private static final long serialVersionUID=1l;

    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(max=120,message = "O tamanho máximo deve ser de 120 caracteres")
    private String name;

    @NotNull(message = "Preenchimento obrigatório")
    @Digits(integer = 7,message = "O tamanho máximo deve ser de 7 caracteres",fraction = 0)
    private Integer crm;

    @Digits(integer = 15,message = "O tamanho máximo deve ser de 15 caracteres",fraction = 0)
    private long landline;

    @Digits(integer = 15,message = "O tamanho máximo deve ser de 15 caracteres",fraction = 0)
    private long cellPhone;

    @NotNull(message = "Preenchimento obrigatório")
    private Integer cep;

    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;

    private List<MedicalSpecialtyDTO> medicalSpecialty = new ArrayList<>();


    public DoctorDTO(){

    }

    public DoctorDTO(Doctor obj) {
        id= obj.getId();
        name = obj.getName();
        crm = obj.getCrm();
        landline = obj.getLandline();
        cellPhone = obj.getCellPhone();
        cep = obj.getCep();
        logradouro = obj.getLogradouro();
        bairro = obj.getBairro();
        localidade = obj.getLocalidade();
        uf = obj.getUf();
    }
    public DoctorDTO(Doctor doctor, Set<MedicalSpecialty> medicalSpecialty){
        this(doctor);
        medicalSpecialty.forEach(x -> this.medicalSpecialty.add(new MedicalSpecialtyDTO(x)));
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


    public List<MedicalSpecialtyDTO> getMedicalSpecialty() {
        return medicalSpecialty;
    }
}
