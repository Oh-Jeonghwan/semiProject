<%@page import="com.kh.member.model.vo.Member"%> <%@ page language="java"
contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <% Member loginUser = (Member)session.getAttribute("loginUser");
 String contextPath = request.getContextPath(); 
 String alertMsg = (String)session.getAttribute("alertMsg");
 String confiMsg = (String)session.getAttribute("confiMsg");
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <link
      href="https://fonts.googleapis.com/css2?family=Jua&family=Poor+Story&display=swap"
      rel="stylesheet"
    />
    <link
      rel="stylesheet"
      href="https://use.fontawesome.com/releases/v5.14.0/css/all.css"
      integrity="sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc"
      crossorigin="anonymous"
    />
    <!-- Latest compiled and minified CSS -->
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
    />

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <style>
      * {
        box-sizing: border-box;
      }

      a,
      a:hover {
        text-decoration: none;
      }

      /*
        font-family: 'Jua', sans-serif;
        font-family: 'Cute Font', cursive;

        */
      body {
        margin: 0;
        font-family: "Poor Story", cursive;
        font-size: 16px;

        width: 100%;
      }

      .outer {
        height: 100vw;
      }
      ul {
        margin: 0;
        padding: 0;
      }
      li {
        list-style: none;
      }
      /*-------------- menu bar -----------*/

      .bars {
        position: fixed;
        width: 100%;
        top: 0;
        left: 0;
        right: 0;
        background-color: white;
        z-index: 100;
        position: relative;
      }

      .topbar {
        background-color: aliceblue;
        color: #3f3b75;
        padding: 0.2rem;
        font-size: 0.8rem;
        font-weight: bold;
      }

      .navbar_ {
        margin: auto;
        width: 80%;
        display: flex;
        padding: 0.5rem;
      }
      .nav_logo a {
        display: flex;
        width: auto;
        font-family: "Jua", sans-serif;
      }
      .logo {
        background: url("./resources/images/logo.png");
        background-size: cover;
        width: 80px;
        height: 81px;
      }
      .logo_name {
        font-size: 1.8rem;
        padding: 1rem 0 0 0.3rem;
        width: 200px;
        align-self: center;
        color: #423bad;
        font-weight: bold;
      }

      .nav_ {
        width: 100%;
        padding-right: 1rem;
      }
      .nav_ ul {
        display: flex;
        justify-content: end;
        height: 100%;
        align-items: center;
      }
      .nav_ li {
        font-weight: bold;
        padding: 0.8rem;
        margin: 0.5rem;
        width: 90px;
        text-align: center;
        color: rgb(85, 26, 139);
        cursor: pointer;
      }

      .nav_ li:hover {
        transform: scale(1.2);
        color: yellowgreen;
      }

      .afterlogin_bar {
        display: flex;
      }
      #adminDashBoard {
        width: 120px;
      }

      #afterlogin_welcome {
        position: absolute;
        text-align: end;
        font-size: 14px;
        top: 4.5rem;
        right: 6rem;
        font-weight: bold;
      }
    </style>
  </head>
  <body>
    <section class="section_header">
      <div class="bars">
        <div class="topbar">
          <marquee> 맡 겨 만 주 시 조 에 오 신 걸 환 영 합 니 다 .</marquee>
        </div>
        <div class="navbar_">
          <div class="nav_logo">
            <a href="/pet/">
              <div class="logo"></div>
              <div class="logo_name">맡겨만주시조</div>
            </a>
          </div>
          <div class="nav_">
            <ul>
              <%if(loginUser != null && loginUser.getMemId().equals("admin") ){
              %>

              <p style="margin: 0">
                <%= loginUser.getMemName() %> 님 환영합니다.
              </p>
              <li
                id="adminDashBoard"
                onclick="location.href='/pet/adminDashBoard.bo'"
              >
                관리자 대시보드
              </li>
              <li onclick="location.href='<%= contextPath %>/logout.me'">
                로그아웃
              </li>

              <% }else if( loginUser!= null &&
              !loginUser.getMemName().equals("admin")){%>
              <div class="afterlogin">
                <div class="afterlogin_bar">
                  <li onclick="location.href='<%= contextPath %>/myPage.me'">
                    마이페이지
                  </li>
                  <li onclick="location.href='<%= contextPath %>/support.ad'">
                    고객지원
                  </li>
                  <li
                    onclick="location.href='<%= contextPath %>/list.no?currentPage=1'"
                  >
                    공지사항
                  </li>
                  <li onclick="location.href='<%= contextPath %>/logout.me'">
                    로그아웃
                  </li>
                </div>
                <div id="afterlogin_welcome"><%= loginUser.getMemName() %></div>
              </div>

              <%} else{%>
              <li onclick="location.href='<%= contextPath %>/loginForm.me'">
                로그인
              </li>
              <li onclick="location.href='<%= contextPath %>/registerForm.me'">
                회원가입
              </li>
              <li
                onclick="location.href='<%= contextPath %>/list.no?currentPage=1'"
              >
                공지사항
              </li>
              <li onclick="location.href='<%= contextPath %>/support.ad'">
                고객지원
              </li>
              <%} %>
            </ul>
          </div>
        </div>
      </div>
      <div class="gap"></div>
    </section>
    <script>

      let msg =  "<%= alertMsg%>";
      if(msg != "null"){
       window.alert(msg);
       <% session.removeAttribute("alertMsg"); %>
      }

      let confiMsg = "<%= confiMsg%>";
    </script>
  </body>
</html>
