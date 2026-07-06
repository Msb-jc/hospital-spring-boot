package com.nounou.Hospital.DTOs;

import com.nounou.Hospital.Model.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientMappper {

    public Patient toEntity(PatientRequest patientRequest){
        return Patient.builder()
                .fullName(patientRequest.getFullName())
                .address(patientRequest.getAddress())
                .phoneNumber(patientRequest.getPhoneNumber())
                .dateOfBirth(patientRequest.getDateOfBirth())
                .gender(patientRequest.getGender())
                .build();

    }

    public PatientResponse toDTO(Patient patient){
        return new PatientResponse(
                patient.getId(),
                patient.getFullName(),
                patient.getDateOfBirth(),
                patient.getGender(),
                patient.getPhoneNumber(),
                patient.getAddress(),
                patient.getCreatedAt()
        );
    }

}
