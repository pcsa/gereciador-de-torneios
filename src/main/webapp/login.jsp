<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gerenciador de Torneios</title>
</head>
<body>
	<form action="login" method="post">
		Email: <input type="text" name="email" /> <br />
		Senha: <input type="password" name="password" /> <br />
		<input type="submit" value="Login" />
	</form>
	${message} </br>
	<a href="register.jsp"><button>Cadastrar</button></a>
	<a href="index.html"><button>Voltar</button></a>
</body>
</html>