package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.model.Applicants;
import com.model.Jobs;
import com.service.JobsService;

public class JobsController {

	public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    JobsService jobsService = new JobsService();
		while(true) {
			System.out.println("----------Customer Menu------------"); // MAIN MENU
			System.out.println("Press 1.View Jobs");
			System.out.println("Press 2.Get applicants by job id");
			System.out.println("Press 0. EXIT");
			int input = sc.nextInt(); // INPUT FROM USER
			
			if(input == 0) { // FOR EXITING
				System.out.println("Logging out");
				break;
			}
			
			switch(input) {
			case 1:
				 try {
                     List<Jobs> jobs = jobsService.getJobListings();
                 } catch (SQLException e) {
                     System.out.println("Error fetching jobs: " + e.getMessage());
                 }
				break;
				
			case 2:
				System.out.println("Enter job ID:");
                int jobId = sc.nextInt();
                try {
                    List<Applicants> applicants = jobsService.getApplicantsByjobId(jobId);
                } catch (SQLException e) {
                    System.out.println("Error fetching applicants: " + e.getMessage());
                }
				break;
				
			
				
			default:
				System.out.println("Invalid Input");
				break;
			}			
		}


	}

}
