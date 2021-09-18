package com.doctorManagement.DoctorManagement.utils;

import com.doctorManagement.DoctorManagement.dto.DoctorDTO;
import com.doctorManagement.DoctorManagement.services.exceptions.MinimumMedicalSpecialtyException;


public class MinimumMedicalSpecialty {


    public static void minimumLimit(DoctorDTO doctorDTO) {
        if (doctorDTO.getMedicalSpecialty().size() < 2) {
            throw new MinimumMedicalSpecialtyException("O mínimo de especialidade são duas!");
        }

    }

}
