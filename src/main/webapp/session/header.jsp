<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
  if (session.getAttribute("user") == null){
    String destPage = "/index.jsp";
    response.sendRedirect(request.getContextPath()+destPage);
  }
%>
<div class="header" style="display: flex; width: 500px; background-color: #AA3BAA">
<p id="userName" style="flex: 1;">${sessionScope.user.getName()}</p>
<form id="logOutButton" method="POST" action="logout" style="text-align: center; flex: 1;">
	<button type="submit"> Logout </button>
</form>
</div>