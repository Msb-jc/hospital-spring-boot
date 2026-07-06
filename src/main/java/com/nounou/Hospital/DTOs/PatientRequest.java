package com.nounou.Hospital.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientRequest {
    @NotBlank(message="The FullName is required")
    private String fullName;
    @NotNull(message="The Date of Birth is required")
    private Date dateOfBirth;
    @NotBlank(message="The Gender is required")
    private String gender;
    @NotBlank(message="The Phone number is required")
    private String phoneNumber;
    @NotBlank(message="The Address is required")
    private String address;
}