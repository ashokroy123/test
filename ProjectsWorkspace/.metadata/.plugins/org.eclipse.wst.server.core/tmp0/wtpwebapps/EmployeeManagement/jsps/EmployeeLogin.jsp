<html>
<head>
<style>
</style>
</head>
<body background="images/Banner.jpg"
	style="background-repeat: no-repeat; background-size: 1366px 768px;">
	<div>
		<a href="http://bsolsystems.com/"><img
			src="${pageContext.request.contextPath}/images/bsol-logo.png"></a>
		<center>
			<h2><font color="green">Employee Management System</font></h2>
			<form action="${pageContext.request.contextPath}/LoginServlet"
				method="post">
				
				
				<fieldset style="border: solid 1px; width: 300px;">
					<label style="color: red;">${errorMessege}</label>
					<pre></pre>
					<label><b>Username:</b></label>&nbsp;&nbsp;<input type=text
						name="uname" value=${uname} ></input>
					<pre></pre>
					<label><b>Password:</b></label>&nbsp;&nbsp;<input type=password
						name="pwd" value=${pwd} ></input>
					<pre></pre>
					<input type=submit value="Login" name="Login"></input>&nbsp;&nbsp;&nbsp;
					<input type="reset" value="Clear" name="Clear"></input> <br>
					<br>
				</fieldset>
				
				
			</form>
		</center>
	</div>
</body>
</html>