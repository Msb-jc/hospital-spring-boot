package com.nounou.Hospital.Service;

import com.nounou.Hospital.DTOs.PatientRequest;
import com.nounou.Hospital.DTOs.PatientResponse;
import org.springframework.data.domain.Page;

public interface PatientService {
     Page<PatientResponse> getAllPatients(int page, int size);
     PatientResponse getPatient(Long id);
     PatientResponse updatePatient(PatientRequest patient, Long id);
     PatientResponse creatPatient(PatientRequest patient);
     void deletePatient(Long id);
}
