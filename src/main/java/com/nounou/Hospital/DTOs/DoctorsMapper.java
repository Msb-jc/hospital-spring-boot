package com.nounou.Hospital.DTOs;

import com.nounou.Hospital.Model.Doctors;
import org.springframework.stereotype.Component;

@Component
public class DoctorsMapper {

    public Doctors toEntity(DoctorsRequest dto){
        return Doctors.builder()
                .phoneNumber(dto.getPhoneNumber())
                .email(dto.getEmail())
                .fullName(dto.getFullName())
                .specialization(dto.getSpecialization())
                .build();
    }

    public DoctorsResponse toDto(Doctors doctor){
        return new DoctorsResponse(
                doctor.getId(),
                doctor.getFullName(),
                doctor.getEmail(),
                doctor.getSpecialization(),
                doctor.getPhoneNumber(),
                doctor.getCreatedAt()
        );
    }

}
