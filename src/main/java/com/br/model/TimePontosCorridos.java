package com.br.model;

public class TimePontosCorridos extends Time{

	private int pontos;
    private int saldodegols;
    private int vitorias;
    private int empates;
    private int derrotas;
    
    public TimePontosCorridos(String nome) {
		this.nome = nome;
		pontos = 0;
		saldodegols = 0;
		vitorias = 0;
		empates = 0;
		derrotas = 0;		
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public int getSaldodegols() {
		return saldodegols;
	}

	public void setSaldodegols(int saldodegols) {
		this.saldodegols = saldodegols;
	}

	public int getVitorias() {
		return vitorias;
	}

	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}

	public int getEmpates() {
		return empates;
	}

	public void setEmpates(int empates) {
		this.empates = empates;
	}

	public int getDerrotas() {
		return derrotas;
	}

	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}
 	
}
