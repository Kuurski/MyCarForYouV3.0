package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

//import com.mysql.jdbc.PreparedStatement;
import java.sql.PreparedStatement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import model.Utilisateur;
import view.HomeOverviewController;

public class PropUtilDAO {

	
	public void logDAO(String email, String password) {
		System.out.println("Avant try LogDAO");
		
		try {
			System.out.println("try LogDAO");
			HomeOverviewController hoc = new HomeOverviewController();
			
			String sql = "SELECT * "
				+ "FROM utilisateur "
				+ "WHERE mailUser = ? "
				+ "AND mdp = ? ";
			Connection connect = ConnectDB.initConnection();
		
		PreparedStatement preparedstatement = connect.prepareStatement(sql);
		preparedstatement.setString(1, email);
		preparedstatement.setString(2, password);
		ResultSet resultSet = preparedstatement.executeQuery();
		
		System.out.println("Message Après Exec DAO");
	} catch (Exception e) {
		System.out.println("Message d'erreur Catch PropUtilDAO ");
		
	}
	}
	
/*	public ObservableList<ProprietaireUtilisateur> logIn(String mailProp, String mdpProp) {
		
		ObservableList<ProprietaireUtilisateur> listPropUtil = FXCollections.observableArrayList();
		Connection connect = ConnectDB.initConnection();
		String sqlLog;
		sqlLog = "SELECT mailPropUtil, mdp "
				+ "FROM proprietaireutilisateur "
				+ "WHERE mailPropUtil ='"+mailProp+"'"
				+ "AND mdpPropUtil = '"+mdpProp+"'";
		try {
			Connection connexion = ConnectDB.initConnection();
			Statement st = connexion.createStatement();
			ResultSet rs = st.executeQuery(sqlLog);
			while (rs.next()) {
				
				ProprietaireUtilisateur unUtilisateur = new ProprietaireUtilisateur();
				listPropUtil.add(unUtilisateur);
			}
			
		} catch(Exception e) {
					System.err.println(e.getMessage());
			}
		return null;
	}
		*/
        }
