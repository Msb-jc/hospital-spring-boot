package com.nounou.Hospital.DTOs;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class DoctorsResponse {

    private Long id;
    private String fullName;
    private String specialization;
    private String email;
    private String phoneNumber;
    private LocalDateTime createdAt;
}
