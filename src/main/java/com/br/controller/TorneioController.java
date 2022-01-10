package com.br.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.RequestContext;

import com.br.dao.TorneioDAO;
import com.br.model.Torneio;
import com.br.model.User;
import com.br.utils.ConnectionFactory;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import com.br.bean.TorneioBean;
import com.br.business.Cartela;

/**
 * Servlet implementation class TorneioController
 */
@WebServlet(urlPatterns = { "/TorneioController", "/home", 
		"/novoTorneio", "/criarTorneio", "/selecionaTorneio", 
		"/editaTorneio", "/deletar", "/cartela" })
public class TorneioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TorneioController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getServletPath();
		System.out.println(acao);

		if (acao.equals("/home")) {
			Torneios(request, response);
		} else if (acao.equals("/novoTorneio")) {
			novoTorneio(request, response);
		} else if(acao.equals("/criarTorneio")) {
			RequestDispatcher rd = request.getRequestDispatcher("session/novoTorneio.jsp");
			rd.forward(request, response);
		} else if (acao.equals("/selecionaTorneio")) {
			selecionaTorneio(request, response);
		} else if (acao.equals("/editaTorneio")) {
			editaTorneio(request, response);
		} else if (acao.equals("/deletar")) {
			deletaTorneio(request, response);
		} else if (acao.equals("/cartela")) {
			geraCartela(request, response);
		}else {
			response.sendRedirect("index.html");
		}

	}

	protected void Torneios(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		User user = (User) request.getSession().getAttribute("user");
		TorneioBean TorneioBean = new TorneioBean();
		ArrayList<Torneio> Torneios = TorneioBean.getTorneios(user.getId());
		
		//encaminhar para JSP
		
		request.setAttribute("Torneios", Torneios);
		
		//despachante vai levar os dados para uma jsp de maneira dinamica
		
		RequestDispatcher rd = request.getRequestDispatcher("session/user.jsp");
		
		rd.forward(request, response);
			

	}

	protected void novoTorneio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		TorneioBean TorneioBean = new TorneioBean();
		TorneioBean.novoTorneio(request, response);

	}
	
	protected void selecionaTorneio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		TorneioBean TorneioBean = new TorneioBean();
		Torneio Torneio = new Torneio();
		Torneio = TorneioBean.selecionaTorneio(id);
		
		
		System.out.println(Torneio.getTitle());
		
		request.setAttribute("Torneio", Torneio);
		
		RequestDispatcher rd = request.getRequestDispatcher("session/editarTorneio.jsp");
		
		rd.forward(request, response);
		
	} 
	
	protected void editaTorneio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		TorneioBean TorneioBean = new TorneioBean();
		TorneioBean.editaTorneio(request, response);
		
	}
	
	protected void deletaTorneio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		TorneioBean TorneioBean = new TorneioBean();
		TorneioBean.deletaTorneio(request, response);

	}
	
	//gerar tabela
	//link <https://github.com/itext/itextpdf/releases/tag/5.5.13.2>
	protected void geraCartela(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		TorneioBean bean = new TorneioBean();
		int id = Integer.parseInt(request.getParameter("id"));
		if(user == null) {
			response.sendRedirect("index.html");
		} else if(!bean.checkUserByIdTorneio(user.getId(),id) ) {
			RequestDispatcher rd = request.getRequestDispatcher("session/user.jsp");
			rd.forward(request, response);
		} else {
			Cartela Cartela = new Cartela();
			Cartela.geraCartela(response,id);
		}
	}
	

}
