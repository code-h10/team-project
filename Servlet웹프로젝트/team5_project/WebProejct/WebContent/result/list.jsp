<%@page import="member.vo.MemberVO" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<% ArrayList<MemberVO> list = (ArrayList<MemberVO>) request.getAttribute("list");
if(!list.isEmpty()){ %>
	
	
	<table border=1>
		<tr>
			<td>1</td>
			<td>2</td>
			<td>3</td>
			<td>4</td>
			<td>5</td>
			<td>6</td>
		</tr>
	
	<% 
		for(int i = 0; i < list.size(); i++){
			MemberVO member = list.get(i);
	%>
	
	<tr>
		<td><%=member.getSale_id() %></td>
		<td><%=member.getSaleClass() %></td>
		<td><%=member.getSaleName() %></td>
		<td><%=member.getSaleOption() %></td>
		<td><%=member.getSaleFoodinfo() %></td>
		<td><%=member.getSaleprice() %></td>
	</tr>
		
<%	
}
}else{
	out.println("등록된 정보가 없습니다.");
}
	
	%>
 	</table>
 	
 
 	
 
</body>
</html>