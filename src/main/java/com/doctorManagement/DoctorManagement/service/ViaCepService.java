package com.doctorManagement.DoctorManagement.service;

import java.util.HashMap;
import java.util.Map;

import com.doctorManagement.DoctorManagement.dto.AddressDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ViaCepService {

    @Autowired
    private RestTemplate restTemplate;

    private String uri = "http://viacep.com.br/ws";
    private String type = "/json";

    public AddressDTO doFindCep(Integer cep) {
        Map<String, String> params = new HashMap<>();
        params.put("cep", cep.toString());
        ResponseEntity<AddressDTO> addressDto = restTemplate.getForEntity(uri+"/{cep}"+type,AddressDTO.class,params);
        return addressDto.getBody();

    }

}