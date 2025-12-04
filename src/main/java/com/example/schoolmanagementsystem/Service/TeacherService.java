package com.example.schoolmanagementsystem.Service;

import com.example.schoolmanagementsystem.Api.ApiException;
import com.example.schoolmanagementsystem.DTO.TeacherDTO;
import com.example.schoolmanagementsystem.Model.Teacher;
import com.example.schoolmanagementsystem.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public List<Teacher> get(){
        if (teacherRepository.findAll().isEmpty()) throw new ApiException("Teacher not found");

        return teacherRepository.findAll();
    }

    public void add(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public void update(Integer id,Teacher teacher){
        Teacher oldTeacher = teacherRepository.findTeacherById(id);
        if (oldTeacher==null) throw new ApiException("Teacher not found");

        oldTeacher.setAge(teacher.getAge());
        oldTeacher.setName(teacher.getName());
        oldTeacher.setEmail(teacher.getEmail());
        oldTeacher.setSalary(teacher.getSalary());

        teacherRepository.save(oldTeacher);
    }

    public void delete(Integer id){
        Teacher oldTeacher = teacherRepository.findTeacherById(id);
        if (oldTeacher==null) throw new ApiException("Teacher not found");

        teacherRepository.delete(oldTeacher);
    }

    public Teacher findTeacherById(Integer id){
        return teacherRepository.findTeacherById(id);
    }
}
