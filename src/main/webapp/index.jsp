<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
</body>
</html>