package com.br.model;

import java.util.ArrayList;

public abstract class Torneio {
	
	protected ArrayList<Time> times;
	
	public Torneio() {
		times = new ArrayList<Time>();
	}
	
	public ArrayList<Time> getTimes() {
        return times;
    }
	
	public abstract void AtribuirResultado(Object dados);
    public abstract void CadastrarEquipe(String nome);
    public abstract Object[][] ToArray();
	
}
