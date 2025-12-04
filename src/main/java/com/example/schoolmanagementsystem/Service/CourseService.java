package com.example.schoolmanagementsystem.Service;

import com.example.schoolmanagementsystem.Api.ApiException;
import com.example.schoolmanagementsystem.DTO.TeacherDTO;
import com.example.schoolmanagementsystem.Model.Course;
import com.example.schoolmanagementsystem.Model.Teacher;
import com.example.schoolmanagementsystem.Repository.CourseRepository;
import com.example.schoolmanagementsystem.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public List<Course> get(){
        return courseRepository.findAll();
    }

    public void add(Course course){
        courseRepository.save(course);
    }

    public void assignCourseToTeacher(Integer teacherId,Integer courseId){
        Teacher teacher = teacherRepository.findTeacherById(teacherId);
        Course course = courseRepository.findCourseById(courseId);

        if (teacher == null || course == null) throw new ApiException("Teacher or course not found");

        course.setTeacher(teacher);
        courseRepository.save(course);
    }

    public void update(Integer id,Course course){
        Course oldCourse = courseRepository.findCourseById(id);
        if (oldCourse == null) throw new ApiException("Course not found");

        oldCourse.setName(course.getName());
        courseRepository.save(oldCourse);
    }

    public void delete(Integer id){
        Course oldCourse = courseRepository.findCourseById(id);
        if (oldCourse == null) throw new ApiException("Course not found");

        courseRepository.delete(oldCourse);
    }

    public TeacherDTO teacherInformation(Integer courseId){
        Course course = courseRepository.findCourseById(courseId);
        if (course == null)throw new ApiException("Course not found");
        Teacher teacher = course.getTeacher();
        if (teacher == null) throw new ApiException("Teacher not found");

        return new TeacherDTO(teacher.getName(), teacher.getAge(),teacher.getEmail(),teacher.getSalary());
    }
}
