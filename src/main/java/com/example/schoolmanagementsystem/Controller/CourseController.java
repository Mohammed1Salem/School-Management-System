package com.example.schoolmanagementsystem.Controller;


import com.example.schoolmanagementsystem.Api.ApiResponse;
import com.example.schoolmanagementsystem.DTO.AddressDTO;
import com.example.schoolmanagementsystem.Model.Course;
import com.example.schoolmanagementsystem.Service.AddressService;
import com.example.schoolmanagementsystem.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping("get")
    public ResponseEntity<?> get() {
        return ResponseEntity.status(200).body(courseService.get());
    }

    @PostMapping("add")
    public ResponseEntity<?> post(@RequestBody @Valid Course course) {
        courseService.add(course);
        return ResponseEntity.status(200).body(new ApiResponse("course added"));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> put(@PathVariable Integer id, @RequestBody @Valid Course course) {
        courseService.update(id, course);
        return ResponseEntity.status(200).body(new ApiResponse("course updated"));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        courseService.delete(id);
        return ResponseEntity.status(200).body(new ApiResponse("course deleted"));
    }

    @PutMapping("assign-course-to-teacher/{teacherId}/{courseId}")
    public ResponseEntity<?> assignCourseToTeacher(@PathVariable Integer teacherId,@PathVariable Integer courseId) {
        courseService.assignCourseToTeacher(teacherId,courseId);
        return ResponseEntity.status(200).body(new ApiResponse("Course has been assigned"));
    }

    @GetMapping("get-teacher-name/{courseId}")
    public ResponseEntity<?> getTeacherName(@PathVariable Integer courseId) {
        return ResponseEntity.status(200).body(courseService.teacherInformation(courseId));
    }

    @GetMapping("get-students-in-course/{id}")
    public ResponseEntity<?> getStudentsInCourse(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(courseService.getStudentsInCourse(id));
    }

    @PutMapping("assign-student-and-course/{studentId}/{courseId}")
    public ResponseEntity<?> put(@PathVariable Integer studentId, @PathVariable Integer courseId) {
        courseService.assignStudentAndCourse(studentId,courseId);
        return ResponseEntity.status(200).body(new ApiResponse("Course and student assigned to each other"));
    }
}
