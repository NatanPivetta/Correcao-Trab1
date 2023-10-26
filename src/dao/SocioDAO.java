package dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import pessoas.Socio;

import javax.xml.transform.Result;

public class SocioDAO {

	public static boolean inserirSocio(Socio socio) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();
		if (connection != null) {
			System.out.println("Conexão aberta!");
			PreparedStatement stmt = connection
					.prepareStatement("INSERT INTO socio (nome, email, endereco, nascimento) VALUES (?, ?, ?, ?)");
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
		// Implemente a lógica de atualização aqui
		return false;
	}

	public boolean excluirSocio(int id) {
		// Implemente a lógica de exclusão aqui
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
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM socio WHERE nome=?");
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

}
