<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
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
      #enroll-form > table {
        border: 1px solid black;
      }

      #enroll-form input,
      #enroll-form textarea {
        width: 95%;
        box-sizing: border-box;
        margin: 10px;
      }
      #enroll-form th {
        text-align: right;
      }
    </style>
  </head>
  <body>
    <%@ include file="../common/menubar.jsp" %>

    <h2 align="center" style="font-weight: bold; margin: 3rem">
      공지사항 작성하기
    </h2>
    <form id="enroll-form" action="<%=contextPath%>/enroll.no" method="post">
      <input type="hidden" name="memNum" value="<%=loginUser.getMemNum()%>" />
      <table class="table table-success" style="width: 60%; margin: auto">
        <tr>
          <th width="50" style="vertical-align: inherit">제목</th>
          <td width="350"><input type="text" name="title" required /></td>
        </tr>

        <tr>
          <th>내용</th>
          <td></td>
        </tr>
        <tr>
          <td colspan="2">
            <textarea
              name="content"
              rows="10"
              style="resize: none"
              required
            ></textarea>
          </td>
        </tr>
      </table>
      <div align="center" style="margin: 3rem">
        <button type="submit" class="btn btn-primary">등록 하기</button>
        <button
          type="button"
          class="btn btn-secondary"
          onclick="history.back();"
        >
          뒤로가기
        </button>
        <!--history.back(): 이전 페이지로 돌아가게 해주는 함수-->
      </div>
    </form>
  </body>
  <footer><%@ include file="../common/footer.jsp" %></footer>
</html>
