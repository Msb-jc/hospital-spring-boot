package com.nounou.Hospital.Service;

import com.nounou.Hospital.DTOs.AppointmentMapper;
import com.nounou.Hospital.DTOs.AppointmentRequest;
import com.nounou.Hospital.DTOs.AppointmentResponse;
import com.nounou.Hospital.Exception.ResourceNotFoundException;
import com.nounou.Hospital.Model.Appointment;
import com.nounou.Hospital.Repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService{

    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;

    public Page<AppointmentResponse> getAllAppointments(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return appointmentRepository.findAll(pageable)
                .map(appointmentMapper::toDto)
                ;
    }

    @Override
    public AppointmentResponse getAppointment(Long id) {
        Appointment found =appointmentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Appointment not found "+ id) );
        return appointmentMapper.toDto(found);
    }

    @Override
    public AppointmentResponse creatAppointment(AppointmentRequest appointmentRequest) {
        Appointment appointment = appointmentMapper.toEntity(appointmentRequest);
        appointmentRepository.save(appointment);
        return appointmentMapper.toDto(appointment);
    }

    @Override
    public AppointmentResponse updateAppointment(AppointmentRequest appointmentRequest, Long id) {
        Appointment appointment = appointmentMapper.toEntity(appointmentRequest);
        Appointment found =appointmentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Appointment not found "+ id) );
        found.setAppointmentDate(appointment.getAppointmentDate());
        found.setPatient(appointment.getPatient());
        found.setNotes(appointment.getNotes());
        found.setStatus(appointment.getStatus());
        found.setDoctor(appointment.getDoctor());
        appointmentRepository.save(found);
        return appointmentMapper.toDto(found);
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}
