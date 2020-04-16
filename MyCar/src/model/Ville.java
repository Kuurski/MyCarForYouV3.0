package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Ville {
	
	private IntegerProperty idVille = new SimpleIntegerProperty();
	private StringProperty libelleV = new SimpleStringProperty();
	
	
	public Ville() {
		super();
	}


	public Ville(IntegerProperty idVille, StringProperty libelleV) {
		super();
		this.idVille = idVille;
		this.libelleV = libelleV;
	}
	
	public Ville(int idVille, String libelleV) {
		super();
		this.idVille.set(idVille);
		this.libelleV.set(libelleV);
	}
	


	public IntegerProperty getIdVille() {
		return idVille;
	}


	public void setIdVille(IntegerProperty idVille) {
		this.idVille = idVille;
	}


	public StringProperty getLibelleV() {
		return libelleV;
	}


	public void setLibelleV(StringProperty libelleV) {
		this.libelleV = libelleV;
	}
	
	
	

}
