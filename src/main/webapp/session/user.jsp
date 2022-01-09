<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.br.model.Torneio"%>
<%@page import="com.br.dao.TorneioDAO"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Página do usuário</title>
</head>
<body>
<%@ include file="header.jsp" %>
<%
	ArrayList<Torneio> torneios = new ArrayList<Torneio>();
	TorneioDAO daoTorneios = new TorneioDAO();
	try {
// 		torneios = (ArrayList<Torneio>) request.getAttribute("torneios");
		torneios = daoTorneios.getTorneios();
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e);
	}
 
%>

<h3>Torneios criados</h3>

	<% if(torneios != null) { for(Torneio torneio : torneios) { %>
		<p>
			<span><p><%=torneio.getTitle()%></p></span>
			<a href="cartela"><button>Gerar Cartela</button></a>
			<a href="selecionaTorneio?id=<%=torneio.getId() %>"><button>Editar</button></a>
			<a href="deletar?id=<%=torneio.getId() %>"><button>Deletar</button></a>
		</p>
	<% }} else { 
		%> <p>Nenhum torneio criado</p> <% }%>

<h3>Criar novo torneio</h3>
<a href="novoTorneio.jsp"><button>Novo torneio</button></a>

</body>
</html>