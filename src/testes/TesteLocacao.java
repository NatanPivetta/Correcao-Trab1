package testes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;


import pessoas.*;
import locacoes.*;

import util.Menu;
public class TesteLocacao {
	private static List<Locacao> locacoes = new ArrayList<>();
	
    public static void main(String[] args) throws Exception {
    	
    	
    	
    	Locacao locacao1 = new Locacao();
    	locacao1.setTitulo("Praia");
    	locacao1.setValor(250);
    	
    	Locacao locacao2 = new Locacao();
    	locacao2.setTitulo("Gramado");
    	locacao2.setValor(110);

    	Locacao locacao3 = new Locacao();
    	locacao3.setTitulo("Serra");
    	locacao3.setValor(550);
    	
    	locacoes.add(locacao3);

    	locacoes.add(locacao2);

    	locacoes.add(locacao1);
    	
    	Collections.sort(locacoes);
    	
    	String s = "Locacoes: \n";
		for (Locacao locacao : locacoes) {
			s += "Descricao: " + locacao.getTitulo() + " ";
			s += "Valor: " + locacao.getValor()+ "\n\n";
			
		}
		
		System.out.println(s);
    }
}
