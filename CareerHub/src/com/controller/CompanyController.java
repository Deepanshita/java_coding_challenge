package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.model.Company;
import com.model.Jobs;
import com.service.CompanyService;

public class CompanyController {

	public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
	   CompanyService cs=new CompanyService();
		while(true) {
			System.out.println("----------Company Menu------------"); // MAIN MENU
			System.out.println("Press 1. Add a company");
			System.out.println("Press 2. List of all companies");
			System.out.println("Press 3. Post a new job listing");
			System.out.println("Press 4. List of job posted by the particular company");
			System.out.println("Press 0. EXIT");
			int input = sc.nextInt(); // INPUT FROM USER
			
			if(input == 0) { // FOR EXITING
				System.out.println("Logging out");
				break;
			}
			
			switch(input) {
			case 1:
				 System.out.println("Enter company name:");
				 sc.nextLine();
                 String companyName = sc.nextLine();
                 
                 System.out.println("Enter company location:");
                 String companyLocation = sc.nextLine();
                 Company newCompany = new Company(companyName, companyLocation);
                 try {
                     cs.insertCompany(newCompany);
                     System.out.println("Company added successfully.");
                 } catch (SQLException e) {
                     System.out.println("Failed to add company: " + e.getMessage());
                 }
				break;
				
			case 2:
				try {
                    List<Company> companies = cs.getCompanies();
                    System.out.println("List of all companies:");
                    for (Company company : companies) {
                        System.out.println(company);
                    }
                } catch (SQLException e) {
                    System.out.println("Failed to fetch companies: " + e.getMessage());
                }

				break;
				
			case 3:
				try {
				System.out.println("Enter job title:");
				sc.nextLine();
			    String jobTitle = sc.nextLine();
			    
			    System.out.println("Enter job description:");
			    sc.nextLine();
			    String jobDescription = sc.nextLine();
			    
			    System.out.println("Enter job location:");
			    String jobLocation = sc.nextLine();
			    System.out.println("Enter job salary:");
			    double salary = sc.nextDouble();
			    System.out.println("Enter job type:");
			    String jobType = sc.nextLine();
			    jobType = sc.nextLine(); 
			    System.out.println("Enter job posting date (YYYY-MM-DD):");
			    String postedDate = sc.nextLine();
			    System.out.println("Enter your company id");
			    int companyId=sc.nextInt();
			    boolean isJobPosted = cs.postJob(jobTitle, jobDescription, jobLocation, salary, jobType, postedDate, companyId);
		        if (isJobPosted) {
		            System.out.println("Job posted successfully.");
		        } else {
		            System.out.println("Failed to post job.");
		        }
		        
		    } catch (SQLException e) {
		        System.out.println("An error occurred while posting job: " + e.getMessage());
		    }
				break;
				
			case 4:
				 try {
				        System.out.println("Enter company ID:");
				        int companyId = sc.nextInt();

				        // Get job listings for the specified company
				        List<Jobs> jobs = cs.getJobs(companyId);

				        if (jobs.isEmpty()) {
				            System.out.println("No job listings found for the company.");
				        } else {
				            System.out.println("Job listings for company ID " + companyId + ":");
				            for (Jobs job : jobs) {
				                System.out.println(job);
				            }
				        }
				    } catch (SQLException e) {
				        System.out.println("An error occurred while fetching job listings: " + e.getMessage());
				    }

				break;
				
				
			default:
				System.out.println("Invalid Input");
				break;
			}			
		}


	}

}
