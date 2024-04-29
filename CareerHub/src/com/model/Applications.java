package com.model;

public class Applications {
      private int applicationsID;
      private int applicantsID;
      private int jobsID;
      private String applicationDate;
      private String coverLetter;
	public int getApplicationsID() {
		return applicationsID;
	}
	public void setApplicationsID(int applicationsID) {
		this.applicationsID = applicationsID;
	}
	public int getJobsID() {
		return jobsID;
	}
	public void setJobsID(int jobsID) {
		this.jobsID = jobsID;
	}
	public String getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(String applicationDate) {
		this.applicationDate = applicationDate;
	}
	public String getCoverLetter() {
		return coverLetter;
	}
	public void setCoverLetter(String coverLetter) {
		this.coverLetter = coverLetter;
	}

	@Override
	public String toString() {
		return "Applications [applicationsID=" + applicationsID + ", applicantsID=" + applicantsID + ", jobsID="
				+ jobsID + ", applicationDate=" + applicationDate + ", coverLetter=" + coverLetter + "]";
	}
	public Applications(int applicationsID, int applicantsID, int jobsID, String applicationDate, String coverLetter) {
		super();
		this.applicationsID = applicationsID;
		this.applicantsID = applicantsID;
		this.jobsID = jobsID;
		this.applicationDate = applicationDate;
		this.coverLetter = coverLetter;
	}
	public Applications() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getApplicantsID() {
		return applicantsID;
	}
	public void setApplicantsID(int applicantsID) {
		this.applicantsID = applicantsID;
	}
	
	
}
