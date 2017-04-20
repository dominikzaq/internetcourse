package com.pkproject.internetcourse.application.account;

/**
 * Created by dominikzaq on 05.12.2016.
 */
public class Instructor extends Account {

    public Instructor() {
        accountType = "Instructor";
        addressMainCountroller = "/fxml/instructor/InstructorMenuScreen.fxml";
    }
}
