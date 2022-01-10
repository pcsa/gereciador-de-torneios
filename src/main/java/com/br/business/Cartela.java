package com.br.business;

import javax.servlet.http.HttpServletResponse;

import com.br.dao.TorneioDAO;
import com.br.model.Torneio;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Cartela {

	public void geraCartela(HttpServletResponse response, int id) {
		
		Document Cartela = new Document();

		try {
			
			Torneio torneio;

			TorneioDAO TorneioDAO = new TorneioDAO();
			torneio = TorneioDAO.getTorneio(id);
			TorneioDAO.fechar();
			
			// definir o tipo de conteudo da resposta

			response.setContentType("application/pdf");

			// nome do Cartela

			response.addHeader("Content-Disposition", "inline; filename=" + "Torneio-"+torneio.getTitle()+".pdf");

			// criando o Cartela

			PdfWriter.getInstance(Cartela, response.getOutputStream());

			// Abrir o documento

			Cartela.open();
			
			Paragraph titulo = new Paragraph("Torneio "+torneio.getTitle());
			titulo.setAlignment(1);

			Cartela.add(titulo);
			Cartela.add(new Paragraph(" "));

			// PdfPTable(numero de colunas)
			PdfPTable tabela = new PdfPTable(4);

			// cabecalho

			PdfPCell col1 = new PdfPCell(new Paragraph("Time"));
			PdfPCell col2 = new PdfPCell(new Paragraph("V"));
			PdfPCell col3 = new PdfPCell(new Paragraph("D"));
			PdfPCell col4 = new PdfPCell(new Paragraph("E"));

			// adicionando celulas a tabela

			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);

			// popular tabela com dados de Torneio

			
			for (String time : torneio.getTimes()) {
				tabela.addCell(new PdfPCell(new Paragraph(time)));
				tabela.addCell(new PdfPCell(new Paragraph("")));
				tabela.addCell(new PdfPCell(new Paragraph("")));
				tabela.addCell(new PdfPCell(new Paragraph("")));
			}

			Cartela.add(tabela);

			Cartela.close();

		} catch (Exception e) {
			System.out.println(e);
			Cartela.close();
		}
	}

}
