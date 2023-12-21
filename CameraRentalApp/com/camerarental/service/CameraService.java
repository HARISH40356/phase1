package com.camerarental.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.camerarental.bean.Camera;

public class CameraService {

	static List<Camera> listOfCamera = new ArrayList<>();
	static int id = 0;
	
	Scanner sc = new Scanner(System.in);
	
	//addCamera method
	public void addCamera() {
		//reading camera details to add camera
		System.out.print("ENTER THE CAMERA BRAND -");
		String brand = sc.next();
		System.out.print("ENTER THE CAMERA MODEL - ");
		String model = sc.next();
		System.out.print("ENTER THE PER DAY PRICE (INR) - ");
		float amount = sc.nextFloat();
		//setting camera details
		Camera cc = new Camera();
		cc.setBrand(brand);
		cc.setModel(model);
		cc.setPerDayPrice(amount);
		
			//listOfCamera.add(cc);
		//if camera added then setting camera personal details
		if(listOfCamera.add(cc)) {
			id++;
			cc.setId(id);
			cc.setStatus("Available");
		}
		System.out.println("YOUR CAMERA HAS BEEN SUCCESSFULLY ADDED TO THE LIST.");
	}
	
	//removeCamera method
	public void removeCamera() {
		//if camera is not available we cant remove camera from list
		if(listOfCamera.size() == 0) {
			System.out.println("No cameras are available.");
		}
		//if camera is available we can remove camera from list
		else {
			
			//calling viewAllCamera method to see available cameras to remove camera
			viewAllCamera(); 
			System.out.println("=========================================================================================");
			System.out.print("ENTER THE CAMERA ID TO REMOVE - ");
			//reading id through keyboard to remove camera
			int id1 = sc.nextInt();
			int flag = 0;
			Iterator<Camera>li = listOfCamera.iterator();
			//checking with id camera available or not from the list of cameras
			for(Camera cc : listOfCamera) {
				if(cc.getId() == id1) {
					//if id is available remove camera
					listOfCamera.remove(id1-1);
					id--;
					flag++;
					System.out.println("CAMERA SUCCESSFULLY REMOVED FROM THE LIST.");
					break;
				}
			}
			//if id is not available then print message
			if(flag == 0) {
				System.out.println("CAMERA NOT EXIST WITH THIS ID.");
			}
		}
		
	}
	
	//viewAllCamera method
	public void viewAllCamera() {
		//if no cameras print message
		if(listOfCamera.size() == 0) {
			System.out.println("No cameras available.");
		}
		else {
			System.out.println("=========================================================================================");
			System.out.println("CAMERA ID              BRAND             MODEL          PRICE(PER DAY)             STATUS");
			System.out.println("=========================================================================================");
			//if cameras available display all available cameras
			Iterator<Camera> li = listOfCamera.iterator();
			while(li.hasNext()) {
				Camera cc = li.next();
				System.out.println(cc);  // toString method 
			}
			System.out.println("=========================================================================================");
		}
	}
	
	static float walletAmount = 500;
	//myWallet method
	public void myWallet() {
		System.out.println("YOUR CURRENT WALLET BALANCE IS INR."+walletAmount);
		System.out.print("DO YOU WANT TO DEPOSIT MORE AMOUNT INTO YOUR WALLET?(YES/NO) - ");
		String opt = sc.next();
		if(opt.equalsIgnoreCase("yes")) {
			System.out.print("ENTER YOUR AMOUNT (INR) - ");
			int addWallet = sc.nextInt();
			//adding amount to wallet amount
			walletAmount += addWallet;
			System.out.println("YOUR WALLET BALANCE UPDATED SUCCESSFULLY. CURRENT WALLET BALANCE (INR) - "+	walletAmount);
		}
	}
	
	//rentCamera method
	public void rentCamera() {
		
		//calling viewAllCamera method to see available cameras to get a camera rent
		viewAllCamera();
		System.out.print("ENTER THE CAMERA ID YOU WANT TO RENT - ");
		int id = sc.nextInt();
		int flag = 0;
		Iterator<Camera> li = listOfCamera.iterator();
		while(li.hasNext()) {
			Camera cam = li.next();
			//checking camera available or not for rent and i have sufficient wallet amount or not to take camera rent
			if(cam.getId() == id && cam.getStatus().equals("Available") && walletAmount >= cam.getPerDayPrice()) {
				flag++;
				cam.setStatus("Rented");
				walletAmount -= cam.getPerDayPrice();
				System.out.println("CAMERA RENTED SUCCESSFULLY ");
			}
		}
		if(flag == 0) {
			System.out.println("ERROR : TRANSACTION FAILED DUE TO INSUFFICIENT BALANCE PLEASE DEPOSIT AMOUNT TO YOUR WALLET\nCAMERA NOT EXIST WITH THIS ID.");
		}
	}
	
}