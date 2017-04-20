package com.pkproject.internetcourse.application.dialogs;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.*;


/**
 * Created by dominikzaq on 13.12.2016.
 */
public class DialogsUtils {
    public static void DialogAboutApplication() {
        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle("ok");
        informationAlert.setHeaderText("git");
        informationAlert.setContentText("seriously");
        informationAlert.showAndWait();
    }

    public static Optional<ButtonType> exitWithProgramDialog() {
        Alert confirmationDialog = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationDialog.setTitle("exit with program");
        confirmationDialog.setHeaderText("do you really want to quit");
        Optional<ButtonType> result = confirmationDialog.showAndWait();
        return result;
    }

    public static Optional<ButtonType> logoutWithProgramDialog() {
        Alert confirmationDialog = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationDialog.setTitle("logout");
        confirmationDialog.setHeaderText("do you really want to logout");
        Optional<ButtonType> result = confirmationDialog.showAndWait();
        return result;
    }

}
