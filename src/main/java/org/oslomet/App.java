package org.oslomet;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {

    //private static Scene scene;

    List<String> confArray3 = new ArrayList<String>();

    @Override
    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("editConfiguration.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        /*
        scene = new Scene(loadFXML("primary"));
        stage.setScene(scene);
        stage.show();

         */
    }
/*
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

 */



    public static void main(String[] args) {
        launch();
    }

}