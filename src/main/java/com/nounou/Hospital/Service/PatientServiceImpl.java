package com.nounou.Hospital.Service;

import com.nounou.Hospital.DTOs.PatientMappper;
import com.nounou.Hospital.DTOs.PatientRequest;
import com.nounou.Hospital.DTOs.PatientResponse;
import com.nounou.Hospital.Exception.ResourceNotFoundException;
import com.nounou.Hospital.Model.Patient;
import com.nounou.Hospital.Repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService{

    private final PatientRepository patientRepository;
    private final PatientMappper patientMappper;

    @Override
    public Page<PatientResponse> getAllPatients(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
       return patientRepository.findAll(pageable)
               .map(patientMappper::toDTO);
    }

    public PatientResponse getPatient(Long id){
        Patient found = patientRepository.findById(id)
                .orElseThrow(() ->new ResourceNotFoundException("Patient Not Found" + id));
        return patientMappper.toDTO(found);
    }

    public PatientResponse creatPatient(PatientRequest patient){
        Patient newOne = patientMappper.toEntity(patient);
        patientRepository.save(newOne);
        return patientMappper.toDTO(newOne);
    }

    public PatientResponse updatePatient(PatientRequest dto, Long id){
        Patient patient = patientMappper.toEntity(dto);
        Patient found = patientRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Patient Not Found"));
        found.setFullName(patient.getFullName());
        found.setGender(patient.getGender());
        found.setAddress(patient.getAddress());
        found.setPhoneNumber(patient.getPhoneNumber());
        patientRepository.save(found);
        return patientMappper.toDTO(found);
    }
    public void deletePatient(Long id){
        patientRepository.deleteById(id);
    }

}
