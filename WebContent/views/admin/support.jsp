<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <style>
      .FAQ_container p {
        display: none;
      }
      .FAQ_container {
        text-align: center;
        margin: 2rem;
      }
      .FAQ_container h3 {
        padding: 1rem;
      }
    </style>
  </head>
  <body>
    <%@ include file="../common/menubar.jsp" %>

    <div class="support_container">
      <h2 align="center" style="font-weight: bold">자주묻는 질문들</h2>
      <div class="FAQ_container">
        <h3>Q. 고객센터의 상담시간</h3>
        <p>
          - 고객센터 전화번호 : 1544-0000 <br />
          <br />
        </p>
        <h3>Q. 고객센터의 상담시간2</h3>
        <p>
          - 상담 시간 : 평일 오전 9시 30분 ~ 오후 6시 (점심시간 : 오전 11시 30분
        </p>
        <h3>Q. 고객센터의 상담시간3</h3>
        <p>~ 오후 1시 30분 / 주말, 공휴일 휴무) <br /></p>
        <h3>Q. 고객센터의 상담시간4</h3>
        <p>
          - 전화 연결이 어려운 경우 이메일로 문의를 남겨주시면 확인 후 정성껏
          답변드리겠습니다. <br />
        </p>
        <h3>Q. 고객센터의 상담시간</h3>
        <p>
          - 고객센터 전화번호 : 1544-0000 <br />
          - 상담 시간 : 평일 오전 9시 30분 ~ 오후 6시 (점심시간 : 오전 11시 30분
          ~ 오후 1시 30분 / 주말, 공휴일 휴무) <br />
          - 전화 연결이 어려운 경우 이메일로 문의를 남겨주시면 확인 후 정성껏
          답변드리겠습니다. <br />
        </p>
        <section class="direction">
            <h3 align = "center">Q. 오시는 길</h3>
            <p><img src="././resources/images/map.png" width="700px" /><br></p>
        </section>
      </div>
    </div>

    <script>
      $(function () {
        $(".FAQ_container h3").click(function () {
          if ($(this).next().css("display") == "none") {
            $(this).next().slideDown();
          } else {
            $(this).next().slideUp();
          }
        });
      });
    </script>
    <%@ include file="../common/footer.jsp" %>
  </body>
</html>
