package com.doctorManagement.DoctorManagement.integrationTests;

import com.doctorManagement.DoctorManagement.domain.Doctor;
import com.doctorManagement.DoctorManagement.domain.MedicalSpecialty;
import com.doctorManagement.DoctorManagement.repository.DoctorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashSet;
import java.util.Set;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DoctorRepositoryIT {

    @Autowired
    private DoctorRepository repository;

    @Test
    public void saveDoctor_whenAllParamentersAreOk_shouldBeSavedInDataBase() {
        Set<MedicalSpecialty> specialties = new HashSet<>();
        specialties.add(new MedicalSpecialty(1, "Angiologia"));
        specialties.add(new MedicalSpecialty(2, "Cirurgião de coração"));

        Doctor doctor = mockDoctor();
        doctor.setMedicalSpecialty(specialties);
        repository.save(doctor);

        Assertions.assertNotNull(repository.findByNameIgnoreCase("Name"));
    }

    private Doctor mockDoctor() {

        Doctor doctor = new Doctor(1, "Name", 1234, 12345678, 7654321, 41490352, "logradouro",
                "bairro", "localidade", "uf");

        return doctor;
    }

}
