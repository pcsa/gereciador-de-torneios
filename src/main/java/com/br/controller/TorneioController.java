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
		"/novoTorneio", "/selecionaTorneio", 
		"/editaTorneio", "/deletar", "/cartela" })
public class TorneioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TorneioController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String acao = request.getServletPath();
		System.out.println(acao);

		if (acao.equals("/home")) {
			Torneios(request, response);
		} else if (acao.equals("/novoTorneio")) {
			novoTorneio(request, response);
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

		// ConnectionFactory cf = new ConnectionFactory();
		// cf.testeConnection();
	}

	protected void Torneios(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//response.sendRedirect("Torneio.jsp");
		/*
		TorneioDAO TorneioDAO = new TorneioDAO();
		
		ArrayList<Torneio> Torneios = 
				TorneioDAO.getTorneios();
		
		TorneioDAO.fechar();
		*/
		
		TorneioBean TorneioBean = new TorneioBean();
		ArrayList<Torneio> Torneios = TorneioBean.getTorneios();
		
		//encaminhar para JSP
		
		request.setAttribute("Torneios", Torneios);
		
		//despachante vai levar os dados para uma jsp de maneira dinamica
		
		RequestDispatcher rd = 
//				request.getRequestDispatcher("Torneio.jsp");
				request.getRequestDispatcher("session/user.jsp");
		
		rd.forward(request, response);
			

	}

	protected void novoTorneio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/*
		Torneio Torneio = new Torneio();
		
		//1. recuperando parametros do formulario
		Torneio.setNome(request.getParameter("nome"));
		Torneio.setTelefone(request.getParameter("telefone"));
		Torneio.setEmail(request.getParameter("email"));
		
		TorneioDAO TorneioDAO = new TorneioDAO();
		
		TorneioDAO.adiciona(Torneio);
		
		System.out.println("Torneio foi gravado!");
		
		TorneioDAO.fechar();
		response.sendRedirect("home");
		*/
		
		TorneioBean TorneioBean = new TorneioBean();
		TorneioBean.novoTorneio(request, response);

	}
	
	protected void selecionaTorneio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		/*
		Torneio Torneio = new Torneio();
		
		TorneioDAO TorneioDAO = new TorneioDAO();
		
		Torneio = TorneioDAO.getTorneio(id);
		
		TorneioDAO.fechar();
		*/
		
		TorneioBean TorneioBean = new TorneioBean();
		Torneio Torneio = new Torneio();
		Torneio = TorneioBean.selecionaTorneio(id);
		
		
		System.out.println(Torneio.getTitle());
		
		request.setAttribute("Torneio", Torneio);
		
		RequestDispatcher rd = request.getRequestDispatcher("editarTorneio.jsp");
		
		rd.forward(request, response);
		
	} 
	
	protected void editaTorneio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		Torneio Torneio = new Torneio();
		
		int id = Integer.parseInt(request.getParameter("id"));
		Torneio.setId(id);
		
		Torneio.setNome(request.getParameter("nome"));
		Torneio.setTelefone(request.getParameter("telefone"));
		Torneio.setEmail(request.getParameter("email"));
		
		TorneioDAO TorneioDAO = new TorneioDAO();
		
		TorneioDAO.atualiza(Torneio);
		TorneioDAO.fechar();
		
		response.sendRedirect("home");
		*/
		
		TorneioBean TorneioBean = new TorneioBean();
		TorneioBean.editaTorneio(request, response);
		
	}
	
	protected void deletaTorneio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/*
		Torneio Torneio = new Torneio();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Torneio.setId(id);
		
		TorneioDAO TorneioDAO = new TorneioDAO();
		
		TorneioDAO.remove(Torneio);
		
		TorneioDAO.fechar();
		
		response.sendRedirect("home");
		*/
		
		TorneioBean TorneioBean = new TorneioBean();
		TorneioBean.deletaTorneio(request, response);
		
		
		
	}
	
	//gerar relatório
	//link <https://github.com/itext/itextpdf/releases/tag/5.5.13.2>
	protected void geraCartela(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		Cartela Cartela = new Cartela();
		Cartela.geraCartela(response);
		
		
	}
	

}
