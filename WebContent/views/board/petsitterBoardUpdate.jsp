<%@page import="com.kh.common.model.vo.Attachment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kh.board.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
Board b = (Board)request.getAttribute("b");
String psExp  = (b.getPsExp() == null) ? "" : b.getPsExp(); 
String psPet  = (b.getPsPet() == null) ? "" : b.getPsPet(); 
String psKid  = (b.getPsKid() == null) ? "" : b.getPsKid(); 
String psSmoke  = (b.getPsSmoke() == null) ? "" : b.getPsSmoke(); 
int petCap = b.getPetCap();
int price =  b.getPrice();

ArrayList<Attachment> list = (ArrayList<Attachment>)request.getAttribute("list");

%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <style>
      .petSitterUpdate_container {
        margin-bottom: 2rem;
      }
      .petSitterupdate_form_container {
        width: 800px;
        margin: auto;
        padding: 2rem;
      }
      .petSitterUpdate_container table {
        padding: 1rem;
        margin: auto;
        width: 500px;
      }
      .petSitterUpdate_container th {
        width: 300px;
      }
      .petSitterUpdate_container td {
        width: 300px;
        text-align: center;
      }
     .petSitterupdate_form_container form {
        padding: 1rem;
      }


    </style>
  </head>
  <body>
    <%@ include file="../common/menubar.jsp" %>
<div class="petSitterUpdate_container">
      <h2 style="text-align: center; font-weight: bold; margin-top: 3rem">
        펫시터 게시판 수정하기
      </h2>
      <div class="petSitterupdate_form_container">
        <form
          action="<%= contextPath %>/update.bo"
          method="post"
          enctype="multipart/form-data"
          style="padding: 2rem"
        >
        <input type="hidden" name="bno" value=<%=b.getBoardNum() %>>
    
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
                <select name="petCap">
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
                <select name="price">
                  <option selected value="7000" >7000원</option>
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
            <script>
              $(function(){

                  let psExp = "<%= psExp %>";
                  let psPet = "<%= psPet %>";
                  let psKid = "<%= psKid %>";
                  let psSmoke = "<%= psSmoke %>";
                  let petCap = "<%= petCap%>";
                  let price = "<%= price%>";
          
                $("input[name=psExp]").each(function(){
                
                    if( $(this).val() === psExp){
                
                      $(this).attr("checked", true);
                    }
                  });
                $("input[name=psPet]").each(function(){
                
                  if( $(this).val() === psPet){
              
                    $(this).attr("checked", true);
                  }
                 });
                $("input[name=psKid]").each(function(){
                  
                  if( $(this).val() === psKid){
              
                    $(this).attr("checked", true);
                  }
                });
                $("input[name=psSmoke]").each(function(){
                
                  if( $(this).val() === psSmoke){
              
                    $(this).attr("checked", true);
                  }
                });

                $("select[name=petCap] option").each(function(){
                    if($(this).val()=== petCap){
         
                      $(this).attr("selected", true);
                    }
                })
                $("select[name=price] option").each(function(){
                    if($(this).val()=== price){
                 
                      $(this).attr("selected", true);
                    }
                })

              })
            </script>
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
                >
                <%= b.getCondition() %>
                </textarea>
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
                  value="<%= b.getPsTitle() %>"
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
                ><%= b.getPsDesc() %></textarea>
              </td>
            </tr>
            <tr>
              <th>소개할 사진을 올려주세요</th>
				<td >
				
          <div id="upfiles_wrap originalfiles"  >
            <%for(int i =0; i< list.size(); i++){ 
            String fileName = "originalFileName"+ (i+1);
            String fileNo = "originalFileNo"+ (i+1);%>
            <input type="hidden" name=<%=fileNo%> value="<%= list.get(i).getFileNo() %>" />
            <input type="hidden" name=<%=fileName%> value="<%= list.get(i).getChangeName() %>" />
            <%} %>
          </div>
        
        </td>
              <td>
                <div id="upfiles_wrap">
                  <span>MAIN</span>
                  <% if(!list.isEmpty()){ %>
                   <img src="<%= contextPath %><%= list.get(0).getFilePath() %><%= list.get(0).getChangeName() %>" width="100px" heigth="100px" >
                  <%} %>
                 
                  <input type="file" name="reUpfiles1" />
                </div>
                
               
              	  <div id="upfiles_wrap">
                  <span>SUB1</span>
                  <%if(list.size()>=2){ %>
                    <img src="<%= contextPath %><%= list.get(1).getFilePath() %><%= list.get(1).getChangeName() %>" width="100px" heigth="100px" >
                  <%} %>
                   
                  <input type="file" name="reUpfiles2" />
                </div>
          		  <div id="upfiles_wrap">
                  <span>SUB2</span>
    					 <%if(list.size()>=3){ %>
                    <img src="<%= contextPath %><%= list.get(2).getFilePath() %><%= list.get(2).getChangeName() %>" width="100px" heigth="100px" >
                  <%} %>
                  <input type="file" name="reUpfiles3" />
                </div>
              </td>
            </tr>
          </table>



          <div class="register_btns" align="center">
            <button  class="btn btn-primary" type="submit">업데이트 하기</button>
            <button type="reset" class="btn btn-secondary" type="reset">취소하기</button>
          </div>
        </form>
      </div>
    </div>


    <%@ include file="../common/footer.jsp" %>
  </body>
</html>
