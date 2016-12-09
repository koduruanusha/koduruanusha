<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Balance: <br/> </h1>
<%
int bal;
Object o=session.getAttribute("k2");

bal=(int)o;
	
%>

<form action="cs">
<%= bal %>
<Br/>  <input type="hidden" name="purpose" value="ab"/>

<Br/>  <input type="submit" value="back"/>


</form>
</body>
</html>