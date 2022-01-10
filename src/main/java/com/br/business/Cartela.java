package com.br.business;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import com.br.dao.TorneioDAO;
import com.br.model.Torneio;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Cartela {

	public void geraCartela(HttpServletResponse response) {
		
		Document Cartela = new Document();

		try {
			// definir o tipo de conteudo da resposta

			response.setContentType("application/pdf");

			// nome do Cartela

			response.addHeader("Content-Disposition", "inline; filename=" + "Torneios.pdf");

			// criando o Cartela

			PdfWriter.getInstance(Cartela, response.getOutputStream());

			// Abrir o documento

			Cartela.open();

			Cartela.add(new Paragraph("Lista de Torneios"));
			Cartela.add(new Paragraph(" "));

			// PdfPTable(numero de colunas)
			PdfPTable tabela = new PdfPTable(3);

			// cabecalho

			PdfPCell col1 = new PdfPCell(new Paragraph("Nome"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Telefone"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Email"));

			// adicionando celulas a tabela

			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);

			// popular tabela com dados de Torneio

			ArrayList<Torneio> Torneios = new ArrayList<Torneio>();

			TorneioDAO TorneioDAO = new TorneioDAO();

			try {
				Torneios = TorneioDAO.getTorneios(1);
				TorneioDAO.fechar();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
			
			for (Torneio Torneio : Torneios) {
				System.out.println(Torneio.getTitle());
				System.out.println(Torneio.getTimes());
				tabela.addCell(
					new PdfPCell(new Paragraph(Torneio.getTitle())));
//				tabela.addCell(new Paragraph(Torneio.getTimes().toString()));
//				tabela.addCell(new Paragraph("hi"));       
//				tabela.addCell(new Paragraph("hi"));
//				tabela.addCell(new Paragraph("hi"));
				tabela.addCell(Torneio.getTitle());
			}

			Cartela.add(tabela);

			Cartela.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			Cartela.close();
		}
	}

}
