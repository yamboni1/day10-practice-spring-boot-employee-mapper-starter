package com.afs.restapi.service.dto;

public class CompanyRequest {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public CompanyRequest(String name) {
        this.name = name;
    }
    public CompanyRequest(){}
}
