package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Marque;
import model.Utilisateur;
import model.Vehicule;
import model.Ville;

public class VehiculeDAO {

	public ObservableList<Vehicule> tableauVehicule() {

		ObservableList<Vehicule> listTableVehicule = FXCollections.observableArrayList();
		String sqlNum;
		sqlNum = "SELECT * " + "FROM vehicule,marque,ville " + "WHERE vehicule.idMarque=marque.idMarque "
				+ "AND vehicule.idVille=ville.idVille ";

		try {
			System.out.println("test avant sql");
			Connection connexion = ConnectDB.initConnection();
			Statement st = connexion.createStatement();
			ResultSet rs = st.executeQuery(sqlNum);
			System.out.println("test avant while");
			while (rs.next()) {

				int idVehicule = rs.getInt("idVehicule");
				Ville ville = new Ville(rs.getInt("idVille"), rs.getString("libelleV"));
				Marque marque = new Marque(rs.getInt("idMarque"), rs.getString("libelleM"));
				String matricule = rs.getString("matricule");
				String anneeMeS = rs.getString("anneeMeS");
				int kmVehicule = rs.getInt("kmVehicule");
				int tarif = rs.getInt("tarif");

				Vehicule tabVehicule = new Vehicule(idVehicule, ville, marque, matricule, anneeMeS, kmVehicule, tarif);
				listTableVehicule.add(tabVehicule);

			}

		} catch (Exception e) {
			System.out.println("Si ce message s'affiche, c'est que tu as un probleme ! ");
			System.err.println(e.getMessage());
		}

		return listTableVehicule;
	}

	public ObservableList<Vehicule> findByVille(Ville ville, LocalDate startDate, LocalDate endDate) {

		ObservableList<Vehicule> listTableVehicule = FXCollections.observableArrayList();
		Connection connect = ConnectDB.initConnection();
		String sqlVille;
		sqlVille = "SELECT * "
				+ "FROM vehicule"
			    + " INNER JOIN ville ON vehicule.idVille=ville.idVille"
			    + " INNER JOIN marque ON vehicule.idMarque=marque.idMarque"
			    + " LEFT JOIN location ON vehicule.idVehicule=location.idVehicule"

			+ " WHERE ville.idVille = '"+ville.getIdVille().get()+ "'" 
			+ " AND (dateDebut NOT BETWEEN '" +startDate+ "' AND '"+endDate+"'"
			+ " AND dateFin  NOT BETWEEN '"+startDate+ "' AND '"+endDate+"'"
			+ " or (dateDebut is NULL "
			+ " AND dateFin is null))";
			
//				"SELECT * "
//				+"FROM vehicule"
//				 +   "INNER JOIN ville ON vehicule.idVille=ville.idVille"
//				  + " INNER JOIN marque ON vehicule.idMarque=marque.idMarque"
//				   +" LEFT JOIN location ON vehicule.idVehicule=location.idVehicule"
//
//				+ "WHERE ville.idVille = '"+ville.+"' "
//				AND
//				(dateDebut NOT BETWEEN '2018-03-04' AND '2020-04-03'
//
//				AND dateFin NOT BETWEEN '2020-03-04' AND '2020-04-03'
//
//				or 
//				(dateDebut is NULL
//				AND dateFin is null))
//				
//				" SELECT *  FROM vehicule "
//				+ " INNER JOIN ville ON vehicule.idVille=ville.idVille "
//				+ " INNER JOIN marque ON vehicule.idMarque=marque.idMarque "
//				+ " INNER JOIN location ON vehicule.idVehicule=location.idVehicule "
//				+ " WHERE ville.idVille = '" + ville.getIdVille().get() + "'"
//				+ " AND ( 'dateDebut' NOT BETWEEN '"+startDate+"' AND '"+endDate+"'"
//				+ " AND 'dateFin' NOT BETWEEN '"+startDate+"' AND '"+endDate+"'"
//				+ " OR ( 'dateDebut' is NULL "
//				+ " AND 'dateFin' is null ))";
//				
//				+ "AND dateDebut NOT BETWEEN '"+startDate+"' AND '"+endDate+"'"
//				+ "AND dateFin NOT BETWEEN '"+startDate+"' AND '"+endDate+"'";
				
		
//		SELECT vehicule.idVehicule,libelleM,libelleV,dateDebut,dateFin
//		FROM vehicule
//		INNER JOIN marque ON vehicule.idMarque=marque.idMarque
//		INNER JOIN location ON vehicule.idUser=location.idUser
//		INNER JOIN ville ON vehicule.idVille=ville.idVille
//		WHERE ville.idVille = '1'
//		AND dateDebut NOT BETWEEN '2020-03-04' AND '2020-04-03'
//		AND dateFin NOT BETWEEN '2020-03-04' AND '2020-04-03'
//				+ "AND ('dateDebut' >"+startDate+ " "
//				+ "AND 'dateFin' < " +endDate+ " ) "
//				+ "OR ('dateDebut' <"+startDate+ " "
//				+ "AND 'dateFin' >"+endDate+" ) "
//				+ "OR ('dateDebut' <"+endDate+" "
//				+ "AND 'dateFin' >"+endDate+" ) "
//				+ "OR ('dateDebut' <"+startDate+" "
//				+ "AND 'dateFin' >"+startDate+" ) "
//				+ "OR ('dateDebut' IS NULL "
//				+ "AND 'dateFin' IS NULL)";
		
		
		System.out.print("Fin SQL findByVille");
		System.out.print(sqlVille);
		try {
			Connection connexion = ConnectDB.initConnection();
			Statement st = connexion.createStatement();
			ResultSet rs = st.executeQuery(sqlVille);
			System.out.print("Avant While findByVille");
			
			while (rs.next()) {
				
				
				
				System.out.print("Interieur While Debut findByVille");

				int idVehicule = rs.getInt("idVehicule");
				Marque marque = new Marque(rs.getInt("idMarque"), rs.getString("libelleM"));
				String matricule = rs.getString("matricule");
				String anneeMeS = rs.getString("anneeMeS");
				int kmVehicule = rs.getInt("kmVehicule");
				int tarif = rs.getInt("tarif");

				Vehicule tabVehicule = new Vehicule(idVehicule, ville, marque, matricule, anneeMeS, kmVehicule, tarif);
				listTableVehicule.add(tabVehicule);
			}
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return listTableVehicule;
	}

	public Integer newVehicule(Utilisateur proprietaire, Vehicule newvehicule) throws SQLException {

		Connection connexion = ConnectDB.initConnection();

		int idUser = proprietaire.getIdUser().get();
		int idVehicule = newvehicule.getIdVehicule().get();
		Ville ville = newvehicule.getVille().get();
		Marque marque = newvehicule.getMarque().get();
		String anneeMeS = newvehicule.getAnneeMeS().get();
		int kmVehicule = newvehicule.getKmVehicule().get();
		String matricule = newvehicule.getMatricule().get();
		int tarif = newvehicule.getTarif().get();

		try {

			String sqlNew;
			sqlNew = "INSERT INTO vehicule (idUser, idMarque, idAssurance, idVille, matricule, anneeMeS, kmVehicule, tarif ) VALUES "
					+ "('" + idUser + "','" + marque.getIdMarque().get() + "','" + '1' + "','"
					+ ville.getIdVille().get() + "','" + matricule + "','" + anneeMeS + "','" + kmVehicule + "','"
					+ tarif + "')";

			PreparedStatement st = connexion.prepareStatement(sqlNew, Statement.RETURN_GENERATED_KEYS);

			System.out.print("Interieur ClientsDAO : " + sqlNew);
			st.executeUpdate();

			ResultSet rs = st.getGeneratedKeys();
			if (rs.next()) {
				int pk = rs.getInt(1);
				System.out.println("Generated PK = " + pk);

				return pk;
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public ObservableList<Vehicule> tableauVehiculeClient() {

		ObservableList<Vehicule> listTableVehiculeClient = FXCollections.observableArrayList();
		String sqlNum;
		sqlNum = "SELECT * " + "FROM vehicule,utilisateur,marque,ville  " + "WHERE vehicule.idUser=utilisateur.idUser "
				+ "AND vehicule.idMarque=marque.idMarque " + "AND vehicule.idVille=ville.idVille "
				+ "AND vehicule.idUser = '1' ";

		try {
			System.out.println("TEST LIST TABLEVEHICULE DANS DAO");
			Connection connexion = ConnectDB.initConnection();
			Statement st = connexion.createStatement();
			ResultSet rs = st.executeQuery(sqlNum);
			System.out.println("test avant while");
			while (rs.next()) {

				System.out.println(sqlNum);
				int idVehicule = rs.getInt("idVehicule");
				Ville ville = new Ville(rs.getInt("idVille"), rs.getString("libelleV"));
				Marque marque = new Marque(rs.getInt("idMarque"), rs.getString("libelleM"));
				String matricule = rs.getString("matricule");
				String anneeMeS = rs.getString("anneeMeS");
				int kmVehicule = rs.getInt("kmVehicule");
				int tarif = rs.getInt("tarif");
				Vehicule tabVehicule = new Vehicule(idVehicule, ville, marque, matricule, anneeMeS, kmVehicule, tarif);
				listTableVehiculeClient.add(tabVehicule);
				System.out.println(tabVehicule);
				System.out.println(idVehicule);
				System.out.println("TEST LIST TABLEVEHICULE DANS DAO FIN");
			}

		} catch (Exception e) {
			System.out.println("Si ce message s'affiche, c'est que tu as un probleme ! ");
			System.err.println(e.getMessage());
		}

		return listTableVehiculeClient;
	}

}