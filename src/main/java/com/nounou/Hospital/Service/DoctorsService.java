package com.nounou.Hospital.Service;

import com.nounou.Hospital.DTOs.DoctorsRequest;
import com.nounou.Hospital.DTOs.DoctorsResponse;
import org.springframework.data.domain.Page;

public interface DoctorsService {
      Page<DoctorsResponse> getAllDoctors(int page, int size);
      DoctorsResponse getDoctors(Long id);
      DoctorsResponse updateDoctors(DoctorsRequest doctor, Long id);
      DoctorsResponse creatDoctors(DoctorsRequest doctor);
      void deleteDoctors(Long id);
}
