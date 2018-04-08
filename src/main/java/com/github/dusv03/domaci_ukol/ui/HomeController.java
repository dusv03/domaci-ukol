package com.github.dusv03.domaci_ukol.ui;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.github.dusv03.domaci_ukol.logika.Game;
import com.github.dusv03.domaci_ukol.logika.Word;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class HomeController extends GridPane {
	private Map<String, Word> tlacitka;
	private Game game;
	private List<Word> Words;
	private boolean hadani = false;
	
	@FXML private Button	button1;
	@FXML private Button  	button2;
	@FXML private Button  	button3;
	@FXML private Button  	button4;
	@FXML private Button  	button5;
	@FXML private Button  	button6;
	@FXML private Tooltip  	tooltip1;
	@FXML private Tooltip  	tooltip2;
	@FXML private Tooltip  	tooltip3;
	@FXML private Tooltip  	tooltip4;
	@FXML private Tooltip  	tooltip5;
	@FXML private Tooltip  	tooltip6;
	@FXML private ImageView  	picture1;
	@FXML private ImageView  	picture2;
	@FXML private ImageView 	picture3;
	@FXML private ImageView 	picture4;
	@FXML private ImageView		picture5;
	@FXML private ImageView  	picture6;
	@FXML private Button  	button0;
	@FXML private TextArea	textvystup;

	
	public void odesliPrikaz() {
		textvystup.clear();
		String odpoved = 	"Správné odpovědi: " + game.getDobre() + "\n" +
							"Špatné odpovědi›: " + game.getSpatne();
		textvystup.appendText(odpoved);
	}
	
public void inicializuj(Game game) {
	this.game = game;
	tlacitka = new HashMap<String, Word>();
	Words = game.getSlovicka();
	
	tlacitka.put(button1.getId(), Words.get(0));
	String URL = Words.get(0).getURL();
	Image obr = new Image (getClass().getResourceAsStream(URL));
	picture1.setImage(obr);
	tooltip1.setText(tlacitka.get("button1").getCZ());
	
	
	tlacitka.put(button2.getId(), Words.get(1));
	URL = Words.get(1).getURL();
	obr = new Image (getClass().getResourceAsStream(URL));
	picture2.setImage(obr);
	tooltip2.setText(tlacitka.get("button2").getCZ());
	
	tlacitka.put(button3.getId(), Words.get(2));
	URL = Words.get(2).getURL();
	obr = new Image (getClass().getResourceAsStream(URL));
	picture3.setImage(obr);
	tooltip3.setText(tlacitka.get("button3").getCZ());
	
	tlacitka.put(button4.getId(), Words.get(3));
	URL = Words.get(3).getURL();
	obr = new Image (getClass().getResourceAsStream(URL));
	picture4.setImage(obr);
	tooltip4.setText(tlacitka.get("button4").getCZ());
	
	tlacitka.put(button5.getId(), Words.get(4));
	URL = Words.get(4).getURL();
	obr = new Image (getClass().getResourceAsStream(URL));
	picture5.setImage(obr);
	tooltip5.setText(tlacitka.get("button5").getCZ());
	
	tlacitka.put(button6.getId(), Words.get(5));
	URL = Words.get(5).getURL();
	obr = new Image (getClass().getResourceAsStream(URL));
	picture6.setImage(obr);
	tooltip6.setText(tlacitka.get("button6").getCZ());
	
	
	
}
	@FXML public void clickguess(ActionEvent arg0) {
		if (!hadani) {
			game.vyberSlovo();
			String word = game.getHadane();
			button0.setText(word);
			hadani = true;
		}
	}
	
	@FXML public void guess(ActionEvent arg0) {
		if (hadani) {
			String hadane = ((Node) arg0.getTarget()).getId();
			hadane = tlacitka.get(hadane).getEN();
			if (button0.getText().equals(hadane)) {
				game.setSkore(hadane);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Vyhodnocení odpovědi");
				alert.setHeaderText(null);
				alert.setContentText("Hádané slovo je správně!!!");
				alert.showAndWait();
			}
			else 
			{	
				game.setSkore(hadane);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Vyhodnocení odpovědi");
				alert.setHeaderText("Hádané slovo je špatně!!!");
				alert.showAndWait();
			}
		hadani = false;
		button0.setText("Hádej");
		this.odesliPrikaz();
		}
	}
	
	public void novahra() {
		hadani = false;
		button0.setText("Hádej");
		game.vynulovat();
		textvystup.clear();
	}
	
	public void konechry() {
		Platform.exit();	
	}
}