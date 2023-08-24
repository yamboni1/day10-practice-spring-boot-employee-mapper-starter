package com.afs.restapi.service;

import com.afs.restapi.entity.Company;
import com.afs.restapi.exception.CompanyNotFoundException;
import com.afs.restapi.repository.CompanyJpaRepository;
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

    public CompanyService(InMemoryCompanyRepository inMemoryCompanyRepository, InMemoryEmployeeRepository inMemoryEmployeeRepository, CompanyJpaRepository companyJpaRepository) {
        this.inMemoryCompanyRepository = inMemoryCompanyRepository;
        this.inMemoryEmployeeRepository = inMemoryEmployeeRepository;
        this.companyJpaRepository = companyJpaRepository;
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

    public List<Company> findByPage(Integer pageNumber, Integer pageSize) {
        return getCompanyRepository().findByPage(pageNumber, pageSize);
    }

    public Company findById(Long id) {
        Company company = getCompanyRepository().findById(id).orElseThrow(CompanyNotFoundException::new);
        List<Employee> employees = getEmployeeRepository().findByCompanyId(company.getId());
        company.setEmployees(employees);
        return company;
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
