<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.br.model.Torneio"%>
<%@page import="com.br.model.User"%>
<%@page import="com.br.dao.TorneioDAO"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="resources/css/global.css">
		<link rel="icon" type="image/x-icon" href="resources/images/torneios.jpg">
		<title>Inicio</title>
	</head>

	<body>
		<div class="page-container center">
			<h1>Seus Torneios</h1>
			<img class="logo" src="resources/images/torneios.jpg">
			<%@ include file="header.jsp" %>
			<%
				ArrayList<Torneio> torneios = new ArrayList<Torneio>();
				TorneioDAO daoTorneios = new TorneioDAO();
				try {
					User user = (User) session.getAttribute("user");
					torneios = daoTorneios.getTorneios(user.getId());
					
				} catch (Exception e) {
					System.out.println(e);
				}
			
			%>
			
			<div class="fundo-claro">
				<h3>Torneios criados</h3>

					<% if(torneios != null) { for(Torneio torneio : torneios) { %>
						<p>
							<span><%=torneio.getTitle()%></span>
							<a href="cartela?id=<%=torneio.getId() %>"><button class="small-button blue-button">Gerar Cartela</button></a>
							<a href="selecionaTorneio?id=<%=torneio.getId() %>"><button class="small-button blue-button">Editar</button></a>
							<a href="deletar?id=<%=torneio.getId() %>"><button class="small-button">x Deletar</button></a>
						</p>
					<% }} else { 
						%> <p>Nenhum torneio criado</p> <% }%>
			</div>

			<h3>Criar novo torneio</h3>
			<a href="criarTorneio"><button>Novo torneio</button></a>
		</div>
	</body>
</html>