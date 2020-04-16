	package controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {

	private static Connection connect = null;
	private String url = "jdbc:mysql://localhost:3306/mycar";
	private String user = "root";
	private String passwd ="";

	public ConnectDB() {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver O.K");
			connect = (Connection) DriverManager.getConnection(url, user, passwd);
			System.out.println("Connexion effective ");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		}
	
	public static Connection initConnection() {
	
		if (connect==null) {new ConnectDB(); }
		return connect;
	}
	}
	

