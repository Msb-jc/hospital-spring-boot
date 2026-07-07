package com.nounou.Hospital.Controller;

import com.nounou.Hospital.DTOs.DoctorsRequest;
import com.nounou.Hospital.DTOs.DoctorsResponse;
import com.nounou.Hospital.Service.DoctorsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/hospital/doctor")
public class DoctorsController {

    private final DoctorsService doctorService;

    @GetMapping
    public ResponseEntity<Page<DoctorsResponse>> getAllDoctors(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size){
        return ResponseEntity.ok( doctorService.getAllDoctors(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorsResponse> getDoctors(@PathVariable Long id){
        return ResponseEntity.ok( doctorService.getDoctors(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<DoctorsResponse> updateDoctors(@Valid @RequestBody DoctorsRequest doctor, @PathVariable Long id){
        return ResponseEntity.ok( doctorService.updateDoctors(doctor, id));
    }
    @PostMapping
    public ResponseEntity<DoctorsResponse> creatDoctors (@Valid @RequestBody DoctorsRequest doctor){
        return ResponseEntity.status(201).body( doctorService.creatDoctors(doctor));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctors (@PathVariable Long id){
         doctorService.deleteDoctors(id);
        return ResponseEntity.noContent().build();
    }
}
