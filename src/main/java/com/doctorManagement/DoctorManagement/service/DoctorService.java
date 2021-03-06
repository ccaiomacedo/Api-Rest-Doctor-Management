package com.doctorManagement.DoctorManagement.service;

import com.doctorManagement.DoctorManagement.domain.Doctor;
import com.doctorManagement.DoctorManagement.domain.MedicalSpecialty;
import com.doctorManagement.DoctorManagement.dto.AddressDTO;
import com.doctorManagement.DoctorManagement.dto.DoctorDTO;
import com.doctorManagement.DoctorManagement.dto.MedicalSpecialtyDTO;
import com.doctorManagement.DoctorManagement.repository.DoctorRepository;
import com.doctorManagement.DoctorManagement.repository.MedicalSpecialtyRepository;
import com.doctorManagement.DoctorManagement.services.exceptions.DataIntegrityViolationException;
import com.doctorManagement.DoctorManagement.services.exceptions.ObjectNotFoundException;
import com.doctorManagement.DoctorManagement.utils.MinimumMedicalSpecialty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
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


    public Doctor find(Integer id) {
        Optional<Doctor> obj = doctorRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Doctor.class.getName()));
    }

    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }


    @Transactional()
    public DoctorDTO insert(DoctorDTO objdto) {
        objdto.setId(null);
        Doctor obj = new Doctor();
        doctorDtoToDoctor(obj, objdto);
        MinimumMedicalSpecialty.minimumLimit(objdto);
        doctorRepository.save(obj);
        return new DoctorDTO(obj, obj.getMedicalSpecialty());
    }

    @Transactional
    public DoctorDTO update(Integer id, DoctorDTO doctorDTO) {
        try {
            Doctor aux = updateDataAux(id, doctorDTO);
            MinimumMedicalSpecialty.minimumLimit(doctorDTO);
            doctorRepository.save(aux);
            return new DoctorDTO(aux, aux.getMedicalSpecialty());
        } catch (EntityNotFoundException e) {
            throw new ObjectNotFoundException("Id não encontrado: " + id);
        }
    }

    public void delete(Integer id) {
        find(id);
        try {
            doctorRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Não é possível excluir porque há objetos relacionados");
        }
    }

    private Doctor doctorDtoToDoctor(Doctor doctor, DoctorDTO doctorDTO) {
        doctor.setName(doctorDTO.getName());
        doctor.setCrm(doctorDTO.getCrm());
        doctor.setLandline(doctorDTO.getLandline());
        doctor.setCellPhone(doctorDTO.getCellPhone());
        doctor.setCep(doctorDTO.getCep());

        addressDTOToViaCep(doctor);

        for (MedicalSpecialtyDTO medicalSpecialtyDTO : doctorDTO.getMedicalSpecialty()) {
            MedicalSpecialty aux = medicalSpecialtyRepository.getById(medicalSpecialtyDTO.getId());
            doctor.getMedicalSpecialty().add(aux);
        }

        return doctor;

    }

    private Doctor addressDTOToViaCep(Doctor doctor) {
        AddressDTO addressDTO = viaCepService.doFindCep(doctor.getCep());
        doctor.setBairro(addressDTO.getBairro());
        doctor.setLocalidade(addressDTO.getLocalidade());
        doctor.setLogradouro(addressDTO.getLogradouro());
        doctor.setUf(addressDTO.getUf());

        return doctor;
    }

    public List<Doctor> findByName(String name) {
        List<Doctor> obj = doctorRepository.findByNameIgnoreCase(name);
        if (obj.size() == 0) {
            throw new ObjectNotFoundException("Objeto não encontrado! Nome: " + name + ", Tipo: " + Doctor.class.getName());
        }
        return obj;
    }

    public Doctor findByCrm(Integer crm) {
        Doctor obj = doctorRepository.findByCrm(crm);
        if (obj == null) {
            throw new ObjectNotFoundException("Objeto não encontrado! CRM: " + crm + ", Tipo: " + Doctor.class.getName());
        } else {
            return obj;
        }

    }

    public Doctor findByCellPhone(long cellPhone) {
        Doctor obj = doctorRepository.findByCellPhone(cellPhone);
        if (obj == null) {
            throw new ObjectNotFoundException("Objeto não encontrado! CellPhone: " + cellPhone + ", Tipo: " + Doctor.class.getName());
        } else {
            return obj;
        }

    }

    public Doctor findByLandline(long landline) {
        Doctor obj = doctorRepository.findByLandline(landline);
        if (obj == null) {
            throw new ObjectNotFoundException("Objeto não encontrado! Landline: " + landline + ", Tipo: " + Doctor.class.getName());
        } else {
            return obj;
        }

    }

    public List<Doctor> findByLogradouro(String logradouro) {
        List<Doctor> obj = doctorRepository.findByLogradouroIgnoreCase(logradouro);
        if (obj.size() == 0) {
         throw new ObjectNotFoundException("Objeto não encontrado! Logradouro: " + logradouro + ", Tipo: " + Doctor.class.getName());
        }
        return obj;
    }

    public List<Doctor> findByCep(Integer cep) {
        List<Doctor> obj = doctorRepository.findByCep(cep);
        if (obj.size() == 0) {
            throw new ObjectNotFoundException("Objeto não encontrado! Cep: " + cep + ", Tipo: " + Doctor.class.getName());
        }
        return obj;
    }

    public List<Doctor> findByUf(String uf) {
        List<Doctor> obj = doctorRepository.findByUfIgnoreCase(uf);
        if (obj.size() == 0) {
            throw new ObjectNotFoundException("Objeto não encontrado! Uf: " + uf + ", Tipo: " + Doctor.class.getName());
        }
        return obj;
    }

    public List<Doctor> findByLocalidade(String localidade) {
        List<Doctor> obj = doctorRepository.findByLocalidadeIgnoreCase(localidade);
        if (obj.size() == 0) {
            throw new ObjectNotFoundException("Objeto não encontrado! Localidade: " + localidade + ", Tipo: " + Doctor.class.getName());
        }
        return obj;
    }

    public List<Doctor> findByBairro(String bairro) {
        List<Doctor> obj = doctorRepository.findByBairroIgnoreCase(bairro);
        if (obj.size() == 0) {
            throw new ObjectNotFoundException("Objeto não encontrado! Bairro: " + bairro + ", Tipo: " + Doctor.class.getName());
        }
        return obj;
    }

    private Doctor updateDataAux(Integer id, DoctorDTO doctorDTO) {
        Doctor doctor = doctorRepository.getById(id);
        doctor.setName(doctorDTO.getName());
        doctor.setCrm(doctorDTO.getCrm());
        doctor.setLandline(doctorDTO.getLandline());
        doctor.setCellPhone(doctorDTO.getCellPhone());
        doctor.setCep(doctorDTO.getCep());
        updateAddressAux(doctor);
        doctor.getMedicalSpecialty().clear();
        for (MedicalSpecialtyDTO medicalSpecialtyDTO : doctorDTO.getMedicalSpecialty()) {
            MedicalSpecialty aux = medicalSpecialtyRepository.getById(medicalSpecialtyDTO.getId());
            doctor.getMedicalSpecialty().add(aux);
        }
        return doctor;
    }

    private Doctor updateAddressAux(Doctor doctor) {
        AddressDTO addressDTO = viaCepService.doFindCep(doctor.getCep());
        doctor.setLocalidade(addressDTO.getLocalidade());
        doctor.setLogradouro(addressDTO.getLogradouro());
        doctor.setBairro(addressDTO.getBairro());
        doctor.setUf(addressDTO.getUf());

        return doctor;
    }


}
