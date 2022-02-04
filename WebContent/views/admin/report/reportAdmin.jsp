<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import = "java.util.ArrayList , com.kh.member.model.vo.Report" %>

<%
ArrayList<Report> rList = (ArrayList<Report>)request.getAttribute("rList");
%> 

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>

    <style>
      .report-manage {
        width: 95%;
        margin: auto;
        margin-top: 3rem;
        margin-bottom: 3rem;
      }

      .report-manage table {
        width: 90%;
        margin: auto;
        margin-bottom: 4rem;
      }

      .report-manage table tr {
        text-align: center;
      }
    </style>
  </head>
  <body>
    <%@ include file = "../../common/menubar.jsp"%>

    <div class="report-manage">
      <h2 align="center" style="margin: 2rem; font-weight: bold">
        신고내역 관리
      </h2>

      <table align="center" class="table">
        <thead class="thead-dark" style="text-align: center">
          <tr>
            <th style="width: 80px">번호</th>
            <th style="width: 150px">신고한 회원번호</th>
            <th style="width: 150px">신고 받은 회원번호</th>
            <th>내용</th>
            <th style="width: 200px">신고날짜</th>
          </tr>
        </thead>
        <% if(rList.isEmpty()) { %>
        <tr>
          <td colspan="6">존재하는 신고내역이 없습니다</td>
        </tr>
        <% } else { %> <% for(Report r : rList) { %>

        <tr>
          <td><%= r.getRepNum() %></td>
          <td><%= r.getRepWriter()%></td>
          <td><%= r.getRepMem()%></td>
          <td><%= r.getRepContent() %></td>
          <td><%= r.getRepDate() %></td>
        </tr>

        <% } %> <% } %>
      </table>
    </div>
    <%@ include file = "../../common/footer.jsp"%>
  </body>
</html>
