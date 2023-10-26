package testes;

import java.sql.SQLException;
import java.util.Date;

import dao.*;
import pessoas.Socio;
public class TesteSocioDAO {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		
		Date dataNasc = new Date();
		
		Socio socio = new Socio("Rafael", "Salomoni", "rafael@gmail", dataNasc);
		
		SocioDAO.inserirSocio(socio);
		

	}

}
