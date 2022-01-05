package com.code;

import java.io.IOException;
import java.util.Scanner;

public class Home {
	
	public static void main(String [] args) throws IOException {
	     Scanner bfr = new Scanner (System.in);
		while(true) {
			
			
		System.out.println("\n\n**********  WEL-COME IN LIBRARY MANAGEMENT SYSTEM   **********");
		System.out.println("\t\tPress 1 for Login ");
		System.out.println("\t\tPress 2 for Create Account");
		System.out.println("\t\tPress 3 for Exit ");
		
		int c= bfr.nextInt();
		
		if(c==1) {
		//	System.out.println("Login Successfully ...");
			System.out.println("Enter User Name :");
			String usname = bfr.next();
			System.out.println("Enter Password : ");
			String pass = bfr.next();
			
		  login.Sign(usname, pass);
		  
		}
		else if (c==2){
			System.out.println("Enter User Name :");
			String usname = bfr.next();
			System.out.println("Enter Password : ");
			String pass = bfr.next();
			
			boolean f = login.CreateAccount(usname,pass);
			if(f==true)
			System.out.println("Account is Created Successfully ...");
			else
				System.out.println("SomeWhere is Problem Please Try Again");
		}
		else if(c==3) {
			break;
		}
		else {
			System.out.println("Something Problem in System , Please Try Again ");
		}
		
		}
		bfr.close();
	}

}
