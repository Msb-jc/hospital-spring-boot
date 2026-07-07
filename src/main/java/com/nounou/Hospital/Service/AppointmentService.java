package com.nounou.Hospital.Service;

import com.nounou.Hospital.DTOs.AppointmentRequest;
import com.nounou.Hospital.DTOs.AppointmentResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


public interface AppointmentService {
    Page<AppointmentResponse> getAllAppointments(int page, int size);
    AppointmentResponse getAppointment(Long id);
    AppointmentResponse creatAppointment(AppointmentRequest appointmentRequest);
    void deleteAppointment(Long id);
    AppointmentResponse updateAppointment(AppointmentRequest appointmentRequest, Long id);
}
