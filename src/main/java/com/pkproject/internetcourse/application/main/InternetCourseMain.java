package com.pkproject.internetcourse.application.main;

import com.pkproject.internetcourse.application.datebase.DBCreate;
import com.pkproject.internetcourse.application.datebase.Operation;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;

/**
 * Created by dominikzaq on 31.10.2016.
 */
public class InternetCourseMain extends Application{

	public InternetCourseMain() throws SQLException {
		new DBCreate().createDB();
	}

    public static void main(String [] args) {
       launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(this.getClass().getResource("/fxml/MainScreen.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();


	}
}
