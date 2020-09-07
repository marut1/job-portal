package com.tropogo.jobportal.service.impl;

import com.tropogo.jobportal.model.*;
import com.tropogo.jobportal.respository.JobPostRepository;
import com.tropogo.jobportal.service.JobPostService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class JobPostServiceImplTest {

    @InjectMocks
    JobPostService jobPostService;

    @Test
    void getJobListTest() {
        List<JobPost> jobPostList = new ArrayList<>();
        UUID locationId = UUID.randomUUID();
        UUID companyId = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        UUID jobTypeId = UUID.randomUUID();
        List<Skills> skills = new ArrayList<>();
        Skills skill = new Skills(UUID.randomUUID(), "JAVA");
        skills.add(skill);
        Company company = new Company(companyId, "Tropogo");
        Location location = new Location(locationId, "address", "city",
                "state", "country", "zip");
        UserAccount user = new UserAccount(userId, "First", "Last",
                "abc@gmail.com", "9876543210",company, location);
        JobType jobType = new JobType(jobTypeId, "Software Tester");
        JobPost jobPost = new JobPost(UUID.randomUUID(),"title","description", 1,2,null, null, userId,
                locationId, jobTypeId, companyId, user, company, skills, jobType, location);
        jobPostList.add(jobPost);
        JobPostRepository jobPostRepositoryMock = Mockito.mock(JobPostRepository.class);

        when(jobPostRepositoryMock.findAll()).thenReturn(jobPostList);

        jobPostService = new JobPostServiceImpl(jobPostRepositoryMock);

        List<JobPost> response = jobPostService.getJobList();

        verify(jobPostRepositoryMock, times(1)).findAll();
        assertEquals(jobPost, response.get(0));

    }

}