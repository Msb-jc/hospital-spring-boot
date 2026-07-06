package com.nounou.Hospital.Repository;

import com.nounou.Hospital.Model.Doctors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorsRepository extends JpaRepository<Doctors, Long> {
}
