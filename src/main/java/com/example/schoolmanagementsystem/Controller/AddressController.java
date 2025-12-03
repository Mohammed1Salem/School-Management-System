package com.example.schoolmanagementsystem.Controller;

import com.example.schoolmanagementsystem.Api.ApiResponse;
import com.example.schoolmanagementsystem.DTO.AddressDTO;
import com.example.schoolmanagementsystem.Model.Address;
import com.example.schoolmanagementsystem.Model.Teacher;
import com.example.schoolmanagementsystem.Service.AddressService;
import com.example.schoolmanagementsystem.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping("get")
    public ResponseEntity<?> get() {
        return ResponseEntity.status(200).body(addressService.get());
    }

    @PostMapping("add")
    public ResponseEntity<?> post(@RequestBody @Valid AddressDTO addressDTO) {
        addressService.add(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Address added"));
    }

    @PutMapping("update")
    public ResponseEntity<?> put(@RequestBody @Valid AddressDTO addressDTO) {
        addressService.update(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Address updated"));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        addressService.delete(id);
        return ResponseEntity.status(200).body(new ApiResponse("Address deleted"));
    }
}
