package com.doctorManagement.DoctorManagement.resources;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.doctorManagement.DoctorManagement.domain.Cep;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


@RestController
public class ViaCepCtrl implements Serializable {

    private static final long serialVersionUID = 1L;


    @GetMapping(value = "/getCep/{cep}")
    public ResponseEntity<Cep> doObterCep(@PathVariable(name = "cep") String cep) {
        RestTemplate restTemplate = new RestTemplate();

        String uri = "http://viacep.com.br/ws/{cep}/json/";

        Map<String, String> params = new HashMap<String, String>();
        params.put("cep", cep);
        Cep address = restTemplate.getForObject(uri, Cep.class, params);
        return new ResponseEntity<Cep>(address, HttpStatus.OK);

    }

}