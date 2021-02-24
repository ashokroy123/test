package com.app.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.modelBean.Department;
import com.app.modelBean.EmployeeQualification;
import com.app.modelBean.EmployeeReg;

import dao.DepartmentDao;
import dao.DepartmentDaoImpl;
import dao.EmployeeDao;
import dao.EmployeeDaoImpl;

/**
 * Servlet implementation class EmpDetailsServlet
 */
public class EmpDetailsServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		EmployeeDao dao = new EmployeeDaoImpl();
		DepartmentDao deptDao = new DepartmentDaoImpl(); 
		
		int empId = new Integer(req.getParameter("empid"));
		
		EmployeeReg emp = dao.getEmployeeByEmpId(empId);
		System.out.println(emp);
		req.setAttribute("emp", emp);
		
		EmployeeQualification qual = emp.getQualification();
		
		String mTechSelected = "";
		String bTechSelected = "";
		String interSelected = "";
		String sscSelected = "";
		if(qual==null) {
			// No option selected
		}else if("M.Tech".equals(qual.getQualification())) {
			mTechSelected = "selected";
		}else if("B.Tech".equals(qual.getQualification())) {
			bTechSelected = "selected";
		}else if("Intermediate".equals(qual.getQualification())) {
			interSelected = "selected";
		}else if("SSC".equals(qual.getQualification())) {
			sscSelected = "selected";
		}
		String opts="<option value='M.Tech' "+mTechSelected+">M.Tech</option>"+
		"<option value='B.Tech' "+bTechSelected+">B.Tech</option>"+
		"<option value='Intermediate' "+interSelected+">Intermediate</option>"+
		"<option value='SSC' "+sscSelected+">SSC</option>";
		req.setAttribute("opts", opts);
		int deptId=emp.getDeptId();
		List<Department> deptList = deptDao.getDepartmentDetails();
		String depts="";
		for (Department dept : deptList) {
			if(deptId == dept.getDeptId()) {
				depts = depts+"<option value='"+dept.getDeptId()+"' selected>"+dept.getDeptName()+"</option>";
			}else {
				depts = depts+"<option value='"+dept.getDeptId()+"'>"+dept.getDeptName()+"</option>";
			}
		}
		req.setAttribute("depts", depts);

		
		String activeSelected="";
		String inactiveSelected="";
		
		if("active".equals(emp.getStatus())) {
			activeSelected = "selected";
		}else {
			inactiveSelected = "selected";
		}
		String stus="<option value='active' "+activeSelected+">Active</option>"+
				"<option value='inactive' "+inactiveSelected+">Inactive</option>";
				req.setAttribute("stus", stus);
				
				
				String NSelected="";
				String YSelected="";
				
				if("N".equals(emp.getExperience())) {
					NSelected = "selected";
				}else {
					YSelected = "selected";
				}
				String exp="<option value='N' "+NSelected+">No</option>"+
						"<option value='Y' "+YSelected+">Yes</option>";
						req.setAttribute("exp", exp);

				
		req.getRequestDispatcher("/jsps/EmployeeRegisterForm.jsp").forward(req, res);
	}

}
