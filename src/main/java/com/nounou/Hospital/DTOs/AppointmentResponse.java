package com.nounou.Hospital.DTOs;

import com.nounou.Hospital.Model.Doctors;
import com.nounou.Hospital.Model.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AppointmentResponse {
    private Long id;
    private PatientResponse patient;
    private DoctorsResponse doctor;
    private Date appointmentDate;
    private String status;
    private String notes;
    private LocalDateTime createdAt;
}
