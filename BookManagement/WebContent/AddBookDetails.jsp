<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Book Details Page</title>
</head>
<body>
	<!-- This tag is used to show error on page -->
	<i>
		<form:errors path="BookDetails.bookName"></form:errors><br/>
		<form:errors path="BookDetails.isbnNumber"></form:errors><br/>
	</i>
	<form action="addBook.spring" method="post">
		<pre>
			Book Name:<input type="text" name="bookName"/>
			Book ISBN Number:<input type="text" name="isbnNumber"/>
			Author:<input type="text" name="author"/>
			Edition:<input type="text" name="edition"/>
			<input type="submit" value="Add Book Details">
		</pre>
	</form>
	
</body>
</html>