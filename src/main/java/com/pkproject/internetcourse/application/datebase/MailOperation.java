package com.pkproject.internetcourse.application.datebase;

import com.pkproject.internetcourse.application.account.Account;
import com.pkproject.internetcourse.application.account.Trainee;
import com.pkproject.internetcourse.application.mail.Mail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by dominikzaq on 21.12.2016.
 */
public class MailOperation {
    private DBConnect dbConnect;
    private PreparedStatement preparedStatement;
    private Connection connection;
    private String query;

    public MailOperation() {
        dbConnect = new DBConnect();
        connection = dbConnect.getConnection();
    }

    public ArrayList<String> listMail() throws SQLException {
        ArrayList<String> mails = new ArrayList<>();

        query = "select daneosobiste.Email from `internetcourse`.`konto` " +
                "join `internetcourse`.`daneosobiste` " +
                "on konto.idKonto = daneosobiste.idKonto";

        preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()) {
            mails.add(resultSet.getString("Email"));
        }

        return mails;
    }

    public void insertMessage(Mail mail, Account account) throws SQLException {
        query = "INSERT INTO `internetcourse`." +
                "`wiadomosc` (`idKonto`, `nadawca`, `odbiorca`, `tematWiadomosci`, `trescWiadomosci`) " +
                "VALUES (?, ?, ?, ?, ?)";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, account.getIdAccount());
        preparedStatement.setString(2, account.getEmail());
        preparedStatement.setString(3, mail.getEmail());
        preparedStatement.setString(4, mail.getSubject());
        preparedStatement.setString(5, mail.getTextMessage());
        preparedStatement.executeUpdate();
    }
}
