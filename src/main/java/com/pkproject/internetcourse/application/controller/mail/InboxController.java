package com.pkproject.internetcourse.application.controller.mail;

import com.pkproject.internetcourse.application.account.Account;
import com.pkproject.internetcourse.application.dialogs.DialogsUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

/**
 * Created by dominikzaq on 14.11.2016.
 */
public class InboxController {
    private Stage primaryMainStage;

    private Account account;


    public void setAccount(Account account) {
        this.account = account;
    }

    @FXML
    private Button btnLogout;

    @FXML
    public void goToMainScreen() throws IOException {
        Optional<ButtonType> result = DialogsUtils.logoutWithProgramDialog();

        if(result.get() == ButtonType.APPLY.OK) {
            Parent root = FXMLLoader.load(this.getClass().getResource("/fxml/MainScreen.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

            primaryMainStage = (Stage) btnLogout.getScene().getWindow();
            primaryMainStage.close();
        }
    }
}
