<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
</head>
<body>
	<p>${welcomeMessage}</p>
	<spring:url var="namePage" value="/getname" ></spring:url>
	<spring:url var="presentPage" value="/ispresent" ></spring:url>
	<p><a href="${namePage}">Name</a></p>
	<p><a href="${presentPage}">Is Present</a></p>
</body>
</html>