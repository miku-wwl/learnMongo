package com.weilai.mongo.repository;

import com.weilai.mongo.model.Enrollment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends MongoRepository<Enrollment, String> {
}
