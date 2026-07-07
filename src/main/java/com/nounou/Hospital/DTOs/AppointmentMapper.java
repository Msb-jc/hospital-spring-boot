package com.nounou.Hospital.DTOs;

import com.nounou.Hospital.Exception.ResourceNotFoundException;
import com.nounou.Hospital.Model.Appointment;
import com.nounou.Hospital.Model.Doctors;
import com.nounou.Hospital.Model.Patient;
import com.nounou.Hospital.Repository.DoctorsRepository;
import com.nounou.Hospital.Repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppointmentMapper {
    private final PatientRepository patientRepository;
    private final DoctorsRepository doctorsRepository;
    private final DoctorsMapper doctorsMapper;
    private final PatientMappper patientMappper;

    public Appointment toEntity(AppointmentRequest appointment){
        Patient patient = patientRepository.findById(appointment.getPatientId()).orElseThrow(()-> new ResourceNotFoundException("Patient id not found"));
        Doctors doctor = doctorsRepository.findById(appointment.getDoctorId()).orElseThrow(()-> new ResourceNotFoundException("Doctor id not found"));
        return Appointment.builder()
                .doctor(doctor)
                .patient(patient)
                .appointmentDate(appointment.getAppointmentDate())
                .status(appointment.getStatus())
                .notes(appointment.getNotes())
                .build();
    }
    public AppointmentResponse toDto(Appointment appointment){
        return new AppointmentResponse(
                appointment.getId(),
                patientMappper.toDTO(appointment.getPatient()),
                doctorsMapper.toDto(appointment.getDoctor()),
                appointment.getAppointmentDate(),
                appointment.getStatus(),
                appointment.getNotes(),
                appointment.getCreatedAt()
        );
    }

}
