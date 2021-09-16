package com.doctorManagement.DoctorManagement.resources;

import com.doctorManagement.DoctorManagement.domain.Doctor;
import com.doctorManagement.DoctorManagement.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/doctors")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @RequestMapping(value ="/{id}",method = RequestMethod.GET)
    public ResponseEntity<Doctor> find(@PathVariable Integer id){
        Doctor obj = doctorService.find(id);
        return ResponseEntity.ok().body(obj);
    }

}
