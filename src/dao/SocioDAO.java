package dao;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import dao.SQLs;
import pessoas.Socio;

import javax.xml.transform.Result;

public class SocioDAO {

	public static boolean inserirSocio(Socio socio) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();
		if (connection != null) {
			System.out.println("Conexão aberta!");
			PreparedStatement stmt = connection
					.prepareStatement(SQLs.INSERT_SOCIO.getSql());
			stmt.setString(1, socio.getNome());
			stmt.setString(2, socio.getEmail());
			stmt.setString(3, socio.getEndereco());
			java.sql.Date sqlDate = new java.sql.Date(socio.getDataNascimento().getTime());
			stmt.setDate(4, sqlDate);

			stmt.executeUpdate();
			return true;
		} else {

			System.out.println("Conexão com exceção!");
		}
		connection.close();

		return false;
	}

	public boolean atualizarSocio(Socio socio) {
		try(Connection connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt = 
						connection.prepareStatement(SQLs.UPDATE_SOCIO.getSql())){
			stmt.setString(1, socio.getNome());
			stmt.setString(2, socio.getEmail());
			stmt.setString(3, socio.getEndereco());
			java.sql.Date sqlDate = new java.sql.Date(socio.getDataNascimento().getTime());
			stmt.setDate(4, sqlDate);
			if(stmt.execute()) return true;
		}catch(SQLException e){ System.out.println("Exce��o SQL - update Pessoa");
		}catch(Exception e){  System.out.println("Exce��o no c�digo - update Pessoa");
		}
		return false;
	}

	public boolean excluirSocio(Socio socio) {
		try(Connection connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt = 
						connection.prepareStatement(SQLs.DELETE_SOCIO.getSql())){
			stmt.setString(1, socio.getNome());
			System.out.println("Conex�o aberta!");
			if(stmt.execute()) return true;
		}catch(SQLException e){ e.printStackTrace(); System.out.println("Exce��o SQL - delete Pessoa");
		}catch(Exception e){  System.out.println("Exce��o no c�digo - delete Pessoa");
		}
		return false;
	}
	

	public static Socio getSocio(String nome) throws SQLException {
		Socio socio = null;
		String socioNome = "";
		String socioEmail = "";
		String socioEndereco = "";
		Date socioNascimento = new Date();
		Connection connection = new ConnectionFactory().getConnection();
		if (connection != null) {
			PreparedStatement stmt = connection.prepareStatement(SQLs.FIND_BY_NOME_SOCIO.getSql());
			stmt.setString(1, nome);

			ResultSet rs = stmt.executeQuery();
			if (rs != null) {
				System.out.println("Sócio Encontrado");
				while (rs.next()) {
					socioNome = rs.getString("nome");
					socioEmail = rs.getString("email");
					socioEndereco = rs.getString("endereco");
					socioNascimento = rs.getDate("nascimento");

				}
			}else {
				System.out.println("Socio não encontrado");
			}

		} else {
			System.out.println("Sem conexão");
		}
		socio = new Socio(socioNome, socioEmail, socioEndereco, socioNascimento);
		return socio;
	}
	
	public static List<Socio> listAllSocio(){
		List<Socio> socios = new ArrayList<>();
		try(Connection connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt = 
						connection.prepareStatement(SQLs.LISTALL_SOCIO.getSql())){
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				String nome = rs.getString("nome");
				String endereco = rs.getString("endereco");
				String email = rs.getString("email");
				java.util.Date dataNasc =  rs.getDate("dataNasc");
				socios.add(new Socio(nome, email, endereco, dataNasc));
			}
			return socios;
		}catch(SQLException e){ System.out.println("Exce��o SQL - listAll Pessoa");
		}catch(Exception e){  System.out.println("Exce��o no c�digo - listAll Pessoa!");
		}
		return null;
		
	}

}
