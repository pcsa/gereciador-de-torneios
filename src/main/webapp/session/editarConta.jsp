<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="resources/css/global.css">
		<link rel="icon" type="image/x-icon" href="resources/images/torneios.jpg">
		<title>Editar Conta</title>
	</head>

	<body>
		<form action="updateUser" method="post">
			Nome: <input type="text" name="name" value="${sessionScope.user.getName()}" placeHolder="Nome" /> <br />
			Email: <input type="text" name="email" value="${sessionScope.user.getEmail()}" placeHolder="Email" /> ${message} <br />
			Nova senha: <input type="password" name="password" placeHolder="Senha"/> <br />
			Confirmar senha: <input type="password" name="password_confirm" placeHolder="Repita a senha"/> <br />
			<input type="submit" value="Salvar" />
		</form>
	<a href="delete"><button> Excluir conta </button></a>
	<a href="home"><button><< Voltar</button></a>
	</body>
</html>