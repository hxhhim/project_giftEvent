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
<style>
    #product{
        display: inline-block;
    }
    #twoline{
    	width: 420px;
    }
</style>
</head>
<body>
        <div>
            <input type="text"  width="300" id="search">
            <button>검색</button>
            <td>${articlesList[5].pname}</td>
        </div>
      <div id=twoline>
        <div id="items"></div>
        <p id="sentinel"></p>
        <script>
            const count = 20;
            let index = 0;
            let max = 900;

            function loadItems() {
                let item = "";

                for (let i = index ; i <= index + count; ++i) {
                    if(index>max){
                        break;
                    }
                    item = `<table id=product>
                             <tr width=300>
                                <td>${articlesList[i].brand}</td>
                                <td>${articlesList[i].event}</td>
                            </tr>
                            <tr>
                                <td colspan="2"><img src="${contextPath}/resources/img/${articlesList[i].imageFileName}" width="200" height="200"></td>
                            </tr>
                            <tr>
                                <td width=150 style="word-break:break-all">${articlesList[i].pname}</td>
                                <td rowspan="2">like</td>
                            </tr>
                            <tr>
                                <td>${articlesList[i].price}</td>
                                
                            </tr>
                            </table>`;
                            console.log(index);
                            console.log(i);
                            console.log(max);
                    document.getElementById('items').innerHTML += item;
                    
                }

               
                index += count;
            }
            
            const io = new IntersectionObserver(entries => {
                entries.forEach(entry => {
                    if (!entry.isIntersecting) {
                        return;
                    }

                    loadItems();
                });
            });

            io.observe(document.getElementById('sentinel'));

            loadItems();
        </script>
        </div>
   
</body>
</html>