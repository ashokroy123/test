package com.app.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;



/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		EmployeeDao dao = new EmployeeDaoImpl();
		int empId = new Integer(req.getParameter("empid"));
		
		boolean deleted = dao.removeEmployee(empId);
		System.out.println(deleted);
		req.getRequestDispatcher("/allEmp").forward(req, res);
	
	}

}
