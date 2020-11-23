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
<script src="//code.jquery.com/jquery-latest.js"></script>

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
        
        </div>
   
</body>
<script>


            const count = 20;
            let startNum = 1;
            let endNum = 20;
            let param  ;
            
            
           
            function loadItems() {
                let item = "";
                      param ={ "startNum":startNum, "endNum":endNum};
                      
                    $.ajax({
                        type:"POST",
                        url:"http://localhost:8090/gift/productBoard/selectPagingArticlesList",
                        data : JSON.stringify(param) ,
                        contentType: "application/json",
                        success: function(data){
                            console.log(data);
                            console.log(data.length);
                            console.log(data[3]);
                            
                            data.forEach (function(article) {
                                item = `<table id=product>
                                            <tr width=300>
                                                    <td>${data.brand}</td>
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
                                                    <td>${articles.price}</td>
                                                </tr>
        		                        </table>`;
                           
                    document.getElementById('items').innerHTML += item;
                            })
                        }, 
                        error: function(){
                            alert("error");
                        }

                    })
                startNum += 20;
                endNum += 20;
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
</html>