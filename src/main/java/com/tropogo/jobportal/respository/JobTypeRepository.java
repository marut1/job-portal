package com.tropogo.jobportal.respository;

import com.tropogo.jobportal.model.JobType;
import com.tropogo.jobportal.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JobTypeRepository extends JpaRepository<JobType, UUID> {

    List<JobType> findByOrderByTypeAsc();

}
