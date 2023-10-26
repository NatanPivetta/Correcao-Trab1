package testes;

import java.util.Date;

import javax.swing.JOptionPane;


import pessoas.*;

import util.Menu;
public class Teste {
    public static void main(String[] args) throws Exception {
    	
    	Date dataNasc = new Date();
    	
    	Socio socio = new Socio("Natan", "Salomoni", "@natan", dataNasc);
    	System.out.println(socio.toString());
    	
    }
}
