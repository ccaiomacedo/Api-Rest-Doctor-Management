package com.doctorManagement.DoctorManagement;

import com.doctorManagement.DoctorManagement.domain.Doctor;
import com.doctorManagement.DoctorManagement.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DoctorManagementApplication implements CommandLineRunner {

	@Autowired
	DoctorRepository doctorRepository;

	public static void main(String[] args) {
		SpringApplication.run(DoctorManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Doctor doctor = new Doctor(null,"josé",2434245,4532342,42342345,3424254);
		Doctor doctor2 = new Doctor(null,"Fernando",2434245,4532342,42342345,3424254);

		doctorRepository.save(doctor);
		doctorRepository.save(doctor2);

	}
}
