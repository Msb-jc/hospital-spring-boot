package com.nounou.Hospital.Repository;

import com.nounou.Hospital.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
