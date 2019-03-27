<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles/styles.css">
</head>
<body>
<%@ include file="header.jsp" %>
<h2>The following details are inserted in DB successfully</h2>
Product id= <c:out value="${pid}"/><br>
name = <c:out value="${name}"/><br>
price = <c:out value="${price}"/>

</body>
</html>