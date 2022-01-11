<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="resources/css/global.css">
		<link rel="icon" type="image/x-icon" href="resources/images/torneios.jpg">
		<title>Cadastro</title>
	</head>

	<body>
		<div class="page-container center">
			<h1>Preencha com seus dados:</h1>
			<img class="logo" src="resources/images/torneios.jpg">
			<form action="register" method="post">
				<input type="text" name="name" value="${formName}" placeHolder="seu nome" /> <br />
				<input type="text" name="email" value="${formEmail}" placeHolder="seu email" /> ${message} <br />
				<input type="password" name="password" placeHolder="senha"/> <br />
				<input type="password" name="password_confirm" placeHolder="repita a senha"/> <br />
				<input type="submit" class="blue-button button" value="Cadastrar" />
			</form>
			<a href="index.html"><button><< Voltar</button></a>
		</div>
	</body>
</html>