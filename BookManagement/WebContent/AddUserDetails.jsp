<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add User Details Page</title>
</head>
<body>
	<!-- This tag is used to show error on page -->
	<i>
		<form:errors path="UserDetails.userName"></form:errors><br/>
		<form:errors path="UserDetails.userPassword"></form:errors><br/>
	</i>
	<form action="addUser.spring" method="post">
		<pre>
			User Name:<input type="text" name="userName"/>
			User Password:<input type="text" name="userPassword"/>
			User Mobile Number:<input type="text" name="mobile"/>
			Address:<input type="text" name="address"/>
			Email:<input type="text" name="email"/>
			User Type:<input type="text" name="type"/>
			<input type="submit" value="Add User Details">
		</pre>
	</form>
	
</body>
</html>