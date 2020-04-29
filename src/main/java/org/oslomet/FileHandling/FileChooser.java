package org.oslomet.FileHandling;

import javafx.stage.Stage;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileChooser {

    //Opens dialog for selection of file, returns path of selected file
    public static Path openJobjFile() {
        Stage frame = new Stage();
        javafx.stage.FileChooser fileChooser = new javafx.stage.FileChooser();
        fileChooser.setTitle("Open file");
        fileChooser.getExtensionFilters().addAll(
                new javafx.stage.FileChooser.ExtensionFilter("Jobj files", "*.jobj"));
        File selectedFile = fileChooser.showOpenDialog(frame);
        String path = selectedFile.getAbsolutePath();
        Path paths = Paths.get(path);
        return paths;
    }

    //Opens dialog for saving file, returns path of saved file
    public static Path saveJobjFile() {
        Stage frame = new Stage();
        javafx.stage.FileChooser fileChooser = new javafx.stage.FileChooser();
        fileChooser.setTitle("Save file");
        fileChooser.getExtensionFilters().addAll(
                new javafx.stage.FileChooser.ExtensionFilter("Jobj files", "*.jobj"));
        File selectedFile = fileChooser.showSaveDialog(frame);
        String path = selectedFile.getAbsolutePath();
        Path paths = Paths.get(path);
        return paths;
    }

    //Opens dialog for selection of file, returns path of selected file
    public static Path openTxtFile() {
        Stage frame = new Stage();
        javafx.stage.FileChooser fileChooser = new javafx.stage.FileChooser();
        fileChooser.setTitle("Open file");
        fileChooser.getExtensionFilters().addAll(
                new javafx.stage.FileChooser.ExtensionFilter("Csv files", "*.csv"));
        File selectedFile = fileChooser.showOpenDialog(frame);
        String path = selectedFile.getAbsolutePath();
        Path paths = Paths.get(path);
        return paths;
    }

    //Opens dialog for saving file, returns path of saved file
    public static Path saveTxtFile() {
        Stage frame = new Stage();
        javafx.stage.FileChooser fileChooser = new javafx.stage.FileChooser();
        fileChooser.setTitle("Save file");
        fileChooser.getExtensionFilters().addAll(
                new javafx.stage.FileChooser.ExtensionFilter("Csv files", "*.csv"));
        File selectedFile = fileChooser.showSaveDialog(frame);
        String path = selectedFile.getAbsolutePath();
        Path paths = Paths.get(path);
        return paths;
    }
}

