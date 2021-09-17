package com.doctorManagement.DoctorManagement.dto;

import com.doctorManagement.DoctorManagement.domain.Doctor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class DoctorDTO implements Serializable {
    private static final long serialVersionUID=1l;

    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(max=120,message = "O tamanho máximo deve ser de 120 caracteres")
    private String name;

    @Length(max = 7,message = "O tamanho máximo deve ser de 7 caracteres")
    private long CRM;

    private long landline;
    private long cellPhone;


    private List<MedicalSpecialtyDTO> medicalSpecialty = new ArrayList<>();


    public DoctorDTO(){

    }

    public DoctorDTO(Doctor obj) {
        id= obj.getId();
        name = obj.getName();
        CRM = obj.getCRM();
        landline = obj.getLandline();
        cellPhone = obj.getCellPhone();
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


}
