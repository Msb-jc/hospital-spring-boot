package com.nounou.Hospital.Controller;

import com.nounou.Hospital.DTOs.PatientRequest;
import com.nounou.Hospital.DTOs.PatientResponse;
import com.nounou.Hospital.Service.PatientServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/hospital/patient")
public class PatientController {

    private final PatientServiceImpl patientServiceImpl;

    @GetMapping
    public ResponseEntity<Page<PatientResponse>> getAllPatients(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {
        return ResponseEntity.ok(patientServiceImpl.getAllPatients(page, size));
    }
    @GetMapping("/{id}")
    public ResponseEntity<PatientResponse> getPatient(@PathVariable Long id){
        return ResponseEntity.ok(patientServiceImpl.getPatient(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<PatientResponse> updatePatient(@Valid @RequestBody PatientRequest patient, @PathVariable Long id){
        return ResponseEntity.ok(patientServiceImpl.updatePatient(patient, id));
    }
    @PostMapping
    public ResponseEntity<PatientResponse> creatPatient (@Valid @RequestBody PatientRequest patient){
        return ResponseEntity.status(201).body(patientServiceImpl.creatPatient(patient));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient (@PathVariable Long id){
        patientServiceImpl.deletePatient(id);
        return ResponseEntity.noContent().build();
    }
}
