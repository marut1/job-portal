package com.tropogo.jobportal.service.impl;

import com.tropogo.jobportal.model.Company;
import com.tropogo.jobportal.respository.CompanyRepository;
import com.tropogo.jobportal.service.CompanyService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CompanyServiceImplTest {

    @InjectMocks
    CompanyService companyService;

    @Test
    void getCompanyListTest() {
        CompanyRepository companyRepositoryMock = Mockito.mock(CompanyRepository.class);
        List<Company> companyList = new ArrayList<>();
        Company company = new Company(UUID.randomUUID(), "Tropogo");
        companyList.add(company);

        when(companyRepositoryMock.findByOrderByNameAsc()).thenReturn(companyList);

        companyService = new CompanyServiceImpl(companyRepositoryMock);

        List<Company> response = companyService.getCompanyList();

        verify(companyRepositoryMock, times(1)).findByOrderByNameAsc();
        assertEquals(company, response.get(0));
    }
}