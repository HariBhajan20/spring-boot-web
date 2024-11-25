package com.learning.springbootWeb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.learning.springbootWeb.annotations.EmployeeRoleValidation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long id;

    @NotBlank(message ="Name of the Employee cannot be blank")
    @Size(min=3, max = 10, message = "Number of characters in name should be in the range: [3,10]")
    private String name;

    @NotBlank(message = "Email of the Employee cannot be blank")
    @Email(message ="It should be a valid email")
    private String email;

    @NotNull(message = "Age of the Employee cannot be blank")
    @Max(value = 80,message = "Age of Employee cannot be more than 80")
    @Min(value = 18, message = "Age of Employee cannot be less than 18")
    private Integer age;

    @NotBlank(message = "Role of the Employee cannot be blank")
//    @Pattern(regexp = "^(USER|ADMIN)$",message = "Role of Employee can be USER or ADMIN")
    @EmployeeRoleValidation
    private String role;

    @NotNull(message = "Salary of Employee should be not null")
    @Positive(message = "salary should be positive")
    @Digits(integer = 7,fraction = 2,message = "Salary can be in the form XXXXXXX.YY")
    @DecimalMax(value = "9999999.99")
    @DecimalMin(value = "100.50")
    private Double salary;

    @PastOrPresent(message = "DateOfJoining field in employee cannot be in the future")
    private LocalDate dateOfJoining;
    @JsonProperty("isActive")
    private Boolean isActive;

}
