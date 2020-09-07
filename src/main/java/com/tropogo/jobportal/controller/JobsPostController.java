package com.tropogo.jobportal.controller;

import com.tropogo.jobportal.exception.DuplicateEntryException;
import com.tropogo.jobportal.exception.UnProcessableRequestException;
import com.tropogo.jobportal.model.JobPost;
import com.tropogo.jobportal.request.JobPostRequest;
import com.tropogo.jobportal.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/api/v1")
public class JobsPostController {

    @Autowired
    JobPostService jobPostService;

    @GetMapping("/job/all")
    public ResponseEntity<List<JobPost>> getAllJobs() {
        List<JobPost> val = jobPostService.getJobList();
        return ResponseEntity.ok(val);
    }

    @PostMapping("/job/post")
    public HttpStatus saveJobPost(@Valid @RequestBody JobPost jobPost, BindingResult bindingResult)
            throws UnProcessableRequestException, DuplicateEntryException {

        jobPostService.createJobPost(jobPost, bindingResult);

        return HttpStatus.CREATED;
    }

}