package com.doctorManagement.DoctorManagement.unitTests;

import com.doctorManagement.DoctorManagement.domain.Doctor;
import com.doctorManagement.DoctorManagement.domain.MedicalSpecialty;
import com.doctorManagement.DoctorManagement.dto.DoctorDTO;
import com.doctorManagement.DoctorManagement.dto.MedicalSpecialtyDTO;
import com.doctorManagement.DoctorManagement.utils.MinimumMedicalSpecialty;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SpecialityValidationTests {

    @Test
    public void minimumMedicalSpecialty_whenDoctorHasLessThanTwoSpecialties_shouldThrowMinimumMedicalSpecialtyException() {

        List<MedicalSpecialtyDTO> specialties = new ArrayList<MedicalSpecialtyDTO>();
        specialties.add(new MedicalSpecialtyDTO(new MedicalSpecialty(1, "Angiologia")));

        DoctorDTO doctor = mockDoctorDTO();
        doctor.setMedicalSpecialty(specialties);

        try {
            MinimumMedicalSpecialty.minimumLimit(doctor);
            Assertions.fail("Should thrown an exception");
        } catch (Exception e) {
            Assertions.assertEquals("O mínimo de especialidade são duas!", e.getMessage());
        }

    }

    private DoctorDTO mockDoctorDTO() {

        DoctorDTO doctor = new DoctorDTO(new Doctor(1, "Name", 1234, 12345678, 7654321, 41490352, "logradouro",
                "bairro", "localidade", "uf"));

        return doctor;
    }

}
