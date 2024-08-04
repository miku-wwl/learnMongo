package com.weilai.mongo.service;

import com.weilai.mongo.model.Enrollment;

import java.util.List;

public interface EnrollmentService {
    List<Enrollment> getAllEnrollments();
    Enrollment getEnrollmentById(String id);
    Enrollment addEnrollment(Enrollment enrollment);
    Enrollment updateEnrollment(String id, Enrollment enrollment);
    void deleteEnrollment(String id);
}
