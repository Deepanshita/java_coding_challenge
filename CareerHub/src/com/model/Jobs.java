package com.model;

public class Jobs {
       private int jobID;
       private String title;
       private String description;
       private String location;
       private double salary;
       private String jobType;
       private String postedDate;
       private int companyID;
	public int getJobID() {
		return jobID;
	}
	public void setJobID(int jobID) {
		this.jobID = jobID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getPostedDate() {
		return postedDate;
	}
	public void setPostedDate(String postedDate) {
		this.postedDate = postedDate;
	}
	public int getCompanyID() {
		return companyID;
	}
	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}
	public Jobs() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Jobs(int jobID, String title, String description, String location, double salary, String jobType,
			String postedDate, int companyID) {
		super();
		this.jobID = jobID;
		this.title = title;
		this.description = description;
		this.location = location;
		this.salary = salary;
		this.jobType = jobType;
		this.postedDate = postedDate;
		this.companyID = companyID;
	}
	@Override
	public String toString() {
		return "Jobs [jobID=" + jobID + ", title=" + title + ", description=" + description + ", location=" + location
				+ ", salary=" + salary + ", jobType=" + jobType + ", postedDate=" + postedDate + ", companyID="
				+ companyID + "]";
	}
       
       
       
}
