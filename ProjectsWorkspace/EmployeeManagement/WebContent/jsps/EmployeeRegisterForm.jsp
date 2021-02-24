<%@page import="com.app.modelBean.*"%>
<%@page import="dao.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	  <title>Employee Register Form:</title>
	  <!-- <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
<style>
#mainDiv {
    padding-top: 30px;
    padding-right: 10px;
    padding-bottom: 50px;
    padding-left: 255px;
}
.mandatory {
	color: #FF0000;
}
</style>
<script>
function validateForm() {
    var firstname = document.forms["RegForm"]["firstname"].value.trim();
    var lastname = document.forms["RegForm"]["lastname"].value.trim();
    var dateofjoin = document.forms["RegForm"]["dateofjoin"].value;
    var department = document.forms["RegForm"]["department"].value;
    var mobilenumber = document.forms["RegForm"]["mobilenumber"].value.trim();
    var mobilePattern = /^[0-9]{10}$/;
    var email = document.forms["RegForm"]["email"].value.trim();
    if (firstname == "") {
        alert("First Name must be filled out");
        document.forms["RegForm"]["firstname"].value=firstname;
        return false;
    }else if(firstname.length>20){
    	alert("First Name shouldn't exceed more than 20 Chars");
    	document.forms["RegForm"]["firstname"].value=firstname;
        return false;
    }else if (lastname == "") {
        alert("Last Name must be filled out");
        document.forms["RegForm"]["lastname"].value=lastname;
        return false;
    }else if(lastname.length>20){
    	alert("Last Name shouldn't exceed more than 20 Chars");
    	document.forms["RegForm"]["lastname"].value=lastname;
        return false;
    }else if (dateofjoin == "") {
        alert("Date Of Join must be filled out");
        document.forms["RegForm"]["dateofjoin"].value=dateofjoin;
        return false;
    }else if(department==""){
    	alert("Please Select a Department");
        return false;
    }else if(mobilenumber==""){
    	alert("Mobile Number must be filled out");
        document.forms["RegForm"]["mobilenumber"].value=mobilenumber;
        return false;
    }else if(mobilenumber.length != 10){
    	alert("Mobile Number should be 10 Numbers");
        document.forms["RegForm"]["mobilenumber"].value=mobilenumber;
        return false;
    }else if(mobilenumber.match(mobilePattern) == null){
    	alert("Mobile Number is not valid");
        document.forms["RegForm"]["mobilenumber"].value=mobilenumber;
        return false;
    }else if(email==""){
    	alert("Email Id must be filled out");
        document.forms["RegForm"]["email"].value=email;
        return false;
    }else if(email.length>50){
    	alert("Email Id shouldn't exceed more than 50 Chars");
    	document.forms["RegForm"]["email"].value=email;
        return false;
    }
}
</script>
</head>

<body style="background-color: #d7e7f3;">
<%
String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
System.out.println(basePath);
Object obj = request.getAttribute("emp");
if(obj!=null){ //For Modification
EmployeeReg emp1 = (EmployeeReg)obj;
String empIdStr = "<label><b>Employee Id:</b></label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' name='employeeid' value='"+emp1.getEmpId()+"' readonly ></input><pre></pre>";
request.setAttribute("empIdStr", empIdStr);
}else{ // New Form
	String opts="<option value='M.Tech' >M.Tech</option>"+
			"<option value='B.Tech' >B.Tech</option>"+
			"<option value='Intermediate' >Intermediate</option>"+
			"<option value='SSC' >SSC</option>";
			request.setAttribute("opts", opts);

	DepartmentDao deptDao = new DepartmentDaoImpl(); 
	List<Department> deptList = deptDao.getDepartmentDetails();
	String depts="";
	for (Department dept : deptList) {
		depts = depts+"<option value='"+dept.getDeptId()+"'>"+dept.getDeptName()+"</option>";
	}
	System.out.println(depts);
	request.setAttribute("depts", depts);
			
	String stus="<option value='active'>Active</option>"+
			"<option value='inactive'>Inactive</option>";
			request.setAttribute("stus", stus);
			
			
	String exp="<option value='N'>No</option>"+
			"<option value='Y'>Yes</option>";
			request.setAttribute("exp", exp);
}

 %>
<center>
<h2>Employee Register Form:</h2>
</center>
<div id="mainDiv">
	<a href="<%=basePath%>/jsps/EmployeeHomePage.jsp"><b>Home</b></a><pre></pre>
	<form name="RegForm" action="${pageContext.request.contextPath}/RegFormSubmit" method="POST" onsubmit="return validateForm()">
		<fieldset style="padding-left: 180px;width:  500px;">
		<pre></pre>
         ${empIdStr}
         <label class="mandatory">*</label><label><b>First Name:</b></label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="text" name="firstname" required  value=${emp.firstName}></input><pre></pre>
         <label class="mandatory">*</label><label><b>Last Name:</b></label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  		    <input type="text" name="lastname" required value=${emp.lastName}></input><pre></pre>
         <label class="mandatory">*</label><label><b>Date of Join:</b></label>&nbsp;&nbsp;&nbsp;&nbsp;
         	<input type="date" name="dateofjoin" required value=${emp.dateOfJoin} ></input><pre></pre>
         <label class="mandatory">*</label><label><b>Department:</b></label>&nbsp;&nbsp;&nbsp;&nbsp;
     	      <select name="department" id="department">
     	      <option value=''>Select Department</option>
  	     		${depts}
        	  </select><pre></pre>
         <label><b>Salary:</b></label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          	<input type="number" name="salary"  value=${emp.salary}></input><pre></pre>
         <label><b>Experience:</b></label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         	 <select name="experiance">
            	${exp}
          	</select><pre></pre> 
      <fieldset  style="width: 635px;">
        <legend><b>Address:</b></legend>
          <label><b>Present Address:</b></label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <textarea name="presentaddress" rows="5" cols="20" >${emp.address.presentAddress}</textarea>
             <pre></pre>
           <label><b>Permanent Address:</b></label>
              <textarea name="permanentaddress" rows="5" cols="20" >${emp.address.permanentAddress}</textarea>
      </fieldset>
      <fieldset id="fieldset3" style="padding:20px; width: 200px;"><pre></pre> 
        <legend><b>Educational Details:</b></legend>
          <table id="EducationalDeatails" border="1" cellpadding="3%">
                 <tr>
                   <th>Qualification</th>
                   <th>University/College</th>
                   <th>Percentage</th>
                   <th>Year Of Completion</th>
                 </tr>
                 <tr>
                   <td><select id="qualification" name="qualification">
                   		 <option value="">Select Qualification</option>
                   		 ${opts}
                       </select></td>
                   <td><input type="text" id="college" name="college" value=${emp.qualification.collegeName}></input> </td>
                   <td><input type="number" id="percentage" name="percentage" min="0" max="100" step="0.01" value=${emp.qualification.percentage} ></input> </td>
                   <td><input type="number" id="year" name="year" step="1" value=${emp.qualification.yearOfpassedout} ></input> </td>
                 </tr>
          </table><pre></pre>
                  <pre></pre>
        </fieldset><pre></pre> 
           <label class="mandatory">*</label><label><b>Mobile Number:</b></label>
		      <input name="mobilenumber" min="0" required value=${emp.mobileNumber}></input><pre></pre> 
           <label class="mandatory">*</label><label><b>Email Id:</b></label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <input type="email" id="email" name="email" required value=${emp.emailId}></input><pre></pre>
           <label class="mandatory">*</label><label><b>Status:</b></label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     	     <select name="status">
  	           ${stus}
             </select><pre></pre>
               <pre></pre>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
              <div style="padding-left: 188px;">
              <input type="submit"  value="Save">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
              <input type="reset" value="clear">
              </div>
    </fieldset>            
</form>
</div>
</body>
</html>