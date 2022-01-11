<%@page import="com.br.model.Torneio"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="resources/css/global.css">
		<link rel="icon" type="image/x-icon" href="resources/images/torneios.jpg">
		<title>Novo Torneio</title>
	</head>

<body>
<%@ include file="header.jsp" %>
<h3>Novo torneio</h3>

<form name="formNovoTorneio" action="novoTorneio">
	<input placeholder="Título" type="text" name="title" required><br />
	<input placeholder="Times" type="text" name="times" required><br />
	
	<input type="submit" value="Salvar">
	
</form>
<a href="home"><button><< Voltar</button></a>
</body>
</html>