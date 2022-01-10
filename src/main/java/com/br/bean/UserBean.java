package com.br.bean;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.br.dao.UserDAO;
import com.br.model.Torneio;
import com.br.model.User;

public class UserBean {
	
	private User user;
	private UserDAO userDAO;
	
	public void createUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		if(userAvailable(request.getParameter("email"))) {
			user = new User();
			
			user.setName(request.getParameter("name"));
			user.setEmail(request.getParameter("email"));
			user.setPsw(request.getParameter("password"));

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

	public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name").toString();
		String email = request.getParameter("email").toString();
		String senha = request.getParameter("password").toString();
		
		User user = (User) request.getSession().getAttribute("user");
		User user_ = new User();
		
		user_.setId(user.getId());
		
		if(name != "")	user_.setName(name);
		else user_.setName(user.getName());
		
		if(email != "")	user_.setEmail(email);
		else user_.setEmail(user.getEmail());
		
		if(senha != "")	user_.setPsw(senha);
		else user_.setPsw(user.getPsw());
		
		UserDAO userDAO = new UserDAO();
		userDAO.update(user_);
		userDAO.close();
		
		response.sendRedirect("home");
	}

	public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		TorneioBean torneioBean = new TorneioBean();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		ArrayList<Torneio> torneios =  torneioBean.getTorneios(user.getId());
		
		for(Torneio torneio : torneios) {
			torneioBean.deleteTorneioById(torneio.getId());
		}
		
		UserDAO userDAO = new UserDAO();
		userDAO.delete(user);
		userDAO.close();
		
		session.invalidate();
		response.sendRedirect("index.html");
	}
}
