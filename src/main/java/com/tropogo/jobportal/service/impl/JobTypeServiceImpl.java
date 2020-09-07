package com.tropogo.jobportal.service.impl;

import com.tropogo.jobportal.model.JobType;
import com.tropogo.jobportal.respository.JobTypeRepository;
import com.tropogo.jobportal.service.JobTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobTypeServiceImpl implements JobTypeService {

    @Autowired
    JobTypeRepository jobTypeRepository;

    public JobTypeServiceImpl() {
    }

    public JobTypeServiceImpl(JobTypeRepository jobTypeRepository) {
        this.jobTypeRepository = jobTypeRepository;
    }

    @Override
    public List<JobType> getJobTypeList() {
        return jobTypeRepository.findByOrderByTypeAsc();
    }
}
