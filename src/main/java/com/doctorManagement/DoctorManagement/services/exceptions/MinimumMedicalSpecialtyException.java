package com.doctorManagement.DoctorManagement.services.exceptions;

public class MinimumMedicalSpecialtyException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public MinimumMedicalSpecialtyException(String msg){
        super(msg);
    }


}
