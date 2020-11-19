<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>행사 알림</title>
</head>
<body>
    <table id=product>
       <c:forEach var="article" items="${articlesList}" >
        <tr width=300>
            <td>${article.brand}</td>
            <td>${article.event}</td>
        </tr>
        <tr>
            <td colspan="2">imageFileName</td>
        </tr>
        <tr>
            <td>${article.pname}</td>
            <td rowspan="2">like</td>
        </tr>
        <tr>
            <td>${article.price}</td>
            
        </tr>
    </c:forEach>
    </table>
</body>
</html>