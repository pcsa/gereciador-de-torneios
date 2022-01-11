<%@page import="com.br.model.Torneio"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="resources/css/global.css">
		<link rel="icon" type="image/x-icon" href="resources/images/torneios.jpg">
		<title>Editar Torneio</title>
	</head>

<body>
<%@ include file="header.jsp" %>
<%
Torneio torneio = 
(Torneio) request.getAttribute("Torneio");
%>

<h1>Editar torneio</h1>

<form name="formEditTorneio" action="editaTorneio">
	<input type="hidden" name="id" value="<%=torneio.getId() %>">
	<input placeholder="Title" type="text" name="title" value="<%=torneio.getTitle() %>" required><br />
	<input placeholder="Times" type="text" name="times" value="<%=torneio.getTimesSingle() %>" required><br />
	
	<input type="submit" value="Editar Torneio">
	
</form>
<a href="home"><button><< Voltar</button></a>
</body>
</html>