package com.code;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;



public class lib_action {

public static boolean addStudent(int stid , String stname,
String stfather,String stcourse,String stbranch,String styear , String stSem) {
	boolean f=false;
	
	try {
		Connection con = (Connection) ConnectConnection.createC();
		String q = "insert into student(student_id,name,father,course,"
				+ "branch,year,semester)values(?,?,?,?,?,?,?);";
		PreparedStatement pstmt = con.prepareStatement(q);
		pstmt.setInt(1, stid);
        pstmt.setString(2, stname);
        pstmt.setString(3, stfather);
        pstmt.setString(4, stcourse);
        pstmt.setString(5, stbranch);
        pstmt.setString(6,styear);
        pstmt.setString(7,stSem);

		pstmt.executeUpdate();
		f=true;
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return f;
	
	
	
}	
public static boolean addBook( String bkname,String bkpub , String bkauth) {
	boolean f=false;
	
	try {
		Connection con = (Connection) ConnectConnection.createC();
		String q = "insert into book(bookname,bookpublisher,bookauthor)values(?,?,?);";
		PreparedStatement pstmt = con.prepareStatement(q);
		pstmt.setString(1, bkname);
        pstmt.setString(2, bkpub);
        pstmt.setString(3, bkauth);
    

		pstmt.executeUpdate();
		f=true;
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return f;
	
	
	
}
public static boolean issueBook(String stuid, int bkid, String dateissue) {
	// TODO Auto-generated method stub
	boolean f=false; 
	try {
		Connection con = (Connection) ConnectConnection.createC();
		String q = "insert into issuenbook(stid,bookid,dateofissue,isreturn)values(?,?,?,?);";
		PreparedStatement pstmt = con.prepareStatement(q);
		pstmt.setString(1, stuid);
        pstmt.setInt(2, bkid);
        pstmt.setString(3, dateissue);
        pstmt.setString(4, "0");


		pstmt.executeUpdate();
		f=true;
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
	
	
	return f;
}

public static boolean returnBook(String stuid, int bkid, String datereturn) {
	// TODO Auto-generated method stub
	boolean f=false; 
	try {
		Connection con = (Connection) ConnectConnection.createC();
		String q = "update issuenbook set isreturn=?, dateofreturn = ? where stid =   ? and bookid=?";
		PreparedStatement pstmt = con.prepareStatement(q);
		boolean b= true;
pstmt.setBoolean(1,b );
pstmt.setString(2, datereturn);
pstmt.setString(3, stuid);
pstmt.setInt(4, bkid);

		pstmt.executeUpdate();
		f=true;
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
	
	
	return f;
}
public static void statisOfissue()  {
	
	try {
		//jdbc code
		Connection con = (Connection) ConnectConnection.createC();
		String q = "select student.*,book.*,issuenbook.dateofissue from student,book,issuenbook "
				+ "where  issuenbook.stid=student.stident_id and issuenbook.bookid=book.bid and issuenbook.isreturn = 0 ";
		// Statement 
		
		
		Statement stmt=(Statement) con.createStatement();
		ResultSet set= stmt.executeQuery(q);


		System.out.println("**********************************");
		System.out.println("*                                *");
		System.out.println("*   -:  Details of Issued Book :-    *");System.out.println("*                                *");
		while(set.next()) {
		
		int stid= set.getInt("student_id");
		String name= set.getString("name");
		String father=set.getString("father");
		String course = set.getString("course");
		String branch = set.getString("branch");
		String year= set.getString("year");
		String Semester=set.getString("semester");
		int bkid= set.getInt("bid");
		String bkname=set.getString("bookname");
		String bkpub= set.getString("bookpublisher");
		String bkauth=set.getString("bookauthor");
		String dateissue=set.getString("dateofissue");
		

		System.out.println("**********************************");
		System.out.println("Student Id :"+ stid);
		System.out.println("Name : "+ name);
		System.out.println("Father's Name : "+ father);
		System.out.println("Course : "+ course);
		System.out.println("Branch : "+ branch );
		System.out.println("Year : "+ year  );
		System.out.println ("Semester : "+ Semester);
		 System.out.println("Book Id : "+ bkid);
		 System.out.println("Book Name : "+ bkname);
		 System.out.println("Book Publisher : "+ bkpub);
		 System.out.println("Book Author : "+ bkauth);
		 System.out.println("Date of issue : "+ dateissue);
		
		System.out.println("**********************************");
		
		
		}
}
	catch(Exception e) {
		e.printStackTrace();
	}
}
	
	


	


	
}
