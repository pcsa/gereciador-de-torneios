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
		
		if(!userAvailable(request.getParameter("email"))) {
			System.out.println("Já existe!");
			String message = "Este email já está em uso.";
			String formName = request.getAttribute("name").toString();
			String formEmail = request.getAttribute("email").toString();
		    request.setAttribute("message", message);
		    request.setAttribute("formName", formName);
		    request.setAttribute("formEmail", formEmail);
		    RequestDispatcher rd = 
					request.getRequestDispatcher("register.jsp");
			
			rd.forward(request, response);
		} else {
			user = new User();
			
			user.setName(request.getParameter("name"));
			user.setEmail(request.getParameter("email"));
			user.setPassword(request.getParameter("password"));

			userDAO = new UserDAO();
			userDAO.insert(user);

			userDAO.close();

			response.sendRedirect("index.jsp");
		}
	}

	public boolean userAvailable(String email) {
		
		user = new User();
		userDAO = new UserDAO();
		
		user = userDAO.getUserByEmail(email);
		System.out.println(user.getName());
		if(user == null) {
			return true;
		} else {
			return false;
		}
	}
}
