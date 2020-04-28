package org.oslomet;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.oslomet.ComponentClasses.*;
import org.oslomet.ComponentRegistry.*;
import org.oslomet.ComputerClasses.ComputerModel;
import org.oslomet.ComputerClasses.ComputerRegistry;
import org.oslomet.FileHandling.FileChooser;
import org.oslomet.FileHandling.FileOpenerJobj;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("viewConfiguration.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();

        Path path = Paths.get("Components.jobj");
        FileOpenerJobj.openJobj(path);

        makeDemoComputer("Demo computer 1", 0,0,0,0,0,0,0,0,0,0,0);
        makeDemoComputer("Demo computer 2", 1,1,1,1,1,1,1,1,1,1,1);
        makeDemoComputer("Demo computer 3", 2,2,2,2,2,2,2,2,2,2,2);
    }

    public static void main(String[] args) {
        launch();
    }

    private void makeDemoComputer(String computerName, int computerCaseArrayIndex, int CPUArrayIndex, int GPUArrayIndex, int RAMArrayIndex, int hardDriveArrayIndex,
    int motherboardArrayIndex, int PSUArrayIndex, int soundCardArrayIndex, int keyboardArrayIndex, int monitorArrayIndex, int mouseArrayIndex) {
        ComputerModel demoComputer = new ComputerModel(
                computerName,
                (ComputerCaseModel) ComputerCaseRegistry.returnArray().get(computerCaseArrayIndex),
                (CPUModel) CPURegistry.returnArray().get(CPUArrayIndex),
                (GPUModel) GPURegistry.returnArray().get(GPUArrayIndex),
                (RAMModel) RAMRegistry.returnArray().get(RAMArrayIndex),
                (HarddriveModel) HardDriveRegistry.returnArray().get(hardDriveArrayIndex),
                (MotherboardModel) MotherboardRegistry.returnArray().get(motherboardArrayIndex),
                (PSUModel) PSURegistry.returnArray().get(PSUArrayIndex),
                (SoundCardModel) SoundCardRegistry.returnArray().get(soundCardArrayIndex),
                (KeyboardModel) KeyboardRegistry.returnArray().get(keyboardArrayIndex),
                (MonitorModel) MonitorRegistry.returnArray().get(monitorArrayIndex),
                (MouseModel) MouseRegistry.returnArray().get(mouseArrayIndex),
                0,0
        );
        ComputerRegistry.addComputer(demoComputer);
    }

}