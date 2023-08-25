package com.afs.restapi.service.dto;

public class CompanyResponse {

    private Long id;
    private String name;
    private Integer employeeCount;



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

    public Integer getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(Integer employeeCount) {
        this.employeeCount = employeeCount;
    }
    public CompanyResponse(){

    }


    public CompanyResponse(Long id, String name, Integer employeeCount) {
        this.id = id;
        this.name = name;
        this.employeeCount = employeeCount;
    }
}
