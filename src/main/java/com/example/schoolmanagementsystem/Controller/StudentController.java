package com.example.schoolmanagementsystem.Controller;

import com.example.schoolmanagementsystem.Api.ApiResponse;
import com.example.schoolmanagementsystem.Model.Course;
import com.example.schoolmanagementsystem.Model.Student;
import com.example.schoolmanagementsystem.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("get")
    public ResponseEntity<?> get() {
        return ResponseEntity.status(200).body(studentService.get());
    }

    @PostMapping("add")
    public ResponseEntity<?> post(@RequestBody @Valid Student student) {
        studentService.add(student);
        return ResponseEntity.status(200).body(new ApiResponse("student added"));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> put(@PathVariable Integer id, @RequestBody @Valid Student student) {
        studentService.update(id, student);
        return ResponseEntity.status(200).body(new ApiResponse("student updated"));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        studentService.delete(id);
        return ResponseEntity.status(200).body(new ApiResponse("student deleted"));
    }

    @PutMapping("change-major/{id}/{newMajor}")
    public ResponseEntity<?> put(@PathVariable Integer id,@PathVariable String newMajor) {
        studentService.changeMajor(id,newMajor);
        return ResponseEntity.status(200).body(new ApiResponse("student major changed"));
    }
}
