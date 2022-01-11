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
@WebServlet(urlPatterns = {"/login", "/logout", "/register", "/editarConta", "/updateUser", "/delete"})
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String action = request.getServletPath();
    	if(action.equals("/editarConta")) {
			RequestDispatcher rd = request.getRequestDispatcher("session/editarConta.jsp");
			rd.forward(request, response);
		} else if(action.equals("/delete")) {
			delete(request, response);
		}
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		if(action.equals("/login")) {
			login(request, response);
		} else if(action.equals("/logout")) {
			logout(request, response);
		} else if(action.equals("/register")) {
			register(request, response);
		} else if(action.equals("/updateUser")) {
			update(request, response);
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
                destPage = "session/home.jsp";
            } else {
                String message = "E-mail ou senha inválidos.";
                request.setAttribute("message", message);
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
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean userBean = new UserBean();
		userBean.update(request, response);
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean userBean = new UserBean();
		userBean.delete(request, response);
	}
}
