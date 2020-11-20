<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="imgPath" value="C:\testimg\\" />
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>행사 알림</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, 
                                maximum-scale=1.0, minimum-scale=1.0">
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<style>
    #product{
        display: inline-block;
    }
    #twoline{
    	width: 420px;
    }
</style>
<script>
    let size = ${articlesList};
    let max = size.brand;
    console.log(size);
</script>
</head>
<body>
       <div>
            <input type="text"  width="300" id="search">
            <button>검색</button>
        </div>
      <div id=twoline>
       <c:forEach var="article" items="${articlesList}" >
       <table id=product>
        <tr width=300>
            <td>${article.brand}</td>
            <td>${article.event}</td>
        </tr>
        <tr>
            <td colspan="2"><img src="${contextPath}/resources/img/${article.imageFileName}" width="200" height="200"></td>
        </tr>
        <tr>
            <td width=150 style="word-break:break-all">${article.pname}</td>
            <td rowspan="2">like</td>
        </tr>
        <tr>
            <td>${article.price}</td>
            
        </tr>
         </table>
    </c:forEach>
        </div>
   
   
</body>
</html>