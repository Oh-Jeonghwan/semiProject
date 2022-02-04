<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <style>
      .petSitterRegister_container {
        margin-bottom: 2rem;
      }
      .petSitterRegister_form_container {
        width: 800px;
        margin: auto;
        padding: 2rem;
      }
      .petSitterRegister_form_container form {
        padding: 1rem;
      }
      .petSitterRegister_container table {
        padding: 1rem;
        margin: auto;
        width: 600px;
      }

      .petSitterRegister_container td {
        text-align: center;
      }
      .ps_agreement_container {
        width: 600px;
        margin: 3rem auto;
      }
      .ps_agreement {
        width: 100%;
        text-align: end;
        padding: 2rem;
      }
      #upfiles_wrap {
        display: flex;
      }
      #upfiles_wrap span,
      #upfiles_wrap input {
        padding: 0.5rem;
      }
      
      .register_btns{
      	margin-top : 2rem;
      }
    </style>
  </head>
  <body>
    <%@ include file="../common/menubar.jsp" %>

    <div class="petSitterRegister_container">
      <h2 style="text-align: center; font-weight: bold; margin-top: 3rem">
        펫시터 신청하기
      </h2>
      <div class="petSitterregister_form_container">
        <form
          action="<%= contextPath %>/insert.bo"
          method="post"
          enctype="multipart/form-data"
          style="padding: 2rem"
        >
          <input
            type="hidden"
            name="memNum"
            value="<%= loginUser.getMemNum() %>"
          />
          <table class="table table-borderless">
            <tr>
              <th>펫시터 경험이 있으신가요?</th>
              <td>
                <input type="radio" name="psExp" value="Y" id="exyes" />
                <label for="exyes">예</label>

                <input type="radio" name="psExp" value="N" id="exno" />
                <label for="exno">아니요</label>
              </td>
            </tr>
            <tr>
              <th>지금 키우시는 댕댕이가 있으신가요?</th>
              <td>
                <input type="radio" name="psPet" value="Y" id="petyes" />
                <label for="petyes">예</label>

                <input type="radio" name="psPet" value="N" id="petno" />
                <label for="petno">아니요</label>
              </td>
            </tr>
            <tr>
              <th>댁에 어린아이(12미만)가 있으신가요?</th>
              <td>
                <input type="radio" name="psKid" value="Y" id="kidyes" />
                <label for="kidyes">예</label>

                <input type="radio" name="psKid" value="N" id="kidno" />
                <label for="kidno">아니요</label>
              </td>
            </tr>
            <tr>
              <th>댁에 흡연자가 있으신가요?</th>
              <td>
                <input type="radio" name="psSmoke" value="Y" id="smokeyes" />
                <label for="smokeyes">예</label>

                <input type="radio" name="psSmoke" value="N" id="smokeno" />
                <label for="smokeno">아니요</label>
              </td>
            </tr>
            <tr>
              <th>돌봄 가능한 댕댕이 수</th>
              <td>
                <select name="petCap" required>
                  <option selected>0</option>
                  <option>1</option>
                  <option>2</option>
                  <option>3</option>
                  <option>4</option>
                  <option>5</option>
                  <option>6</option>
                  <option>7</option>
                  <option>8</option>
                  <option>9</option>
                  <option>10</option>
                </select>
              </td>
            </tr>
            <tr>
              <th>펫시팅 서비스 금액</th>
              <td>
                <select name="price" required>
                  <option selected value="7000">7000원</option>
                  <option value="8000">8000원</option>
                  <option value="9000">9000원</option>
                  <option value="10000">10000원</option>
                  <option value="11000">11000원</option>
                  <option value="12000">12000원</option>
                  <option value="13000">13000원</option>
                  <option value="14000">14000원</option>
                  <option value="15000">15000원</option>
                  <option value="16000">16000원</option>
                  <option value="17000">17000원</option>
                  <option value="18000">18000원</option>
                  <option value="19000">19000원</option>
                  <option value="20000">20000원</option>
                  <option value="21000">21000원</option>
                  <option value="22000">22000원</option>
                  <option value="23000">23000원</option>
                  <option value="24000">24000원</option>
                  <option value="25000">25000원</option>
                  <option value="26000">26000원</option>
                  <option value="27000">27000원</option>
                  <option value="28000">28000원</option>
                  <option value="29000">29000원</option>
                  <option value="30000">30000원</option>
                </select>
              </td>
            </tr>
            <tr>
              <th colspan="2">
                "이건 너무 어려워요"하는 사항이 있나요?
                <p style="margin: 0">
                  예) 15kg이상 강아지는 돌보기가 어려워요.
                </p>
              </th>
            </tr>
            <tr>
              <td colspan="2" style="padding: 0">
                <textarea
                  placeholder="내용을 입력해주세요."
                  name="condition"
                  rows="5"
                  cols="80"
                ></textarea>
              </td>
            </tr>
            <tr>
              <th colspan="2">견주들에게 자신을 소개시켜주세요!</th>
            </tr>
            <tr>
              <td colspan="2">
                <input
                  type="text"
                  name="psTitle"
                  size="82"
                  placeholder="예) 사랑으로 케어하는 다롱이 엄마입니다!"
                  required
                />
              </td>
            </tr>
            <tr>
              <td colspan="2" style="padding: 0">
                <textarea
                  placeholder="내용을 입력해주세요."
                  name="psDesc"
                  rows="5"
                  cols="80"
                ></textarea>
              </td>
            </tr>
            <tr>
              <th>소개할 사진을 올려주세요</th>

              <td>
                <div id="upfiles_wrap">
                  <span>MAIN</span>
                  <input type="file" name="upfiles1" required />
                </div>
                <div id="upfiles_wrap">
                  <span>SUB1</span>
                  <input type="file" name="upfiles2" />
                </div>
                <div id="upfiles_wrap">
                  <span>SUB2</span>
                  <input type="file" name="upfiles3" />
                </div>
              </td>
            </tr>
          </table>

  

          <div class="register_btns" align="center">
            <button class="btn btn-primary" type="submit">신청하기</button>
            <button class="btn btn-secondary" type="reset">취소하기</button>
          </div>
        </form>
      </div>
    </div>

    <%@ include file="../common/footer.jsp" %>
  </body>
</html>
