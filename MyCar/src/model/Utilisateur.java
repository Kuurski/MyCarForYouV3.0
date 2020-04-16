package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Utilisateur {
	
	private IntegerProperty idUser = new SimpleIntegerProperty();
	private StringProperty nomUser = new SimpleStringProperty();
	private StringProperty prenomUser = new SimpleStringProperty();
	private IntegerProperty telUser = new SimpleIntegerProperty();
	private StringProperty mailUser = new SimpleStringProperty();
	private IntegerProperty pointFidelite = new SimpleIntegerProperty();
	private StringProperty mdp = new SimpleStringProperty();
	
	
	
	public Utilisateur() {
		super();
	}


	public Utilisateur(IntegerProperty idUser, StringProperty nomUser, StringProperty prenomUser,
			IntegerProperty telUser, StringProperty mailUser, IntegerProperty pointFidelite, StringProperty mdp) {
		super();
		this.idUser = idUser;
		this.nomUser = nomUser;
		this.prenomUser = prenomUser;
		this.telUser = telUser;
		this.mailUser = mailUser;
		this.pointFidelite = pointFidelite;
		this.mdp = mdp;
	}
	
	public Utilisateur(int idUser, String nomUser, String prenomUser,
			int telUser, String mailUser, int pointFidelite, String mdp) {
		super();
		this.idUser.set(idUser);
		this.nomUser.set(nomUser);
		this.prenomUser.set(prenomUser);
		this.telUser.set(telUser);
		this.mailUser.set(mailUser);
		this.pointFidelite.set(pointFidelite);
		this.mdp.set(mdp);
	}




	public IntegerProperty getIdUser() {
		return idUser;
	}




	public void setIdUser(IntegerProperty idUser) {
		this.idUser = idUser;
	}




	public StringProperty getNomUser() {
		return nomUser;
	}




	public void setNomUser(StringProperty nomUser) {
		this.nomUser = nomUser;
	}




	public StringProperty getPrenomUser() {
		return prenomUser;
	}




	public void setPrenomUser(StringProperty prenomUser) {
		this.prenomUser = prenomUser;
	}




	public IntegerProperty getTelUser() {
		return telUser;
	}




	public void setTelUser(IntegerProperty telUser) {
		this.telUser = telUser;
	}




	public StringProperty getMailUser() {
		return mailUser;
	}




	public void setMailUser(StringProperty mailUser) {
		this.mailUser = mailUser;
	}




	public IntegerProperty getPointFidelite() {
		return pointFidelite;
	}




	public void setPointFidelite(IntegerProperty pointFidelite) {
		this.pointFidelite = pointFidelite;
	}




	public StringProperty getMdp() {
		return mdp;
	}




	public void setMdp(StringProperty mdp) {
		this.mdp = mdp;
	}



	
}
