<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList
				, com.kh.notice.model.vo.Notice
				, com.kh.common.model.vo.PageInfo" %>
<%
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
	
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <style>
      .outer {
        width: 1000px;
        height: 700px;
        margin: auto;
        margin-top: 50px;
      }
      .search {
        margin: auto;
      }
      .list-area {
        border: solid black 1px;
        text-align: center;
      }

      .list-area > tbody > tr:hover {
        background: gray;
        cursor: pointer;
      }
      .paging-area button {
        border: 1px solid black;
      }
      .thead-dark{
       position: relative;
      }
      
      #noresult{
      position: absolute;
     bottom: -68px;
      left: 45%;
      }
  
    </style>
  </head>
  <body>
    <%@include file="../common/menubar.jsp" %>

    <div class="outer">
      <h2 align="center" style="font-weight: bold">공지사항</h2>
      <br />
      <div align="center">
        <form action="<%=contextPath %>/search.no" method="post">
          <input type="hidden" name="currentPage" value="1"/>
          <input type="date" name="noStartDate" required /> ~
          <input type="date" name="noEndDate" required /> 제목
          <input type="text" name="keyword" required />
          <input type="submit" value="검색" />
        </form>
      </div>
      <br />
      <table class="list-area table" align="center">
        <thead class="thead-dark">
          <tr>
            <th>글번호</th>
            <th width="400">제목</th>
            <th width="100">게시자</th>
            <th width="100">날짜</th>
            <th>조회수</th>
          </tr>
        </thead>
        <tbody>
          <%if(list.isEmpty()){ %>
         
            <div colspan="5" id="noresult">조회된 목록이 없습니다.</div>
         
          <%}else{ %> <%for(Notice n : list){ %>
          <!-- ArrayList는 size() -->
          <tr>
            <td><%=n.getNoticeNum() %></td>
            <td><%=n.getNoticeTitle() %></td>
            <td><%=n.getNoticeWriter() %></td>
            <td><%=n.getNoticeDate() %></td>
            <td><%=n.getNoticeViewer() %></td>
          </tr>
          <%} %> <%} %>
        </tbody>
      </table>
      <br />
      <%if(loginUser!=null && loginUser.getMemId().equals("admin")){ %>
      <div align="center">
        <button
          class="btn btn-primary"
          style="margin-top: 2rem"
          onclick="location.href='<%=contextPath%>/enrollForm.no'"
        >
          글 작성하기
        </button>
      </div>
      <%} %>
      <br />

      <!-- ------------------------페이징바 처리 ---------------------------------- -->
      <div class="paging-area" align="center">
        <%if(currentPage != 1){ %>
	        <!-- 현재 페이지가  1이 아니라면 '<' 표시 -->
	        <button id="prev" >&lt;</button>
        <% }%> 
        
        <%for(int i = startPage; i<=endPage; i++) {%> 
	        <%if(i !=currentPage){ %>
	          <button class="number"><%=i %></button>
	        <%} else{%>
             <!-- 해당 페이지일 때 해당번호 disabled-->
             <button disabled><%=i %></button>
        	<%}%> 
        <%} %> 
        
        <!-- 현재 페이지가 끝 페이지가 아니면 '>' 표시 -->
        <%if(currentPage != maxPage){ %>
        	<button id="next">&gt;</button>
        <%} %>
      </div>
      
      
      <script>
        //script 태그 내에서도 스크립틀릿과 같은 jsp 요소를 쓸 수 있다.
        $(function(){
        	
        	$(".list-area>tbody>tr").click(function(){
        		var nno = $(this).children().eq(0).text();
        		console.log(nno);

        		location.href="/pet/detail.no?nno="+nno+"&currentPage="+<%=currentPage%>;
        	});
        	
        	$("#prev").click(function(){
        		location.href="/pet/list.no?currentPage="+<%=currentPage-1%>;
        	});
        	
        	//검색 조건이 없을 시 숫자 누를 시 이동 경로
        	
          
          $(".number").click(function(){ 
        	 var number = $(".number").text();
        	 
            for(var i=0; i<number.length; i++){
              location.href="/pet/list.no?currentPage="+$(this).text();
            }
          });
        	
        	//검색 조건이 없을 시 > 누를 시 이동 경로
        	$("#next").click(function(){
            location.href="/pet/list.no?currentPage="+<%=currentPage+1%>;
          });
        	
        	
        	
        	//검색 조건이 있을 때
        	//검색 조건이 있을 시  <클릭 시 이동 경로
        	
        	
        	//검색 조건이 있을 때 숫자 누를 시 이동경로
        	
        	
        	//검색 조건이 있을 때 > 누를 시 이동경로
       });
      </script>
    </div>
  </body>
  <footer><%@ include file="../common/footer.jsp" %></footer>
</html>
