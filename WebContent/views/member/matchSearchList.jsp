<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.member.model.vo.Match, com.kh.common.model.vo.PageInfo,java.sql.Date" %>
<%
	ArrayList<Match> list = (ArrayList<Match>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	
	// 페이징바 만들때 필요한 변수 미리 셋팅
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
	String id = (String)request.getAttribute("id");
	String sdate = (String)request.getAttribute("sdate");
	Date edate = (Date)request.getAttribute("edate");
	String location = (String)request.getAttribute("location");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>맡겨만주시조 - 나의 매칭내역</title>

<style>
    table {
        text-align: center;
    }
      
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>

    <h3 align="center">나의 매칭내역</h3>
    <br>

    <div align="center" class="search_bar">
        <form action="<%= contextPath %>/matchsearch.ma" method="get" style="display: inline-block;">
           <input type = hidden name ="currentPage" value = "1">
            <select name="location" required>
                <option>서울</option>
                <option>경기</option>
                <option>인천</option>
                <option>강원</option>
                <option>충북</option>
                <option>충남</option>
                <option>전북</option>
                <option>전남</option>
                <option>광주</option>
                <option>울산</option>
                <option>경북</option>
                <option>경남</option>
                <option>대구</option>
                <option>부산</option>
                <option>세종</option>
                <option>대전</option>
                <option>제주</option>
            </select>
            날짜<input type="date" name="sdate" required> ~
            <input type="date" name="edate" required>
            아이디<input type="text" name="id" required>
            <button type="submit" style="display: inline-block;">검색</button>
        </form>
    </div>
    <br>
    
    

    <table border="1" class="list-area" align="center" width=1000px>
    	<thead>
	        <tr>
	            <th>매칭코드</th>
	            <th>견주</th>
	            <th>펫시터</th>
	            <th>지역</th>
	            <th>예약 날짜</th>
	            <th>돌봄 시작 날짜</th>
	            <th>돌봄 종료 날짜</th>
	            <th>상세주소</th>
	            <th>돌봄 반려동물</th>
	            <th>매칭종료여부</th>
	        </tr>
        </thead>
        <tbody>
	    	<!-- 게시글 출력 : 게시글이 있는지 없는지 => isEmpty() 이용해서 없는 경우 먼저 조건 부여 -->
            <% if(list.isEmpty()) { %> <!-- 조회글 없음 -->
            	<tr>
                	<td colspan="10">조회된 리스트가 없습니다.</td>
                </tr>
                <% } else { %>
                <!-- 반복 : list 에 있는 값을 순차적으로 접근해서 뽑아오기 -->
                <% for(Match m : list) { %>
                	<tr>
		            	<td><%= m.getMatNo() %></td>
		                <td><%= m.getPoNum() %></td>
		                <td><%= m.getPsNum() %></td>
		                <td><%= m.getLocation() %></td>
		                <td><%= m.getRequestdate() %></td>
		                <td><%= m.getCareSdate() %></td>
		                <td><%= m.getCareDdate() %></td>
		                <td><%= m.getAddress() %></td>
		                <td><%= m.getPetNum() %></td>
		                <td>
		                	<% if(m.getIsEnd().equals("N")) { %>
                				진행중
                			<% } else { %>
                				종료
                			<% } %>
                		</td>
                	</tr>
                <% } %>
            <% } %>
        </tbody>
    </table>
    
    <script>
    	$(function() {
			$(".list-area>tbody>tr").click(function() {
				var mno = $(this).children().eq(0).text();
        			
				location.href = "<%= contextPath %>/matchDetail.ma?mno=" + mno;
				
			});
        });
	</script>
    
	<div align="center" class="paging-area">
        <!-- 페이징바에서 < 를 담당 : 이전페이지로 이동 -->
    	<!-- http://localhost:8888/pet/matchsearch.ma?currentPage=1&location=%EC%84%9C%EC%9A%B8&sdate=2021-12-01&edate=2021-12-22&id=user03 -->
    	<% if(currentPage != 1) { %>
        	<button onclick="location.href='<%= contextPath %>/matchsearch.ma?currentPage=<%= currentPage - 1 %>&location=<%=location%>&sdate=<%=sdate%>&edate=<%=edate%>&id<%=id%>'">&lt;</button>
        <% } %>
        
        <!-- 페이징바에서 숫자를 담당 -->
        <% for(int i = startPage; i <= endPage; i++) { %>
        	<!-- 버튼이 눌렸을 때 해당 페이지로 이동하게끔 -->
            <% if(i != currentPage) { %>
            	<button onclick="location.href='<%= contextPath %>/matchsearch.ma?currentPage=<%= i %>&location=<%=location%>&sdate=<%=sdate%>&edate=<%=edate%>&id<%=id%>'"><%= i %></button>
            <% } else { %>
            <!-- 현재 내가 보고있는 페이지일 경우에는 클릭이 안되게끔 막고싶다. -->
            	<button disabled><%= i %></button>
            <% } %>
        <% } %>
            
        <!-- 페이징바에서 > 를 담당 : 다음페이지로 이동 -->
        <% if(currentPage != maxPage) { %>
        	<button onclick="location.href='<%= contextPath %>/matchsearch.ma?currentPage=<%= currentPage + 1 %>&location=<%=location%>&sdate=<%=sdate%>&edate=<%=edate%>&id<%=id%>'">&gt;</button>
        <% } %>
            
        </div>
</body>
</html>