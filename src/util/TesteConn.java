package util;

import dao.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;

public class TesteConn {

	public static void main(String[] args) throws SQLException{
		Connection connection =
		new ConnectionFactory().getConnection();
		if(connection!=null)
		System.out.println("Conexão aberta!");
		else
		System.out.println("Conexão com exceção!");
		
		connection.close();
		}
		

}
