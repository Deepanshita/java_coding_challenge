package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.exception.InsufficientFundException;
import com.exception.InvalidPetAgeException;
import com.model.CashDonation;
import com.model.Cat;
import com.model.Dog;
import com.model.Donation;
import com.model.ItemDonation;
import com.model.Participant;
import com.model.Pet;
import com.service.CashDonationService;
import com.service.CatService;
import com.service.DogService;
import com.service.DonationService;
import com.service.ItemDonationService;
import com.service.ParticipantService;
import com.service.PetService;

public class MainController {
	public static void main(String[] args) {
		PetService petService = new PetService();
		DogService dogService = new DogService();
		CatService catService = new CatService();
		ParticipantService participantService = new ParticipantService();
		DonationService donationService = new DonationService();
		CashDonationService cashDonationService = new CashDonationService();
		ItemDonationService itemDonationService = new ItemDonationService();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println();
			System.out.println("-------------Welcome to Pet Pals-------------");
			System.out.println();
			System.out.println("Press 1. Add Pet");
			System.out.println("Press 2. Remove Pet");
			System.out.println("Press 3. Show All Available Pets");
			System.out.println("Press 4. Make Donation");
			System.out.println("Press 5. Adoption Event");
			System.out.println("Press 0. To Exit");
			System.out.print("Choose an option: ");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Exiting from Pet Pals...");
				break;
			}
			switch (input) {
			case 1:
				System.out.println();
				System.out.println("-------------Add Pet-------------");
				
				System.out.print("Enter pet name : ");
				sc.nextLine();
				String petName = sc.nextLine();
				System.out.print("Enter pet age : ");
				int petAge = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter pet type (Dog/Cat): ");
				String petType = sc.nextLine();
				int isAvailable = 1;
				Pet pet = new Pet(petName, petAge, petType, isAvailable);


				try {
				    // Add the pet
				    int petStatus = petService.save(pet);
				    System.out.println("-------------All Available Pets-------------");
					try {
						List<Pet> list = petService.getAllAvailablePets();
						for (Pet a : list)
							System.out.println(a);
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
					System.out.println("Please enter pet id");
					int petid=sc.nextInt();
					// Check if the pet was added successfully
				    if (petStatus == 1) {
				        if (petType.equalsIgnoreCase("dog")) {
				            System.out.print("Enter dog breed : ");
				            String dogBreed = sc.nextLine().trim();
				            Dog dog = new Dog(dogBreed,petid);
				            int dogStatus = dogService.save(dog);
				            if (dogStatus == 1)
				                System.out.println("Dog added successfully!!!");
				            else
				                System.out.println("Dog addition failed...");
				        } else if (petType.equalsIgnoreCase("cat")) {
				            System.out.print("Enter cat color : ");
				            String catColor = sc.nextLine().trim();
				            Cat cat = new Cat(catColor);
				            int catStatus = catService.save(cat);
				            if (catStatus == 1)
				                System.out.println("Cat added successfully");
				            else
				                System.out.println("Cat addition failed");
				        }
				    } else {
				        System.out.println("Pet addition failed...");
				    }
				} catch (SQLException e) {
				    System.out.println("Error: " + e.getMessage());
				}
				break;
			   
			case 2:
				System.out.println();
				try {
					List<Pet> list = petService.getAllPets();
					for (Pet a : list)
						System.out.println(a);
					System.out.print("Choose pet id from above to remove : ");
					int petId = sc.nextInt();
					int status = petService.removePetById(petId);
					if (status == 1)
						System.out.println("Pet removed successfully!!!");
					else
						System.out.println("Pet removal failed!!!");
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 3:
				System.out.println();
				System.out.println("-------------All Available Pets-------------");
				try {
					List<Pet> list = petService.getAllAvailablePets();
					for (Pet a : list)
						System.out.println(a);
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 4:
				System.out.println();
				System.out.println("-------------Make Donation-------------");
				try {
					sc.nextLine();
					List<Pet> list = petService.getAllPets();
					for (Pet a : list)
						System.out.println(a);
					System.out.print("Choose pet id from above to donate : ");
					int petId = sc.nextInt();
					sc.nextLine();
					System.out.print("Enter your name : ");
					String donorName = sc.nextLine().trim();
					System.out.print("Enter donation type (cash/item): ");
					String donationType = sc.nextLine();
			        Donation donation = new Donation(donorName, petId);

					int donationId = Math.abs(new Random().nextInt());
					if (donationType.equalsIgnoreCase("cash")) {
						System.out.print("Enter donation amount : ");
						double donationAmount = sc.nextDouble();
						sc.nextLine();
						System.out.print("Enter today's date : ");
						String donationDate = sc.nextLine();
						CashDonation cashDonation = new CashDonation(donationAmount, donationDate);
						int donationStatus = donationService.recordDonation(donation);
						int cashDonationStatus = cashDonationService.recordDonation(cashDonation, donationId);
						if (donationStatus == 1 && cashDonationStatus == 1)
							System.out.println("Amount donated successfully!!!");
						else
							System.out.println("Amount donation failed...");
					} else if (donationType.equalsIgnoreCase("item")) {
						System.out.print("Enter donation item name : ");
						String donationItem = sc.nextLine();
						System.out.print("Enter today's date : ");
						String donationDate = sc.nextLine();
						ItemDonation itemDonation = new ItemDonation( donationItem, donationDate);
						int donationStatus = donationService.recordDonation(donation);
						int itemDonationStatus = itemDonationService.recordDonation(itemDonation, donationId);
						if (donationStatus == 1 && itemDonationStatus == 1)
							System.out.println("Item donated successfully!!!");
						else
							System.out.println("Item donation failed...");
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} catch (InsufficientFundException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 5:
				System.out.println();
				System.out.println("-------------Adoption Event-------------");
				System.out.println();
				System.out.println("Press 1. Adopt Pet");
				System.out.println("Press 2. Register Participant");
				System.out.println("Press 3. Show All Participants");
				System.out.println("Press 0. To Back");
				System.out.print("Choose an option: ");
				input = sc.nextInt();
//				if (input == 0) {
//					MainController.main(args);
//					break;
//				}
//				switch (input) {
//				case 1:
//					break;
//
//				case 2:
//					
//
//				case 3:
//					
//
//				}
//
//				break;

			default:
				System.out.println();
				System.out.println("Please select a valid option");
			}
		}
		sc.close();
	}
}
