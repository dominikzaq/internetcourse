package com.pkproject.internetcourse.application.controller.mail;

import com.pkproject.internetcourse.application.account.Account;
import com.pkproject.internetcourse.application.controller.admin.ManageAccountController;
import com.pkproject.internetcourse.application.datebase.MailOperation;
import com.pkproject.internetcourse.application.dialogs.DialogsUtils;
import com.pkproject.internetcourse.application.mail.Mail;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by dominikzaq on 14.11.2016.
 */
public class MessageController {
    private Stage primaryMainStage;
    private Account account;
    private Mail mail = new Mail();

    public void setAccount(Account account) {
        this.account = account;
    }

    @FXML
    private TextArea tfText;

    @FXML
    private TextField tfSubject;

    @FXML
    private Button btnSend;

    @FXML
    private ChoiceBox<KeyValuePair> chbEmail;
    ObservableList<KeyValuePair> keyValue;

    @FXML
    public void initialize() {
        keyValue = FXCollections.observableArrayList();
        chbEmail.setItems(keyValue);



     /*   ArrayList<KeyValuePair> keyValuePairs = new ArrayList<>();

        for(int i = 0; i < accounts.size(); i++) {
            KeyValuePair keyValuePair = new ManageAccountController.KeyValuePair(accounts.get(i).getIdAccount(), accounts.get(i).getFullname());
            keyValuePairs.add(keyValuePair);
        }

        keyValue.addAll(keyValuePairs);
        data.addAll(items);*/
    }

    @FXML
    void cancelOperation() {
        tfText.clear();
        tfSubject.clear();
    }

    @FXML
    void sendMessage() throws SQLException {
       /* if(tfSubject.getText().trim() != "" && tfText.getText().trim() != "" &&  !chbEmail.getSelectionModel().isEmpty()) {
            mail.setEmail(chbEmail.getValue());
            mail.setSubject(tfSubject.getText().trim());
            mail.setTextMessage(tfText.getText().trim());

            MailOperation mailOperation = new MailOperation();
            mailOperation.insertMessage(mail, account);
        }*/
    }


    public class KeyValuePair {
        private final int key;
        private final String value;
        public KeyValuePair(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public int getKey()   {    return key;    }

        public String toString() {    return value;  }
    }
}
