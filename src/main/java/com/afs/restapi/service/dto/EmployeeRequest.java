package com.afs.restapi.service.dto;

import com.afs.restapi.entity.Employee;

public class EmployeeRequest {
    private String name;

    private Long id;

    private Integer age;
    private String gender;
    private Integer salary;


    private Long companyId;

    public EmployeeRequest(Employee employee){

        this.name = employee.getName();
        this.age = employee.getAge();
        this.gender = employee.getGender();
        this.salary = employee.getSalary();
        this.companyId = employee.getCompanyId();

    }
    public EmployeeRequest(String name, Integer age, String gender, Integer salary, Long companyId) {

        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
        this.companyId = companyId;
    }
    public EmployeeRequest(Long id, String name, Integer age, String gender, Integer salary, Long companyId) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
        this.companyId = companyId;
    }



    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public Integer getSalary() {
        return salary;
    }

    public Long getCompanyId() {
        return companyId;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

}
