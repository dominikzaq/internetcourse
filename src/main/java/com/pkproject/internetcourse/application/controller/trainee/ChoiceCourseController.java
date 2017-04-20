package com.pkproject.internetcourse.application.controller.trainee;

import com.pkproject.internetcourse.application.account.Account;
import com.pkproject.internetcourse.application.controller.settings.AccountSettingsController;
import com.pkproject.internetcourse.application.dialogs.DialogsUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

/**
 * Created by dominikzaq on 14.11.2016.
 */
public class ChoiceCourseController {
    private Stage primaryMainStage;
    private Account account;
    public ChoiceCourseController(Account account) {
        this.account = account;
    }

    @FXML
    private RadioButton rbBasicLevel;

    @FXML
    private RadioButton rbAdvancedLevel;

    @FXML
    void searchData() {
        if(rbBasicLevel.isSelected()) {

        }

        if(rbAdvancedLevel.isSelected()) {

        }


    }

}
