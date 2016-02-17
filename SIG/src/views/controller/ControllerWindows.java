/*Clase que controla que se cargue la ventana seleccionada
 * en el espacio en blacon y permite agregar un efecto 
 * de transición*/
//Developer:Lozano Ventura Jesus Alberto <0Line/>
//UTCV TICSI 5"A" Equipo:3
package views.controller;

import java.util.HashMap;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class ControllerWindows extends AnchorPane{
	//Esta linea crea como un interprete o diccionario
	private HashMap<String, Node>Screens=new HashMap<>();
	
	//Contructor de la clase
	public ControllerWindows(){
		super();
	}
	
	//Agregamos la ventana al diccionario
	//Recibiendo por parametros el nombre de la ventana y su ubicación o llamodo de
	//forma el nodo
	public void addWindows(String windowsname,Node screenFXML){
		Screens.put(windowsname, screenFXML);
	}
	
	//Optenomos la direccion del nodo
	public Node getWindows(String windowsoption){
		return Screens.get(windowsoption);
	}
	
	//Cargamos la ventana al espacio en blanco
	public Boolean loadScreen(String windowsname, String root){
		try {
			FXMLLoader myLoader=new FXMLLoader(getClass().getResource(root));
			Parent windowLoad=(Parent)myLoader.load();
			addWindows(windowsname, windowLoad);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("option=>"+windowsname+"<==>");
			return false;
		}
	}
	
	//Descargamos la ventana cargada para cargar otra nueva

	public boolean download(String windowsoption){
		if(Screens.remove(windowsoption)==null){
			System.out.println("No exites la ventana");
			return false;
		}
		else{
			return true;
		}
	}
	//Aqui activamos la vista de la interfaz
	public boolean showScreen(final String windowsoption)
	{
		System.out.println(Screens.get(windowsoption)+ "===");
		if(Screens.get(windowsoption)!=null)
		{
			final DoubleProperty opacity = opacityProperty();
			System.out.println("ingreso");
			if(!getChildren().isEmpty())
			{
			Timeline time=new Timeline(
					new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
					new KeyFrame(new Duration(1000), new EventHandler<ActionEvent>(){
						
						public void handle(ActionEvent event)
						{
							getChildren().remove(0);
							getChildren().add(0, Screens.get(windowsoption));
							Timeline input= new Timeline(
									new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
									new KeyFrame(new Duration(800), new KeyValue(opacity, 1.0)));
							input.play();
						}	
					}, new KeyValue(opacity, 0.0)));
					time.play();
			}else{
				setOpacity(0.0);
				getChildren().add(Screens.get(windowsoption));
				Timeline input=new Timeline(
						new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
						new KeyFrame(new Duration(2500), new KeyValue(opacity, 1.0)));
				input.play();
			}
			return true;
		}else{
			System.out.println("No se puede cargar el archivo");
			return false;
		}
	}
}
