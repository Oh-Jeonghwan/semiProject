<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.kh.notice.model.vo.Notice" %> 
<% 
	Notice n = (Notice)request.getAttribute("n"); 
	int currentPage = Integer.parseInt(request.getParameter("currentPage"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .outer{
        width: 1000px;
        height: 700px;
        margin: auto;
        margin-top: 50px;
    }
    #enroll-form>table{border:1px solid black;} 
    
    #enroll-form input, #enroll-form textarea{
        width: 95%;
        box-sizing: border-box;
        margin: 10px;
    }
    #enroll-form th{text-align: right;}
</style>
</head>
<body>
    <%@ include file="../common/menubar.jsp" %>
    <div class="outer">
        <h2 align="center">공지사항 수정하기</h2>
        <form id="enroll-form" action="<%=contextPath %>/update.no" method="post">
            <input type="hidden" name="nno" value="<%=n.getNoticeNum()%>">
            <input type="hidden" name="currentPage" value="<%=currentPage%>">
            <table align="center">

                <tr>
                    <th width="50">제목</th>
                    <td width="350"><input type="text" name="title" value="<%=n.getNoticeTitle() %>" required></td>
                </tr>
               
                <tr>
                    <th>내용</th>
                    <td></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <textarea name="content"  rows="10" style="resize:none" required><%=n.getNoticeContent() %></textarea>
                    </td>
                </tr>
            </table>
            <br><br>
            <div align="center">
                <button type="submit">수정 하기</button>
                <button type="button" onclick="history.back();">뒤로가기</button>
                <!--history.back(): 이전 페이지로 돌아가게 해주는 함수-->
            </div>
        </form>
    </div>
</body>
<footer><%@ include file="../common/footer.jsp" %></footer>
</html>