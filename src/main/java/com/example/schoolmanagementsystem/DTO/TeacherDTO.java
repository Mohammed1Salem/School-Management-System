package com.example.schoolmanagementsystem.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeacherDTO {
    @NotEmpty
    private String name;
    @NotNull
    private Integer age;
    @NotEmpty
    @Email
    private String email;
    @NotNull
    private Integer salary;
}
