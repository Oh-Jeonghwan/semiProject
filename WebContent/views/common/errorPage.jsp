<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String errorMsg = (String)request.getAttribute("errorMsg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <%@ include file="../common/menubar.jsp" %>
    
    <h1 ><%= errorMsg %></h1>
    
        <%@ include file="../common/footer.jsp" %>
</body>
</html>