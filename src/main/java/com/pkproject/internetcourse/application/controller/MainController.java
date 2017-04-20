package com.pkproject.internetcourse.application.controller;


import com.pkproject.internetcourse.application.dialogs.DialogsUtils;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class MainController {
    private Stage primaryMainStage;

    @FXML
    private Button btnLogging;

    @FXML
    private Button btnRegistration;

    @FXML
    private Button btnInformation;

	@FXML
	public void goToLogging() throws IOException {

        Parent root = FXMLLoader.load(this.getClass().getResource("/fxml/LoggingScreen.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        primaryMainStage = (Stage) btnLogging.getScene().getWindow();
        primaryMainStage.close();
	}
	
	@FXML
	public void goToRegistration() throws IOException{
        Parent root = FXMLLoader.load(this.getClass().getResource("/fxml/RegistrationScreen.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        primaryMainStage = (Stage) btnRegistration.getScene().getWindow();
        primaryMainStage.close();
	}
	
	@FXML
	public void goToInformation() throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/fxml/InformationScreen.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        primaryMainStage = (Stage) btnInformation.getScene().getWindow();
        primaryMainStage.close();
	}
	
	@FXML
	public void exitWithProgram() {
        Optional<ButtonType> result = DialogsUtils.exitWithProgramDialog();

        if(result.get() == ButtonType.APPLY.OK) {
            Platform.exit();
        }

	}

}
