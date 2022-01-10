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
		ArrayList<String> times_ = new ArrayList<String>();
		for(String time : times) {
			times_.add(time);
		}
        return times_;
    }
	
	public String getTimesSingle(){
		String times_ = "";
		for(String time : times) {
			times_ += time+" ";
		}
		times_.charAt(times_.length()-1);
        return times_;
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
