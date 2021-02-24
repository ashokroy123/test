<%@page import="java.util.List"
		import="dao.EmployeeDao, dao.EmployeeDaoImpl, com.app.modelBean.Employee"
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Employee Details</title>
<style type="text/css">
td {
	padding: 10px;
	border: 10px; 
}
</style>
<style>
table, th, td {
    border: 1px solid black;
}
</style>
</head>
<body style="background-color: #d7e7f3;">
<%
String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
System.out.println(basePath);
EmployeeDao dao = new EmployeeDaoImpl();
List<Employee> list = dao.allEmployees();
System.out.println(list);
%>
<center><h2>All Employee Details:</h2></center>
<div style="padding-left: 130px;">
<a href="<%=basePath%>/jsps/EmployeeHomePage.jsp"><b>Home</b></a>
<table style="padding: 10px; border: 10px;">
	<tr>
		<th>Employee Id</th>
		<th>Name</th>
		<th>Date of Join</th>
		<th>Department</th>
		<th>Mobile No</th>
		<th>Email Id</th>
		<th>Highest Qualification</th>
		<th>Delete</th>
	</tr>
<%for(int i=0;i< list.size(); i++) {%> <!-- Start for loop -->
	<tr>
		<td><a href=<%=basePath%>/EmpDetailsServlet?empid=<%=list.get(i).getEmpId()%>><u><%=list.get(i).getEmpId()%></u></a></td>
		<td><%=list.get(i).getName()%></td>
		<td><%=list.get(i).getDateOfJoin()%></td>
		<td><%=list.get(i).getDepartmentName()%></td>
		<td><%=list.get(i).getMobileNumber()%></td>
		<td><%=list.get(i).getEmailId()%></td>
		<td><%=list.get(i).getHighestQualification()%></td>
		<td><a href=<%=basePath%>/DeleteServlet?empid=<%=list.get(i).getEmpId()%>><button type="button">Delete</button></a></td>
	</tr>
<%} %> <!-- End for loop -->
</table>
</div>
</body>
</html>