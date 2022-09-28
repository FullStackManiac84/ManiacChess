<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Perform.Player,Perform.Color" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get ready for CHESSSSSS</title>
</head>
<body>
<%
	Player p1 = new Player(Color.WHITE, "Pat");
	Player p2 = new Player(Color.BLACK, "Frank");
	//request.setAttribute("player", p1);
	request.getSession().setAttribute("player1", p1);
	request.getSession().setAttribute("player2", p2);
	request.getRequestDispatcher("add.jsp").forward(request, response);
%>
</body>
</html>