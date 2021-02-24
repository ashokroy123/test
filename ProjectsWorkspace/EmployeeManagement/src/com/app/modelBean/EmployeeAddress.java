package com.app.modelBean;

public class EmployeeAddress {
private int empId;
private String presentAddress;
private String permanentAddress;
public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
public String getPresentAddress() {
	return presentAddress;
}
public void setPresentAddress(String presentAddress) {
	this.presentAddress = presentAddress;
}
public String getPermanentAddress() {
	return permanentAddress;
}
public void setPermanentAddress(String permanentAddress) {
	this.permanentAddress = permanentAddress;
}
@Override
public String toString() {
	return "EmployeeAddress [empId=" + empId + ", presentAddress=" + presentAddress + ", permanentAddress="
			+ permanentAddress + "]";
}
}

