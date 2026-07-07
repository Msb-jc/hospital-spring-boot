package com.nounou.Hospital.Service;

import com.nounou.Hospital.DTOs.DoctorsMapper;
import com.nounou.Hospital.DTOs.DoctorsRequest;
import com.nounou.Hospital.DTOs.DoctorsResponse;
import com.nounou.Hospital.Exception.ResourceNotFoundException;
import com.nounou.Hospital.Model.Doctors;
import com.nounou.Hospital.Repository.DoctorsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorsService{
    private final DoctorsRepository doctorRepository;
    private final DoctorsMapper doctorsMapper;

    public Page<DoctorsResponse> getAllDoctors(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return doctorRepository.findAll(pageable)
                .map(doctorsMapper::toDto);
    }

    public DoctorsResponse getDoctors(Long id){
        Doctors doctors = doctorRepository.findById(id)
                .orElseThrow(() ->new ResourceNotFoundException("Doctors Not Found" + id));
        return doctorsMapper.toDto(doctors);
    }

    public DoctorsResponse creatDoctors(DoctorsRequest dto){
        Doctors doctor = doctorsMapper.toEntity(dto);
        doctorRepository.save(doctor);
        return doctorsMapper.toDto(doctor);
    }

    public DoctorsResponse updateDoctors(DoctorsRequest dto, Long id){
        Doctors doctor = doctorsMapper.toEntity(dto);
        Doctors found = doctorRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Doctors Not Found"));
        found.setFullName(doctor.getFullName());
        found.setEmail(doctor.getEmail());
        found.setSpecialization(doctor.getSpecialization());
        found.setPhoneNumber(doctor.getPhoneNumber());
        doctorRepository.save(found);
        return doctorsMapper.toDto(found);
    }
    public void deleteDoctors(Long id){
        doctorRepository.deleteById(id);
    }
}
