package com.code;

import java.io.IOException;
import java.sql.ResultSet;

//import com.Management.CP;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class login {

	public static boolean CreateAccount(String usname , String pass )
	{boolean re = false ;
	try {
		Connection  con = (Connection) ConnectConnection.createC();
		String q = " insert into account (u_name,password) values (?,?);";
		// PreparedStatement 
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(q);
		pstmt.setString(1, usname);
		pstmt.setString(2, pass);
		pstmt.executeUpdate();
		re=true;

		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
	
	return re;
		
	}
	public static void Sign(String usname , String pass) throws IOException {
		boolean f=false;
		try {
			Connection con = (Connection) ConnectConnection.createC();
			String q = "select * from account ;";
			// Statement 
			
			
			Statement stmt=(Statement) con.createStatement();
			ResultSet set= stmt.executeQuery(q);


			while(set.next()) {
				
				String Cusname=set.getString(1);
				String Cpass =set.getString(2);
				if( usname.equals(Cusname)) {
					if(pass.equals(Cpass)) {
						f=true;
						break;
					}
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		if(f==true) {
			System.out.println("\n\nYou Login Successfully ....\n\n");
			library.Open_lib();
			
			
		}
		else {
			System.out.println("\n\nYou Enter the Wrong User Id and PassWord !!!\n\n");
		}
		
	
	}
	
}
