package com.model;

public class Company {
    private int companyID;
    private String CompanyName;
    private String location;
	public int getCompanyID() {
		return companyID;
	}
	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Company(String companyName, String location) {
        super();
        this.CompanyName = companyName;
        this.location = location;
    }
	public Company(int companyID, String companyName, String location) {
		super();
		this.companyID = companyID;
		CompanyName = companyName;
		this.location = location;
	}

	@Override
	public String toString() {
		return "Company [companyID=" + companyID + ", CompanyName=" + CompanyName + ", location=" + location + "]";
	}
	
    
}
