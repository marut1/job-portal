package com.tropogo.jobportal.respository;

import com.tropogo.jobportal.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JobPostRepository extends JpaRepository<JobPost, UUID> {
    List<JobPost> findAll();



}
