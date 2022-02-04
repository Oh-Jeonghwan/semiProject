<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ page import = "com.kh.notice.model.vo.Notice" %>
 <%
Notice n = (Notice)request.getAttribute("n"); 
 int currentPage = (int)request.getAttribute("currentPage"); 
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

      #detail-area {
        border: 1px solid black;
      }
      .button > a {
        cursor: pointer;
      }
    </style>
  </head>
  <body>
    <%@include file="../common/menubar.jsp" %>

    <div class="outer">
      <br />
      <h2 align="center" style="font-weight: bold">공지사항 상세보기</h2>
      <br />

      <table id="detail-area" align="center" border="1" class="table">
        <tr>
          <th width="70px" class="table-success">제목</th>
          <td width="350px" colspan="3"><%=n.getNoticeTitle() %></td>
        </tr>
        <tr>
          <th class="table-success">작성자</th>
          <td><%=n.getNoticeWriter() %></td>
          <th class="table-success" style="width: 100px">작성일</th>
          <td><%=n.getNoticeDate() %></td>
        </tr>
        <tr>
          <th class="table-success">내용</th>
          <td colspan="3">
            <p style="height: 150px"><%=n.getNoticeContent() %></p>
          </td>
        </tr>
      </table>
      <br /><br />
      <div class="button" align="center">
        <a
          href="<%=contextPath %>/list.no?currentPage=<%=currentPage%>"
          class="btn btn-primary"
          >목록가기</a
        >

        <!-- 작성자만 보이게끔 -->
        <!-- 로그인이 되어있고 현재 로그인된 사용자가 작성자와 동일할 경우에만 -->
        <%if(loginUser!=null &&
        loginUser.getMemId().equals(n.getNoticeWriter())){ %>
        <a
          href="<%=contextPath %>/updateForm.no?nno=<%=n.getNoticeNum()%>&currentPage=<%=currentPage %>"
          class="btn btn-warning"
          >수정하기</a
        >
        <a
          href="<%=contextPath %>/delete.no?nno=<%=n.getNoticeNum()%>"
          class="btn btn-danger"
          >삭제하기</a
        >
        <!-- 게시물 번호 가져와서 뒤에다 붙여줘야함 -->
        <%} %>
      </div>
    </div>
  </body>
  <footer><%@ include file="../common/footer.jsp" %></footer>
</html>
