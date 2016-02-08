package controller;
	

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception{
		try {
			String Patch="../views/fxml/prueba.fxml";
			AnchorPane root = FXMLLoader.load(getClass().getResource(Patch));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("../views/css/main.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
