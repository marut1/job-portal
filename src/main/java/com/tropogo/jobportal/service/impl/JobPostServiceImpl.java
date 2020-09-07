package com.tropogo.jobportal.service.impl;

import com.tropogo.jobportal.exception.DuplicateEntryException;
import com.tropogo.jobportal.exception.UnProcessableRequestException;
import com.tropogo.jobportal.exception.ValidationError;
import com.tropogo.jobportal.model.*;
import com.tropogo.jobportal.respository.*;
import com.tropogo.jobportal.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class JobPostServiceImpl implements JobPostService {

    @Autowired
    JobPostRepository jobPostRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    JobTypeRepository jobTypeRepository;

    @Autowired
    LocationRepository locationRepository;

    public JobPostServiceImpl() {
    }

    public JobPostServiceImpl(JobPostRepository jobPostRepository) {
        this.jobPostRepository = jobPostRepository;
    }

    @Override
    public List<JobPost> getJobList() {
        return jobPostRepository.findAll();
    }

    @Override
    public void createJobPost(JobPost jobPost, BindingResult bindingResult) throws
            UnProcessableRequestException, DuplicateEntryException {
        validateRequest(bindingResult);
        Optional<UserAccount> user = userRepository.findById(jobPost.getUserId());
        Optional<Company> company = companyRepository.findById(jobPost.getCompanyId());
        Optional<JobType> jobType = jobTypeRepository.findById(jobPost.getJobTypeId());
        Optional<Location> location = locationRepository.findById(jobPost.getLocationId());

        if (user.equals(Optional.empty()) || company.equals(Optional.empty())
                || jobType.equals(Optional.empty()) || location.equals(Optional.empty())) {
            throw new UnProcessableRequestException("Invalid request");
        }

        try {
            jobPostRepository.save(jobPost);
        } catch (Exception e) {
            throw new DuplicateEntryException("Entry already exist");
        }

    }

    @Override
    public void validateRequest(BindingResult bindingResult) throws UnProcessableRequestException {
        if (bindingResult.hasErrors()) {
            List<ValidationError> errorList = new ArrayList<>();

            for (FieldError error : bindingResult.getFieldErrors()) {
                ValidationError validationError = new ValidationError(error.getField(),
                        error.getDefaultMessage());
                errorList.add(validationError);
            }
            throw new UnProcessableRequestException("Invalid request body");
        }
    }
}
