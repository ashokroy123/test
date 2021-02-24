package com.app.modelBean;

import java.sql.Date;

public class EmployeeQualification {
private int empId;
private String qualification;
private String collegeName;
private Double percentage;
private Integer yearOfpassedout;
public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
public String getQualification() {
	return qualification;
}
public void setQualification(String qualification) {
	this.qualification = qualification;
}
public String getCollegeName() {
	return collegeName;
}
public void setCollegeName(String collegeName) {
	this.collegeName = collegeName;
}
public Double getPercentage() {
	return percentage;
}
public void setPercentage(Double percentage) {
	this.percentage = percentage;
}
public Integer getYearOfpassedout() {
	return yearOfpassedout;
}
public void setYearOfpassedout(Integer yearOfpassedout) {
	this.yearOfpassedout = yearOfpassedout;
}
@Override
public String toString() {
	return "EmployeeQualification [empId=" + empId + ", qualification=" + qualification + ", collegeName=" + collegeName
			+ ", percentage=" + percentage + ", yearOfpassedout=" + yearOfpassedout + "]";
}


}
