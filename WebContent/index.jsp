<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="view/validations.js"></script>
<style>
body{
	background-color:"lightblue";
}
div{
color:red;
}
</style>
</head>
<body>
<%@ include file="view/header.jsp" %>
<div>
<c:if test="${errmsg!=null}">
<c:out value="${errmsg}"/>
</c:if></div>
<form action="ProductServlet" method="post" id="productManagementForm">
ProductId:<br>
<input type="text" name="pid" id="pid"/><br><span id="pidErr" style="display:none; color:red;">enter product id</span><br><br>
ProductName:<br>
<input type="text" name="name" id="name"/><br><span id="nameErr" style="display:none; color:red;">enter product name</span><br><br>
Price:<br>
<input type="text" name="price" id="price"/><br><span id="priceErr" style="display:none; color:red;">enter price name</span><br><br>
<input type="button" onclick="myFunction()"value="OK"/>
</form>

</body>
</html>