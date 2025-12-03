package com.example.schoolmanagementsystem.Controller;


import com.example.schoolmanagementsystem.Api.ApiResponse;
import com.example.schoolmanagementsystem.Model.Teacher;
import com.example.schoolmanagementsystem.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping("get")
    public ResponseEntity<?> get() {
        return ResponseEntity.status(200).body(teacherService.get());
    }

    @PostMapping("add")
    public ResponseEntity<?> post(@RequestBody @Valid Teacher teacher) {
        teacherService.add(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("teacher added"));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> put(@PathVariable Integer id, @RequestBody @Valid Teacher teacher) {
        teacherService.update(id,teacher);
        return ResponseEntity.status(200).body(new ApiResponse("teacher updated"));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        teacherService.delete(id);
        return ResponseEntity.status(200).body(new ApiResponse("teacher deleted"));
    }
}
