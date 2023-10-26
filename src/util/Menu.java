package util;

import dao.SocioDAO;
import locacoes.Locacao;
import pessoas.Pessoa;
import pessoas.Socio;

import java.awt.*;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TreeSet;

import javax.swing.*;

public class Menu {

	private static ArrayList<Socio> socios = new ArrayList<>();
	private static ArrayList<Locacao> locacoes = new ArrayList<>();

	public static int montaMenu() {
		String str = "";
		for (OpcoesMenu opcaoMenu : OpcoesMenu.values())
			str += opcaoMenu.getOpcao() + "\n";
		return Integer.parseInt(JOptionPane.showInputDialog(str));
	}

	// opcao 1 do menu
	public static void cadastraLocacao() throws SQLException, ParseException {
		Locacao loc = Panel.cadastraLocacao();
		locacoes.add(loc);
		
		for (Locacao locacao : locacoes) {
			System.out.println("Loc: " + loc.getTitulo() + " " + loc.getValor());
		}

	}

	// opcao 2 do menu
	public static String pesqLocacao() {
		String s = "";
		double valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe o Valor da Locação"));
		if(locacoes.isEmpty()) {
			s += "Locacões não Encontradas";
			return s;
		}
		for (Locacao locacao : locacoes) {
			if(locacao.getValor() == valor) {
				s += locacao.toString() + "\n";
				}
		}
		return s;

	}

	// opcao 3 do menu
	public static boolean cadastraSocio() throws SQLException {
		Socio socio = Panel.cadastraSocio();
		socios.add(socio);
		if (socio != null) {

			System.out.println("Sócio cadastrado");
			Pessoa.setTotal();
			System.out.println("Total de pessoas: " + Pessoa.getTotal());
		}

		else {
			System.out.println("Sócio não cadastrado");

		}

		return false;

	}

	// opcao 4 do menu
	public static String pesquisaSocio() throws SQLException {
		Socio socio = Panel.pesquisaSocio();
		String s = "";
		if (socio != null) {

			s = "Sócio Encontrado: \n";
			s += socio.toString();
		} else
			s += "Socio nao encontrado";

		return s;
	}

	// opcao 5 do menu
	public static String listaLocacao() {
		String s = "Locacoes: \n";
		for (Locacao locacao : locacoes) {
			s += locacao.toString();
		}
		return s;
	}

	// opcao 6 do menu
	public static String listaSocios() {
		String s = "Socios: \n";
		for (Socio socio : socios) {
			s += socio.toString();
		}
		return s;
	}
	
	public static void addSocio (Socio socio) {
		socios.add(socio);
	}
}