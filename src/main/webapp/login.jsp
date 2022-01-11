<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="resources/css/global.css">
		<link rel="icon" type="image/x-icon" href="resources/images/torneios.jpg">
		<title>Gerenciador de Torneios</title>
	</head>

	<body>
		<div class="page-container center">
			<h1>Login:</h1>
			<img class="logo" src="resources/images/torneios.jpg">
			<form action="login" method="post">
				<input type="text" name="email" placeholder="seu e-mail"/> <br />
				<input type="password" name="password" placeholder="sua senha"/> <br />
				<input type="submit" class="blue-button button" value="Login >>" />
			</form>
			<p class="error">${message}</p> </br>
			<a href="register.jsp"><button>Cadastrar</button></a>
			<a href="index.html"><button><< Voltar</button></a>
		</div>
	</body>
</html>