package com.test;

import java.util.ArrayList;
import java.util.List;

import com.app.modelBean.Employee;
import com.app.modelBean.EmployeeAddress;
import com.app.modelBean.EmployeeQualification;
import com.app.modelBean.EmployeeReg;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
public class EmployeeTest {
	public static void main(String[] args) throws Exception{
		EmployeeDao dao = new EmployeeDaoImpl();
		
		/*EmployeeReg emp = dao.getEmployeeByEmpId(1);
		System.out.println("getEmployeeByEmpId :: "+emp);*/
		
		/*List<Employee> allEmp = dao.allEmployees();
		System.out.println("allEmployees :: "+allEmp);*/
		
		/*EmployeeReg emp1=null;
		try
		{
				emp1=new EmployeeReg();
				
				emp1.setFirstName("anil");
				emp1.setLastName("g");
				emp1.setDateOfJoin("2018-02-13 00:00:00");
				emp1.setDeptId(1);
				emp1.setDeptName("Hr");
				emp1.setSalary(1000.0);
				emp1.setExperience("N");
				emp1.setMobileNumber("7382149196");
				emp1.setEmailId("ANILG@GMAIL.COM");
				emp1.setStatus("Active");
				
				
				EmployeeAddress addr=new EmployeeAddress();
				int empId = 0;
				addr.setEmpId(empId);
				addr.setPresentAddress("Banglore");
				addr.setPermanentAddress("Nellore");
				emp1.setAddress(addr);
				
				EmployeeQualification qual=new EmployeeQualification();
				
				qual.setQualification("Btech");
				qual.setCollegeName("Audisankara Institute of Technology");
				qual.setPercentage(66.88);
				qual.setYearOfpassedout(2017);
				emp1.setQualification(qual);
		}catch(Exception e) {
			e.printStackTrace();
		}
		boolean saved = dao.saveEmployee(emp1);
		System.out.println(saved);*/
		
		/*allEmp = dao.allEmployees();
		System.out.println("allEmployees :: "+allEmp);*/
		
		/*EmployeeReg emp = dao.getEmployeeByEmpId(1);
		System.out.println("getEmployeeByEmpId :: "+emp);
		emp.setFirstName("ANIL TEST2 MODIFY");
		EmployeeReg empReg =dao.modifyEmployee(emp);
		System.out.println(empReg);*/
		
		/*System.out.println("DELETED :: "+dao.removeEmployee(1));
		System.out.println("After Deletion");*/
		
		
	}
}
