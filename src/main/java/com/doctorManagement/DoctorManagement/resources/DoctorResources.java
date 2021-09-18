package com.doctorManagement.DoctorManagement.resources;

import com.doctorManagement.DoctorManagement.domain.Doctor;
import com.doctorManagement.DoctorManagement.dto.DoctorDTO;
import com.doctorManagement.DoctorManagement.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/doctors")
public class DoctorResources {

    @Autowired
    DoctorService doctorService;

    @RequestMapping(value ="/{id}",method = RequestMethod.GET)
    public ResponseEntity<Doctor> find(@PathVariable Integer id){
        Doctor obj = doctorService.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<DoctorDTO> insert(@Valid @RequestBody DoctorDTO objDto){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objDto.getId()).toUri();
        return ResponseEntity.created(uri).body(doctorService.insert(objDto));
    }

    @Transactional(readOnly = true)
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<DoctorDTO>> findAll(){
        List<Doctor> list = doctorService.findAll();
        List<DoctorDTO> listDto = list.stream().map(obj -> new DoctorDTO(obj,obj.getMedicalSpecialty())).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

}
