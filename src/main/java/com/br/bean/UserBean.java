package com.br.bean;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.dao.UserDAO;
import com.br.model.User;

public class UserBean {
	
	private User user;
	private UserDAO userDAO;
	
	public void createUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		if(userAvailable(request.getParameter("email"))) {
			user = new User();
			
			user.setName(request.getParameter("name"));
			user.setEmail(request.getParameter("email"));
			user.setPassword(request.getParameter("password"));

			userDAO = new UserDAO();
			userDAO.insert(user);

			userDAO.close();
			response.sendRedirect("login.jsp");
		} else {
			String message = "Este email já está em uso.";
			String formName = request.getParameter("name").toString();
			String formEmail = request.getParameter("email").toString();
		    request.setAttribute("message", message);
		    request.setAttribute("formName", formName);
		    request.setAttribute("formEmail", formEmail);
		    RequestDispatcher rd = 
					request.getRequestDispatcher("register.jsp");
			
			rd.forward(request, response);
		}
	}

	public boolean userAvailable(String email) {
		
		userDAO = new UserDAO();
		
		user = userDAO.getUserByEmail(email);
		
		if(user == null) {
			return true;
		} else {
			return false;
		}
	}
}
