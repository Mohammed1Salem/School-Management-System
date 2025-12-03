package com.example.schoolmanagementsystem.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {

    @NotNull
    private Integer teacher_id;
    @NotEmpty
    private String area;
    @NotEmpty
    private String street;
    @NotEmpty
    private String buildingNumber;

}
