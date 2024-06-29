package com.loverestro;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class login extends HttpServlet {
	public void doPost(HttpServletRequest req ,HttpServletResponse res)  throws ServletException,IOException{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		pw.print("login successfully.........");
		String name=req.getParameter("username");
		System.out.print(name);
		String pass=req.getParameter("password");
		String usertype=req.getParameter("usertype");
		try {
			String user,url,password;
			int id;
			user="root";
			url="jdbc:mysql://localhost:3306/restrolove";
			password="2004";
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,user,password);
			PreparedStatement ps=con.prepareStatement("insert into login values(?,?,?)");
			ps.setString(1,name);
			ps.setString(2,pass);
			ps.setString(3,usertype);
			
			int i=ps.executeUpdate();
	
		}
		catch(Exception e) {
			System.out.println(e);
		}
		}
}
