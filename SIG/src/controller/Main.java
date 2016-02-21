package controller;


import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import views.controller.ControllerWindows;

public class Main extends Application{
	
	@FXML private Button btnMantenimientos;
	ControllerWindows myWindows=ControllerWindows.getInstancia();
	BorderPane container=null;
	public static String screenSupports="Mantenimientos";
	public static String fileSupports="../fxml/Mantenimientos.fxml";
	Group root= new Group();
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		
		myWindows.loadScreen(Main.screenSupports, Main.fileSupports);
		java.net.URL location = getClass().getResource("../views/fxml/menu.fxml");
		FXMLLoader fxml = new FXMLLoader(location);
		container = (BorderPane) fxml.load();
		//fxml.getController();
		Scene scene= new Scene(root);
		container.setCenter(myWindows);
		root.getChildren().add(container);
		scene.getStylesheets().add(getClass().getResource("../views/css/main.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.centerOnScreen();
		primaryStage.show();		
	}

	@FXML private void supports(){
		System.out.println(Main.screenSupports);
		myWindows.showScreen(Main.screenSupports);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
