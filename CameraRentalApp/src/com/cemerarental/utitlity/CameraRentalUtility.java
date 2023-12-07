package com.cemerarental.utitlity;

import java.util.Scanner;

import com.camerarental.service.CameraService;

public class CameraRentalUtility {

	static Scanner sc = new Scanner(System.in);
	
	//login method
	public static void login() {
		//reading useername and password through keyboard
		System.out.print("USERNAME - ");
		String emailid = sc.next();
		System.out.print("PASSWORD - ");
		String password = sc.next();
		//checking username and password correchat or not
		if(emailid.equalsIgnoreCase("harish@gmail.com") && password.equals("harish@123")) {
			System.out.println("SUCCESSFULLY LOGIN ");
			System.out.println();
			//if username and password correct calling mainOption method
			mainOption();
		}else {
			//if username or password wrong displaying message
			System.out.println("USERNAME OR PASSWORD INCORRECT ");
		}
	}
	
	//mainOption method
	private static void mainOption() {
		CameraService cs = new CameraService();
		int choice;
		String con="";
		
		do {
			//printing options
			System.out.println();
			System.out.println("1: MY CAMERA ");
			System.out.println("2: RENT CAMERA ");
			System.out.println("3: VIEW ALL CAMERAS ");
			System.out.println("4: MY WALLET ");
			System.out.println("5: EXIT");
			System.out.print("PLEASE ENTER YOUR CHOICE: ");
			//reading the choice from above list
			choice = sc.nextInt();
			
			switch(choice) {
			//if choice is 1 it will call subMenuOption method
			case 1: subMenuOption(cs);
				break;
			//if choice is 2 it will call rentCamera method
			case 2: cs.rentCamera();
				break;
			//if choice is 3 it will call viewAllCamera method
			case 3: cs.viewAllCamera();
				break;
			//if choice is 4 it will call myWallet method
			case 4: cs.myWallet();
				break;
			//if choice is 5 it will call closeApp method
			case 5: closeApp();
				break;
			//if choice is not in above list it will print wrong choice
			default:System.out.println("WRONG CHOICE ");
			break;
			}
			//it will ask yes or no for to continue or exit
			System.out.print("DO YOU WANT TO CONTINUE(YES/NO) ");
			con = sc.next();
			if(con.equalsIgnoreCase("yes")) {
				con = "1";
			}else {
				con = "0";
			}
		}while(con.equalsIgnoreCase("1"));
	}
	
	//subMenuOption method
	private static void subMenuOption(CameraService cs) {
		int choice;
		String con="";
		//CameraService cs = new CameraService();
		do {
			//printing the sub menu list
			System.out.println();
			System.out.println("1: ADD");
			System.out.println("2: REMOVE");
			System.out.println("3: VIEW ALL CAMERAS ");
			System.out.println("4. GO TO PREVIOUS MENU ");
			System.out.print("PLEASE ENTER YOUR CHOICE: ");
			//reading choice through keyboard
			choice = sc.nextInt();
			switch(choice) {
			//if choice is 1 it will call addCamera method
			case 1: cs.addCamera();
				break;
			//if choice is 2 it will call removeCamera method
			case 2: cs.removeCamera();
				break;
			//if choice is 3 it will call viewAllCamera method
			case 3: cs.viewAllCamera();
				break;
			//if choice is 4 it will call mainOption method
			case 4: mainOption();
				break;
			//if choice is not in above list then print wrong choice
			default:System.out.println("WRONG CHOICE ");
			break;
			}
			System.out.print("DO YOU WANT TO CONTINUE(YES/NO) ");
			//it will ask yes or no for to continue or not
			con = sc.next();
			if(con.equalsIgnoreCase("yes")) {
				con = "1";
			}else {
				con = "0";
			}
		}while(con.equalsIgnoreCase("1"));
	}
	
	//closeApp method
	private static void closeApp() {
		//printing thank you message
		System.out.println("\nClosing your application... \nThank you!");
	}
}
