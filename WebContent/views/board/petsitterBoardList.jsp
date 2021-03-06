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
                  <label >??????</label>
                <select name="location" id="location">
                  <option selected value="??????">??????</option>
                    <option value="??????">??????</option>
                    <option value="??????">??????</option>
                    <option value="??????">??????</option>
                    <option value="??????">??????</option>
                    <option value="??????">??????</option>
                    <option value="??????">??????</option>
                    <option value="??????">??????</option>
                    <option value="??????">??????</option>
                    <option value="??????">??????</option>
                    <option value="??????">??????</option>
                    <option value="??????">??????</option>
                    <option value="??????">??????</option>
                    <option value="??????">??????</option>
                    <option value="??????">??????</option>
                    <option value="??????">??????</option>
                    <option value="??????">??????</option>
                  </select>
                </div>
                <div class="search_price">
                  <label>??????</label>
                  <select name="price" id="price">
                  
                    <option selected value="7000~15000">7000??? ~ 15000???</option>
                    <option value="15000~20000">15000??? ~ 20000???</option>
                    <option value="20000~25000">20000??? ~ 25000???</option>
                    <option value="25000~30000">25000??? ~ 30000???</option>
                  </select>
                </div>
 
              </div>
           
              <div class="search_btn">
                <input class="btn btn-secondary" id="searchBtn" type="submit" value="??????" />
              </div>
           
		  	<script>
		  	
		  	$(function(){
        
          let location = "??????";
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
	                             result += " <span id='petsitter_name'>?????? ????????????.</span>";
	                            }else{
	                             result += "  <span id='petsitter_name'>?????? ?????????.</span>"
	                             }                                      
	                             result   += "</div>"
	                             + "<div class='petsitter_price'>1???: "+ res[i].price +"</div>"
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
                  <span id="petsitter_name">?????? ????????????.</span>
               <%}else{ %>
                 <span id="petsitter_name">?????? ?????????.</span>
               <%} %>
              
              </div>
              <div class="petsitter_price">1???: <%= b.getPrice() %></div>
            </div>
          </div>
          
          <%} %>
        </div>
        <div class="searchedlist_container"></div>
        
        <div class="petsitter_list_paging">
        <div align="center" class="paging-area">
            <!--  ????????? ?????????  <??? ?????? -->
            <% if(currentPage != 1){ %>
            <button
              onclick="location.href='<%= contextPath%>/list.bo?currentPage=<%=currentPage-1%>'"
            >
              &lt;
            </button>
            <%} %>

            <!-- ????????? ????????? ????????? ?????? -->
            <% for(int i = startPage; i <= endPage; i++){%>
            <!--  ????????? ????????? ??? ?????? ???????????? ?????? -->

            <!--  ?????? ?????? ?????? ?????? ???????????? ????????? ?????? ?????? -->
            <%if(currentPage == i) {%>
            <button disabled><%= i %></button>
            <%} else{ %>
            <button
              onclick="location.href='<%= contextPath%>/list.bo?currentPage=<%=i%>'"
            >
              <%= i %>
            </button>
            <%} %> <%} %>

            <!--  ????????? ?????????  >??? ?????? -->

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