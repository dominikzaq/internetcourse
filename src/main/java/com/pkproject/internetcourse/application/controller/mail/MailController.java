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
public class MailController {
    private Account account;
    private Stage primaryMainStage;

    @FXML
    private ExitController exitController;

    public MailController(Account account) {
        this.account = account;
    }

    @FXML
    public void initialize() {
        exitController.setAccount(account);
    }
}
