package com.controller;

import java.util.Scanner;

public class MainController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(true) {
		System.out.println("WELCOME");
		System.out.println("Press 1 :customers");
		System.out.println("Press 2 :Products");
		System.out.println("Press 3 :Orders");
		System.out.println("Press 4: Inventory ");
		System.out.println("Press 0: EXIT");
		
		int input = sc.nextInt(); // INPUT FROM USER
		
		if(input == 0) { // FOR EXITING
			System.out.println("Leaving Car rental...");
			break;
		}
		switch(input) {
		case 1: 
			System.out.println("Customers");
			CustomerController.customerMenu();
			break;
			
		case 2:
			System.out.println("Products");
			ProductController.ProductsMenu();
			break;
			
		case 3:
			System.out.println("Orders");
			OrdersController.OrdersMenu();
			break;
	
			
		case 4:
			System.out.println("Inventory");
			InventoryController.InventoryMenu();
			break;
			
		default:
			System.out.println("Invalid Input");
			break;
		}
		
	}
	sc.close();

		
		}
		
	}

