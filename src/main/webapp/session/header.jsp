<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  if (session.getAttribute("user") == null){
    String destPage = "/index.html";
    response.sendRedirect(request.getContextPath()+destPage);
  }
%>
<div class="header" style="display: flex; width: 500px; background-color: #AA3BAA">
<p id="userName" style="flex: 1;">${sessionScope.user.getName()}</p>
<form id="logOutButton" method="POST" action="logout" style="text-align: center; flex: 1;">
	<button type="submit"> Logout </button>
</form>
</div>