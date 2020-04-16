package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Assurance {
	
	
	private IntegerProperty idAssurance = new SimpleIntegerProperty();
	private StringProperty libelle = new SimpleStringProperty();
	private StringProperty adresse = new SimpleStringProperty();
	
	
	
	
	public Assurance() {
		super();
	}




	public Assurance(IntegerProperty idAssurance, StringProperty libelle, StringProperty adresse) {
		super();
		this.idAssurance = idAssurance;
		this.libelle = libelle;
		this.adresse = adresse;
	}




	public IntegerProperty getIdAssurance() {
		return idAssurance;
	}




	public void setIdAssurance(IntegerProperty idAssurance) {
		this.idAssurance = idAssurance;
	}




	public StringProperty getLibelle() {
		return libelle;
	}




	public void setLibelle(StringProperty libelle) {
		this.libelle = libelle;
	}




	public StringProperty getAdresse() {
		return adresse;
	}




	public void setAdresse(StringProperty adresse) {
		this.adresse = adresse;
	}
	
	

}
