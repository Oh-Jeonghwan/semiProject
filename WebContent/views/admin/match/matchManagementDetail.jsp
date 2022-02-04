<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.kh.member.model.vo.Match, com.kh.member.model.vo.Mypet, com.kh.member.model.vo.Review" %>
<%
	Match m = (Match)request.getAttribute("m");

	Review re = (Review)request.getAttribute("r");

	Mypet mp = (Mypet)request.getAttribute("mp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

    .matching-detail{
        background: #9e9e9e1a;
        width: 95%;
        margin: auto;
        margin-bottom: 4rem;
    }
    .matching-detail table {
        text-align: center;
        width: 95%;
        margin: auto;
    }
 
  .detail_area table{
      width: 90%;
      margin: auto;
  }

  .matching-detail-pet{
      display: flex;
      justify-content: center;
      width: 90%;
      margin: auto;
  }

  .matching-detail-pet table{
      width: 700px;
      margin: 1rem;
  }
  .matching-detail-review{
      display: flex;
      justify-content: center;
  }
  .review_area{

      text-align: center;
    
  }
    #delete-review-btn{
        margin: 0rem 1rem;
    }
    .del_btn {
        display: inline-block;
        background: orangered;
    }
 
    .del_btn a {
        text-decoration: none;
        color : black;
    }
</style>
</head>
<body>
    <%@ include file="../../common/menubar.jsp" %>

    <div class="matching-detail">
        <h1 align="center" style="margin: 3rem; padding-top: 2rem ; font-weight: bold;">매칭내역 상세관리</h1>

            <table class="table table-striped detail_table"  width="80%">
                <th >
                    <th>매칭코드</th>
                    <th>견주</th>
                    <th>펫시터</th>
                    <th>지역</th>
                    <th>예약 날짜</th>
                    <th>돌봄 시작 날짜</th>
                    <th>돌봄 종료 날짜</th>
                    <th>매칭종료여부</th>
                </th>
                <tr style="background: white;">
                    <td><%= m.getMatNo() %></td>
                    <td><%= m.getPoNum() %></td>
                    <td><%= m.getPsNum() %></td>
                    <td><%= m.getLocation() %></td>
                    <td><%= m.getRequestdate() %></td>
                    <td><%= m.getCareSdate() %></td>
                    <td><%= m.getCareDdate() %></td>
                    <td>
                    	<% if(m.getIsEnd().equals("N")) { %>
                			진행중
                		<% } else { %>
                			종료
                		<% } %>
                	</td>
                </tr>
            </table>
        
            <table class="table detail_tb"  width="80%" >
                <tr>
                    <th style="background: rgba(0,0,0,.05)" width=400>돌봄주소</th>
                    <td style="border-bottom: 1px solid #dee2e6;"><%= m.getAddress() %></td>
                </tr>            
            </table>
            <h2 style="text-align: center; font-weight: bold; padding: 2rem; margin-top: 2rem;">반려동물 정보</h2>
            <div class="matching-detail-pet">
            
                <div class="matching-detail-pet-img" style="    align-self: center;">
                    <img src="<%= contextPath %>/<%= mp.getTitleImg() %>" width="150" height="100"  ">
                </div>
                <table class="table detail_tb">
                    <tr>
                        <th>반려동물 종</th>
                        <th >반려동물 이름</th>
                        <th>반려동물 성별</th>
                        <th>반려동물 나이</th>
                        <th>반려동물 몸무게</th>
                        <th>요구사항 및 특징</th>
                    </tr>
                    <tr style="background: white;">
                        <td><%= m.getPetType() %></td>
                        <td><%= m.getPetNum() %></td>
                        <td><%= mp.getPetGender() %></td>
                        <td><%= mp.getPetBirth() %></td>
                        <td><%= mp.getPetWeight() %></td>
                        <td><%= mp.getPetDec() %></td>
                    </tr>
                </table>
             </div>
             <h2 style="text-align: center; font-weight: bold; padding: 2rem; margin-top: 2rem;">리뷰 정보</h2>
             <div class="matching-detail-review">
                <% if(re != null) { %>
                <div class="review_area">
             
                   <span style="font-weight: bold; font-size: 1.1rem; color: rgb(34, 33, 33);"><%= re.getReviewDate() %></span> &nbsp; <span style="width: 100%;" ><%= re.getReviewContent() %></span>
                </div>
                
                <div >
                    <form action="<%= contextPath %>/reviewdelete.re" method="post">
                        <input type="hidden" name="reviewWriter" value="<%= re.getReviewWriter() %>">
                        <input type="hidden" name="matNo" value="<%= m.getMatNo() %>">
                        <button type="submit" id="delete-review-btn" class="btn  btn-outline-dark btn-sm" >리뷰 삭제</button>
                    </form>
                </div>
                <% } %>
            </div>
            <div class="matching-delete-btn-area" align="center" style="padding: 3rem;" >
            	<form action="<%= contextPath %>/matchdelete.ma" method="post">
            	<input type="hidden" name="matNo" value="<%= m.getMatNo() %>">
            		<button class="btn btn-danger del_btn" type="submit">매칭 내역 삭제</button>
                    <button class="btn btn-secondary del_btn" onclick="history.back()" type="button">뒤로가기</button>
            	</form>
            </div>
    
    </div>
    <%@ include file="../../common/footer.jsp" %>
</body>
</html>