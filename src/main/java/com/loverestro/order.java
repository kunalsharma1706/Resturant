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

public class order extends HttpServlet{
	public void doPost(HttpServletRequest req ,HttpServletResponse res)  throws ServletException,IOException{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		pw.print("order placed successfully");
		String cake=req.getParameter("cake");
		String cakeno=req.getParameter("cakeno");
		String chinese=req.getParameter("chinese");
		String chineseno=req.getParameter("chineseno");
		String italian=req.getParameter("italian");
		String italianno=req.getParameter("italianno");
		String fastfood=req.getParameter("fastfood");
		String fastfoodno=req.getParameter("fastfoodno");


		try {
			String user,url,password;
			user="root";
			url="jdbc:mysql://localhost:3306/kunalrestro";
			password="kunal@123";
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,user,password);
			PreparedStatement ps=con.prepareStatement("insert into khano values(?,?,?,?,?,?,?,?)");
			ps.setString(1,cake);
			ps.setString(2,cakeno);
			ps.setString(3,chinese);
			ps.setString(4,chineseno);
			ps.setString(5,italian);
			ps.setString(6,italianno);
			ps.setString(7,fastfood);
			ps.setString(8,fastfoodno);
		
			int i=ps.executeUpdate();
			if(i>0) {
				pw.print("order successfully placed........");
			}
			else {
				pw.print("order is not successfully placed...........");
			}
	
		}
		catch(Exception e) {
			System.out.println(e);
		}
		}
}
