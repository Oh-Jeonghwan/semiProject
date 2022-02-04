<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import = "java.util.ArrayList, com.kh.member.model.vo.Member" %>
    
    <% 
    	ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
    	
    
		ArrayList<Member> blist = (ArrayList<Member>)request.getAttribute("blist");

    %> 
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>

    <style>
      .mamber-admin {
        width: 95%;
      }
      .mam-manage-list,
      .blackmem-manage-list {
        margin: auto;
        width: 95%;
      }

      .paging-area button {
        border: 1px solid black;
      }

      .mam-manage-search {
        margin: 1rem;
      }
      .mam-manage-list table,
      .blackmem-manage-list table {
        margin: 1rem;
      }
      .mam-manage-list table th,
      .blackmem-manage-list table th {
        padding: 0.5rem;
      }
      .table .thead-dark th {
        font-size: 0.8rem;
        text-align: center;
      }
      .mam-manage-list table td,
      .blackmem-manage-list {
        margin-bottom: 5rem;
      }

      .blackmem-manage-list table td {
        font-size: 0.9rem;
        padding: 0.5rem;
        text-align: center;
      }
    </style>
  </head>
  <body>
    <%@ include file = "../../common/menubar.jsp"%>

    <div class="mamber-admin">
      <h2 align="center" style="font-weight: bold; margin: 3rem">
        관리자모드 회원관리
      </h2>

      <h4 align="center">회원목록 / 검색</h4>

      <div align="center" class="mam-manage-search" style="margin-bottom: 2rem">
        <form action="<%= contextPath%>/adminSearch.ad" method="get">
          회원아이디 <input type="text" name="keyword" />
          <input type="submit" value="검색" />
        </form>
      </div>

      <div class="mam-manage-list">
        <table class="table">
          <!-- 보통 작성일 기준으로 내림차순, 즉 최신글이 가장 위에 온다 -->
          <thead class="thead-dark">
            <tr>
              <th>회원번호</th>
              <th>아이디</th>
              <th>비밀번호</th>
              <th>이름</th>
              <th>주민번호</th>
              <th>이메일</th>
              <th>전화번호</th>
              <th>지역</th>
              <th>주소</th>
              <th>신고수</th>
              <th>펫시터 유뮤</th>
              <th>마이펫 유무</th>
              <th>가입 날짜</th>
            </tr>
          </thead>
          <!-- 리스트가 비어있는지 아니면 차있는지 -->
          <% if(list.isEmpty()) { %>
          <!-- 리스트가 비어있을 경우 -->
          <tr>
            <td colspan="12">존재하는 회원이 없습니다.</td>
          </tr>
          <% } else { %>
          <!-- 리스트가 차있을 경우 : 반복문 -->

          <!-- 향상된 for 문 -->
          <% for(Member m : list) { %>

          <tr>
            <td><%= m.getMemNum() %></td>
            <td><%= m.getMemId() %></td>
            <td><%= m.getMemPwd() %></td>
            <td><%= m.getMemName() %></td>
            <td><%= m.getIdNum() %></td>
            <td><%= m.getEmail() %></td>
            <td><%= m.getPhone() %></td>
            <td><%= m.getLocation() %></td>
            <td><%= m.getAddress() %></td>

            <td><%= m.getReportCnt() %></td>

            <% if (m.getPetsitterYN().equals("N")) { %>

            <td>펫시터 미등록</td>
            <%} else { %>
            <td>펫시터 등록</td>

            <%} %> <% if (m.getMyPetYN().equals("N")) { %>
            <td>마이펫 미등록</td>
            <%} else { %>
            <td>마이펫 등록</td>
            <%} %>

            <td><%= m.getEnrollDate() %></td>
          </tr>
          <% } %> <% } %>
        </table>
      </div>
      

      <h2 align="center" style="margin: 2rem">블랙리스트 관리</h2>
      <div class="blackmem-manage-list">
        <table class="table">
          <thead class="thead-dark">
            <tr>
              <th>회원번호</th>
              <th>아이디</th>
              <th>비밀번호</th>
              <th>이름</th>
              <th>주민번호</th>
              <th>이메일</th>
              <th>전화번호</th>
              <th>지역</th>
              <th>주소</th>
              <th>신고수</th>
              <th>펫시터 유뮤</th>
              <th>마이펫 유무</th>
              <th>가입 날짜</th>
              <th>강제탈퇴</th>
              <th>회원복구</th>
            </tr>
          </thead>
          <tbody>
            <!-- 리스트가 비어있는지 아니면 차있는지 -->
            <% if(blist.isEmpty()) { %>
            <!-- 리스트가 비어있을 경우 -->
            <tr>
              <td colspan="15" style="width: 100%">
                존재하는 회원이 없습니다.
              </td>
            </tr>
            <% } else { %>
            <!-- 리스트가 차있을 경우 : 반복문 -->
            <!-- 향상된 for 문 -->
            <% for(Member b : blist) { %>

            <tr>
              <td><%= b.getMemNum() %></td>
              <td><%= b.getMemId() %></td>
              <td><%= b.getMemPwd() %></td>
              <td><%= b.getMemName() %></td>
              <td><%= b.getIdNum() %></td>
              <td><%= b.getEmail() %></td>
              <td><%= b.getPhone() %></td>
              <td><%= b.getLocation() %></td>
              <td><%= b.getAddress() %></td>
              <td><%= b.getReportCnt() %></td>

              <% if (b.getPetsitterYN().equals("N")) { %>
              <td>펫시터 미등록</td>
              <%} else { %>
              <td>펫시터 등록</td>
              <%} %> <% if (b.getMyPetYN().equals("N")) { %>
              <td>마이펫 미등록</td>
              <%} else { %>
              <td>마이펫 등록</td>
              <%} %>

              <td><%= b.getEnrollDate() %></td>
              <td>
                <a
                  href="<%= contextPath %>/adminDelete.ad?mnum=<%= b.getMemNum() %>"
                  class="btn btn-dander btn-sm"
                  >강제탈퇴</a
                >
              </td>
              <td>
                <a
                  href="<%= contextPath %>/adminRestore.ad?mnum=<%= b.getMemNum() %>"
                  class="btn btn-dander btn-sm"
                  >회원복구</a
                >
              </td>
            </tr>
            <% } %> <% } %>
          </tbody>
        </table>
      </div>
    </div>
    <%@ include file = "../../common/footer.jsp"%>
  </body>
</html>
