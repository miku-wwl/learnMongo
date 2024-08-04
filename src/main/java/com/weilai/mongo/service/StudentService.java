package com.weilai.mongo.service;

import com.weilai.mongo.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(String id);
    Student addStudent(Student student);
    Student updateStudent(String id, Student student);
    void deleteStudent(String id);
}