package com.cinexpress.videofriend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinexpress.videofriend.models.Company;
import com.cinexpress.videofriend.repository.CompanyRepository;
import com.cinexpress.videofriend.services.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company createCompany(Company company) {
        try {
            return companyRepository.save(company);
        } catch (Exception e) {
            throw new RuntimeException("Error creating company", e);
        }
    }

    @Override
    public void deleteCompany(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteCompany'");
    }

}
