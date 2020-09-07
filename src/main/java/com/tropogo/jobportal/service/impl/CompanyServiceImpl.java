package com.tropogo.jobportal.service.impl;

import com.tropogo.jobportal.model.Company;
import com.tropogo.jobportal.respository.CompanyRepository;
import com.tropogo.jobportal.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public CompanyServiceImpl() {
    }

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getCompanyList() {
        return companyRepository.findByOrderByNameAsc();
    }
}
