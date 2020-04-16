package view;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.ConnectDB;
import controller.LocationDAO;
import controller.MainApp;
import controller.VehiculeDAO;
import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import model.Ville;
import model.Location;
import model.Marque;
import model.Utilisateur;
import model.Vehicule;

public class MainOverviewController implements Initializable {

	
	
	@FXML
	private ComboBox<Ville> comboBoxVille;
	@FXML
	private DatePicker dateDepart;
	@FXML
	private DatePicker dateRetour;

	// TableView Vehicule
	@FXML
	private TableView<Vehicule> vehiculeTable;
	@FXML
	private TableColumn<Vehicule, Integer> idVehiculeColumn;
	@FXML
	private TableColumn<Vehicule, String> marqueColumn;
	@FXML
	private TableColumn<Vehicule, String> matriculeColumn;
	@FXML
	private TableColumn<Vehicule, String> anneeColumn;
	@FXML
	private TableColumn<Vehicule, Integer> kmColumn;
	@FXML
	private TableColumn<Vehicule, Integer> tarifColumn;
	@FXML 
	private TextField idVehiculeField;

	// NewVehicule
	@FXML
	private ComboBox<Marque> comboBoxMarque;
	@FXML
	private ComboBox<Ville> comboBoxVille2;
	@FXML
	private TextField anneeField;
	@FXML
	private TextField kmField;
	@FXML
	private TextField tarifField;
	@FXML
	private TextField matriculeField;

	// ListViewVehicule
	@FXML
	private TableView<Vehicule> vehiculeClientTable;
	@FXML
	private TableColumn<Vehicule, String> marqueClientColumn;
	@FXML
	private TableColumn<Vehicule, String> matriculeClientColumn;
	@FXML
	private TableColumn<Vehicule, String> anneeClientColumn;
	@FXML
	private TableColumn<Vehicule, Integer> kmClientColumn;
	@FXML
	private TableColumn<Vehicule, Integer> tarifClientColumn;

	private MainApp mainApp;
	private MainOverviewController mainOver;

	public ObservableList<Vehicule> listTableVehicule = FXCollections.observableArrayList();

	private void initializeComboBoxVille() {

		String sqlSearchVilles = "SELECT * " + "FROM ville ";
		try {

			

			Connection connexion = ConnectDB.initConnection();
			Statement st = connexion.prepareStatement(sqlSearchVilles);
			ResultSet rs = st.executeQuery(sqlSearchVilles);

			ObservableList<Ville> listVilleFirst = FXCollections.observableArrayList();
			
			while (rs.next()) {

				int idVille = rs.getInt("idVille");
				String libelleVille = rs.getString("libelleV");
				Ville ville = new Ville(idVille, libelleVille);
				listVilleFirst.add(ville);

				
			}
			
			
			comboBoxVille.setItems(listVilleFirst);
			comboBoxVille.setConverter(new StringConverter<Ville>() {

				@Override
				public Ville fromString(String libelleVille) {
					// TODO Auto-generated method stub
					ObservableList<Ville> lstCombo = comboBoxVille.getItems();

					for (Ville villeInstance : lstCombo) {

						if (libelleVille.equals(villeInstance.getLibelleV())) {

							return villeInstance;
						}
					}
					return null;
				}

				@Override
				public String toString(Ville ville) {
					// TODO Auto-generated method stub
					return ville.getLibelleV().get();
				}

			});

		} catch (Exception e) {

			System.out.println(e.getMessage());
			// boolean isSelected =
		}
	}

	private void initializeComboBoxVille2() {

		String sqlSearch = "SELECT * " + "FROM ville ";
		try {

			Connection connexion = ConnectDB.initConnection();
			Statement st = connexion.prepareStatement(sqlSearch);
			ResultSet rs = st.executeQuery(sqlSearch);

			ObservableList<Ville> listVilleSecond = FXCollections.observableArrayList();

			while (rs.next()) {

				int idVille = rs.getInt("idVille");
				String libelleVille = rs.getString("libelleV");
				Ville ville = new Ville(idVille, libelleVille);
				listVilleSecond.add(ville);

			}

			comboBoxVille2.setItems(listVilleSecond);
			comboBoxVille2.setConverter(new StringConverter<Ville>() {

				@Override
				public Ville fromString(String libelleVille) {
					// TODO Auto-generated method stub
					ObservableList<Ville> lstCombo = comboBoxVille2.getItems();

					for (Ville villeInstance : lstCombo) {

						if (libelleVille.equals(villeInstance.getLibelleV())) {

							return villeInstance;
						}
					}
					return null;
				}

				@Override
				public String toString(Ville ville) {
					// TODO Auto-generated method stub
					return ville.getLibelleV().get();
				}

			});

		} catch (Exception e) {

			System.out.println(e.getMessage());
			// boolean isSelected =
		}
	}

	private void initializeComboBoxMarque() {

		ObservableList<Marque> listMarques = FXCollections.observableArrayList();

		String sqlSearchMarque = "SELECT * " + "FROM marque ";
		try {

			Connection connexion = ConnectDB.initConnection();
			Statement st = connexion.prepareStatement(sqlSearchMarque);
			ResultSet rs = st.executeQuery(sqlSearchMarque);

			while (rs.next()) {

				int marqueId = rs.getInt("idMarque");
				String marqueLibelle = rs.getString("libelleM");
				Marque marques = new Marque(marqueId, marqueLibelle);
				listMarques.add(marques);

			}

			comboBoxMarque.setItems(listMarques);
			comboBoxMarque.setConverter(new StringConverter<Marque>() {

				@Override
				public Marque fromString(String libelleMarque) {
					// TODO Auto-generated method stub
					ObservableList<Marque> marquesCombo = comboBoxMarque.getItems();

					for (Marque marqueInstance : marquesCombo) {

						if (libelleMarque.equals(marqueInstance.getLibelleM())) {

							return marqueInstance;
						}
					}
					return null;
				}

				@Override
				public String toString(Marque marque) {
					// TODO Auto-generated method stub
					return marque.getLibelleM().get();
				}

			});

		} catch (Exception e) {

			System.out.println(e.getMessage());
			// boolean isSelected =
		}
	}

	@FXML // Ajout d'un Client dans la base de données
	private void newvehicule(ActionEvent event) throws SQLException {

		VehiculeDAO nouveauVehicule = new VehiculeDAO();
		Utilisateur user = mainApp.getUser();
		Ville ville = (Ville) comboBoxVille2.getValue();
		Marque marque = (Marque) comboBoxMarque.getValue();
		String anneeMeS = anneeField.getText();
		int kmVehicule = Integer.parseInt(kmField.getText());
		int tarif = Integer.parseInt(tarifField.getText());
		String matricule = matriculeField.getText();
		Vehicule leVehicule = new Vehicule(0, ville, marque, matricule, anneeMeS, tarif, kmVehicule);

		int idVehicule = nouveauVehicule.newVehicule(user, leVehicule);
		leVehicule.setIdVehicule(idVehicule);

	}

	@FXML
	private void rechercheVille(ActionEvent event) {

		System.out.println("Teest debut Recherche");

		ObservableList<Vehicule> listTableVehicule = FXCollections.observableArrayList();
		Ville ville = comboBoxVille.getValue();
		LocalDate startDate = this.dateDepart.getValue();
		System.out.println(startDate);
		LocalDate endDate = this.dateRetour.getValue();
		VehiculeDAO vlDAO = new VehiculeDAO();
		listTableVehicule = vlDAO.findByVille(ville,startDate,endDate);
		vehiculeTable.setItems(listTableVehicule);

		System.out.println("Teest fin Recherche");

	}

	private String initializeDateDepart() {

		dateDepart.setOnAction(event -> {
			LocalDate date = dateDepart.getValue();
			System.out.println("Selected date:" + date);
		});
		return null;

	}

	private String initializeDateRetour() {

		dateRetour.setOnAction(event -> {
			LocalDate date = dateRetour.getValue();
			System.out.println("Selected date:" + date);
		});
		return null;

	}

	@FXML
	private void newLocationVehicule(ActionEvent event) throws SQLException {

		LocationDAO locDAO = new LocationDAO();


		int idVehicule = vehiculeTable.getSelectionModel().getSelectedItem().getIdVehicule().get();

		Utilisateur user = mainApp.getUser();
		String dateDebut = dateDepart.getValue().toString();
		String dateFin = dateRetour.getValue().toString();


		Location laLocation = new Location(0, 0, idVehicule, dateDebut, dateFin);
		int idLocation = locDAO.ajoutLocation(user, laLocation);
		System.out.println(idLocation);
		System.out.println(laLocation);
		laLocation.setIdLocation(idLocation);
		

		try {

		} catch (Exception e) {

			
			System.out.println("Interieur Catch NewLocationVehicule");
			System.out.println(e.getMessage());

		}

	}

	public void setMain(MainApp mainApp) {
		// TODO Auto-generated method stub

		this.mainApp = mainApp;
		vehiculeTable.setItems(mainApp.getListTableVehicule());
		vehiculeClientTable.setItems(mainApp.getListTableVehiculeClient());

	}

	public void setDialogStage(Stage dialogStage) {
		// TODO Auto-generated method stub

	}

	public boolean isOkClicked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		initializeComboBoxVille();
		initializeComboBoxVille2();
		initializeComboBoxMarque();
		initializeDateDepart();
		initializeDateRetour();

		// Vehicule
		VehiculeDAO vlDAO = new VehiculeDAO();
		listTableVehicule.addAll(vlDAO.tableauVehicule());

		// TableViewVehicule

		marqueColumn.setCellValueFactory(cellData -> cellData.getValue().getMarque().getValue().getLibelleM());
		matriculeColumn.setCellValueFactory(cellData -> cellData.getValue().getMatricule());
		anneeColumn.setCellValueFactory(cellData -> cellData.getValue().getAnneeMeS());
		kmColumn.setCellValueFactory(cellData -> cellData.getValue().getKmVehicule().asObject());
		tarifColumn.setCellValueFactory(cellData -> cellData.getValue().getTarif().asObject());

		// TableViewVehicule Client

		matriculeClientColumn.setCellValueFactory(cellData -> cellData.getValue().getMatricule());
		marqueClientColumn.setCellValueFactory(cellData -> cellData.getValue().getMarque().getValue().getLibelleM());
		anneeClientColumn.setCellValueFactory(cellData -> cellData.getValue().getAnneeMeS());
		kmClientColumn.setCellValueFactory(cellData -> cellData.getValue().getKmVehicule().asObject());
		tarifClientColumn.setCellValueFactory(cellData -> cellData.getValue().getTarif().asObject());



}
}
