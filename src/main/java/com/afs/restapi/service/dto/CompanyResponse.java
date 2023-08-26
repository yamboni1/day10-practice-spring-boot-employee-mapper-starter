package com.afs.restapi.service.dto;

public class CompanyResponse {

    private Long id;
    private String name;
    private Integer employeesCount;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEmployeesCount() {
        return employeesCount;
    }

    public void setEmployeesCount(Integer employeesCount) {
        this.employeesCount = employeesCount;
    }

    public CompanyResponse() {

    }


    public CompanyResponse(Long id, String name, Integer employeesCount) {
        this.id = id;
        this.name = name;
        this.employeesCount = employeesCount;
    }
}
