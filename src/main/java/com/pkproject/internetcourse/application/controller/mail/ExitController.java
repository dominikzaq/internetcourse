package com.pkproject.internetcourse.application.controller.mail;

import com.pkproject.internetcourse.application.account.Account;
import com.pkproject.internetcourse.application.controller.admin.AdminMenuController;
import com.pkproject.internetcourse.application.controller.instructor.InstructorMenuController;
import com.pkproject.internetcourse.application.controller.trainee.TraineeMenuController;
import com.pkproject.internetcourse.application.dialogs.DialogsUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

/**
 * Created by dominikzaq on 14.11.2016.
 */
public class ExitController {
    private Stage primaryMainStage;
    private Account account;


    public void setAccount(Account account) {
        this.account = account;
    }

    @FXML
    public Button btnExit;

    @FXML
    void exitWithMail() throws IOException {


        if (account.getAccountType() == "Admin") {
            goToAdminMenuController("/fxml/admin/AdminMenuScreen.fxml");
        }

        if (account.getAccountType() == "Instructor") {
            goToInstructorMenuController("/fxml/instructor/InstructorMenuScreen.fxml");
        }

        if (account.getAccountType() == "Trainee") {
            goToTraineeMenuController("/fxml/trainee/TraineeMenuScreen.fxml");
        }


        primaryMainStage  = (Stage) btnExit.getScene().getWindow();
        primaryMainStage.close();
    }



    public void goToAdminMenuController(String menuController) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(menuController));
        AdminMenuController controller = new AdminMenuController(account);

        loader.setController(controller);

        AnchorPane anchorPane = loader.load();
        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        primaryMainStage = (Stage) btnExit.getScene().getWindow();
        primaryMainStage.close();
    }

    public void goToInstructorMenuController(String menuController) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(menuController));
        InstructorMenuController controller = new InstructorMenuController(account);

        loader.setController(controller);

        AnchorPane anchorPane = loader.load();
        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();


        primaryMainStage = (Stage) btnExit.getScene().getWindow();
        primaryMainStage.close();
    }




    public void goToTraineeMenuController(String menuController) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(menuController));
        TraineeMenuController controller = new TraineeMenuController(account);

        loader.setController(controller);
        AnchorPane anchorPane = loader.load();
        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();


        primaryMainStage = (Stage) btnExit.getScene().getWindow();
        primaryMainStage.close();
    }
}
