package controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Utilisateur;
import model.Vehicule;
import view.HomeOverviewController;
import view.MainOverviewController;
import view.RentOverviewController;

public class MainApp extends Application {

    private Stage mainStage;
    private BorderPane rootLayout;
    private AnchorPane rootPane;
    private Utilisateur user;

    @Override
    public void start(Stage primaryStage) {
        this.mainStage = primaryStage;
        this.mainStage.setTitle("My Car For You");

        initRootLayout();
        showHomeOverview();
        
    }
    
    public ObservableList<Vehicule> listTableVehicule = FXCollections.observableArrayList();
    
    public ObservableList<Vehicule> getListTableVehicule() {
    	
    	VehiculeDAO vlDAO = new VehiculeDAO();
    	listTableVehicule.addAll (vlDAO.tableauVehicule());
    	
		return listTableVehicule;
	}
    
	public void setListTableVehicule(ObservableList<Vehicule> listTableVehicule) {
		this.listTableVehicule = listTableVehicule;
	}
	
    public ObservableList<Vehicule> listTableVehiculeClient = FXCollections.observableArrayList();
    
    public ObservableList<Vehicule> getListTableVehiculeClient() {
    	
    	VehiculeDAO vlDAO = new VehiculeDAO();
    	listTableVehiculeClient.addAll (vlDAO.tableauVehicule());
    	
		return listTableVehiculeClient;
	}
    
	public void setListTableVehiculeClient(ObservableList<Vehicule> listTableVehiculeClient) {
		this.listTableVehiculeClient = listTableVehiculeClient;
	}
	
    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            mainStage.setScene(scene);
            mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showHomeOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/view/HomeOverview.fxml"));
            AnchorPane homeOverview = (AnchorPane) loader.load();
            HomeOverviewController controller = (HomeOverviewController)loader.getController();
            controller.setMain(this);
            
            // Set person overview into the center of root layout.
            rootLayout.setCenter(homeOverview);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public void showMainOverview(Utilisateur user){
    	
    	System.out.println("AFFICHE MOI ça Avant Try");
    	
    try {
    	
    	System.out.println("AFFICHE MOI 'ShowMainOverview'");	
    	
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("/view/MainOverview.fxml"));
        AnchorPane mainOverview = (AnchorPane) loader.load();
       
    	MainOverviewController controller = loader.getController();
        // Set person overview into the center of root layout.
    	controller.setMain(this);
    	
    	this.setUser(user);
    	
    	
        rootLayout.setCenter(mainOverview);
  	
  		} catch (IOException e) {
    		e.printStackTrace();
    		
    	} 
		
    	
    } 
    
    
    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return mainStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}
    
    
}