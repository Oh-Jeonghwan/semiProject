<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 .login_container {
        padding: 2rem 2rem 5rem 2rem;
      }

      .login_form_container{
        padding: 1.5rem 2.5rem 0rem 2.5rem;
      }

      .login_form_container th{
        width: 80px;
      }
      
      .login_btns{
        padding: 1rem;
      }
      .login_btns button{
        width: 70px;
    
      }
</style>
</head>
<body>

<%@ include file="../common/menubar.jsp" %>

<div class="login_container">
        <h2 style="text-align: center;font-weight: bold; margin-top: 1rem">WELCOME</h2>
        <div class="login_form_container" align="center">
          <form action="<%= contextPath %>/login.me" method="post">
            <table>
              <tr>
                <th >아이디 </th>
                <td><input type="text" name="userId" required /></td>
              </tr>
              <tr>
                <th>비밀번호 </th>
                <td><input type="password" name="userPwd" required /></td>
              </tr>
            </table>
            <div class="login_btns" align="center">
              <button class="btn btn-primary btn-sm" type="submit">로그인</button>
              <button  class="btn btn-secondary btn-sm" type="reset">취소</button>
            </div>
          </form>
        </div>
        <div align="center" style="font-size: 14px; font-weight: bold;"><a href="<%= contextPath%>/registerForm.me">계정이 아직 없으신가요? click!</a></div>
      </div>

<%@ include file="../common/footer.jsp" %>
</body>
</html>