package com.doctorManagement.DoctorManagement.service;

import java.util.HashMap;
import java.util.Map;

import com.doctorManagement.DoctorManagement.dto.AddressDTO;
import com.doctorManagement.DoctorManagement.services.exceptions.AddressNotFoundException;
import com.doctorManagement.DoctorManagement.services.exceptions.InvalidFormatZipCodeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


@Service
public class ViaCepService {

    @Autowired
    private RestTemplate restTemplate;

    private String uri = "http://viacep.com.br/ws";
    private String type = "/json";
    private String payload ="";

    public AddressDTO doFindCep(Integer cep) {
        try {
            Map<String, String> params = new HashMap<>();
            params.put("cep", cep.toString());
            ResponseEntity<AddressDTO> addressDto = restTemplate.getForEntity(uri + "/{cep}" + type, AddressDTO.class, params);
            if (addressDto.getStatusCodeValue() == 200 && addressDto.getBody().getLocalidade() == null) {
                throw new AddressNotFoundException("Cep não existente :" + cep);
            }
            return addressDto.getBody();
        } catch (HttpClientErrorException e) {
            payload = e.getResponseBodyAsString();
            throw new InvalidFormatZipCodeException(payload);
        }
    }
}