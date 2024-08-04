package com.weilai.mongo.service.impl;

import com.weilai.mongo.model.Student;
import com.weilai.mongo.repository.StudentRepository;
import com.weilai.mongo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(String id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(String id, Student student) {
        Student existingStudent = getStudentById(id);
        if (existingStudent != null) {
            existingStudent.setName(student.getName());
            existingStudent.setAge(student.getAge());
            existingStudent.setMajor(student.getMajor());
            return studentRepository.save(existingStudent);
        }
        return null;
    }

    @Override
    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }
}
