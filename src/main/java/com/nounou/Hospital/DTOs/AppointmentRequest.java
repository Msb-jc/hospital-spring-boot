package com.nounou.Hospital.DTOs;

import com.nounou.Hospital.Model.Doctors;
import com.nounou.Hospital.Model.Patient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AppointmentRequest {
    @NotNull(message = "Patient is required")
    private Long patientId;
    @NotNull(message = "Doctor is required")
    private Long doctorId;
    @NotNull(message = "Appointment Date is required")
    private Date appointmentDate;
    @NotBlank(message = "Status is required")
    private String status;
    @NotBlank(message = "Notes is required")
    private String notes;
}
