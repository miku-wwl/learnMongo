package com.weilai.mongo.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "enrollments")
public class Enrollment {
    @Id
    private String id;
    private String studentId;
    private String courseId;
    private String grade;
}