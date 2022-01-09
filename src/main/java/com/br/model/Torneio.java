package com.br.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Torneio {
	
	private int id;
	private String title;
	protected ArrayList<String> times;
	
	public Torneio() {
		times = new ArrayList<String>();
	}
	
	public ArrayList<String> getTimes() {
        return times;
    }
	
	public void setTimes(ArrayList<String> times) {
		this.times = times;
	}
	
	public void setTimes(String times) {
		String[] newTimes = times.split("\\s+");
		ArrayList<String> arrList = new ArrayList<String>(Arrays.asList(newTimes));
		this.times = arrList;
	}

//	public abstract void AtribuirResultado(Object dados);
//    public abstract void CadastrarEquipe(String nome);
//    public abstract Object[][] ToArray();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
