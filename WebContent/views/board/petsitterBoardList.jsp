<%@page import="com.kh.common.model.vo.PageInfo"%>
<%@page import="com.kh.common.model.vo.Attachment"%>
<%@page import="com.kh.board.model.vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <% 
   ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
   PageInfo pi = (PageInfo)request.getAttribute("pi");
   int currentPage = pi.getCurrentPage(); 
   int maxPage = pi.getMaxPage();
   int startPage = pi.getStartPage();
   int endPage = pi.getEndPage();
 
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <style>
      .petsitter_list_container {
          margin: 3rem 2rem;
      }
      .search_container {
        border: 1px solid gray;
        padding: 1rem;
        width: 76%;
        margin: auto;
        position: relative;
      }
    
      .search_container_top {
        width: 80%;
        padding: 0.5rem;
        display: flex;
        justify-content: space-around;
      }
      .search_container_bottom {
        width: 80%;
        display: flex;
        padding: 0.5rem;
        justify-content: space-around;
      }

    
      .search_btn {
        position:absolute;
        padding: 0.5rem;
        bottom: 0;
        right: 1rem;
      }
      .search_btn input {
        width: 60px;
      }
      .list_container,.searchedlist_container {
        margin: auto;
        width: 80%;
      }
      .petsitter_info {
        margin: 1.5rem auto;
        width: 95%;
        display: flex;
        border: 1px solid gray;
        cursor: pointer;
      }
      .petsitter_thumbnail {
        width: 35%;
      }
      .petsitter_thumbnail img {
        width: 100%;
      }
      .petsitter_content {
        padding: 1rem;
        width: 65%;
      }
      .petsitter_content h4 {
        font-size: 1.3rem;
        text-align: center;
        font-weight: bold;
      }
      .petsitter_content .petsitter_desc {
        padding: 0.3rem 3rem;
      }
      .petsitter_price {
        text-align: end;
        padding: 1rem;
        font-size: 1.2rem;
        font-weight: bold;
      }
      .petsitter_list_paging {
        width: 500px;
        margin: 5rem auto;
        text-align: center;
      }

      .petsitter_info:hover{
        border: 2px yellowgreen solid;
     
      }
    </style>
</style>
</head>
<body>
    <%@ include file="../common/menubar.jsp" %>
    
    
     <div class="petsitter_list_container">
        <div class="search_container">
            
              <div class="search_container_top">
                <div class="search_location">
                  <label >지역</label>
                <select name="location" id="location">
                  <option selected value="서울">서울</option>
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
                </div>
                <div class="search_price">
                  <label>가격</label>
                  <select name="price" id="price">
                  
                    <option selected value="7000~15000">7000원 ~ 15000원</option>
                    <option value="15000~20000">15000원 ~ 20000원</option>
                    <option value="20000~25000">20000원 ~ 25000원</option>
                    <option value="25000~30000">25000원 ~ 30000원</option>
                  </select>
                </div>
 
              </div>
           
              <div class="search_btn">
                <input class="btn btn-secondary" id="searchBtn" type="submit" value="검색" />
              </div>
           
		  	<script>
		  	
		  	$(function(){
        
          let location = "서울";
          let price = "7000~15000";
 



          $("#location").change(function(){
    
            location = $(this).val();
          
          }) 
     
          $("#price").change(function(){
              price = $(this).val();   
          }) 

          $("#searchBtn").click(function(){
	       
            $.ajax({
                  url:"<%= contextPath%>/search.bo",
                  data:{
                    location :location,
                    price:price                    
                  },
                  type: "post",
                  success: function(res){
              
               console.log("res: ", res);
                    let result = ""; 	 
      
                	  for(let i =0; i< res.length; i++){
                      console.log(res[i].psExp) //
	            		  result +=    "<div class='petsitter_info'>"
	                          + "<input type='hidden' value= "+res[i].boardNum +">"
	                           +  "<div class='petsitter_thumbnail'>"
	                            +   "<img src='<%= contextPath %>"+res[i].mainImg +"' alt='"+res[i].boardNum + "no board img'   />"
	                         + " </div>"
	                          +  " <div class='petsitter_content'>"
	                           +    "<h4>"+res[i].psTitle+" </h4>"
	                            +  " <div class='petsitter_desc'>"
	                             +   " <span id='petsitter_name'>"+ res[i].writer+ "</span> /"
	                              +      " <span id='petsitter_name'>" + res[i].writerLocation +"</span> /";
	                            if( res[i].psExp === "Y"){
	                             result += " <span id='petsitter_name'>경력 있습니다.</span>";
	                            }else{
	                             result += "  <span id='petsitter_name'>경력 없어요.</span>"
	                             }                                      
	                             result   += "</div>"
	                             + "<div class='petsitter_price'>1박: "+ res[i].price +"</div>"
	                            + "</div>"
	                      + " </div>"
                                 
                	  }
                    $(".searchedlist_container").html(result);
                    $(".list_container").css("display","none");
      
                
                  },
                  error: function(r){
                    alert("error ", r)
                  }

                })
          })
        })
		  	
		  	
		  	</script>
        </div>
        <div class="list_container">
          
          <% for(Board b: list){ %>
           <div class="petsitter_info">
           <input type="hidden" value=<%= b.getBoardNum() %> >
            <div class="petsitter_thumbnail">
              <img src="<%= contextPath %><%= b.getMainImg()%>" alt="<%= b.getBoardNum() %>no board img" />
            </div>
            <div class="petsitter_content">
       
              <h4><%= b.getPsTitle() %></h4>
              <div class="petsitter_desc">
                <span id="petsitter_name"><%= b.getWriter() %></span> /
                <span id="petsitter_name"><%= b.getWriterLocation() %></span> /
               
               <% if(b.getPsExp().equals("Y")){%>
                  <span id="petsitter_name">경력 있습니다.</span>
               <%}else{ %>
                 <span id="petsitter_name">경력 없어요.</span>
               <%} %>
              
              </div>
              <div class="petsitter_price">1박: <%= b.getPrice() %></div>
            </div>
          </div>
          
          <%} %>
        </div>
        <div class="searchedlist_container"></div>
        
        <div class="petsitter_list_paging">
        <div align="center" class="paging-area">
            <!--  페이징 바에서  <를 담당 -->
            <% if(currentPage != 1){ %>
            <button
              onclick="location.href='<%= contextPath%>/list.bo?currentPage=<%=currentPage-1%>'"
            >
              &lt;
            </button>
            <%} %>

            <!-- 페이징 바에서 숫자를 담당 -->
            <% for(int i = startPage; i <= endPage; i++){%>
            <!--  버튼이 눌렸을 때 해당 페이지로 이동 -->

            <!--  현재 내가 보고 있는 페이지인 경우는 클릭 막음 -->
            <%if(currentPage == i) {%>
            <button disabled><%= i %></button>
            <%} else{ %>
            <button
              onclick="location.href='<%= contextPath%>/list.bo?currentPage=<%=i%>'"
            >
              <%= i %>
            </button>
            <%} %> <%} %>

            <!--  페이징 바에서  >를 담당 -->

            <% if(currentPage != maxPage){ %>
            <button
              onclick="location.href='<%= contextPath%>/list.bo?currentPage=<%= currentPage + 1%>'"
            >
              &gt;
            </button>
            <%} %>
          </div>
        </div>
        </div>
      </div>
      <script>
      
      $(function(){



         $(".searchedlist_container").on("click", ".petsitter_info", function(){

          let bno = $(this).children().val();
        
          location.href="/pet/detail.bo?bno="+bno;

         })
        $(".petsitter_info").on("click", function(){
        	
        	let bno = $(this).children().val();
      
          location.href="/pet/detail.bo?bno="+bno;
        })

      })

      </script>
    
    
    
     <%@ include file="../common/footer.jsp" %>
</body>
</html>