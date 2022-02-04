<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>마이펫 등록</title>
    
    <style>
        .outer1 {
            background : #f5f2ec;
            color : black;
            width : 1200px;
            height : 700px;
            margin : auto;
            margin-top : 50px;
        }
    
       .outer1 table { border:1px solid white; width: 450px; }
        
        table textarea {
            width : 90%;
            box-sizing : border-box;
        }
    
        .outer1  th{
              text-align: center;
          }
  
    </style>
    
    </head>
    <body>
    	
    	<header>
			<%@ include file="../common/menubar.jsp" %> 
			
	 	</header>
        
    
        <br><br><br>
    
        <div class="outer1">
    
            <br>
            <h2 align="center" style="font-weight: bold; padding: 2rem;">마이펫 등록</h2>
    
            <hr>
            <br>
    
            <form action="<%= contextPath %>/myPetEnroll.me" id="enroll-form" method="post" enctype="multipart/form-data">
    
                <table align="center">
                    
                    <!-- 미리보기 영역 -->
                    <tr>
                        <th><img id="titleImg" width="400" height="400" style="padding: 1rem;"></th>
                        <td align="center">
                            <table align="center" >
                                <tr>
                                    <th>이름</th>
                                    <td><input type="text" name="petName" required></td>
                                </tr>
                                <tr>
                                    <th width="100">성별</th>
                                    <td>
                                        <input type="radio" name="petGender" value="M" required>M
                                        <input type="radio" name="petGender" value="F" required>F
                                    </td>
                                </tr>
                                <tr>
                                    <th width="100">품종</th>
                                    <td>
                                        <select name="petType" id="petType" width=100>
                                            <option value="">품종을 선택해주세요</option>
                                            <option value="푸들">푸들</option>
                                            <option value="말티즈">말티즈</option>
                                            <option value="시바견">시바견</option>
                                            <option value="시츄">시츄</option>
                                            <option value="불독">불독</option>
                                            <option value="골든리트리버">골든리트리버</option>
                                            <option value="포메리안">포메리안</option>
                                            <option value="웰시코기">웰시코기</option>
                                            <option value="그외">그외</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th width="100">생년월일</th>
                                    <td><input type="text" name="petBirth" placeholder="예) 2000"></td>
                                </tr>
                                <tr>
                                    <th width="100">몸무게</th>
                                    <td><input type="text" name="petWeight"></td>
                                </tr>
                                <tr>
                                    <th>특징 및 <br> 요구사항</th>
                                    <td>
                                        <input type="text" name="petDec" style="width: 300px; height: 280px;" required></input>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                   
                </table>
            
                <div id="file-area" align="center" style="margin-top: 10px; margin-right:400px ">
                    <input type="file" id="file1"  name="file1" onchange="loadImg(this, 1);" required> <!-- 대표이미지 : 필수 -->
                    <!-- onchange : input 태그의 내용물이 변경되었을 때 발생하는 이벤트 -->
                    <!-- loadImg() 함수를 호출 => 우리가 만들 함수 (매개변수는 이미지 위치를 의미) -->
                </div>
          
                
    			<div align="center">    
			            <button type="submit" class="btn btn-primary" onclick="return validate()" style="width: 80px; margin-top: 40px;">
			           	 등록</button>
		        </div>
    
                <script>


                    function validate(){
                        if($("#file1").val() == ""){
                            alert("사진을 넣어주세요!")
                        }else{
                            return true;
                        }
                    }

                    $(function(){
    
                        $("#file-area").hide();
    
                        $("#titleImg").click(function(){
                            $("#file1").click();
                        });
                    });
    
                    function loadImg(inputFile, num) {
    
          
    
                        if(inputFile.files.length == 1) { 
                            var reader = new FileReader();
    
                      
                            reader.readAsDataURL(inputFile.files[0]);
               
                            reader.onload = function(e){
                            
                                switch(num) {
                                    case 1 : $("#titleImg").attr("src", e.target.result); break;
                                }
                            };
    
                        }
                        else { 
                    
    
                            switch(num) {
                                case 1 : $("#titleImg").attr("src", null); break;
                            }
                        }
    
                    }
                </script>
    			
    
            </form>
        </div>
    
        <br><br><br><br><br>
    
       <footer>
		<%@ include file="../common/footer.jsp" %>
		</footer>
    </body>
    </html>