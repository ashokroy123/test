package com.app.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.modelBean.EmployeeAddress;
import com.app.modelBean.EmployeeQualification;
import com.app.modelBean.EmployeeReg;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
public class RegFormServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("in servlet");
		/*Enumeration e = req.getParameterNames();
		while (e.hasMoreElements()) {
			String str = (String) e.nextElement();
			System.out.println(str+"::"+req.getParameter(str));
		}*/
		EmployeeDao dao = new EmployeeDaoImpl();
		EmployeeReg emp=new EmployeeReg();
		emp.setEmpId((req.getParameter("employeeid")!=null) ? new Integer(req.getParameter("employeeid")) : null);
		emp.setFirstName(req.getParameter("firstname"));
		emp.setLastName(req.getParameter("lastname"));
		emp.setDateOfJoin(req.getParameter("dateofjoin"));
		emp.setDeptId(new Integer(req.getParameter("department")));
		emp.setSalary(req.getParameter("salary")!="" ? new Double(req.getParameter("salary")) : 0);
		emp.setExperience(req.getParameter("experiance"));
		
		
		emp.setMobileNumber(req.getParameter("mobilenumber"));
		emp.setEmailId(req.getParameter("email"));
		emp.setStatus(req.getParameter("status"));
		
		if(req.getParameter("presentaddress")!="" || req.getParameter("permanentaddress")!="") {
		EmployeeAddress addr=new EmployeeAddress();
		addr.setPresentAddress(req.getParameter("presentaddress"));
		addr.setPermanentAddress(req.getParameter("permanentaddress"));
		emp.setAddress(addr);
		}
		
		if(req.getParameter("qualification")!="") {
		EmployeeQualification qual=new EmployeeQualification();
		qual.setQualification(req.getParameter("qualification"));
		qual.setCollegeName(req.getParameter("college"));
		qual.setPercentage(req.getParameter("percentage")!=""? new Double(req.getParameter("percentage")):0);
		qual.setYearOfpassedout(req.getParameter("year") !=""?new Integer(req.getParameter("year")):0);
		emp.setQualification(qual);
		}
		
		System.out.println(emp);
		if(emp.getEmpId() == null) {
			boolean saved = dao.saveEmployee(emp);
			System.out.println(saved);
			req.getRequestDispatcher("/allEmp").forward(req, res);
		}else {
			EmployeeReg empMod = dao.modifyEmployee(emp);
			System.out.println(empMod);
			req.getRequestDispatcher("/allEmp").forward(req, res);
		}
	}

}
