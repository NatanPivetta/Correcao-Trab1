package util;

import dao.SocioDAO;
import locacoes.Locacao;
import pessoas.*;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Panel {

	public Panel() {
	}

	public static Socio cadastraSocio() throws SQLException {
		Socio socio = null;
		boolean dataValida;
		String dataNasc = "";
		JTextField Jnome = new JTextField(30);
		Jnome.setPreferredSize(new Dimension(50, 20));
		JTextField Jemail = new JTextField(30);
		Jemail.setPreferredSize(new Dimension(50, 20));
		JTextField Jendereco = new JTextField(30);
		Jendereco.setPreferredSize(new Dimension(50, 20));
		JTextField Jdia = new JTextField(2);
		JTextField Jmes = new JTextField(2);
		JTextField Jano = new JTextField(4);
		JPanel cadastroSocio = new JPanel();

		cadastroSocio.setPreferredSize(new Dimension(350, 300));

		cadastroSocio.add(new JLabel("Nome:\n"));
		cadastroSocio.add(Jnome);
		cadastroSocio.add(new JLabel("E-mail:\n"));
		cadastroSocio.add(Jemail);
		cadastroSocio.add(new JLabel("Endereço:\n"));
		cadastroSocio.add(Jendereco);
		cadastroSocio.add(new JLabel("Data de Nascimento:\n"));
		cadastroSocio.add(Jdia);
		cadastroSocio.add(Jmes);
		cadastroSocio.add(Jano);

		int panel = JOptionPane.showConfirmDialog(null, cadastroSocio, "Cadastro Sócio", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);

		String nome = Jnome.getText();
		String email = Jemail.getText();
		String endereco = Jendereco.getText();
		dataNasc += Jdia.getText() + "/" + Jmes.getText() + "/" + Jano.getText();
		
		if(!ValidaData.validar(dataNasc)){
			JOptionPane.showMessageDialog(cadastroSocio, "Data Inválida \n");
		}else { 
		
			Date df = new Date(dataNasc);
			Timestamp nascimento = new Timestamp(df.getTime());
			
			socio = new Socio(nome, endereco, email, nascimento);
			SocioDAO.inserirSocio(socio);
			
		}
		return socio;
		
	}

	public static Locacao cadastraLocacao() throws SQLException, ParseException {
		Locacao loc = null;
		Date dataRetirada;
		Date dataDevolucao;
		Date dataDependente;
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat simpleDf = new SimpleDateFormat(pattern);
		double valor;
		String titulo;
		Situacao situacao;
		Socio socio;

		// data de retirada
		JTextField JdiaRet = new JTextField(2);
		JTextField JmesRet = new JTextField(2);
		JTextField JanoRet = new JTextField(4);

		// data de devolução

		JTextField JdiaDev = new JTextField(2);
		JTextField JmesDev = new JTextField(2);
		JTextField JanoDev = new JTextField(4);

		// data de nascimento do depentende
		JTextField JdiaDep = new JTextField(2);
		JTextField JmesDep = new JTextField(2);
		JTextField JanoDep = new JTextField(4);

		
		JTextField Jvalor = new JTextField(30);
		Jvalor.setPreferredSize(new Dimension(50, 20));
		JTextField Jdescricao = new JTextField(30);
		Jdescricao.setPreferredSize(new Dimension(50, 20));
		JTextField Jsocio = new JTextField(30);
		Jsocio.setPreferredSize(new Dimension(50, 20));
		JTextField Jdependente = new JTextField(30);
		Jdependente.setPreferredSize(new Dimension(50, 20));

		JPanel cadastroLocacao = new JPanel();

		cadastroLocacao.setPreferredSize(new Dimension(350, 300));

		cadastroLocacao.add(new JLabel("Data de Retirada:\n"));
		cadastroLocacao.add(JdiaRet);
		cadastroLocacao.add(JmesRet);
		cadastroLocacao.add(JanoRet);

		cadastroLocacao.add(new JLabel("Data de Devolução:\n"));
		cadastroLocacao.add(JdiaDev);
		cadastroLocacao.add(JmesDev);
		cadastroLocacao.add(JanoDev);

		cadastroLocacao.add(new JLabel("Valor:\n"));
		cadastroLocacao.add(Jvalor);
		cadastroLocacao.add(new JLabel("Descrição/Título:\n"));
		cadastroLocacao.add(Jdescricao);
		cadastroLocacao.add(new JLabel("Sócio:\n"));
		cadastroLocacao.add(Jsocio);
		cadastroLocacao.add(new JLabel("Dependente:\n"));
		cadastroLocacao.add(Jdependente);
		cadastroLocacao.add(new JLabel("Data de Nascimento do Dependente:\n"));
		cadastroLocacao.add(JdiaDep);
		cadastroLocacao.add(JmesDep);
		cadastroLocacao.add(JanoDep);
		
		

		int panel = JOptionPane.showConfirmDialog(null, cadastroLocacao, "Cadastro Locação",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

		String dataDep = JdiaDep.getText() + "/" + JmesDep.getText() + "/" + JanoDep.getText();
		String dataRet = JdiaRet.getText() + "/" + JmesRet.getText() + "/" + JanoRet.getText();
		
		String dataDev = JdiaDev.getText() + "/" + JmesDev.getText() + "/" + JanoDev.getText();
		
		if(!ValidaData.validar(dataDep) || !ValidaData.validar(dataRet) || !ValidaData.validar(dataDev)) {
			JOptionPane.showMessageDialog(cadastroLocacao, "Data Inválida \n");
		}else {
			
			dataDevolucao = new SimpleDateFormat(pattern).parse(dataDev);
			dataRetirada = new SimpleDateFormat(pattern).parse(dataRet);
			dataDependente = new SimpleDateFormat(pattern).parse(dataDep);
			
			loc = new Locacao();
			
			socio = SocioDAO.getSocio(Jsocio.getText());
			if (socio != null) {
				
				socio.addDependente(new Dependente(Jdependente.getText(), dataDependente));
				loc.setSocio(socio);
				loc.setTitulo(Jdescricao.getText());
				loc.setValor(Double.parseDouble(Jvalor.getText()));
				
				loc.setDataDevolucao(dataDevolucao); 
				loc.setDataRetirada(dataRetirada);
				Menu.addSocio(socio);
				
			} else {
				JOptionPane.showInternalMessageDialog(cadastroLocacao,
						"Sócio não Encontrado na Base de Dados. Prossiga com o cadastro");
				Panel.cadastraSocio();
				Panel.cadastraLocacao();
			}
			
			System.out.println(socio.getNome());
			
		}
		
		return loc;
		
	}


	public static Socio pesquisaSocio()  throws SQLException {
		Socio socio = SocioDAO.getSocio(JOptionPane.showInputDialog("Nome do Sócio:"));
		
		return socio;
	}

}
