package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TypeAssurance {
	
	private IntegerProperty idType = new SimpleIntegerProperty();
	private StringProperty libelle = new SimpleStringProperty();
	
	
	
	public TypeAssurance() {
		super();
	}



	public TypeAssurance(IntegerProperty idType, StringProperty libelle) {
		super();
		this.idType = idType;
		this.libelle = libelle;
	}



	public IntegerProperty getIdType() {
		return idType;
	}



	public void setIdType(IntegerProperty idType) {
		this.idType = idType;
	}



	public StringProperty getLibelle() {
		return libelle;
	}



	public void setLibelle(StringProperty libelle) {
		this.libelle = libelle;
	}
	
		
	

}
