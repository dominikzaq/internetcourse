package com.pkproject.internetcourse.application.controller;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by dominikzaq on 01.11.2016.
 */
public class InformationController {
    private Stage primaryMainStage;

    @FXML
    private Button btnBack;

    @FXML
    public void goToMainScreen() throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/fxml/MainScreen.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        primaryMainStage  = (Stage) btnBack.getScene().getWindow();
        primaryMainStage.close();
    }

}
