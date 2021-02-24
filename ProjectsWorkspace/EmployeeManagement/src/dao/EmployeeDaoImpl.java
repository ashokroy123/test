package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.DateFormatter;

import com.app.config.DBConnection;
import com.app.constants.Queries;
import com.app.modelBean.Employee;
import com.app.modelBean.EmployeeAddress;
import com.app.modelBean.EmployeeQualification;
import com.app.modelBean.EmployeeReg;

public class EmployeeDaoImpl implements EmployeeDao{
	
	public boolean saveEmployee(EmployeeReg emp) {
		boolean  result = false;
		
		ResultSet rs;
		Connection con=null;
		int maxEmpId = 0;
		int insertedEmp = 0;
		int insertedAddr = 0;
		int insertedQualification = 0;
		try {
			con=DBConnection.getConnect();
			
			PreparedStatement pstmt = con.prepareStatement(Queries.GET_MAX_EMP_ID);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				maxEmpId = rs.getInt(1);
			}
			System.out.println("Max EmpId::"+maxEmpId);
			
			pstmt = con.prepareStatement(Queries.INSERT_EMPLOYEE_DETAILS);
			pstmt.setInt(1, ++maxEmpId);
			pstmt.setString(2, emp.getFirstName());
			pstmt.setString(3, emp.getLastName());
			pstmt.setString(4, emp.getDateOfJoin());
			pstmt.setInt(5, emp.getDeptId());
			pstmt.setDouble(6, emp.getSalary());
			pstmt.setString(7, emp.getExperience());
			pstmt.setDouble(8, new Double(emp.getMobileNumber()));
			pstmt.setString(9, emp.getEmailId());
			pstmt.setString(10, emp.getStatus());
			insertedEmp = pstmt.executeUpdate();

			EmployeeAddress empAddr= emp.getAddress();
			if(empAddr != null) {
				pstmt=con.prepareStatement(Queries.INSERT_EMPLOYEE_ADDRESS);
				pstmt.setInt(1, maxEmpId);
				pstmt.setString(2, empAddr.getPresentAddress());
				pstmt.setString(3, empAddr.getPermanentAddress());
				insertedAddr = pstmt.executeUpdate();
				System.out.println(insertedAddr);
				
			}
			
			EmployeeQualification qual  = emp.getQualification();
			if(qual != null) {
					pstmt=con.prepareStatement(Queries.INSERT_EMPLOYEE_QUALIFICATIONS);
					pstmt.setInt(1, maxEmpId);
					pstmt.setString(2,qual.getQualification());
					pstmt.setString(3, qual.getCollegeName());
					pstmt.setDouble(4, qual.getPercentage());
					pstmt.setInt(5, qual.getYearOfpassedout());
					insertedQualification = pstmt.executeUpdate();
					System.out.println(insertedQualification);
			}
			if(insertedEmp>0) {
				result = true;
			}	
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.closeConnection(con);
		}
		
		
		return result;
	}
	public EmployeeReg modifyEmployee(EmployeeReg emp){
		
		Connection con=null;
		int updatedEmp = 0;
		int updatedAddr = 0;
		int updatedQualification = 0;
		try {
			con=DBConnection.getConnect();
			PreparedStatement pstmt = con.prepareStatement(Queries.UPDATE_EMPLOYEE_DETAILS);
			
			pstmt.setString(1, emp.getFirstName());
			pstmt.setString(2, emp.getLastName());
			pstmt.setString(3, emp.getDateOfJoin());
			pstmt.setInt(4, emp.getDeptId());
			pstmt.setDouble(5, emp.getSalary());
			pstmt.setString(6, emp.getExperience());
			pstmt.setDouble(7, new Double(emp.getMobileNumber()));
			pstmt.setString(8, emp.getEmailId());
			pstmt.setString(9, emp.getStatus());
			pstmt.setInt(10, emp.getEmpId());
			updatedEmp = pstmt.executeUpdate();
		 if(updatedEmp>0) {
			EmployeeAddress empAddr= emp.getAddress();
			 pstmt=con.prepareStatement(Queries.DELETE_EMPLOYEE_ADDRESS);
				pstmt.setInt(1,emp.getEmpId());
				int deleteAddr = pstmt.executeUpdate();
				System.out.println(deleteAddr);

			if(empAddr != null) {
				pstmt=con.prepareStatement(Queries.INSERT_EMPLOYEE_ADDRESS);
				pstmt.setInt(1, emp.getEmpId());
				pstmt.setString(2, empAddr.getPresentAddress());
				pstmt.setString(3, empAddr.getPermanentAddress());
				updatedAddr = pstmt.executeUpdate();
				System.out.println(updatedAddr);
			}
			
			EmployeeQualification qual = emp.getQualification();
			pstmt=con.prepareStatement(Queries.DELETE_EMPLOYEE_QUALIFICATIONS);
			pstmt.setInt(1, emp.getEmpId()); 
			int deletedQual = pstmt.executeUpdate();
			System.out.println(deletedQual);
			
			if(qual != null) {
				pstmt=con.prepareStatement(Queries.INSERT_EMPLOYEE_QUALIFICATIONS);
				pstmt.setInt(1, emp.getEmpId());
				pstmt.setString(2,qual.getQualification());
				pstmt.setString(3, qual.getCollegeName());
				pstmt.setDouble(4, qual.getPercentage());
				pstmt.setInt(5, qual.getYearOfpassedout());
				int insertedQualification = pstmt.executeUpdate();
				System.out.println(insertedQualification);
			}
		  }	
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.closeConnection(con);
		}
		
		
		return emp;
	
	}

	public EmployeeReg getEmployeeByEmpId(int empId){
		ResultSet rs=null;
		ResultSet rs2=null;
		Connection con=null;
		EmployeeReg emp=null;
		try {
			con=DBConnection.getConnect();
			PreparedStatement pstmt=con.prepareStatement(Queries.EMPLOYEE_DATA_BY_ID);
			pstmt.setInt(1, empId);
			rs=pstmt.executeQuery();
			if (rs.next()) {
				emp=new EmployeeReg();
				emp.setEmpId(rs.getInt("EMP_ID"));
				emp.setFirstName(rs.getString("FIRST_NAME"));
				emp.setLastName(rs.getString("LAST_NAME"));
				emp.setDateOfJoin(rs.getString("DATE_OF_JOIN"));
				emp.setDeptId(rs.getInt("DEPT_ID"));
				emp.setDeptName(rs.getString("DEPT_NAME"));
				emp.setSalary(rs.getDouble("SALARY"));
				emp.setExperience(rs.getString("EXPERIENCE"));
				emp.setMobileNumber(rs.getString("MOBILE_NUMBER"));
				emp.setEmailId(rs.getString("EMAIL_ID"));
				emp.setStatus(rs.getString("STATUS"));
				if(rs.getString("PRESENT_ADDRESS") != null){
					EmployeeAddress addr=new EmployeeAddress();
					addr.setEmpId(empId);
					addr.setPresentAddress(rs.getString("PRESENT_ADDRESS"));
					addr.setPermanentAddress(rs.getString("PERMANENT_ADDRESS"));
					emp.setAddress(addr);
				}
				
				pstmt=con.prepareStatement(Queries.GET_QUALIFICATION_DETAILS);
				pstmt.setInt(1, empId);
				rs2=pstmt.executeQuery();
				
				if(rs2.next()) {
					EmployeeQualification qual = new EmployeeQualification();
					qual.setEmpId(empId);
					qual.setQualification(rs2.getString("QUALIFICATION"));
					qual.setCollegeName(rs2.getString("COLLEGE_NAME"));
					qual.setPercentage(rs2.getDouble("PERCENTAGE"));
					qual.setYearOfpassedout(rs2.getInt("YEAR_OF_PASSED_OUT"));
					emp.setQualification(qual);
				}
				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DBConnection.closeConnection(con);
			
		}
		
		return emp;
	}

	public List<Employee> allEmployees(){
		ResultSet rs=null;
		Connection con=null;
		List<Employee> allEmp=new ArrayList<Employee>();
		try {
		con=DBConnection.getConnect();
		PreparedStatement stmt=con.prepareStatement(Queries.ALL_EMPLOYEE_DETAILS);
		rs=stmt.executeQuery();
		while (rs.next()) {
			Employee emp=new Employee();
			emp.setEmpId(rs.getInt("EMP_ID"));
			emp.setName(rs.getString("FIRST_NAME")+" "+rs.getString("LAST_NAME"));
			emp.setDateOfJoin(new SimpleDateFormat("dd-MMM-YYYY").format(new java.util.Date(rs.getDate("DATE_OF_JOIN").getTime())));
			emp.setDeptId(rs.getInt("DEPT_ID"));
			emp.setDepartmentName(rs.getString("DEPT_NAME"));
			emp.setMobileNumber(rs.getString("MOBILE_NUMBER"));
			emp.setEmailId(rs.getString("EMAIL_ID"));
			emp.setHighestQualification(rs.getString("QUALIFICATION") !=null ? rs.getString("QUALIFICATION") : "");
			
			allEmp.add(emp);
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DBConnection.closeConnection(con);
		}
	
	return allEmp;
	}
	public boolean removeEmployee(int empId) {
		boolean  result = false;
		Connection con = null;
		int deletedEmp = 0;
		int deletedAddr = 0;
		int deletedQual = 0;
		
		try {
			con=DBConnection.getConnect();
			PreparedStatement pstmt=con.prepareStatement(Queries.DELETE_EMPLOYEE_DETAILS);
			pstmt.setInt(1, empId);
			deletedEmp=pstmt.executeUpdate();
			
			if(deletedEmp > 0) {
				pstmt=con.prepareStatement(Queries.DELETE_EMPLOYEE_ADDRESS);
				pstmt.setInt(1, empId);
				deletedAddr=pstmt.executeUpdate();
				System.out.println(""+deletedAddr);
				
				pstmt=con.prepareStatement(Queries.DELETE_EMPLOYEE_QUALIFICATIONS);
				pstmt.setInt(1, empId); 
				deletedQual = pstmt.executeUpdate();
				System.out.println(""+deletedQual);
				
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DBConnection.closeConnection(con);
		}
		return result;
	}

}
