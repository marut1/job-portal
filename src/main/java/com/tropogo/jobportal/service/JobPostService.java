package com.tropogo.jobportal.service;

import com.tropogo.jobportal.exception.DuplicateEntryException;
import com.tropogo.jobportal.exception.UnProcessableRequestException;
import com.tropogo.jobportal.model.JobPost;
import com.tropogo.jobportal.request.JobPostRequest;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface JobPostService {

    List<JobPost> getJobList();

    void createJobPost(JobPost jobPost, BindingResult bindingResult) throws UnProcessableRequestException, DuplicateEntryException;

    void  validateRequest(BindingResult bindingResult) throws UnProcessableRequestException;
}
