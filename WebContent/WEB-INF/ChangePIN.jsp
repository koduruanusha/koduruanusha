<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Change PIN <br/> </h1>

<form action="cs">

<Br/> old PIN *: <input type="text" name="oldpin"/>

<Br/> New PIN *: <input type="text" name="newpin"/>

<Br/>  <input type="hidden" name="purpose" value="acp"/>
<input type="submit" value="Change PIN"/>

</form>
</body>
</html>