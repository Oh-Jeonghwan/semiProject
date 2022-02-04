<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>footer</title>
<style>
  /*----------------footer------------------*/
  .footer1 {
        background-color: #585856;
        color: white;
        padding: 1.5rem;
      }
      .footer1 ul {
        display: flex;
        justify-content: space-around;
        font-weight: bold;
        cursor: pointer;
      }

      .footer2 {
        background-color: #53535e;
        color: white;
        display: flex;
        justify-content: space-around;
      }
      .footer2 .logo_name {
        color: white;
        text-align: center;
        padding: 0;
      }

      .footer2_desc {
        padding: 3rem;
        font-size: 13px;
      }

      .footer2_socialmedia {
        width: 300px;
        align-self: center;
        text-align: center;
      }

      .footer2_socialmedia i {
        color: white;
        padding: 0.8rem;
        font-size: 1.3rem;
        align-items: center;
      }

</style>
</head>
<body>

      <section class="section_footer">
        <div class="footer1">
          <ul>
            <li onclick="location.href=''">문의하기</li>
            <li>사용약관</li>
            <li>개인정보보호방침</li>
          </ul>
        </div>
        <div class="footer2">
          <div class="logo_name">맡겨만주시조</div>
          <div class="footer2_desc">
            <p>
              사업자번호: 000-00-000000 대표: 4조 (0000) 서울특별시 영등포구
              <br />
              전화: 02) 000-0000 팩스: 02)000-0000 이메일: support@gmail.com
              <br />
            </p>
          </div>
          <div class="footer2_socialmedia">
            <a href="https://www.facebook.com"><i class="social fab fa-facebook-square"></i></a>
            <a href="https://www.google.com"><i class="social far fa-envelope"></i></a>
            <a href="https://www.instagram.com"><i class="social fab fa-instagram"></i></a>
            <a href="https://www.github.com"><i class="social fab fa-github"></i></a>
          </div>
        </div>
      </section>
 
</body>
</html>