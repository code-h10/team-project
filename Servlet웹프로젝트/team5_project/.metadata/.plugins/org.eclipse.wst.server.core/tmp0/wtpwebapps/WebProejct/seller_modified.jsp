<%@page import="member.vo.MemberVO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 	<link rel="stylesheet" href="./RESOUCE/css/bootstrap.min.css">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  	<script src="./RESOUCE/js/bootstrap.min.js"></script>
  	<link rel="stylesheet" type="text/css" href="./RESOUCE/css/indexjsp.css"></link>
	<title>회원정보수정 페이지</title>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
		<a class="navbar-brand"  href="index.jsp">Home</a>
		<p class="navbar-text">현재위치가 비활성화 입니다.</p>
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
				<li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> 로그인</a></li>
				<li><a href="user_signup.jsp"><span class="glyphicon glyphicon-log-in"></span> 회원가입</a></li>
		<% } %>
      </ul>
    </div>
  </div>
</nav>
  
  
  
	
  
 <div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-3 col-md-2 sidenav">
    	<ul class="nav nav-sidenav">
    		<li class="active"><a data-toggle="tab" href="#home">회원정보 수정</a></li>
    		<li><a data-toggle="tab" href="#menu1">판매자정보 수정</a></li>
    		<li><a data-toggle="tab" href="#menu2">판매 정보</a></li>
    		<li><a data-toggle="tab" href="#menu3">판매정보 조회</a></li>
    		<li><a data-toggle="tab" href="#menu4">판매 정산</a></li>
  		 </ul>
    </div>
    
   <div class="tab-content">   
    <div id="home" class="col-md-4 col-md-offset-2 text-left tab-pane fade in active"> 
      <div class="page-header text-center">
          <h1>회원정보수정</h1>
        </div>
     <% if(member != null){%>
      <form class="form-signin" method="post" action="memberUserUpdate.do" role="form">
            <div class="form-group">
              <label for="Email">이메일 주소</label>
              <input type="text" name="mail" class="form-control" placeholder="이메일 주소" value="${member.mail}" required autofocus>
            </div>
            <div class="form-group">
              <label for="Password">비밀번호</label>
              <input type="password" name="passwd" class="form-control" placeholder="비밀번호" value="${member.passwd}" required>
            </div>
            <div class="form-group">
              <label for="Name">이름</label>
              <input type="text" name="name" class="form-control" placeholder="이름" value="${member.name}" required autofocus>
            </div>
            
            <div class="form-group">
              <label for="Address">주소</label>
              <input type="text" name="address" class="form-control" placeholder="주소" value="${member.address}" required autofocus>
            </div>
           
           <div class="form-group">
              <label for="Phone">전화번호</label>
              <input type="text" name="phone" class="form-control" placeholder="휴대폰입력 ('-'제외)" value="${member.phone}" required autofocus>
              <input type="hidden" name="division" class="form-control" value="${member.division}" >
              <input type="hidden" name="user_id" class="form-control" value="${member.user_id}" >
            </div>
    
            <div class="form-group text-center">
              <button class="btn btn-lg btn-primary btn-block" type="submit">수정</button>
            </div>
          </form>
      <% } %>
    </div>
    
    <div id="menu1" class="col-md-4 col-md-offset-2 text-left tab-pane fade"> 
      <div class="page-header text-center">
       <h1>판매자정보 수정</h1>
     </div>
     <% if(member != null){%>
     	<form class="form-signin" method="post" action="memberSellerUpdate.do" role="form">
            <div class="form-group">
              <label for="Name">식당 이름</label>
              <input type="text" name="sellername" class="form-control" placeholder="식당 이름" value="${member.mail}" required autofocus>
            </div>
            <div class="form-group">
              <label for="Address">식당 주소</label>
              <input type="text" name="selleraddress" class="form-control" placeholder="식당 주소" value="${member.passwd}" required>
            </div>
            <div class="form-group">
              <label for="Hours">영업시간</label>
              <input type="text" name="addresshours" class="form-control" placeholder="영업시간" value="${member.address}" required autofocus>
            </div>
            
            <div class="form-group">
              <label for="Phone">식당 전화번호</label>
              <input type="text" name="sellerphone" class="form-control" placeholder="식당번호('-'제외)" value="${member.phone}" required autofocus>
              <input type="hidden" name="user_id" class="form-control" value="${member.user_id}" >
            </div>
    
            <div class="form-group text-center">
              <button class="btn btn-lg btn-primary btn-block" type="submit">수정</button>
            </div>
          </form>
          <% } %>
    </div>
    
    <div id="menu2" class="text-center tab-pane fade"> 
      	<div class="page-header text-left">
               <input class="btn btn-lg btn-primary" type="button" value="생성" onClick="self.location='sale_create.jsp';"/>
               <input class="btn btn-lg btn-primary" type="button" value="삭제" onClick="self.location='seller_login.jsp';"/>
     	</div>
     		<h1>판매정보가 없습니다. 생성하세요.!</h1>
     </div>
    
    </div>
  </div>
</div>
</body>
</html>