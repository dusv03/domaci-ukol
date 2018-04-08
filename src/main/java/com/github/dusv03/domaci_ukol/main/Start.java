package com.github.dusv03.domaci_ukol.main;

import com.github.dusv03.domaci_ukol.logika.Game;
import com.github.dusv03.domaci_ukol.ui.HomeController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Start extends Application{

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/com/github/dusv03/domaci_ukol/ui/Mainwindow.fxml"));    	
    	Parent root = loader.load();

    	HomeController controller = loader.getController(); 	
    	Game hra = new Game();
    	controller.inicializuj(hra);

    	primaryStage.setScene(new Scene(root));
    	primaryStage.show();
    	primaryStage.setTitle("Aplikace pro výuku angličtiny");
		
	}
}
