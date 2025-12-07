package com.example.schoolmanagementsystem.Service;

import com.example.schoolmanagementsystem.Api.ApiException;
import com.example.schoolmanagementsystem.Model.Course;
import com.example.schoolmanagementsystem.Model.Student;
import com.example.schoolmanagementsystem.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> get(){
        return studentRepository.findAll();
    }

    public void add(Student student) {
        studentRepository.save(student);
    }

    public void update(Integer id,Student student){
        Student oldStudent = studentRepository.findStudentById(id);

        if (oldStudent == null) throw new ApiException("Student not found");

        oldStudent.setMajor(student.getMajor());
        oldStudent.setName(student.getName());
        oldStudent.setAge(student.getAge());

        studentRepository.save(oldStudent);
    }

    public void delete(Integer id){
        Student oldStudent = studentRepository.findStudentById(id);

        if (oldStudent == null) throw new ApiException("Student not found");

        studentRepository.delete(oldStudent);
    }

    public void changeMajor(Integer id,String newMajor){
        Student student = studentRepository.findStudentById(id);
        if (student == null) throw new ApiException("Student not found");

        student.getCourses().clear();
        student.setMajor(newMajor);
        studentRepository.save(student);

    }

}
