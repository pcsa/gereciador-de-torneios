<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro</title>
</head>
<body>
	<form action="register" method="post">
		Nome: <input type="text" name="name" value="${formName}" placeHolder="Nome" /> <br />
		Email: <input type="text" name="email" value="${formEmail}" placeHolder="Email" /> ${message} <br />
		Senha: <input type="password" name="password" placeHolder="Senha"/> <br />
		Confirmar senha: <input type="password" name="password" placeHolder="Repita a senha"/> <br />
		<input type="submit" value="Cadastrar" />
	</form>
	<a href="index.html"><button>Voltar</button></a>
</body>
</html>