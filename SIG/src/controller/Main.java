package controller;
	

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import views.controller.ControllerWindows;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
public class Main extends Application {
	@FXML private Button btnMantenimientos;
	ControllerWindows myWindows=new ControllerWindows();
	BorderPane container=null;
	public static String screenSupports="Mantenimientos";
	public static String fileSupports="../fxml/Mantenimientos.fxml";
	Group root= new Group();
	
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception{
		myWindows.loadScreen(Main.screenSupports, Main.fileSupports);
		java.net.URL location = getClass().getResource("../views/fxml/menu.fxml");
		FXMLLoader fxml = new FXMLLoader(location);
		container = (BorderPane) fxml.load();
		
		Scene scene= new Scene(root);
		container.setCenter(myWindows);
		root.getChildren().add(container);
	
		primaryStage.setScene(scene);
		primaryStage.centerOnScreen();
		primaryStage.show();
	}

	@FXML public void supports(){
		myWindows.showScreen(Main.screenSupports);
	}

}
