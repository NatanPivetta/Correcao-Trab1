package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static final String URL = "jdbc:mysql//localhost:3306/trabpw";
    public static final String USER = "natan";
    public static final String PASSWORD = "123456";

    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";

    
    

    public Connection getConnection() {
    	try {
    	Class.forName("com.mysql.jdbc.Driver");
    	String urlBD="jdbc:mysql://localhost:3306/trabpw";
    	return DriverManager.getConnection(urlBD, "root", "");
    	} catch (SQLException e) {
    	System.out.println("Exceção SQL");
    	} catch(ClassNotFoundException e){
    	System.out.println("Exceção Classe não encontrada");
    	}
    	return null;
    	}

}