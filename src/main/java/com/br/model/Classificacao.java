package com.br.model;

import java.util.Comparator;

public class Classificacao implements Comparator<Time>{

	@Override
	public int compare(Time t1, Time t2) {
		
		TimePontosCorridos time1 = (TimePontosCorridos) t1;
		TimePontosCorridos time2 = (TimePontosCorridos) t2;
		
        /*Critérios de ordenação:
        1o - + Pontos
        2o - + Vitorias
        3o - + Empates
        4o - - Derrotas
        5o - + Saldo de Gols
        6o - Nome*/
        int r;
        if (time1.getPontos() == time2.getPontos())
            if (time1.getVitorias()==time2.getVitorias())
                if (time1.getEmpates()==time2.getEmpates())
                    if (time1.getDerrotas()==time2.getDerrotas())
                        if (time1.getSaldodegols()==time2.getSaldodegols())
                            r=-time1.getNome().compareTo(time2.getNome());
                        else
                            r=time1.getSaldodegols()-time2.getSaldodegols();
                    else
                        r=time1.getDerrotas()-time2.getDerrotas();
                else
                    r=time1.getEmpates()-time2.getEmpates();
            else
                r=time1.getVitorias()-time2.getVitorias();
        else
            r=time1.getPontos()-time2.getPontos();
        return r;
    }		
		
	
}
