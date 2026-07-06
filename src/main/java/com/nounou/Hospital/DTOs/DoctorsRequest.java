package com.nounou.Hospital.DTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DoctorsRequest {
    @NotBlank(message="The FullName is required")
    private String fullName;
    @NotBlank(message="The Specialization is required")
    private String specialization;
    @NotBlank(message="The Email is required")
    private String email;
    @NotBlank(message="The Phone Number is required")
    private String phoneNumber;
}
