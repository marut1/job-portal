package com.tropogo.jobportal.controller;

import com.tropogo.jobportal.model.Company;
import com.tropogo.jobportal.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping(value = "/company/all")
    public ResponseEntity<List<Company>> getAllCompanies() {
        return ResponseEntity.ok(companyService.getCompanyList());
    }
}
