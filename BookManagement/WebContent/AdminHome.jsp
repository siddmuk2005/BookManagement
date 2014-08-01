<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome To Admin Home Page</title>
</head>
<body>
Welcome To Admin Home Page
<br/>
Hi <%=request.getParameter("uname") %> <font>:</font>

<br/>Add Book Details: <a href="addDepartment.spring">Click here</a>
<br/>Add User Details: <a href="addEmployee.spring">Click here</a>
<br/>Add Entry of Books that is given to User: <a href="addBookToUserEntry.spring">Click here to add entry</a> 
</body>
</html>