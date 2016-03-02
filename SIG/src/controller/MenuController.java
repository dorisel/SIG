package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;


public class MenuController implements Initializable,IControllerWindows{
	ControllerWindows myWindows=ControllerWindows.getInstancia();
	private static MenuController menucontroller;
	@FXML private Button btnMantenimientos,btnClientes;
	public MenuController() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public static MenuController getInstancia(){
		if(menucontroller==null){
			menucontroller= new MenuController();
		}
		return menucontroller;
	}
	
	@Override
	public void getMainlWindows(ControllerWindows InternalPage) {
		myWindows=InternalPage;
	}

	//Inicializamos la ventana para mostrar el login
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		myWindows.showScreen(Main.screenLogin);
		
	}
	
	//Métodos para asignar menú segun el nivel
	
		//Método para asignar el menu de administrador
		@FXML private void admin(){
			btnClientes.setVisible(false);
		}
	
	//Métodos para activar las ventanas
	
	@FXML private void supports(){
		myWindows.showScreen(Main.screenSupports);
		btnClientes.setVisible(false);
	}
	
	
	public void activeMenu(String nivel){
		if(nivel=="admin"){
			supports();
		}
	}
}
