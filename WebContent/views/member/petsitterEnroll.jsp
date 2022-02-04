<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>펫시터 등록하기</title>
    <style>
      .psenroll_container {
        margin: 2rem;
        margin-top: 3rem;
      }
      .ps_agreement_container {
        width: 600px;
        margin: 3rem auto;
      }

      .ps_agreement_content {
        border: 1px solid lightgray;
        padding: 2rem;
      }
      .ps_agreement {
        width: 100%;
        text-align: end;
        padding: 2rem;
      }
    </style>
  </head>
  <body>
    <%@ include file="../common/menubar.jsp" %>
    <div class="psenroll_container">
      <h3 align="center" class="psenroll-title">
        맡겨만주시조의 펫시터가 되어 주실래요? :)
      </h3>

      <div align="center" class="ps_agreement_container">
        <div class="ps_agreement_content">
          아래의 '개인정보 수집 및 이용에 대한 동의'를 잘 읽고 이해했으며,
          최종적으로 지원서를 제출하는 경우 아래의 내용에 동의하는 것으로
          인정합니다. 1. 목적 : 지원자 개인 식별,지원의사 확인 2. 항목 : 지원자
          성명, 연락처, 이메일 등 해당 신청서에서 수집된 정보 3. 보유기간 : 해당
          지원자 모집 종료 후 1년간 보유,이용 4. 동의를 거부할 권리 및 동의
          거부에 대한 불이익 : 지원자는 이 내용에 대해 동의하지 않을 권리가
          있으며, 이 내용에 동의가 없으면 펫시터 지원은 불가합니다.
        </div>

        <div class="ps_agreement">
          <input type="radio" id="yesAgree" required />
          <label for="yesAgree"> 네! 동의합니다.</label>
        </div>
      </div>

      <div align="center">
        <button
          type="button"
          onclick="location.href='<%= contextPath%>/register.pe'"
          class="btn btn-primary"
          type="submit"
        >
          신청하기
        </button>
      </div>
    </div>
    <%@ include file="../common/footer.jsp" %>
  </body>
</html>
