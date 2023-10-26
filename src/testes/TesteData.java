package testes;

import util.ValidaData;

public class TesteData {
	
	public static void main(String[] args){
		
		String data1 = "29/02/2017"; // ano bissexto n tem 29 em fevereiro
		String data2 = "10/10/2023";
		String data3 = "31/05/2023";
		String valida = "";
		boolean b;
		
		b = ValidaData.validar(data1);
		 valida  = (b == true) ? "Sim" : "Não";
		System.out.println("Data: " + data1 + "Valida: " + valida);
		

		 b = ValidaData.validar(data2);
		 valida  = (b == true) ? "Sim" : "Não";
		System.out.println("Data: " + data2 + "Valida: " + valida);
		

		b = ValidaData.validar(data3);
		 valida  = (b == true) ? "Sim" : "Não";
		System.out.println("Data: " + data3 + "Valida: " + valida);
	}
}
