package com.doctorManagement.DoctorManagement.services.exceptions;

public class InvalidFormatZipCodeException extends RuntimeException{

    private static final long serialVersionUID = 1l;

    public InvalidFormatZipCodeException(String msg){
        super(msg);
    }
}
