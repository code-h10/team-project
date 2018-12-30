<%@page import="member.vo.MemberVO" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>먹을꺼 내놔 홈페이지</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="./RESOUCE/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="./RESOUCE/js/bootstrap.min.js"></script>
  <link rel="stylesheet" type="text/css" href="./RESOUCE/css/indexjsp.css"></link>
</head>
<body>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
		<a class="navbar-brand"  href="index.jsp">Home</a>
		<p class="navbar-text" id="demo">현재위치가 비활성화 입니다.</p>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
      	<%
			MemberVO member  = (MemberVO)session.getAttribute("member");
			if(member != null){
				
		%>
				<li><a href="login.jsp"> ${member.name} 님 로그인중</a></li>
				<li><a href="logout.jsp"><span class="glyphicon glyphicon-log-in"></span>  로그아웃</a></li>
			<% if(member.getDivision().equals("0")){%>
				<li><a href="user_modified.jsp"><span class="glyphicon glyphicon-log-in"></span>  회원정보수정</a></li>
			<% } else {%>
				<li><a href="seller_modified.jsp"><span class="glyphicon glyphicon-log-in"></span>  회원정보수정</a></li>
			<% } %>
		<%}else{ // 세션 로그인 안했을때 안보여줌%>
				<li><a href="memberSaleList.do"><span class="glyphicon glyphicon-log-in"></span> rr</a></li>
				<li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> 로그인</a></li>
				<li><a href="user_signup.jsp"><span class="glyphicon glyphicon-log-in"></span> 회원가입</a></li>
		<% } %>
      </ul>
    </div>
  </div>
</nav>
  
  
<div class="container-fluid text-center">    
  <div class="row content bg-1">
      <img src="./IMAGE/food.jpg" class="img-circle" alt="Bird" width="200" height="200">
      <h1 class="margin">먹을꺼 내놔</h1>
      
		<form class="navbar-form navbar-center" role="search">
        	<div class="form-group input-group">
          		<input type="text" class="form-control" placeholder="음식/지역/식당..">
          		<span class="input-group-btn">
					<button class="btn btn-default" type="button"><span class="glyphicon glyphicon-search"></span></button>
          		</span>        
        	</div>
      	</form>
  </div>
  
  <div class="row">
  	<nav class="navbar navbar-default" role="navigation">
  		<div class="navbar-collapse collapse">
    		<ul class="nav navbar-nav navbar-center">
        		<li><a href="#">치킨</a></li>
        		<li><a href="#">중식</a></li>
      			<li><a href="#">피자</a></li>
      			<li><a href="#">족발/보쌈</a></li>
      			<li><a href="#">야식</a></li>
				<li><a href="#">찜/탕</a></li>
				<li><a href="#">한식/분식</a></li>
				<li><a href="#">돈가스/일식/회</a></li>
				<li><a href="#">도시락/죽/패스트푸드</a></li>
    		</ul>
  		</div>
	</nav>
  </div>
  	
 <div class="row content bg-2">
 
 
	<div class="col-sm-4 col-sm-2">
    <div class="thumbnail">
      <img src="./IMAGE/food.jpg" alt="..." class="img-thumbnail" width="200" height="200">
      <div class="caption">
        <h3>음식1</h3>
        <p>...</p>
      </div>
    </div>
  </div>
  
  <div class="col-sm-4 col-sm-2">
    <div class="thumbnail">
      <img src="./IMAGE/food.jpg" alt="..." class="img-thumbnail" width="200" height="200">
      <div class="caption">
        <h3>음식1</h3>
        <p>...</p>
      </div>
    </div>
  </div>
  
  <div class="col-sm-4 col-sm-2">
    <div class="thumbnail">
      <img src="./IMAGE/food.jpg" alt="..." class="img-thumbnail" width="200" height="200">
      <div class="caption">
        <h3>음식1</h3>
        <p>...</p>
      </div>
    </div>
  </div>
  
  <div class="col-sm-4 col-sm-2">
    <div class="thumbnail">
      <img src="./IMAGE/food.jpg" alt="..." class="img-thumbnail" width="200" height="200">
      <div class="caption">
        <h3>음식1</h3>
        <p>...</p>
      </div>
    </div>
  </div>
  
  
 </div>
</div>
<footer class="container-fluid text-center">
	<p>야간 5조 : 황일영,김태영 <a href="https://www.google.com">ilyoung6016@gmail.com</a></p>
</footer>
</body>
</html>
    