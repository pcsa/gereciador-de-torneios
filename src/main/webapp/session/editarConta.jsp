<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
</body>
</html>