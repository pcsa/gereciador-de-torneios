package com.br.bean;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.br.dao.TorneioDAO;
import com.br.model.Torneio;
import com.br.model.User;

public class TorneioBean {

	private Torneio Torneio;
	private ArrayList<Torneio> Torneios;
	private TorneioDAO TorneioDAO;

	public void deletaTorneio(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Torneio = new Torneio();

		int id = Integer.parseInt(request.getParameter("id"));

		Torneio.setId(id);

		TorneioDAO = new TorneioDAO();

		TorneioDAO.remove(Torneio);

		TorneioDAO.fechar();

		response.sendRedirect("home");
	}
	
	public void deleteTorneioById(int id) {
		Torneio = new Torneio();

		Torneio.setId(id);

		TorneioDAO = new TorneioDAO();

		TorneioDAO.remove(Torneio);

		TorneioDAO.fechar();
	}

	public Torneio selecionaTorneio(int id) {

		Torneio = new Torneio();

		TorneioDAO = new TorneioDAO();

		Torneio = TorneioDAO.getTorneio(id);

		TorneioDAO.fechar();

		return Torneio;
	}

	public void editaTorneio(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Torneio = new Torneio();

		int id = Integer.parseInt(request.getParameter("id"));
		Torneio.setId(id);
		Torneio.setTitle(request.getParameter("title"));
		Torneio.setTimes(request.getParameter("times"));

		TorneioDAO = new TorneioDAO();

		TorneioDAO.atualiza(Torneio);
		TorneioDAO.fechar();

		response.sendRedirect("home");
	}

	public void novoTorneio(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("user");
		
		if(existeTorneio(request.getParameter("title"), user.getId())) {
			System.out.println("Torneio já existe!");
			response.sendRedirect("home");
		} else {
			Torneio = new Torneio();

			// 1. recuperando parametros do formulario
			Torneio.setTitle(request.getParameter("title"));
			Torneio.setTimes(request.getParameter("times"));

			TorneioDAO = new TorneioDAO();
			TorneioDAO.adiciona(Torneio, user.getId());

			System.out.println(user.getId());
			// System.out.println("Torneio foi gravado!");

			TorneioDAO.fechar();

			response.sendRedirect("home");
		}

		
	}

	public ArrayList<Torneio> getTorneios(int uid) {

		TorneioDAO = new TorneioDAO();

		this.Torneios = TorneioDAO.getTorneios(uid);

		TorneioDAO.fechar();
		
		return Torneios;

	}
	
	public boolean existeTorneio(String title,  int uid) {
		
		Torneio = new Torneio();
		TorneioDAO = new TorneioDAO();
		
		Torneio = TorneioDAO.getTorneioPeloTitle(title, uid);
		
		if(Torneio != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean checkUserByIdTorneio(int uid, int tid) {
		TorneioDAO = new TorneioDAO();
		return TorneioDAO.checkUserPerm(uid,tid);
	}
}