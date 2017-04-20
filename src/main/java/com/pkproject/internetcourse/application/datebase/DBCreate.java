package com.pkproject.internetcourse.application.datebase;

import java.sql.*;
import java.util.GregorianCalendar;

/**
 * Created by dominikzaq on 12.12.2016.
 */
public class DBCreate {
    private DBConnect dbConnect;
    private PreparedStatement preparedStatement;
    private Connection connection;
    private String query;

    public DBCreate() {
        dbConnect = new DBConnect();
    }

    public void createDB() throws SQLException {
        connection = dbConnect.getConnection();

        try {
            query = "CREATE DATABASE IF NOT EXISTS internetcourse DEFAULT CHARACTER SET utf8 " +
                    "DEFAULT COLLATE utf8_polish_ci";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();

            query = "CREATE TABLE IF NOT EXISTS `internetcourse`.`Konto` \n" +
                    "(\t`idKonto` INT NOT NULL AUTO_INCREMENT ,\n" +
                    "\t`Login` VARCHAR(45) NOT NULL ,\n" +
                    "\t`Haslo` VARCHAR(45) NOT NULL , \n" +
                    "\t`RodzajKonta` ENUM('Admin','Instructor','Trainee'), \n" +
                    "\t`BlokadaKonta` BOOLEAN NOT NULL ,\n" +
                    "\t`DataLogowania` DATE  NULL ,\n" +
                    " \tPRIMARY KEY (`idKonto`)\n" +
                    ");";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();

            query = "CREATE TABLE IF NOT EXISTS `internetcourse`.`DaneOsobiste` \n" +
                    "(`idDaneOsobiste` INT NOT NULL AUTO_INCREMENT ,\n" +
                    "`idKonto` INT NOT NULL ,\n" +
                    "`NazwaUzytkownika` VARCHAR(45) NOT NULL,\n" +
                    "`Email` VARCHAR(45) NOT NULL , \n" +
                    "PRIMARY KEY (`idDaneOsobiste`),\n" +
                    "FOREIGN KEY (`idKonto`) REFERENCES Konto(`idKonto`));";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();

            query = "CREATE TABLE IF NOT EXISTS `internetcourse`.`Wiadomosc` \n" +
                    "(\t`idWiadomosc` INT NOT NULL AUTO_INCREMENT ,\n" +
                    "\t`idKonto` INT NOT NULL ,\n" +
                    "\t`nadawca` VARCHAR(45) NOT NULL , \n" +
                    "\t`odbiorca` VARCHAR(45) NOT NULL , \n" +
                    "\t`tematWiadomosci` VARCHAR(45) NOT NULL , \n" +
                    "\t`trescWiadomosci` TEXT(45) NOT NULL , \n" +
                    "\tPRIMARY KEY (`idWiadomosc`),\n" +
                    "\tFOREIGN KEY (`idKonto`) REFERENCES Konto(`idKonto`)\n" +
                    ");";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();

            query = "CREATE TABLE IF NOT EXISTS `internetcourse`.`Kurs` \n" +
                    "(\t`idKurs` INT NOT NULL AUTO_INCREMENT ,\n" +
                    "\t`nazwaKursu` VARCHAR(45) NOT NULL , \n" +
                    "\t`poziomKursu` VARCHAR(45) NOT NULL , \n" +
                    "\t`tematKursu` VARCHAR(45) NOT NULL , \n" +
                    "\t`trescKursu` TEXT(45) NOT NULL , \n" +
                    "\tPRIMARY KEY (`idKurs`)\n" +
                    ");";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();

            query = "CREATE TABLE IF NOT EXISTS `internetcourse`.`Wynik` \n" +
                    "(\t`idWynik` INT NOT NULL AUTO_INCREMENT ,\n" +
                    "\t`nazwaTestu` VARCHAR(45) NOT NULL , \n" +
                    "\t`nazwaUzytkownika` VARCHAR(45) NOT NULL , \n" +
                    "\t`iloscPunktow` VARCHAR(45) NOT NULL ,\n" +
                    "\t`data` DATETIME NOT NULL,\n" +
                    "\tPRIMARY KEY (`idWynik`)\n" +
                    ");\n";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();

            query = "CREATE TABLE IF NOT EXISTS `internetcourse`.`Test` \n" +
                    "(\t`idTest` INT NOT NULL AUTO_INCREMENT ,\n" +
                    "\t`idKurs` INT NOT NULL ,\n" +
                    "\t`kategoria` VARCHAR(45) NOT NULL , \n" +
                    "\t`nazwaTestu` VARCHAR(45) NOT NULL , \n" +
                    "\t`autorTestu` VARCHAR(45) NOT NULL ,\n" +
                    "\t`iloscPytan` VARCHAR(45) NOT NULL ,\n" +
                    "\t`poziomTestu` VARCHAR(45) NOT NULL ,\n" +
                    "\tPRIMARY KEY (`idTest`),\n" +
                    "\tFOREIGN KEY (`idKurs`) REFERENCES Kurs(`idKurs`)\n" +
                    ");\n";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();

            query = "CREATE TABLE IF NOT EXISTS `internetcourse`.`Pytanie` \n" +
                    "(\t`idPytanie` INT NOT NULL AUTO_INCREMENT ,\n" +
                    "\t`idTest` INT NOT NULL ,\n" +
                    "\t`tresc` VARCHAR(45) NOT NULL , \n" +
                    "\t`odpowiedza` VARCHAR(45) NOT NULL , \n" +
                    "\t`odpowiedzb` VARCHAR(45) NOT NULL ,\n" +
                    "\t`odpowiedzc` VARCHAR(45) NOT NULL ,\n" +
                    "\t`odpowiedzd` VARCHAR(45) NOT NULL ,\n" +
                    "\t`prawidlowaOdpowiedz` VARCHAR(45) NOT NULL ,\n" +
                    "\t`liczbaPunktow` VARCHAR(45) NOT NULL ,\n" +
                    "\tPRIMARY KEY (`idPytanie`),\n" +
                    "\tFOREIGN KEY (`idTest`) REFERENCES Test(`idTest`)\n" +
                    ");\n";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();

            query = "CREATE TABLE IF NOT EXISTS `internetcourse`.`RozwiazanyTest` \n" +
                    "(\t`idKonto` INT NOT NULL ,\n" +
                    "\t`idTest` INT NOT NULL ,\n" +
                    "\t`idWynik` INT NOT NULL ,\n" +
                    "FOREIGN KEY (`idKonto`) REFERENCES Konto(`idKonto`),\n" +
                    "FOREIGN KEY (`idTest`) REFERENCES Test(`idTest`),\n" +
                    "FOREIGN KEY (`idWynik`) REFERENCES Wynik(`idWynik`)\n" +
                    ");\n";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();

            insertIntoDataBase();
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

    public void insertIntoDataBase() throws SQLException {
        query = "INSERT INTO `internetcourse`.`konto` (`idKonto`, `Login`, `Haslo`, `RodzajKonta`, `BlokadaKonta`, `DataLogowania`) " +
                "VALUES (1, 'admin', 'admin', 'Admin', '0', NULL)" +
                "ON DUPLICATE KEY UPDATE idKonto='1' AND Login='admin' AND Haslo='admin'";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();


        query = "INSERT INTO `internetcourse`.`daneOsobiste` (`idDaneOsobiste`,`idKonto`, `NazwaUzytkownika`, `Email`) " +
                "VALUES (1, (select konto.idKonto from `internetcourse`.`konto` where Login LIKE 'admin'), 'DominikKieltyka', 'dominikieltyka@wp.pl')" +
                "ON DUPLICATE KEY UPDATE idDaneOsobiste='1' AND NazwaUzytkownika='DominikKieltyka' AND Email='dominikieltyka@wp.pl'";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();



        /*query = "INSERT INTO `internetcourse`.`konto` (`idKonto`, `Login`, `Haslo`, `RodzajKonta`, `BlokadaKonta`, `DataLogowania`) " +
                "VALUES (2, 'damian', 'damian', 'Instructor', '0', NULL)" +
                "ON DUPLICATE KEY UPDATE idKonto='2' AND Login='damian' AND Haslo='damian'";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();


        query = "INSERT INTO `internetcourse`.`daneOsobiste` (`idDaneOsobiste`,`idKonto`, `NazwaUzytkownika`, `Email`) " +
                "VALUES (2, (select konto.idKonto from `internetcourse`.`konto` where Login LIKE 'damian'), 'DamianSmigielski', 'DamianSmigielski')" +
                "ON DUPLICATE KEY UPDATE idDaneOsobiste='2' AND NazwaUzytkownika='DamianSmigielski' AND Email='damian@wp.pl'";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();*/
    }
}
