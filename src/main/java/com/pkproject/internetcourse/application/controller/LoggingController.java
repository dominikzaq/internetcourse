package com.pkproject.internetcourse.application.controller;

import com.pkproject.internetcourse.application.account.Account;
import com.pkproject.internetcourse.application.account.Admin;
import com.pkproject.internetcourse.application.account.Instructor;
import com.pkproject.internetcourse.application.account.Trainee;
import com.pkproject.internetcourse.application.controller.admin.AdminMenuController;
import com.pkproject.internetcourse.application.controller.instructor.InstructorMenuController;
import com.pkproject.internetcourse.application.controller.controllerinterfaces.Controller;
import com.pkproject.internetcourse.application.controller.trainee.TraineeMenuController;
import com.pkproject.internetcourse.application.datebase.Operation;
import com.pkproject.internetcourse.application.menu.AdminController;
import com.pkproject.internetcourse.application.menu.Context;
import com.pkproject.internetcourse.application.menu.InstructorController;
import com.pkproject.internetcourse.application.menu.TraineeController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class LoggingController implements Controller{

    private Account account;
    private Operation operation;
    private  boolean checkLogging;
    private Context context;
    private  Stage primaryMainStage;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnLogin;

    @FXML
    private TextField tfUserName;

    @FXML
    private TextField pfPassword;

    @FXML
    private ToggleGroup accountGroup;

    @FXML
    private RadioButton rbAdministrator;

    @FXML
    private RadioButton rbTrainee;

    @FXML
    private RadioButton rbInstructor;

    public LoggingController() {
        operation = new Operation();
        context = null;
    }

    @FXML
    public void goToMainScreen() throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/fxml/MainScreen.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        primaryMainStage = (Stage) btnBack.getScene().getWindow();
        primaryMainStage.close();
    }

    @FXML
    public void goToMenuScreen() throws IOException, SQLException {
        account.setLogin(tfUserName.getText().trim());
        account.setPassword(pfPassword.getText().trim());

        if(isNoEmpty()) {
            if (rbAdministrator.isSelected()) {
                account = new Admin();
                context = new Context(new AdminController());
            }

            if (rbInstructor.isSelected()) {
                account = new Instructor();
                context = new Context(new InstructorController());
            }

            if (rbTrainee.isSelected()) {
                account = new Trainee();
                context = new Context(new TraineeController());
            }


            Operation operation = new Operation();
            checkLogging =  operation.logging(account);

            if(checkLogging) {
                changeController(context.menuController(account), account.getAddressMainCountroller());
            }
        }
    }


    public boolean isNoEmpty() {
        return !(tfUserName.getText().trim().isEmpty() || pfPassword.getText().trim().isEmpty());
    }


    @Override
    public void changeController(Controller controller, String controllerAddress) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(controllerAddress));
        loader.setController(controller);
        AnchorPane anchorPane = loader.load();
        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        primaryMainStage = (Stage) btnLogin.getScene().getWindow();
        primaryMainStage.close();
    }
}
