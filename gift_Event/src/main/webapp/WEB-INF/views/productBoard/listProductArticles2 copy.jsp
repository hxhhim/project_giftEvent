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
            const count = 20; // 한번에 조회할 갯수
            let index = 0; // 시작할 숫자
            let max = 900; // articlesList 길이
            
            let url = contextPath;
 
            function loadItems(dataList, url, startNumber, cutNumber, maxLength) {
                let item = "";
                let items = [];
                let lastNumber = startNumber;
                
                console.log("넘어온 파라미터: ", arguments);
                console.log("dataList: ", dataList);

                for (let i = startNumber; i < cutNumber; i++) {
                    if(i > maxLength) {
                        break;
                    }
                    
                    item = `<table id=product>
                                <tr width=300>
                                    <td>${dataList[i].brand}</td>
                                    <td>${dataList[i].event}</td>
                                </tr>
                                <tr>
                                    <td colspan="2"><img src="${url}/resources/img/${dataList[i].imageFileName}" width="200" height="200"></td>
                                </tr>
                                <tr>
                                    <td width=150 style="word-break:break-all">${dataList[i].pname}</td>
                                    <td rowspan="2">like</td>
                                </tr>
                                <tr>
                                    <td>${dataList[i].price}</td>
                                
                                </tr>
                            </table>`;
                    items.push(item);

                }
                document.getElementById('items').innerHTML = items.join("");
                lastNumber = i;

                return lastNumber;
            }

            const io = new IntersectionObserver(entries => {
                entries.forEach(entry => {
                    if (!entry.isIntersecting) {
                        return;
                    }

                    console.log("entries 에서 전달하는 파라미터: ", index, count, articlesList.length, dataList, url);
                    index = loadItems(dataList, url, index, count, dataList.length);
                });
            });

            io.observe(document.getElementById('sentinel'));

            console.log("전달하는 파라미터: ", index, count, articlesList.length, dataList, url);
            index = loadItems(dataList, url, index, count, dataList.length);
        </script>
        </div>
   
</body>
</html>