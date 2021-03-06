package com.tropogo.jobportal.respository;

import com.tropogo.jobportal.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CompanyRepository extends JpaRepository<Company, UUID> {
    List<Company> findByOrderByNameAsc();

}