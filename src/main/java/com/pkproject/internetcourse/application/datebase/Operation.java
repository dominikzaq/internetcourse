package com.pkproject.internetcourse.application.datebase;

import com.pkproject.internetcourse.application.account.Account;
import com.pkproject.internetcourse.application.account.Instructor;
import com.pkproject.internetcourse.application.account.Trainee;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by dominikzaq on 21.12.2016.
 */
public class Operation {
    private DBConnect dbConnect;
    private PreparedStatement preparedStatement;
    private Connection connection;
    private String query;

    public Operation() {
        dbConnect = new DBConnect();
        connection = dbConnect.getConnection();
    }


    public void lockAccount(int id) throws SQLException {
        query = " update `internetcourse`.`konto` SET BlokadaKonta=true where idKonto= 2";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
    }

    public void unlockAccount(int id) throws SQLException {
        query = " update `internetcourse`.`konto` SET BlokadaKonta=false where idKonto=" + id;
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
    }



    public void registration(Account account) throws SQLException {
        query = "INSERT INTO `internetcourse`.`konto` (`Login`, `Haslo`, `RodzajKonta`, `BlokadaKonta`) VALUES (?, ?, ?, ?);";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, account.getLogin());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.setString(3, account.getAccountType());
            preparedStatement.setBoolean(4, account.getBlockAccount());
            preparedStatement.execute();

            query = "select konto.idKonto from `internetcourse`.`konto` where Login='" + account.getLogin() + "'";
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            int id = 0;
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }

            query = "INSERT INTO `internetcourse`.`daneOsobiste` (`idKonto`, `NazwaUzytkownika`, `Email`) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, account.getFullname());
            preparedStatement.setString(3, account.getEmail());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (connection != null) {
                connection.close();
            }
        }

    }

    public boolean logging(Account account) throws SQLException {

        boolean result = false;

        query=  "SELECT * FROM `internetcourse`.`konto` as k\n" +
                "join `internetcourse`.`daneosobiste` as do on  do.idKonto = k.idKonto\n" +
                "where k.Login=? AND k.Haslo=? AND k.BlokadaKonta=? AND k.RodzajKonta=?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, account.getLogin());
        preparedStatement.setString(2, account.getPassword());
        preparedStatement.setBoolean(3, false);
        preparedStatement.setString(4, account.getAccountType());

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            account.setIdAccount(resultSet.getInt("idKonto"));
            account.setFullname(resultSet.getString("NazwaUzytkownika"));
            account.setEmail((resultSet.getString("Email")));
            result = true;
        }

        System.out.println("nazwa uzytkownika " + account.getFullname());
        System.out.println("email uzytkownika " + account.getEmail());

        return result;
    }


    public Account updateLogin(Account account, String login) throws SQLException {
        query = "update `internetcourse`.`konto` SET Login='" + login + "' where idKonto=" + account.getIdAccount();
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.execute(query);
        account.setLogin(login);
        return account;
    }

    public Account updateFullName(Account account, String userName) throws SQLException {
        query = "update `internetcourse`.`daneosobiste`\n" +
                "join `internetcourse`.`konto` on daneosobiste.idKonto = konto.idKonto\n" +
                "set daneosobiste.NazwaUzytkownika = '"+ userName +"'\n" +
                "where konto.idKonto=" + account.getIdAccount();
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.execute(query);
        account.setFullname(userName);
        return account;
    }

    public Account updateEmail(Account account, String email) throws SQLException {
        query = "update `internetcourse`.`daneosobiste`\n" +
                "join `internetcourse`.`konto` on daneosobiste.idKonto = konto.idKonto\n" +
                "set \n daneosobiste.Email = '"+ email +"'\n" +
                "where konto.idKonto=" + account.getIdAccount();
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.execute(query);
        account.setEmail(email);
        return  account;
    }

    public Account updatePassword(Account account, String password) throws SQLException {
        query = "update `internetcourse`.`konto` SET Haslo='"+ password +"' where idKonto=" + account.getIdAccount();
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.execute(query);
        account.setPassword(password);
        return account;
    }

    public ArrayList<Account> instructorAccountList() throws SQLException {
        ArrayList<Account> accounts = new ArrayList<Account>();

        query = "SELECT k.idKonto,do.NazwaUzytkownika, k.BlokadaKonta FROM `internetcourse`.`konto` as k \n" +
                "join `internetcourse`.`daneosobiste` as do on  do.idKonto = k.idKonto\n" +
                "where k.RodzajKonta='Instructor'";

        preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()) {
            Account account = new Trainee();
            account.setIdAccount(resultSet.getInt("idKonto"));
            account.setBlockAccount(resultSet.getBoolean("BlokadaKonta"));
            account.setFullname(resultSet.getString("NazwaUzytkownika"));
            accounts.add(account);
        }

        return accounts;
    }

    public ArrayList<Account> traineeAccountList() throws SQLException {
        ArrayList<Account> accounts = new ArrayList<>();

        query =  "SELECT k.idKonto,do.NazwaUzytkownika, k.BlokadaKonta FROM `internetcourse`.`konto` as k \n" +
                "join `internetcourse`.`daneosobiste` as do on  do.idKonto = k.idKonto\n" +
                "where k.RodzajKonta='Trainee'";
        preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()) {
            Account account = new Trainee();
            account.setIdAccount(resultSet.getInt("idKonto"));
            account.setBlockAccount(resultSet.getBoolean("BlokadaKonta"));
            account.setFullname(resultSet.getString("NazwaUzytkownika"));
            accounts.add(account);
        }

        return accounts;
    }

    public void deleteAccount(Account account) {
        query = "";
    }


}
