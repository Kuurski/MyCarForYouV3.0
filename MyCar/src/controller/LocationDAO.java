package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import model.Location;
import model.Utilisateur;
import view.HomeOverviewController;

public class LocationDAO {

	public Integer ajoutLocation(Utilisateur locataire, Location newLocation) throws SQLException {
		
		Connection connexion = ConnectDB.initConnection();
		
		
		int idUser = locataire.getIdUser().get();
		int idLocation = newLocation.getIdLocation().get();
		int idVehicule = newLocation.getIdVehicule().get();
		String dateDebut = newLocation.getDateDebut().get();
		String dateFin = newLocation.getDateFin().get();


		try {

			
			String sqlNew;
			sqlNew = "INSERT INTO location (idUser, idVehicule, dateDebut, dateFin) "
					+ "VALUES" + "('" + idUser + "','"
					+ idVehicule + "','" + dateDebut + "','" + dateFin + "')";


			
			PreparedStatement st = connexion.prepareStatement(sqlNew, Statement.RETURN_GENERATED_KEYS);

			System.out.print("Interieur LocationDAO : " + sqlNew);
			st.executeUpdate();
			System.out.println("Interieur Catch NewLocationVehicule");

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

}
