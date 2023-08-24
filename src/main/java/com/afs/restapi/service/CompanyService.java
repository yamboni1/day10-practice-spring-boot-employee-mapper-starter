package com.afs.restapi.service;

import com.afs.restapi.entity.Company;
import com.afs.restapi.entity.Employee;
import com.afs.restapi.exception.CompanyNotFoundException;
import com.afs.restapi.repository.CompanyRepository;
import com.afs.restapi.repository.EmployeeRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {
    private final CompanyRepository companyJpaRepository;
    private final EmployeeRepository employeeRepository;

    public CompanyService(CompanyRepository companyJpaRepository, EmployeeRepository employeeRepository) {
        this.companyJpaRepository = companyJpaRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<Company> findAll() {
        return companyJpaRepository.findAll();
    }

    public Company findById(Long id) {
        return companyJpaRepository.findById(id).orElseThrow(CompanyNotFoundException::new);
    }

    public List<Company> findByPage(Integer pageNumber, Integer pageSize) {
        return companyJpaRepository.findAll(PageRequest.of(pageNumber-1, pageSize)).stream()
                .collect(Collectors.toList());
    }

    public void update(Long id, Company company) {
        Company toBeUpdatedCompany = findById(id);
        toBeUpdatedCompany.setName(company.getName());
        companyJpaRepository.save(toBeUpdatedCompany);
    }

    public Company create(Company company) {
        return companyJpaRepository.save(company);
    }

    public List<Employee> findEmployeesByCompanyId(Long id) {
        return employeeRepository.findAllByCompanyId(id);
    }

    public void delete(Long id) {
        companyJpaRepository.deleteById(id);
    }
}
