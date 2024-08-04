package com.weilai.mongo.service;

import com.weilai.mongo.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
    Course getCourseById(String id);
    Course addCourse(Course course);
    Course updateCourse(String id, Course course);
    void deleteCourse(String id);
}