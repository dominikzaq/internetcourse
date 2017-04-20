package com.pkproject.internetcourse.application.account;

/**
 * Created by dominikzaq on 05.12.2016.
 */
public class Admin extends Instructor{

    public Admin() {
        accountType = "Admin";
        addressMainCountroller = "/fxml/admin/AdminMenuScreen.fxml";
    }


    public void manageAccounts() {

    }
}
