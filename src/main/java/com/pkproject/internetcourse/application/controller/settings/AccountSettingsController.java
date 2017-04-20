package com.pkproject.internetcourse.application.controller.settings;

import com.pkproject.internetcourse.application.account.Account;
import com.pkproject.internetcourse.application.controller.admin.AdminMenuController;
import com.pkproject.internetcourse.application.controller.instructor.InstructorMenuController;
import com.pkproject.internetcourse.application.controller.trainee.TraineeMenuController;
import com.pkproject.internetcourse.application.datebase.Operation;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by dominikzaq on 06.01.2017.
 */
public class AccountSettingsController {
    private Stage  primaryMainStage;
    private Account account;
    private Operation operation;

    public AccountSettingsController(Account account) {
        this.account = account;
        operation = new Operation();
    }

    @FXML
    private TextField tfFullName;

    @FXML
    private TextField tfLogin;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfPassword;

    @FXML
    private Button btnBack;

    @FXML
    private Label lFullname;

    @FXML
    private Label lLogin;

    @FXML
    private Label lEmail;

    @FXML
    private Label lPassword;

    @FXML
    private TextField tfReTypePassword;

    @FXML
    public void initialize() {
        lFullname.setText(account.getFullname());
        lLogin.setText(account.getLogin());
        lEmail.setText(account.getEmail());
    }

    @FXML
    void changeEmail() throws SQLException {
        String email = tfEmail.getText().trim();
        if(email != "") {
            lEmail.setText(email);
            account = operation.updateEmail(account,email);
        }
    }

    @FXML
    void changeFullName() throws SQLException {
        String fullName = tfFullName.getText().trim();

        if(fullName != "") {
            lFullname.setText(fullName);
            account = operation.updateFullName(account, fullName);
        }
    }

    @FXML
    void changeLogin() throws SQLException {
        String login = tfLogin.getText().trim();

        if(login != "") {
            lLogin.setText(tfLogin.getText());
            account = operation.updateLogin(account, login);
        }
    }

    @FXML
    void changePassword() throws SQLException {
        String password = tfPassword.getText().trim();

        if(isNoEmpty()) {
            lPassword.setText(tfPassword.getText());
            account = operation.updatePassword(account, password);
        }
    }
    public boolean isNoEmpty() {
        return !(tfPassword.getText().trim().isEmpty() || tfReTypePassword.getText().trim().isEmpty());
    }
    @FXML
    void goToMenuScreen() throws IOException {


        if (account.getAccountType() == "Admin") {
            goToAdminMenuController("/fxml/admin/AdminMenuScreen.fxml");
        }

        if (account.getAccountType() == "Instructor") {
            goToInstructorMenuController("/fxml/instructor/InstructorMenuScreen.fxml");
        }

        if (account.getAccountType() == "Trainee") {
            goToTraineeMenuController("/fxml/trainee/TraineeMenuScreen.fxml");
        }


        primaryMainStage  = (Stage) btnBack.getScene().getWindow();
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

        primaryMainStage = (Stage) btnBack.getScene().getWindow();
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


        primaryMainStage = (Stage) btnBack.getScene().getWindow();
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


        primaryMainStage = (Stage) btnBack.getScene().getWindow();
        primaryMainStage.close();
    }
}
