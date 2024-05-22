<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form action ="register" method="post" modelAttribute="myCustomer">
	
		<div>
			<form:label path="firstName">FirstName</form:label>
         	<form:input path="firstName"/>		
		</div>
		
		<div>
			<form:label path="lastName">LastName</form:label>
         	<form:input path="lastName"/>		
		</div>
		
		<div>
			<form:label path="age">Age</form:label>
         	<form:input path="age"/>		
		</div>
		
		<div>
			<form:label path="email">Email</form:label>
         	<form:input path="email"/>		
		</div>
	
		 <input type="submit" value="register"/>
		 
	</form:form>

</body>
</html>