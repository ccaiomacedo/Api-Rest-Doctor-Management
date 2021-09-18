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
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ResponseEntity<DoctorDTO> update(@Valid @PathVariable Integer id, @RequestBody DoctorDTO objDto){
            return ResponseEntity.ok().body(doctorService.update(id,objDto));
    }

    @Transactional(readOnly = true)
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<DoctorDTO>> findAll(){
        List<Doctor> list = doctorService.findAll();
        List<DoctorDTO> listDto = list.stream().map(obj -> new DoctorDTO(obj,obj.getMedicalSpecialty())).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value ="/by-name/{name}",method = RequestMethod.GET)
    public ResponseEntity<Doctor> findByName(@PathVariable String name){
        Doctor obj = doctorService.findByName(name);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value ="/by-landline/{landline}",method = RequestMethod.GET)
    public ResponseEntity<Doctor> findByLandline(@PathVariable long landline){
        Doctor obj = doctorService.findByLandline(landline);
        return ResponseEntity.ok().body(obj);
    }
    @RequestMapping(value ="/by-cellPhone/{cellPhone}",method = RequestMethod.GET)
    public ResponseEntity<Doctor> findByCellPhone(@PathVariable long cellPhone){
        Doctor obj = doctorService.findByCellPhone(cellPhone);
        return ResponseEntity.ok().body(obj);
    }
    @RequestMapping(value ="/by-cep/{cep}",method = RequestMethod.GET)
    public ResponseEntity<Doctor> findByCep(@PathVariable Integer cep){
        Doctor obj = doctorService.findByCep(cep);
        return ResponseEntity.ok().body(obj);
    }   @RequestMapping(value ="/by-logradouro/{logradouro}",method = RequestMethod.GET)
    public ResponseEntity<Doctor> findByLogradouro(@PathVariable String logradouro){
        Doctor obj = doctorService.findByLogradouro(logradouro);
        return ResponseEntity.ok().body(obj);
    }
    @RequestMapping(value ="/by-localidade/{localidade}",method = RequestMethod.GET)
    public ResponseEntity<Doctor> findByLocalidade(@PathVariable String localidade){
        Doctor obj = doctorService.findByLocalidade(localidade);
        return ResponseEntity.ok().body(obj);
    }
    @RequestMapping(value ="/by-bairro/{bairro}",method = RequestMethod.GET)
    public ResponseEntity<Doctor> findByBairro(@PathVariable String bairro){
        Doctor obj = doctorService.findByBairro(bairro);
        return ResponseEntity.ok().body(obj);
    }
    @RequestMapping(value ="/by-uf/{uf}",method = RequestMethod.GET)
    public ResponseEntity<Doctor> findByUf(@PathVariable String uf){
        Doctor obj = doctorService.findByUf(uf);
        return ResponseEntity.ok().body(obj);
    }
    @RequestMapping(value ="/by-crm/{crm}",method = RequestMethod.GET)
    public ResponseEntity<Doctor> findByCrm(@PathVariable Integer crm){
        Doctor obj = doctorService.findByCrm(crm);
        return ResponseEntity.ok().body(obj);
    }


}
