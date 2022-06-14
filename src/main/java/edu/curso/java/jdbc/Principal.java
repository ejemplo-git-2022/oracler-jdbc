package edu.curso.java.jdbc;

import java.sql.*;

public class Principal {

	public static void main(String[] args) {

		System.out.println("Inicio del programa");
		
		String url = "jdbc:oracle:thin:@//192.168.39.130:1521/XEPDB1";
		
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(url, "HR", "hr");
			String sql = "SELECT FIRST_NAME, LAST_NAME FROM EMPLOYEES";
			PreparedStatement comandoSQL = connection.prepareStatement(sql);
			ResultSet resultado = comandoSQL.executeQuery();
			while (resultado.next()) {
				System.out.println(resultado.getString("FIRST_NAME") + " " + resultado.getString("LAST_NAME"));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(connection != null)
					connection.close();
			} catch (Exception e) {}
		}
		
		
	}

}
