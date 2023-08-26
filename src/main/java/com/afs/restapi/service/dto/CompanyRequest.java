package com.afs.restapi.service.dto;

public class CompanyRequest {
    private String name;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public CompanyRequest( Long companyId, String name) {
        this.name = name;
        this.companyId = companyId;
    }

    private Long companyId;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public CompanyRequest(){}

    public CompanyRequest(String name) {
        this.name = name;
    }

}
