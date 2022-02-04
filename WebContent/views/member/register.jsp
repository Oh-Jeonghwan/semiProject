<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <style>
      .register_container {
        margin-bottom: 2rem;
      }
      .register_form_container {
        width: 800px;
        margin: auto;
        padding: 2rem;
      }
      .register_form_container table {
        padding: 1rem;
        margin: auto;
        width: 500px;
      }
      .register_form_container th {
        width: 100px;
      }
      .register_form_container td {
        width: 300px;
        text-align: center;
      }
      .location {
        text-align: left;
        padding-left: 4rem;
      }
      form {
        padding: 1rem;
      }
      tbody {
        position: relative;
      }
      #idCheckBtn {
        position: absolute;
        width: 85px;
        font-size: 11px;
        margin-left: 1rem;
      }
      .agreement {
        text-align: end;
        margin-right: 2rem;
      }
      .register_agreement {
        padding: 2rem;
      }
      .register_agreement fieldset {
        text-align: center;
      }
    </style>
  </head>
  <body>
    <%@ include file="../common/menubar.jsp" %>
    <div class="register_container">
      <h2 style="text-align: center; font-weight: bold; margin-top: 3rem">
        회원가입
      </h2>
      <div class="register_form_container">
        <form
      
          action="<%= contextPath %>/insert.me"
          id="enroll-form"
          method="post"
        >
          <table class="table table-borderless">
            <tr>
              <th><span style="color: red">*</span> 아이디</th>
              <td>
                <input type="text" size="30" name="userId" required />
                <button
                  id="idCheckBtn"
                  onclick="idCheck();"
                  class="btn btn-outline-dark btn-sm"
                >
                  아이디 중복검사
                </button>
              </td>
            </tr>
            <tr>
              <th><span style="color: red">*</span> 비밀번호</th>
              <td>
                <input
                  type="password"
                  size="30"
                  name="userPwd"
                  required
                  disabled
                />
              </td>
            </tr>
            <tr>
              <th><span style="color: red">*</span> 비밀번호 확인</th>
              <td>
                <input type="password" size="30" name="checkPwd" required />
                <p
                  style="
                    margin: 0;
                    font-weight: bold;
                    font-size: 0.7rem;
                    padding: 0.3rem;
                  "
                  id="pwdResult"
                ></p>
              </td>
            </tr>
            <tr>
              <th><span style="color: red">*</span> 이름</th>
              <td><input type="text" name="userName" size="30" required />
                <p id="nameResult"       
                 style=" margin: 0;
                        font-weight: bold;
                        font-size: 0.7rem;
                        padding: 0.3rem; "></p>
              </td>
            </tr>
            <tr>
              <th><span style="color: red">*</span> 주민등록번호</th>
              <td>
                <input
                  type="text"
                  placeholder="- 포함 주민등록번호"
                  name="idNo"
                  size="30"
                  required
                />
              </td>
            </tr>
            <tr>
              <th><span style="color: red">*</span> 이메일</th>
              <td>
                <input
                  type="email"
                  placeholder="abc@email.com"
                  name="email"
                  size="30"
                  required
                />
              </td>
            </tr>
            <tr>
              <th><span style="color: red">*</span> 핸드폰</th>
              <td>
                <input
                  type="text"
                  name="phone"
                  placeholder=" - 없이 번호만 입력해주세요"
                  size="30"
                  required
                />
                <p id="phoneResult"
                style=" margin: 0;
                font-weight: bold;
                font-size: 0.7rem;
                padding: 0.3rem; "></p>
              </td>
            </tr>
            <tr>
              <th><span style="color: red">*</span> 주소</th>
              <td>
                <div class="location">
                  <select name="location" id="location">
                    <option value="서울">서울</option>
                    <option value="경기">경기</option>
                    <option value="인천">인천</option>
                    <option value="강원">강원</option>
                    <option value="충북">충북</option>
                    <option value="충남">충남</option>
                    <option value="전북">전북</option>
                    <option value="전북">전남</option>
                    <option value="광주">광주</option>
                    <option value="울산">울산</option>
                    <option value="경북">경북</option>
                    <option value="경남">경남</option>
                    <option value="대구">대구</option>
                    <option value="부산">부산</option>
                    <option value="세종">세종</option>
                    <option value="대전">대전</option>
                    <option value="제주">제주</option>
                  </select>
                  시
                </div>
                <textarea
                  name="address"
                  id="address"
                  cols="30"
                  rows="4"
                  style="resize: none"
                  required
                ></textarea>
              </td>
            </tr>
          </table>
          <div class="register_agreement">
            <fieldset>
              <legend align="center">개인정보 동의서</legend>
              <textarea name="" id="" cols="90" rows="10" disabled>
        1.개인정보의 수집, 이용 목적 KOTRA 통합 회원관리, 서비스제공, 민원처리
        2.수집하는 개인정보의 항목 : 필수입력항목 아이디, 비밀번호 성명(한글) 주소, 전화번호, 이메일 CI : 개인식별정보 DI : 중복가입 확인정보
        선택 입력항목 성명(영문), 팩스, 휴대전화, 부서, 직위, 주소(영문) 개인관심품목, 개인관심지역
        3.개인정보의 보유 및 이용기간 : 회원 탈퇴 시까지(개인회원 : 2년 단위 재동의, 기업회원 : 5년 단위 재동의) ※ 단, 법률이 정하는 바에 따라 탈퇴 후에도 일정기간 보유할 수 있습니다.
        4.개인정보 제공 수집·이용 동의 거부 권리 및 동의 거부 따른 불이익 내용 또는 제한사항 위의 개인정보 수집∙이용에 대한 동의를 거부할 권리가 있습니다.
            - 필수항목의 경우 KOTRA 사업 안내 및 고객 관리, 민원처리 등을 위해 반드시 필요한 사항으로 필수항목에 대하여 수집∙이용에 동의하지 않을 경우 회원에 가입할 수 없습니다.
            - 선택항목의 수집∙이용에 동의하지 않을 경우는 회원으로 가입하여 기본적인 서비스를 제공받을 수 있으나, 맞춤형 서비스제공 등의 추가적인 서비스를 제공받을 수 없음을 양지하여 주시기 바랍니다.
                            </textarea
              >
            </fieldset>
            <div class="agreement">
              <input
                type="radio"
                name="register-agreement"
                id="agreed"
                required
              />
              <label for="agreed">예, 동의합니다.</label>
            </div>
          </div>
          <div class="register_btns" align="center">
            <p
              style="
                margin: 0;
                font-weight: bold;
                font-size: 0.7rem;
                padding: 0.3rem;
              "
              id="validateMsg"
            ></p>
            <button
              class="btn btn-primary"
              type="submit"
              onclick="return validate()"
            >
              회원가입
            </button>
            <button class="btn btn-secondary" type="reset">취소하기</button>
          </div>
        </form>
      </div>
    </div>
    <script>
      let idValidate = false;
      let pwdValidate = false;
      function idCheck() {
        // 아이디 인풋태그로부터 값을 뽑아와야함
        var $userId = $("#enroll-form input[name=userId]");
        $.ajax({
          url: "idCheck.me",
          data: { checkId: $userId.val() },
          success: function (result) {
            if (result == "NNNNN") {
              alert("이미 존재하거나 탈퇴한회원의 아이디입니다.");
              //다시입력유도
              $userId.focus();
            } else {
              if (confirm("사용 가능한 아이디입니다. 사용하시겠습니까?")) {
                $("#enroll-form button[type=submit]").removeAttr("disabled");
                $("input[name=userPwd]").prop("disabled", false);
                $("input[name=userPwd]").focus();
                $userId.attr("readonly", true);
              } else {
                $userId.focus();
              }
            }
          },
          error: function () {
            console.log("아이디 중복체크용 ajax실패");
          },
        });
      }
      $(function () {
        $("input[name=checkPwd]").keyup(function () {
          if (
            $("input[name=userPwd]").val() === $("input[name=checkPwd]").val()
          ) {
            $("#pwdResult").text("비밀번호가 일치합니다.");
            $("#pwdResult").css("color", "blue");
            pwdValidate = true;
          } else {
            $("#pwdResult").text("비밀번호가 불일치합니다.");
            $("#pwdResult").css("color", "red");
            pwdValidate = false;
          }
        });
        $("input[name=userPwd]").keyup(function () {
          if (
            $("input[name=userPwd]").val() === $("input[name=checkPwd]").val()
          ) {
            $("#pwdResult").text("비밀번호가 일치합니다.");
            $("#pwdResult").css("color", "blue");
            pwdValidate = true;
          } else {
            $("#pwdResult").text("비밀번호가 불일치합니다.");
            $("#pwdResult").css("color", "red");
            pwdValidate = false;
          }
        });
      });


      let regExp = /^[가-힣]+$/;
      
     
     if( $("input[name=userName]").change(function(){
         let userName = $(this).val();
         if(!regExp.test(userName)){
           $("#nameResult").text("올바른 형식의 이름이 아닙니다.");
           $("#nameResult").css("color", "red");
         } else {
          $("#nameResult").text("올바른 형식의 이름 입니다.");
          $("#nameResult").css("color", "blue");


         }

     }));

     
    regExp2 = /^[0-9]+$/;
     if($("input[name=phone]").change(function() {

      
      let phone = $(this).val();
      if(!regExp2.test(phone)) {
        $("#phoneResult").text("올바른 형식의 번호가 아닙니다");
        $("#phoneResult").css("color","red");
      } else {
        $("#phoneResult").text("올바른 형식의 번호 입니다");
        $("#phoneResult").css("color","blue");
      }
      

     }));


    
      function validate() {
        let isValidated = true;
        let messageValidation = "";
      
        if (
          $("input[name=userPwd]").val() !== $("input[name=checkPwd]").val()
        ) {
          isValidated = false;
          messageValidation = "비밀번호를 다시 입력해주세요";
        }
        $("#validateMsg").text(messageValidation);
        return isValidated;
      
        

 
       
      }
    
      
    </script>
    <%@ include file="../common/footer.jsp" %>
  </body>
</html>
















