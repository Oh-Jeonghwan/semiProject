<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <style>
      .admin_menu {
        display: flex;
        flex-wrap: wrap;
        max-width: 900px;
        margin: auto;
        margin-bottom: 6rem;
        justify-content: space-around;
      }
      .admin_menu_manage {
        width: 300px;
        cursor: pointer;
        border: 1px solid lightgray;
        padding: 1rem;
        margin: 1rem;
        border-radius: 5px;
      }
      .admin_menu_manage:hover {
        background-color: rgba(211, 211, 211, 0.507);
      }

      .emoji {
        font-size: 4rem;
      }
      .admin_menu_manage a {
        border: none;
        background-color: none;
        font-weight: bold;
        color: black;
      }
    </style>
  </head>
  <body>
    <%@ include file = "../common/menubar.jsp"%>

    <div class="admin_mainpage">
      <h1
        align="center"
        style="font-weight: bold; padding: 2rem 1rem 1rem 1rem"
      >
        관리자 페이지
      </h1>
      <br />

      <div class="admin_menu" align="center">
        <div
          class="admin_menu_manage manage_board"
          onclick="location.href='/pet/list.bo?currentPage=1'"
        >
          <div class="emoji">📰</div>
          <a class="admin_btn" type="button">게시판 관리</a>
        </div>

        <div
          class="admin_menu_manage manage_matching"
          onclick="location.href='/pet/adminMatch.ad?currentPage=1'"
        >
          <div class="emoji">🤝</div>
          <a class="admin_btn" type="button"> 매칭내역 관리 </a>
        </div>
        <div
          class="admin_menu_manage manage_notice"
          onclick="location.href='/pet/list.no?currentPage=1'"
        >
          <div class="emoji">📌</div>
          <a class="admin_btn" type="button"> 공지사항 관리 </a>
        </div>
        <div
          class="admin_menu_manage manage_member"
          onclick="location.href='/pet/userAdmin.ad?currentPage=1'"
        >
          <div class="emoji">👨‍👨‍👧‍👦</div>
          <a class="admin_btn" type="button"> 회원 관리 </a>
        </div>
        <div
          class="admin_menu_manage manage_report"
          onclick="location.href='/pet/adminReport.ad'"
        >
          <div class="emoji">👮</div>
          <a class="admin_btn" type="button"> 신고내역 조회 </a>
        </div>
        <div
          class="admin_menu_manage manage_static"
          onclick="location.href='/pet/adminStatic.ad'"
        >
          <div class="emoji">📊</div>
          <a class="admin_btn" type="button"> 통계 조회 </a>
        </div>
      </div>
    </div>
    <%@ include file = "../common/footer.jsp"%>
  </body>
</html>
