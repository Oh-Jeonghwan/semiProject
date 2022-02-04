<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>welcome to 맡겨만주시조</title>
    <style>
      /*----------------mian-------------*/

      .mainphoto {
        background: url("resources/images/main2.jpg");
        background-repeat: no-repeat;
        background-size: cover;
        width: 100%;
        height: 500px;
        background-position-y: center;
      }

      .main-firstbox {
        margin: 3rem;

        padding: 1rem;
      }
      #main-firstbox-title {
        padding: 3rem;
        font-size: 2rem;
        font-weight: bold;
      }
      .quickservice_container {
        display: flex;

        margin: auto;
        justify-content: space-around;
        margin: 2rem;
      }
      .applypetsitter_img img {
        object-fit: contain;
        background-blend-mode: overlay;
      }

      .applypetsitter_title,
      .searchpetsitter_title {
        text-align: center;
        padding: 0.6rem;
        font-weight: bold;
        margin: 0;
        font-size: 1.5rem;
      }
      .quickservice_content {
        width: 300px;
        align-self: center;
      }

      .applypetsitter_desc,
      .searchpetsitter_desc {
        padding: 0.5rem 1rem;
        font-weight: bold;
        font-size: 1rem;
        text-align: center;
      }

      .quickservice {
        padding: 1rem;
        display: flex;
        border: 3px solid #e2d4cb;
        border-radius: 5px;
        cursor: pointer;
        transition: all ease 1s;
      }

      .quickservice:hover {
        border: 3px solid greenyellow;
        transform: translateY(-4px);
      }

      .main-secondbox {
        padding: 1rem;
        margin-top: 2rem;
        width: 95%;
        margin: auto;
      }
      .htu_container {
        display: flex;
        justify-content: space-around;
      }
      .htu_box {
        padding: 1rem;
        background-color: #d3d3d336;
        border-radius: 10px;
        width: 300px;
      }
      .htu_content {
        text-align: center;
      }
      .htu_img {
        font-size: 4rem;
        padding: 1rem;
        text-align: center;
      }
      .htu_title {
        font-size: 1.3rem;
        font-weight: bold;
        padding: 0.5rem;
      }
      .htu_desc {
        font-size: 1rem;
      }

      .main-thirdbox {
        margin-top: 8rem;

        color: white;
      }
      .ourcarefirst_img {
        background-image: url("./resources/images/dogwalk.jpg");
        height: 800px;
        width: 100%;
        background-size: cover;
        position: relative;
      }
      .ourcarebox_second {
        position: relative;
        height: 725px;
        background-color: #f5f2ec;
      }
      .ourcaresecond_img {
        height: 500px;
        width: auto;
        float: left;
        margin-top: 7rem;
        margin-left: 11rem;
      }
      .ourcaresecond_img2 {
        height: 300px;
        width: auto;
        float: left;
        margin-top: 3rem;
        margin-left: 4rem;
        position: absolute;
      }
      .ourcarefirst_desc {
        position: absolute;
        bottom: 10rem;
        left: 5rem;
        color: white;
        font-size: 3.5rem;
        font-weight: bold;
        text-shadow: 2px 1px 9px rgb(0 0 0 / 50%);
        width: 420px;
      }
      .ourcaresecond_desc {
        color: black;
        font-size: 2rem;
        font-weight: bold;
        padding-top: 25rem;
        padding-left: 35rem;
        width: 75%;
      }

      #desc_detail {
        font-size: 1rem;
        font-weight: 500;
      }
      .main-fourthbox {
        margin: 6rem 3rem;
      }
      .customer_service_box {
        margin: auto;
        display: flex;
        width: 90%;
        justify-content: space-around;
        padding: 1rem 2rem;
      }
      .customer_contact,
      .customer_faq {
        line-height: 0.9;
        width: 450px;
        border-radius: 1px;
        text-align: center;
        padding: 1rem 1rem 0.7rem 1rem;
        color: #555454;
        background-color: #ece5e0;
      }
      .customer_faq {
        font-size: 2rem;
        vertical-align: middle;
        cursor: pointer;
      }
      .customer_faq div {
        line-height: 5;
      }
      .customer_faq:hover {
        background-color: #d6cec9;
      }
    </style>
  </head>
  <body>
    <div class="outer">
      <header><%@ include file="views/common/menubar.jsp" %></header>
      <main>
        <div class="herobox_container">
          <div class="hero mainphoto"></div>
        </div>
        <section class="main-firstbox">
          <h3 align="center" id="main-firstbox-title">QUICK 서비스</h3>

          <div class="quickservice_container">
            <div class="quickservice applypetsitter" onclick="location.href='<%= contextPath %>/registerForm.bo'">
              <div class="applypetsitter_img">
                <img
                  src="./resources/images/quickService3.gif"
                  width="150px"
                  alt=""
                />
              </div>
              <div class="quickservice_content applypetsitter_content">
                <div class="applypetsitter_title">
                  펫시터 되기
                </div>
                <div class="applypetsitter_desc">
                  댕댕이를 사랑하는 펫시터 님에 대해<br />
                  소개시켜주세요 :)<br />
                  펫시터님의 마음을 나누세요
                </div>
              </div>
            </div>
            <div class="quickservice searchpetsitter" onclick="location.href='<%= contextPath%>/list.bo?currentPage=1'">
              <div class="searchpetsitter_img">
                <img
                  src="./resources/images/quickService2.gif"
                  width="150px"
                  alt=""
                />
                <div id="searchpetsitter_img"></div>
              </div>
              <div class="quickservice_content searchpetsitter_content">
                <div class="searchpetsitter_title">펫시터를 찾아보아요!</div>
                <div class="searchpetsitter_desc">
                  다정하고 경험많은 <br />펫시터분들을 만나보세요! :)
                </div>
              </div>
            </div>
          </div>
        </section>
        <section class="main-secondbox">
          <h3
            align="center"
            style="padding: 3rem; font-size: 2rem; font-weight: bold"
          >
            HOW TO USE?
          </h3>
          <div class="htu_container">
            <div class="htu_box">
              <div class="htu_img first_img">🔎</div>
              <div class="htu_content">
                <div class="htu_title">찾아보세요</div>
                <div class="htu_desc">
                  장소, 환경, 프로필을 보시고 알맞은 펫시터를 구해보세요
                </div>
              </div>
            </div>
            <div class="htu_box">
              <div class="htu_img first_img">⏰</div>
              <div class="htu_content">
                <div class="htu_title">날짜를 잡고 신청하세요</div>
                <div class="htu_desc">
                  예약을 전송하고 펫오너와 안전하게 결제하세요
                </div>
              </div>
            </div>
            <div class="htu_box">
              <div class="htu_img first_img">🤝🏼</div>
              <div class="htu_content">
                <div class="htu_title">사전만남 하세요</div>
                <div class="htu_desc">
                  돌봄시작 전 미리 만나서 펫시터와 돌봄장소를 확인해 보세요.
                </div>
              </div>
            </div>
            <div class="htu_box">
              <div class="htu_img first_img">✏️</div>
              <div class="htu_content">
                <div class="htu_title">후기를 남겨 주세요</div>
                <div class="htu_desc">
                  돌봄 후 소중한 후기를 남겨주셔서 다른 댕댕이들에 알려주세요
                </div>
              </div>
            </div>
          </div>
        </section>
        <section class="main-thirdbox">
          <div class="ourcarebox_first">
            <div class="ourcarefirst_img">
              <div class="ourcarefirst_desc">
                검증된 펫시터가 깨끗한 환경과 안전한 산책을 제공해드려요
              </div>
            </div>
          </div>
          <div class="ourcarebox_second">
            <img
              class="ourcaresecond_img"
              src="./resources/images/comfortdog1.jpg"
              alt="main_comfortDog"
            />

            <img
              class="ourcaresecond_img2"
              src="./resources/images/comfortdog2.jpg"
              alt="main_comfortDog2"
            />
            <div class="ourcaresecond_desc">
              배변처리와 깔끔한 환경정리 :)
              <div id="desc_detail">
                매주 내가 원하는 날, 원하는 시간을 정하기만 하면 <br />
                펫시터가 댕댕이를 맞이할 준비를 합니다.
              </div>
            </div>
          </div>
        </section>

        <section></section>
        <section class="main-fourthbox">
          <h3 align="center" style="font-weight: bold">
            <span class="logo_name" style="font-family: Jua, sans-serif">
              맡겨만주시조
            </span>
            고객센터
          </h3>

          <div class="customer_service_box">
            <div class="customer_contact">
              <h4 style="font-weight: bold">문의 및 이용상담</h4>
              <h1 style="color: black; font-weight: bold">
                <span> 051</span>-123-1234
              </h1>
              <h5 style="color: black">Email: abc@gamil.com</h5>
              운영시간: 평일 10:00 ~ 18:00, 공휴일 휴일
            </div>
            <div
              class="customer_faq"
              onclick="location.href='<%= contextPath%>/support.ad'"
            >
              <div style="color: black; font-weight: bold">
                <span style="color: #555454">자주 묻는 질문</span>
                바로가기
              </div>
            </div>
          </div>
        </section>
      </main>
      <footer><%@ include file="views/common/footer.jsp" %></footer>
    </div>
  </body>
</html>
