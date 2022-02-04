<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ page import="java.util.ArrayList, com.kh.member.model.vo.Mypet" %>
 <% ArrayList<Mypet> list2 = (ArrayList<Mypet>)request.getAttribute("list2"); %>
    <!DOCTYPE html>
    <html>
      <head>
        <meta charset="UTF-8" />
        <title>마이펫 상세조회</title>

        <style>
          .outer1 {
            background: #f5f2ec;
            color: black;
            width: 1200px;
            height: 750px;
            margin: auto;
            margin-top: 50px;
          }

          table {
            border: 1px solid white;
            width: 450px;
          }

          table textarea {
            width: 90%;
            box-sizing: border-box;
          }

          th {
            text-align: center;
          }
          .mypet-info th {
            text-align: center;
          }

          .mypetdetail-btns {
            display: flex;
            justify-content: center;
            margin: 2rem;
          }
          .mypetdetail-btns div {
            align-self: center;
          }
          .mypetdetail-btns button {
            padding: 0.5rem;
            margin: 1rem;
          }
          /*
    td{
    	font-size:20px;
    }  
    */
        </style>
      </head>
      <body>
        <header>
          <%@ include file="../common/menubar.jsp" %> <% String memNum =
          loginUser.getMemNum(); %>
        </header>

        <br /><br /><br />

        <div class="outer1">
          <br />
          <h2 align="center">마이펫 상세조회</h2>

          <hr />
          <br />

          <% for(Mypet mp2 : list2) { %>

          <table align="center">
            <!-- 미리보기 영역 -->
            <tr>
              <th>
                <img
                  src="<%= contextPath %>/<%= mp2.getTitleImg() %>"
                  width="400"
                  height="400"
                />
              </th>
              <td align="center">
                <table align="center" class="mypet-info">
                  <tr>
                    <th>이름</th>
                    <td>
                      <input
                        disabled
                        type="text"
                        name="name"
                        value="<%=mp2.getPetName() %>"
                        readonly
                      />
                    </td>
                  </tr>
                  <tr>
                    <th width="100">성별</th>
                    <td>
                      <input
                        type="text"
                        name="gender"
                        value="<%= mp2.getPetGender() %>"
                        disabled
                      />
                    </td>
                  </tr>
                  <tr>
                    <th width="100">품종</th>
                    <td>
                      <input
                        type="text"
                        name="type"
                        value="<%= mp2.getPetType() %>"
                        disabled
                      />
                    </td>
                  </tr>
                  <tr>
                    <th width="100">생년월일</th>
                    <td>
                      <input
                        type="text"
                        name="age"
                        value="<%= mp2.getPetBirth() %>"
                        disabled
                      />
                    </td>
                  </tr>
                  <tr>
                    <th width="100">몸무게</th>
                    <td>
                      <input
                        type="text"
                        name="weight"
                        value="<%= mp2.getPetWeight() %>"
                        disabled
                      />
                    </td>
                  </tr>

                  <tr>
                    <th>
                      특징 및 <br />
                      요구사항
                    </th>
                    <td>
                      <input
                        type="text"
                        name="petDec"
                        style="width: 300px; height: 280px"
                        value="<%= mp2.getPetDec() %>"
                        disabled
                      />
                    </td>
                  </tr>
                </table>
              </td>
            </tr>
          </table>
          <% } %>

          <div class="mypetdetail-btns">
            <div>
              <button
                type="submit"
                class="btn btn-danger btn-sm"
                data-toggle="modal"
                data-target="#deleteMyPet"
                style="width: 100px"
              >
                삭제
              </button>
            </div>

            <div class="modal" id="deleteMyPet">
              <div class="modal-dialog">
                <div class="modal-content">
                  <!-- Modal Header -->
                  <div class="modal-header">
                    <h4 class="modal-title" style="color: black">
                      마이펫 삭제
                    </h4>
                    <button type="button" class="close" data-dismiss="modal">
                      &times;
                    </button>
                  </div>

                  <div class="modal-body" align="center">
                    <h3 style="color: red">삭제를 완료하시겠습니까?</h3>
                  </div>

                  <br /><br />
                  <% for(Mypet mp2 : list2) { %>
                  <div align="center">
                    <form
                      action="<%= contextPath %>/myPetDelete.me"
                      method="post"
                    >
                      <input
                        type="hidden"
                        name="petNum"
                        value="<%= mp2.getPetNum() %>"
                      />
                      <button
                        type="submit"
                        style="width: 120px"
                        class="btn btn-danger btn-sm"
                      >
                        삭제 완료
                      </button>
                    </form>
                  </div>
                  <% } %>
                  <br /><br />
                </div>
              </div>
            </div>
            <form action="<%= contextPath %>/myPet.me" method="post">
              <input type="hidden" name="memNum" value="<%= memNum %>" />
              <div align="center">
                <button type="submit" class="btn btn-primary">
                  목록으로 돌아가기
                </button>
              </div>
            </form>
          </div>
        </div>

        <br /><br /><br /><br /><br />

        <footer><%@ include file="../common/footer.jsp" %></footer>
      </body>
    </html></Mypet
  ></Mypet
>
