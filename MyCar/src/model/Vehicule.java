package model;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Vehicule {
	
	
	private IntegerProperty idVehicule = new SimpleIntegerProperty();
	private ObjectProperty<Ville> ville = new SimpleObjectProperty<>();
	private ObjectProperty<Marque> marque = new SimpleObjectProperty<>();
	private StringProperty matricule = new SimpleStringProperty();
	private StringProperty anneeMeS = new SimpleStringProperty();
	private IntegerProperty kmVehicule = new SimpleIntegerProperty();
	private IntegerProperty tarif = new SimpleIntegerProperty();
	
	
	public Vehicule() {
		super();
	}


	public Vehicule(int idVehicule, Ville ville, Marque marque, String matricule, String anneeMeS, int kmVehicule,
			int tarif) {
		super();
		this.idVehicule.set(idVehicule);
		this.ville.set(ville);
		this.marque.set(marque);
		this.matricule.set(matricule);
		this.anneeMeS.set(anneeMeS);
		this.kmVehicule.set(kmVehicule);
		this.tarif.set(tarif);
	}


	public IntegerProperty getIdVehicule() {
		return idVehicule;
	}


	public void setIdVehicule(IntegerProperty idVehicule) {
		this.idVehicule = idVehicule;
	}

	public void setIdVehicule(int idVehicule) {
		this.idVehicule.set(idVehicule);
	}


	public ObjectProperty<Ville> getVille() {
		return ville;
	}


	public void setVille(ObjectProperty<Ville> ville) {
		this.ville = ville;
	}


	public ObjectProperty<Marque> getMarque() {
		return marque;
	}


	public void setMarque(ObjectProperty<Marque> marque) {
		this.marque = marque;
	}


	public StringProperty getMatricule() {
		return matricule;
	}


	public void setMatricule(StringProperty matricule) {
		this.matricule = matricule;
	}


	public StringProperty getAnneeMeS() {
		return anneeMeS;
	}


	public void setAnneeMeS(StringProperty anneeMeS) {
		this.anneeMeS = anneeMeS;
	}


	public IntegerProperty getKmVehicule() {
		return kmVehicule;
	}


	public void setKmVehicule(IntegerProperty kmVehicule) {
		this.kmVehicule = kmVehicule;
	}


	public IntegerProperty getTarif() {
		return tarif;
	}


	public void setTarif(IntegerProperty tarif) {
		this.tarif = tarif;
	}

	


	

}
