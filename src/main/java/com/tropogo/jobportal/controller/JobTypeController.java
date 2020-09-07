package com.tropogo.jobportal.controller;

import com.tropogo.jobportal.model.JobType;
import com.tropogo.jobportal.service.JobTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1")
public class JobTypeController {
    @Autowired
    JobTypeService jobTypeService;

    @GetMapping(value = "/job_type/all")
    public ResponseEntity<List<JobType>> getAllJobTypes() {
        return ResponseEntity.ok(jobTypeService.getJobTypeList());
    }
}
