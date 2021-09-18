package com.doctorManagement.DoctorManagement.dto;


import java.io.Serializable;


public class AddressDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

    public AddressDTO() {

    }

    public AddressDTO(String logradouro, String complemento, String bairro, String localidade, String uf) {
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
    }



    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
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
    public String toString() {
        final StringBuilder sb = new StringBuilder("AddressDTO{");
        sb.append("logradouro='").append(logradouro).append('\'');
        sb.append(", complemento='").append(complemento).append('\'');
        sb.append(", bairro='").append(bairro).append('\'');
        sb.append(", localidade='").append(localidade).append('\'');
        sb.append(", uf='").append(uf).append('\'');
        sb.append('}');
        return sb.toString();
    }
}