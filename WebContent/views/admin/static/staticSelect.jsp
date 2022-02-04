<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
   <%@ page import="com.kh.member.model.vo.Match,com.kh.member.model.vo.Petsitter,com.kh.member.model.vo.Mypet  , java.util.ArrayList,com.kh.member.model.vo.Member" %>
   
   <%
   	ArrayList<Match> list = (ArrayList<Match>)request.getAttribute("list");
  	ArrayList<Match> alist = (ArrayList<Match>)request.getAttribute("alist");
  	ArrayList<Match> monthList = (ArrayList<Match>)request.getAttribute("monthList");
  	ArrayList<Member> memList = (ArrayList<Member>)request.getAttribute("memList");
  	ArrayList<Mypet> petList = (ArrayList<Mypet>)request.getAttribute("petList");
  	ArrayList<Petsitter> petsitterList = (ArrayList<Petsitter>)request.getAttribute("petsitterList");
  	
  %> 

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <style>
      .static-manage {
        background-color: rgba(250, 235, 215, 0.479);
        width: 90%;

        margin: auto;
        margin-top: 50px;
        padding: 1.5rem;
        margin-bottom: 3rem;
        position: relative;
      }

      #toTop {
        width: 50px;
        height: 50px;
        background: #423bad;
        text-align: center;
        border-radius: 50px;
        color: white;
        font-weight: bold;
        position: fixed;
        z-index: 100;
        top: 20rem;
        right: 1rem;
        line-height: 50px;
        cursor: pointer;
      }
      #toTop:hover {
        background-color: #302b7a;
      }
    </style>
  </head>
  <body>
    <%@ include file = "../../common/menubar.jsp"%>

    <div id="top" class="static-manage">
      <div id="staticHome">
        <h2 align="center" style="font-weight: bold">관리자모드 통계조회</h2>
      </div>

      <select onchange="location.href=this.value">
        <option selected value="#staticHome">통계 선택</option>
        <option value="#petsitter">총 펫시터 수 통계</option>
        <option value="#matching">총 매칭 수 통계</option>
        <option value="#LocMatchingCount">지역별 매칭수 통계</option>
        <option value="#month">월별 매칭수 통계</option>
        <option value="#locationMember">지역별 회원수 통계</option>
        <option value="#petType">종류별 마이펫 통계</option>
      </select>

      <br /><br />

      <div>
        <h3 id="petsitter">
          총 펫시터 수 : <% for(Petsitter p : petsitterList) {%> <%=
          p.getCount() %> <% } %> 명
        </h3>
      </div>
      <br />

      <div>
        <h3 id="matching">
          총 매칭 수 : <% for(Match m : list) {%> <%= m.getCount() %> <% } %> 건
        </h3>
      </div>

      <br />
      <div>
        <h3 align="center" id="LocMatchingCount" style="padding: 1rem">지역별 매칭 수</h3>

        <table class="table table-striped table-hover">
          <thead class="thead-dark">
            <tr>
              <th>매칭 지역</th>
              <th>매칭 건수</th>
            </tr>
          </thead>
          <tbody>
            <% for(Match a : alist) {%>
            <tr>
              <td><%= a.getLocation() %></td>
              <td><%= a.getCount() %></td>
            </tr>
            <% } %>
          </tbody>
        </table>

        <br /><br />
      </div>

      <div>
        <h3 id="month" align="center" style="padding: 1rem">월별 매칭수</h3>
        <br />

        <table class="table table-striped table-hover">
          <thead class="thead-dark">
            <tr>
              <th>매칭 시작 월</th>
              <th>매칭 건수</th>
            </tr>
          </thead>
          <tbody>
            <% for(Match m : monthList) {%>
            <tr>
              <td><%= m.getLocation() %>월</td>
              <td><%= m.getCount() %>건</td>
            </tr>
            <% } %>
          </tbody>
        </table>
      </div>

      <div>
        <h3 id="locationMember" align="center" style="padding: 1rem">
          지역별 회원수
        </h3>
        <br />

        <table class="table table-striped table-hover">
          <thead class="thead-dark">
            <tr>
              <th>지역</th>
              <th>회원 수</th>
            </tr>
          </thead>
          <tbody>
            <% for(Member m : memList) {%>
            <tr>
              <td><%= m.getLocation() %></td>
              <td><%= m.getCount() %>명</td>
            </tr>
            <% } %>
          </tbody>
        </table>
      </div>

      <div>
        <h3 id="petType" align="center" style="padding: 1rem">
          종류별 마이펫 수
        </h3>
        <br />

        <table class="table table-striped table-hover">
          <thead class="thead-dark">
            <tr>
              <th>종류</th>
              <th>마이펫 수</th>
            </tr>
          </thead>
          <tbody>
            <% for(Mypet m : petList) {%>
            <tr>
              <td><%= m.getPetType() %></td>
              <td><%= m.getCount() %>마리</td>
            </tr>
            <% } %>
          </tbody>
        </table>
      </div>

      <a href="#top"> <div id="toTop">TOP</div> </a>
    </div>
    <%@ include file = "../../common/footer.jsp"%>
  </body>
</html>
