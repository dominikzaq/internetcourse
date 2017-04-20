package com.pkproject.internetcourse.application.controller;



import com.pkproject.internetcourse.application.account.Account;
import com.pkproject.internetcourse.application.account.Instructor;
import com.pkproject.internetcourse.application.account.Trainee;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import com.pkproject.internetcourse.application.datebase.Operation;

public class RegistrationController {
    private Account account;
    private Stage primaryMainStage;

    @FXML
    private TextField tfLogin;

    @FXML
    private TextField tfFullName;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfPassword;

    @FXML
    private TextField tfReTypePassword;

    @FXML
    private RadioButton rbTrainee;

    @FXML
    private RadioButton rbInstructor;

    @FXML
    private Button btnBack;

    @FXML
    private Button signUp;

    @FXML
    public void goToMainScreen() throws IOException, SQLException {

        Operation operation = new Operation();

        if(isValidData()) {
            if(rbTrainee.isSelected()) {
                account = new Trainee();
            }
            else {
                account = new Instructor();
            }

            account.setLogin(tfLogin.getText());
            account.setPassword(tfPassword.getText());
            account.setEmail(tfEmail.getText());
            account.setFullname(tfFullName.getText());
            account.setBlockAccount(false);
            operation.registration(account);
       }


        Parent root = FXMLLoader.load(this.getClass().getResource("/fxml/MainScreen.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        primaryMainStage = (Stage) btnBack.getScene().getWindow();
        primaryMainStage.close();

    }


    private boolean isValidData() {
        boolean emptyString = true;

        if ((tfLogin.getText().isEmpty() ||
            tfFullName.getText().isEmpty() ||
            tfEmail.getText().isEmpty() ||
            tfPassword.getText().isEmpty() ||
            tfReTypePassword.getText().isEmpty()) && comparePassword()) {
            System.out.println("correct data");
            emptyString = false;
        }

        return emptyString;
    }

    private boolean comparePassword() {
        String password = tfPassword.getText();
        String rePassword = tfReTypePassword.getText();

        return password.matches(rePassword);
    }

}
