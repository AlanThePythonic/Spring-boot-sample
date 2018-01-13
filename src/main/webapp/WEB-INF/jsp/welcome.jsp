<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<body>
	<c:url value="/resources/text.txt" var="url"/>
	<spring:url value="/resources/text.txt" htmlEscape="true" var="springUrl" />
	Spring URL: ${springUrl} at ${time}
	<br>
	JSTL URL: ${url}
	<br>
	Message: ${message}
	
	<form action="/update" method="post">
		ID :<input type="text" name="id" id="id" value=""/> <br>
		Name :<input type="text" name="name" id="name" value=""/> <br>
		<input type="submit" value="submit"/>
	</form>
</body>

</html>
