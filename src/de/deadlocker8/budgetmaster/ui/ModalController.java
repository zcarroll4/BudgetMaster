package de.deadlocker8.budgetmaster.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ModalController
{
	@FXML private Label labelMessage;	
	
	public void init(Stage stage, String message)
	{
		labelMessage.setText(message);
		stage.setOnCloseRequest((e)->{
			e.consume();
		});
	}
}