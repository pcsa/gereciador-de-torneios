<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  if (session.getAttribute("user") == null){
    String destPage = "/index.html";
    response.sendRedirect(request.getContextPath()+destPage);
  }
%>

<div class="header">
  <p class="vertical-center" id="userName" style="flex: 1;"><b>Sua conta: </b>${sessionScope.user.getName()}</p>
  <form id="logOutButton" method="POST" action="logout" style="text-align: center; flex: 1;">
    <button type="submit"> Logout </button>
  </form>
    <a href="editarConta"><button> Editar conta </button></a>
</div>