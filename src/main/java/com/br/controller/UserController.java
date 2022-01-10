package com.br.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.br.bean.UserBean;
import com.br.dao.UserDAO;
import com.br.model.User;

/**
 * Servlet implementation class authController
 */
@WebServlet(urlPatterns = {"/login", "/logout", "/register"})
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		
		if(action.equals("/login")) {
			login(request, response);
		} else if(action.equals("/logout")) {
			logout(request, response);
		} else if(action.equals("/register")) {
			register(request, response);
		}
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
        String password = request.getParameter("password");
         
        UserDAO userDao = new UserDAO();
         
        try {
            User user = userDao.checkLogin(email, password);
            String destPage = "login.jsp";
             
            if (user != null) {
                session.setAttribute("user", user);
                destPage = "session/user.jsp";
                System.out.println("Login sucess");
            } else {
                String message = "Email ou password invalidos";
                request.setAttribute("message", message);
                System.out.println("Login fail");
            }
             
            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);
             
        } catch (SQLException ex) {
        	System.out.println("Login exp");
            throw new ServletException(ex);
        }
	}
	
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("index.html");
	}
	
	protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		UserBean userBean = new UserBean();
		userBean.createUser(request, response);
	}
}
