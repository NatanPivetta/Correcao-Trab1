package classes;

import javax.swing.JOptionPane;

import dao.SocioDAO;
import pessoas.*;
import locacoes.*;

import util.Menu;
public class App {
    public static void main(String[] args) throws Exception {
    	
    	int op = 0;
        while(op != 7) {
        	
        	op = Menu.montaMenu();
        	switch (op){
        	case 1:
        		Menu.cadastraLocacao();
        		System.out.println("Cadastrando Locação");
        		break;
        	case 2:
        		System.out.println("Pesquisando Locação");
        		JOptionPane.showMessageDialog(null, Menu.pesqLocacao());
        		break;
        	case 3:
        		System.out.println("Cadastrando Sócio");
        		Menu.cadastraSocio();
        		break;
        	case 4:
        		JOptionPane.showMessageDialog(null, Menu.pesquisaSocio());
        		System.out.println("Pesquisando Sócio");
        		break;
        	case 5:
        		System.out.println("Listando Locações");
        		JOptionPane.showMessageDialog(null, Menu.listaLocacao());
        		break;
        	case 6:
        		System.out.println("Listando Sócios");
        		JOptionPane.showMessageDialog(null, Menu.listaSocios());
        		break;
        	case 7:
        		System.out.println("Saindo");
        		break;
        	default:
        		System.out.println("Opção inválida");
        	}
        }
    }
}
