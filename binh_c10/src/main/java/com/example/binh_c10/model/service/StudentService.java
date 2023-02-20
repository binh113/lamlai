package com.example.binh_c10.model.service;

import com.example.binh_c10.model.dao.StudentDao;
import com.example.binh_c10.model.dto.StudentDto;
import com.example.binh_c10.model.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private StudentDao studentDao = null;

    public StudentService() {
        studentDao = new StudentDao();
    }

    public List<StudentDto> seacrchByName(String name) {
        List<Student> students = studentDao.searchByName(name);
        List<StudentDto> studentDtos = new ArrayList<>();
        for (Student student : students) {
            studentDtos.add(new StudentDto(student.getId(), student.getName(), student.getDob(), student.getAddress(), student.getPhone(), student.getEmail(), student.getClassRoom()));
        }
        return studentDtos;
    }

    public List<StudentDto> findAll() {
        List<Student> students = studentDao.getAll();
        List<StudentDto> studentDtos = new ArrayList<>();

        for (Student student : students) {
            studentDtos.add(new StudentDto(
                    student.getId(), student.getName(),
                    student.getAddress(), student.getClassRoom()));
        }

        return studentDtos;
    }

    public StudentDto find(int id) {
        Student student = studentDao.get(id);
        return new StudentDto(student.getId(), student.getName(),student.getDob(),
                 student.getAddress(), student.getPhone(), student.getEmail(), student.getClassRoom());
    }

    public void add(StudentDto studentDto) {
        Student student = new Student(studentDto.getId(),
                studentDto.getName(), studentDto.getDob(), studentDto.getAddress(),
                studentDto.getPhone(), studentDto.getEmail(),
                studentDto.getClassRoom());
        studentDao.insert(student);


    }

    public void edit(StudentDto studentDto) {
        Student student = new Student(studentDto.getId(),
                studentDto.getName(), studentDto.getDob(), studentDto.getAddress(), studentDto.getPhone(), studentDto.getEmail(), studentDto.getClassRoom());
        studentDao.update(student);
    }

    public void remove(String id) {
        studentDao.delete(id);
    }
}



