package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.model.Applicants;
import com.service.ApplicantService;

public class ApplicantController {

	public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         ApplicantService service = new ApplicantService();
		 while(true) {
			System.out.println("----------Applicant Menu------------"); // MAIN MENU
			System.out.println("Press 1. Create Profile");
			System.out.println("Press 2. Apply for job");
			System.out.println("Press 3 get all applicants");
			System.out.println("Press 0. EXIT");
			int input = sc.nextInt(); // INPUT FROM USER
			
			if(input == 0) { // FOR EXITING
				System.out.println("Logging out");
				break;
			}
			
			switch(input) {
			case 1:
				 System.out.println("Enter First Name:");
                 String firstName = sc.next();
                 System.out.println("Enter Last Name:");
                 String lastName = sc.next();
                 System.out.println("Enter Email:");
                 String email = sc.next();
                 System.out.println("Enter Phone:");
                 String phone = sc.next();
                 System.out.println("Enter Resume:");
                 String resume = sc.next();
                 try {
                     if (service.createProfile(firstName, lastName, email, phone, resume)) {
                         System.out.println("Profile created successfully.");
                     } else {
                         System.out.println("Failed to create profile.");
                     }
                 } catch (SQLException e) {
                     System.out.println("Error: " + e.getMessage());
                 }
				break;
				
			case 2:
				 System.out.println("Enter Applicant ID:");
                 int applicantID = sc.nextInt();
                 System.out.println("Enter Job ID:");
                 int jobID = sc.nextInt();
                 System.out.println("Enter Cover Letter:");
                 String coverLetter = sc.next();
                 try {
                     int status = service.applyForJob(applicantID, jobID, coverLetter);
                     if (status == 1) {
                         System.out.println("Successfully applied for job.");
                     } else {
                         System.out.println("Failed to apply for job.");
                     }
                 } catch (SQLException e) {
                     System.out.println("Error: " + e.getMessage());
                 }
				break;
			
			case 3:
				 try {
                     List<Applicants> applicants = service.getApplicants();
                     if (applicants.isEmpty()) {
                         System.out.println("No applicants found.");
                     } else {
                         System.out.println("List of Applicants:");
                         for (Applicants applicant : applicants) {
                             System.out.println(applicant);
                         }
                     }
                 } catch (SQLException e) {
                     System.out.println("Error: " + e.getMessage());
                 }
                 break;
			default:
				System.out.println("Invalid Input");
				break;
			}			
		}
        
	}

}
