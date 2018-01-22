<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
index파일입니다<br />
뭘하던 저만 보일겁니다.<br/>
<%="니가 보낸 test의 값은"+request.getParameter("test")+"맞지?" %> <br />
니가 보낸 test의 값은 ${param.test} 맞지?<br />

</body>
</html>