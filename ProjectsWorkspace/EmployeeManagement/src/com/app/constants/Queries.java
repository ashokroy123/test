package com.app.constants;

public interface Queries {
	
	public static final String GET_DEPARTMENT_DETAILS = "select * from BSOL_DEPARTMENT"; 
	
	public static final String GET_USER_DETAILS = "select * from BSOL_USER where UNAME=?"; 
	
	public static final String ALL_EMPLOYEE_DETAILS = "select emp.EMP_ID , emp.FIRST_NAME , emp.LAST_NAME, emp.DATE_OF_JOIN , emp.DEPT_ID,dept.DEPT_NAME, emp.MOBILE_NUMBER, emp.EMAIL_ID, qual.QUALIFICATION  " + 
			"from BSOL_EMPLOYEE_DETAILS emp " + 
			"join BSOL_DEPARTMENT dept on dept.DEPT_ID = emp.DEPT_ID  " + 
			"left outer join BSOL_EMPLOYEE_QUALIFICATIONS qual on qual.EMP_ID = emp.EMP_ID ";
	
	
	public static final String EMPLOYEE_DATA_BY_ID = "select emp.EMP_ID, emp.FIRST_NAME, emp.LAST_NAME, emp.DATE_OF_JOIN, emp.DEPT_ID,dept.DEPT_NAME, emp.SALARY, emp.EXPERIENCE, addr.PRESENT_ADDRESS, addr.PERMANENT_ADDRESS, emp.MOBILE_NUMBER, emp.EMAIL_ID, emp.STATUS " + 
			"from BSOL_EMPLOYEE_DETAILS emp  " + 
			"join BSOL_DEPARTMENT dept on emp.DEPT_ID = dept.DEPT_ID  " + 
			"left outer join BSOL_EMPLOYEE_ADDRESS addr on emp.EMP_ID = addr.EMP_ID " + 
			"where emp.EMP_ID=?";
	
	public static final String GET_QUALIFICATION_DETAILS = "select EMP_ID, QUALIFICATION, COLLEGE_NAME, PERCENTAGE, YEAR_OF_PASSED_OUT from BSOL_EMPLOYEE_QUALIFICATIONS  where EMP_ID=?";
	
	public static final String GET_MAX_EMP_ID = "select max(EMP_ID) FROM BSOL_EMPLOYEE_DETAILS";
	
	public static final String INSERT_EMPLOYEE_DETAILS = "insert into BSOL_EMPLOYEE_DETAILS(EMP_ID,FIRST_NAME,LAST_NAME,DATE_OF_JOIN,DEPT_ID,SALARY,EXPERIENCE,MOBILE_NUMBER,EMAIL_ID,STATUS) values (?,?,?,(TO_DATE(?,'yyyy-mm-dd hh24:mi:ss')),?,?,?,?,?,?) ";
			
	public static final String INSERT_EMPLOYEE_ADDRESS = "insert into BSOL_EMPLOYEE_ADDRESS(EMP_ID,PRESENT_ADDRESS,PERMANENT_ADDRESS) values(?,?,?)";
	
	public static final String INSERT_EMPLOYEE_QUALIFICATIONS = "insert into BSOL_EMPLOYEE_QUALIFICATIONS(EMP_ID,QUALIFICATION,COLLEGE_NAME,PERCENTAGE,YEAR_OF_PASSED_OUT) values (?,?,?,?,?)"; 
		
	
	public static final String UPDATE_EMPLOYEE_DETAILS = "update BSOL_EMPLOYEE_DETAILS set FIRST_NAME=?,LAST_NAME=?,DATE_OF_JOIN=(TO_DATE(?,'yyyy-mm-dd hh24:mi:ss')),DEPT_ID=?,SALARY=?,EXPERIENCE=?,MOBILE_NUMBER=?,EMAIL_ID=?,STATUS=? where EMP_ID=?";
			
	
	public static final String DELETE_EMPLOYEE_DETAILS = "delete BSOL_EMPLOYEE_DETAILS where EMP_ID=?"; 
	
	public static final String DELETE_EMPLOYEE_ADDRESS = "delete BSOL_EMPLOYEE_ADDRESS where EMP_ID=?";
	
	public static final String DELETE_EMPLOYEE_QUALIFICATIONS = "delete BSOL_EMPLOYEE_QUALIFICATIONS where EMP_ID=?"; 
	
}
