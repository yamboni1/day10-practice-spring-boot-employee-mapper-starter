package com.afs.restapi.service;

import com.afs.restapi.entity.Company;
import com.afs.restapi.exception.CompanyNotFoundException;
import com.afs.restapi.repository.CompanyJpaRepository;
import com.afs.restapi.repository.EmployeeJpaRepository;
import com.afs.restapi.repository.InMemoryCompanyRepository;
import com.afs.restapi.entity.Employee;
import com.afs.restapi.repository.InMemoryEmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private final InMemoryCompanyRepository inMemoryCompanyRepository;
    private final InMemoryEmployeeRepository inMemoryEmployeeRepository;
    private final CompanyJpaRepository companyJpaRepository;
    private final EmployeeJpaRepository employeeJpaRepository;

    public CompanyService(InMemoryCompanyRepository inMemoryCompanyRepository, InMemoryEmployeeRepository inMemoryEmployeeRepository, CompanyJpaRepository companyJpaRepository, EmployeeJpaRepository employeeJpaRepository) {
        this.inMemoryCompanyRepository = inMemoryCompanyRepository;
        this.inMemoryEmployeeRepository = inMemoryEmployeeRepository;
        this.companyJpaRepository = companyJpaRepository;
        this.employeeJpaRepository = employeeJpaRepository;
    }

    public InMemoryCompanyRepository getCompanyRepository() {
        return inMemoryCompanyRepository;
    }

    public InMemoryEmployeeRepository getEmployeeRepository() {
        return inMemoryEmployeeRepository;
    }

    public List<Company> findAll() {
        return companyJpaRepository.findAll();
    }

    public Company findById(Long id) {
        Company company = companyJpaRepository.findById(id).orElseThrow(CompanyNotFoundException::new);
        List<Employee> employees = employeeJpaRepository.findAllByCompanyId(company.getId());
        company.setEmployees(employees);
        return company;
    }

    public List<Company> findByPage(Integer pageNumber, Integer pageSize) {
        return getCompanyRepository().findByPage(pageNumber, pageSize);
    }

    public void update(Long id, Company company) {
        Company toBeUpdatedCompany = findById(id);
        toBeUpdatedCompany.setName(company.getName());
    }

    public Company create(Company company) {
        return getCompanyRepository().insert(company);
    }

    public List<Employee> findEmployeesByCompanyId(Long id) {
        return getEmployeeRepository().findByCompanyId(id);
    }

    public void delete(Long id) {
        inMemoryCompanyRepository.deleteById(id);
    }
}
