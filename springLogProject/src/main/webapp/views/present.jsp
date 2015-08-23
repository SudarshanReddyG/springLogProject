<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Status Check</title>
</head>
<body>
	<p>${isPresent}</p>
	<spring:url var="homePage" value="/" ></spring:url>
	<p><a href="${homePage}">Go Back</a></p>
</body>
</html>