package com.weilai.mongo.service.impl;

import com.weilai.mongo.model.Enrollment;
import com.weilai.mongo.repository.EnrollmentRepository;
import com.weilai.mongo.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;

    @Autowired
    public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    @Override
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    @Override
    public Enrollment getEnrollmentById(String id) {
        return enrollmentRepository.findById(id).orElse(null);
    }

    @Override
    public Enrollment addEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public Enrollment updateEnrollment(String id, Enrollment enrollment) {
        Enrollment existingEnrollment = getEnrollmentById(id);
        if (existingEnrollment != null) {
            existingEnrollment.setStudentId(enrollment.getStudentId());
            existingEnrollment.setCourseId(enrollment.getCourseId());
            existingEnrollment.setGrade(enrollment.getGrade());
            return enrollmentRepository.save(existingEnrollment);
        }
        return null;
    }

    @Override
    public void deleteEnrollment(String id) {
        enrollmentRepository.deleteById(id);
    }
}
