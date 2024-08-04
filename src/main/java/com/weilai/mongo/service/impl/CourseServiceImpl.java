package com.weilai.mongo.service.impl;

import com.weilai.mongo.model.Course;
import com.weilai.mongo.repository.CourseRepository;
import com.weilai.mongo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(String id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(String id, Course course) {
        Course existingCourse = getCourseById(id);
        if (existingCourse != null) {
            existingCourse.setTitle(course.getTitle());
            existingCourse.setDepartment(course.getDepartment());
            existingCourse.setCreditHours(course.getCreditHours());
            return courseRepository.save(existingCourse);
        }
        return null;
    }

    @Override
    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }
}
