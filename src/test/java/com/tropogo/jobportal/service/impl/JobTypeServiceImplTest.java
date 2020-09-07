package com.tropogo.jobportal.service.impl;

import com.tropogo.jobportal.model.JobType;
import com.tropogo.jobportal.respository.JobTypeRepository;
import com.tropogo.jobportal.service.JobTypeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class JobTypeServiceImplTest {

    @InjectMocks
    JobTypeService jobTypeService;

    @Test
    void getJobTypeList() {
        List<JobType> jobTypeList = new ArrayList<>();
        JobType jobType = new JobType(UUID.randomUUID(), "Software Tester");
        jobTypeList.add(jobType);

        JobTypeRepository jobTypeRepositoryMock = Mockito.mock(JobTypeRepository.class);

        when(jobTypeRepositoryMock.findByOrderByTypeAsc()).thenReturn(jobTypeList);

        jobTypeService = new JobTypeServiceImpl(jobTypeRepositoryMock);
        List<JobType> response = jobTypeService.getJobTypeList();

        verify(jobTypeRepositoryMock, times(1)).findByOrderByTypeAsc();
        assertEquals(jobType, response.get(0));
    }
}