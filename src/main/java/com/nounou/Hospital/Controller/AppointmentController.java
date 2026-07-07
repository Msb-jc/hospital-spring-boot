package com.nounou.Hospital.Controller;

import com.nounou.Hospital.DTOs.AppointmentRequest;
import com.nounou.Hospital.DTOs.AppointmentResponse;
import com.nounou.Hospital.Model.Appointment;
import com.nounou.Hospital.Service.AppointmentService;
import com.nounou.Hospital.Service.AppointmentServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @GetMapping
    public ResponseEntity<Page<AppointmentResponse>> getAllAppointment(
            @RequestParam(defaultValue = "0")Integer page,
            @RequestParam(defaultValue = "10")Integer size){
        return ResponseEntity.ok(appointmentService.getAllAppointments(page, size));
    }
    @GetMapping("/{id}")
    public ResponseEntity<AppointmentResponse> getAppointment(@PathVariable Long id){
        return ResponseEntity.ok(appointmentService.getAppointment(id));
    }
    @PostMapping
    public ResponseEntity<AppointmentResponse> creatAppointment(@Valid @RequestBody AppointmentRequest appointment){
        return ResponseEntity.ok(appointmentService.creatAppointment(appointment));

    }
    @PutMapping("/{id}")
    public ResponseEntity<AppointmentResponse> updateAppointment(@Valid @RequestBody AppointmentRequest appointment, @PathVariable Long id){
        return ResponseEntity.status(201).body(appointmentService.updateAppointment(appointment, id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id){
        appointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();

    }
}
