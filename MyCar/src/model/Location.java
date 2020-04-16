package model;

import java.util.Date;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Location {
	

	private IntegerProperty idLocation = new SimpleIntegerProperty();
	private IntegerProperty idUser = new SimpleIntegerProperty();
	private IntegerProperty idVehicule = new SimpleIntegerProperty();
	private StringProperty dateDebut = new SimpleStringProperty();
	private StringProperty dateFin = new SimpleStringProperty();
	
	
	public Location() {
		super();
	}


	public Location(int idLocation, int idUser, int idVehicule, String dateDebut, String dateFin) {
		super();
		this.idLocation.set(idVehicule);
		this.idUser.set(idUser);
		this.idVehicule.set(idVehicule);
		this.dateDebut.set(dateDebut);
		this.dateFin.set(dateFin);
		
	}


	public IntegerProperty getIdLocation() {
		return idLocation;
	}


	public void setIdLocation(IntegerProperty idLocation) {
		this.idLocation = idLocation;
	}

	public void setIdLocation(int idLocation) {
		this.idLocation.set(idLocation);
	}

	public IntegerProperty getIdUser() {
		return idUser;
	}


	public void setIdUser(IntegerProperty idUser) {
		this.idUser = idUser;
	}


	public IntegerProperty getIdVehicule() {
		return idVehicule;
	}


	public void setIdVehicule(IntegerProperty idVehicule) {
		this.idVehicule = idVehicule;
	}


	public StringProperty getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(StringProperty dateDebut) {
		this.dateDebut = dateDebut;
	}


	public StringProperty getDateFin() {
		return dateFin;
	}


	public void setDateFin(StringProperty dateFin) {
		this.dateFin = dateFin;
	}



	
	

}
