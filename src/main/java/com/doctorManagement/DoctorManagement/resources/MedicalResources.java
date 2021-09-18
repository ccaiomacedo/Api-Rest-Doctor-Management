package com.doctorManagement.DoctorManagement.resources;

import com.doctorManagement.DoctorManagement.domain.MedicalSpecialty;
import com.doctorManagement.DoctorManagement.dto.MedicalSpecialtyDTO;
import com.doctorManagement.DoctorManagement.service.MedicalSpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/medicalSpecialties")
public class MedicalResources {

    @Autowired
    MedicalSpecialtyService medicalSpecialtyService;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<MedicalSpecialtyDTO>> findAll(){
        List<MedicalSpecialty> list = medicalSpecialtyService.findAll();
        List<MedicalSpecialtyDTO> listDto = list.stream().map(obj -> new MedicalSpecialtyDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

}
