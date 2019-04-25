package com.haoche.yltms.system.repository;

import com.haoche.yltms.system.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FeedbackRepository extends JpaRepository<Feedback, String>, JpaSpecificationExecutor<Feedback> {
}
