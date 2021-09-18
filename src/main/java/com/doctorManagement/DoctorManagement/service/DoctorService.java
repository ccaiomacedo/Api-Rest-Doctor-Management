package com.doctorManagement.DoctorManagement.service;

import com.doctorManagement.DoctorManagement.domain.Doctor;
import com.doctorManagement.DoctorManagement.domain.MedicalSpecialty;
import com.doctorManagement.DoctorManagement.dto.AddressDTO;
import com.doctorManagement.DoctorManagement.dto.DoctorDTO;
import com.doctorManagement.DoctorManagement.dto.MedicalSpecialtyDTO;
import com.doctorManagement.DoctorManagement.repository.DoctorRepository;
import com.doctorManagement.DoctorManagement.repository.MedicalSpecialtyRepository;
import com.doctorManagement.DoctorManagement.services.exceptions.MinimumMedicalSpecialtyException;
import com.doctorManagement.DoctorManagement.services.exceptions.ObjectNotFoundException;
import com.doctorManagement.DoctorManagement.utils.MinimumMedicalSpecialty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    public DoctorRepository doctorRepository;

    @Autowired
    public MedicalSpecialtyRepository medicalSpecialtyRepository;

    @Autowired
    private ViaCepService viaCepService;


    public Doctor find(Integer id){
        Optional<Doctor> obj = doctorRepository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException(
                "Objeto não encontrado! Id: "+id+", Tipo: "+Doctor.class.getName()));
    }

    public List<Doctor> findAll(){
        return doctorRepository.findAll();
    }

    @Transactional
    public DoctorDTO insert(DoctorDTO objdto){
        objdto.setId(null);
        Doctor obj = new Doctor();
        doctorDtoToDoctor(obj,objdto);
        MinimumMedicalSpecialty.minimumLimit(objdto);
        doctorRepository.save(obj);
        return new DoctorDTO(obj,obj.getMedicalSpecialty());
    }


    private Doctor doctorDtoToDoctor(Doctor doctor, DoctorDTO doctorDTO){
        doctor.setName(doctorDTO.getName());
        doctor.setCrm(doctorDTO.getCrm());
        doctor.setLandline(doctorDTO.getLandline());
        doctor.setCellPhone(doctorDTO.getCellPhone());
        doctor.setCep(doctorDTO.getCep());

       addressDTOToViaCep(doctor);

        for(MedicalSpecialtyDTO medicalSpecialtyDTO :doctorDTO.getMedicalSpecialty()){
            MedicalSpecialty aux = medicalSpecialtyRepository.getById(medicalSpecialtyDTO.getId());
            doctor.getMedicalSpecialty().add(aux);
        }

        return doctor;

    }

    private Doctor addressDTOToViaCep(Doctor doctor){
        AddressDTO addressDTO = viaCepService.doFindCep(doctor.getCep());
        doctor.setBairro(addressDTO.getBairro());
        doctor.setComplemento(addressDTO.getComplemento());
        doctor.setLocalidade(addressDTO.getLocalidade());
        doctor.setLogradouro(addressDTO.getLogradouro());
        doctor.setUf(addressDTO.getUf());

        return doctor;
    }


}
