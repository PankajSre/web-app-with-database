package com.amdocs.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegistrationController extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		long phone = Long.parseLong(request.getParameter("phone"));
		
		Connection conn = DbUtil.getConnection();
		String sql = "insert into user values(?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, username);
			ps.setString(3, password);
			ps.setString(4, email);
			ps.setLong(5, phone);
			
			int updatedRows = ps.executeUpdate();
			
			if(updatedRows > 0) {
				out.println("Data Inserted Successfully");
			}else {
				out.println("Try Again!");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
}
