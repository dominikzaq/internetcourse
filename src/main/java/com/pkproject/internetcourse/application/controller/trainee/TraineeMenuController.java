package com.pkproject.internetcourse.application.controller.trainee;

import java.io.IOException;
import java.util.Optional;

import com.pkproject.internetcourse.application.account.Account;
import com.pkproject.internetcourse.application.controller.controllerinterfaces.Controller;
import com.pkproject.internetcourse.application.controller.mail.MailController;
import com.pkproject.internetcourse.application.controller.settings.AccountSettingsController;
import com.pkproject.internetcourse.application.dialogs.DialogsUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Created by dominikzaq on 14.11.2016.
 */
public class TraineeMenuController implements Controller{
    private Stage primaryMainStage;
    private Account account;


    public TraineeMenuController(Account account) {
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


    @FXML
    void goToMail() throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/mail/MailScreen.fxml"));
        MailController controller = new MailController(account);
        loader.setController(controller);

        AnchorPane anchorPane = loader.load();
        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        primaryMainStage  = (Stage) btnLogout.getScene().getWindow();
        primaryMainStage.close();
    }


    @FXML
    void goToAccountSettings() throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/settings/AccountSettingsScreen.fxml"));
        AccountSettingsController controller = new AccountSettingsController(account);
        loader.setController(controller);

        AnchorPane anchorPane = loader.load();
        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();


        primaryMainStage  = (Stage) btnLogout.getScene().getWindow();
        primaryMainStage.close();
    }

    @Override
    public void changeController(Controller controller, String name) {

    }
}
