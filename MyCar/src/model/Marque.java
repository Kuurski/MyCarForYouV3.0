package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Marque {

	
	private IntegerProperty idMarque = new SimpleIntegerProperty();
	private StringProperty libelleM = new SimpleStringProperty();
	
	
	public Marque() {
		super();
	}

	public Marque(IntegerProperty idMarque, StringProperty libelleM) {
		super();
		this.idMarque = idMarque;
		this.libelleM = libelleM;
	}

	public Marque(int idMarque, String libelleM) {
		super();
		this.idMarque.set(idMarque);
		this.libelleM.set(libelleM);
	}

	public IntegerProperty getIdMarque() {
		return idMarque;
	}


	public void setIdMarque(IntegerProperty idMarque) {
		this.idMarque = idMarque;
	}


	public StringProperty getLibelleM() {
		return libelleM;
	}


	public void setLibelleM(StringProperty libelleM) {
		this.libelleM = libelleM;
	}
	
	
	
	
}
