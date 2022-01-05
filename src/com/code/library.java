package com.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class library {
	static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
public static void Open_lib() throws IOException {
	while(true) {
	
System.out.println("*****************************************");
System.out.println("****       Wel-Come In Library       ****");
System.out.println("*****************************************");
System.out.println("\tPress 1 to Add Student ");
System.out.println("\tPress 2 to Add Book ");
System.out.println("\tPress 3 to Issue Book ");
System.out.println("\tPress 4 to Return Book ");
System.out.println("\tPress 5 to Statisic of Issue Book ");
System.out.println("\tPress 6 to Statisic Of Return Book");
System.out.println("\tPress 7 to LOGOUT");
int c;
c=Integer.parseInt(bfr.readLine());
	
	if(c==1) {
		System.out.println("Enter the id of the Student :");
		int i= Integer.parseInt(bfr.readLine());
		System.out.println("Enter the Name of the Student: ");
		String Stustr = bfr.readLine();
		System.out.println("Enter the Father's Name  of the Student: ");
		String Fastr = bfr.readLine();
		System.out.println("Course :");
		String Costr=bfr.readLine();
		System.out.println("Branch :");
		String Brastr=bfr.readLine();
		System.out.println("Year : ");
		String yrstr=bfr.readLine();
		System.out.println("Semester : ");
		String Semstr=bfr.readLine();
		boolean ans = lib_action.addStudent(i, Stustr, Fastr, Costr, Brastr, yrstr, Semstr);
if(ans == true ) {
		System.out.println("Student is added successfully ... ");
}
else {
	System.out.println("Something is Poblem in Adding a Student in System, Please Try Again ");
}
	}
	else if(c==2) {
		System.out.println("Enter Book Name :");
		String bkstr = bfr.readLine();
		System.out.println("Enter the Publisher Name :");
		String bkpub=bfr.readLine();
		System.out.println("Enter Name of Author :");
		String bkauth=bfr.readLine();
		System.out.println("Book  is added Successfully... ");
		boolean ans = lib_action.addBook(bkstr, bkpub, bkauth);
		if (ans == true) {
			System.out.println("Book is Added Successfully ...");
			
		}
		else {
			System.out.println("Something is Poblem in Adding a System in System, Please Try Again ");
		}
	}
	else if ( c==3 ) {
		// this is for issue book 
		System.out.println("Enter the Student Id :");
		String stid = bfr.readLine();
		System.out.println("Enter Book Id :");
		
		int  bkid = Integer.parseInt(bfr.readLine());
		System.out.println("Date Of Issue: (In the format of YYYY-MM-DD )");
		String issuedate= bfr.readLine();
		
		boolean ans = lib_action.issueBook(stid , bkid , issuedate);
		if (ans == true) {
			System.out.println("Book is issued Successfully ...");
			
		}
		else {
			System.out.println("Something is Poblem in Adding a System in System, Please Try Again ");
		}
		
		
	}
	else if ( c==4 ) {
		// this is for return book 
		System.out.println("Enter the Student Id :");
		String stid = bfr.readLine();
		System.out.println("Enter Book Id :");
		
		int  bkid = Integer.parseInt(bfr.readLine());
		System.out.println("Date Of Return: (In the format of YYYY-MM-DD )");
		String redate= bfr.readLine();
		
		boolean ans = lib_action.returnBook(stid , bkid , redate);
		if (ans == true) {
			System.out.println("Book is returned Successfully ...");
			
		}
		else {
			System.out.println("Something is Poblem in Adding a System in System, Please Try Again ");
		}
		
		
	}
	else if(c==5) {
		lib_action.statisOfissue();
	}
	else if(c==7) {
		System.out.println(" \n\nLogout Successfully...\n\n");
		break;
	}
	else {
		System.out.println("\n\nSomeWhere Problem in Portal , Please Try Again !!!!\n\n");
		
	}
	
	}

}
	
	
}
