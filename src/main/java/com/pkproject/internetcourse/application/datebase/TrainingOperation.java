package com.pkproject.internetcourse.application.datebase;

import com.pkproject.internetcourse.application.account.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by dominikzaq on 13.01.2017.
 */
public class TrainingOperation {
    private DBConnect dbConnect;
    private PreparedStatement preparedStatement;
    private Connection connection;
    private String query;

    public TrainingOperation() {
        dbConnect = new DBConnect();
        connection = dbConnect.getConnection();
    }

    public void insertTest(Account account, String name) throws SQLException {
        query = " update `internetcourse`.`konto` SET BlokadaKonta=true where idKonto= 2";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.execute();
    }

    public void insertCourse(Account account, String name) {

    }

}
