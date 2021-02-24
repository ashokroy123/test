package com.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.UserDaoImpl;
public class LoginServlet extends HttpServlet {
	 public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uname=req.getParameter("uname");
		 String pass=req.getParameter("pwd");
		 UserDao dao = new UserDaoImpl();
		 String password = dao.getPassword(uname);
		 
		 if(pass.equals(password))
		 {
			 System.out.println("Login Success");
			 
			 req.getRequestDispatcher("/jsps/EmployeeHomePage.jsp").forward(req, res);
		 }
		 else
		 {
			 System.out.println("Login failed");
			 req.setAttribute("uname", uname);
			 req.setAttribute("pwd", pass);
			 req.setAttribute("errorMessege", "Invalid UserName or Password");
			 req.getRequestDispatcher("/jsps/EmployeeLogin.jsp").forward(req, res);;  
		 }
}
}
