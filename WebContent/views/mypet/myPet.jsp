<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> 

<%@ page import="java.util.ArrayList, com.kh.member.model.vo.Mypet, java.util.List" %>
 <% ArrayList<Mypet>  list = (ArrayList<Mypet>)request.getAttribute("list");
 
 %>
    <!DOCTYPE html>
    <html>
      <head>
        <meta charset="UTF-8" />
        <title>마이펫 페이지</title>

        <style>
          th {
            text-align: center;
          }

          .mypet-page {
            padding: 1rem;
            background: #f5f2ec;

            width: 90%;

            margin: auto;
            margin-top: 50px;
          }

          .list-area {
            width: 80%;
            margin: auto;
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
          }

          .thumbnail {
            background: #d3d3d35e;
            margin: 1rem;
          }
          .thumbnail p {
            padding: 1rem;
            font-weight: bold;
          }
          /* .thumbnail {
            border: 1px solid white;
            width: 300px;

            margin: 15px;
            margin-top: 50px;
            position: relative;
            left: 100px;
          }

          .thumbnail:hover {
            cursor: pointer;
            opacity: 0.7;
          } */
        </style>
      </head>
      <body>
        <header>
          <%@ include file="../common/menubar.jsp" %> <% String memNum =
          loginUser.getMemNum(); %>
        </header>

        <br /><br /><br />

        <div class="mypet-page">
          <br />
          <h2 align="center" style="font-weight: bold">마이펫 페이지</h2>

          <hr />
          <br />

          <!-- 로그인한 회원만 버튼이 보여지게끔 -->
          <% if(loginUser != null) { %>

          <form action="<%= contextPath %>/myPetInsert.me">
            <input type="hidden" name="memNum" value="<%= memNum %>" />
            <div align="right">
              <button
                type="submit"
                class="btn btn-success btn-sm"
                style="width: 120px; height: 60px"
              >
                등록하기
              </button>
              <br /><br />
            </div>
          </form>

          <% } %>

          <div class="list-area">
            <% if(!list.isEmpty()) { %> <% for(Mypet mp : list) { %>
            <form
              action="<%= contextPath %>/myPetDetail.me"
              method="post"
              class="form"
            >
              <input
                type="hidden"
                name="petNum"
                value="<%= mp.getPetNum() %>"
              />
              <div class="thumbnail" align="center">
                <button type="submit" class="btn btn-default">
                  <img
                    src="<%= contextPath %>/<%= mp.getTitleImg() %>"
                    width="280px"
                    height="250px"
                  />

                  <p>
                    <span>
                      <%= mp.getPetName() %> (<%= mp.getPetGender() %>)
                    </span>
                    <br />
                    <%= mp.getPetType() %>
                  </p>
                </button>
              </div>
            </form>
            <% } %> <% } else { %>
            <!-- [] 값이 있긴 해서 안드는거임.  -->
            <div align="center">
              <p>
                <b>마이펫을 등록해주세요.</b>
              </p>
            </div>
            <% } %>
          </div>
          <br />
          <br />
          <br />

          <script>
            $(function () {
              $(".thumbnail").click(function () {
                // 클릭될때마다 url 요청 => location.href
                // /jsp/detail.th?bno=X

                // X 먼저 구하기
                var bno = $(this).children().eq(0).val();

                // location.href = /detail.th?bno=" + bno;
              });
            });
          </script>
        </div>

        <br /><br /><br /><br />

        <footer><%@ include file="../common/footer.jsp" %></footer>
      </body>
    </html></Mypet
  ></Mypet
>
