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
import org.oslomet.FileHandling.FileOpenerJobj;

import java.io.IOException;
import java.io.StreamCorruptedException;
import java.nio.file.NoSuchFileException;
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

        try {
            Path path = Paths.get("Components.jobj");
            FileOpenerJobj.openJobj(path);
            makeDemoComputer("Gaming computer", 0,0,0,0,17,19,0,0,0,0,0);
            makeDemoComputer("Budget computer", 15,13,10,19,0,0,14,10,17,17,18);
            makeDemoComputer("Office computer", 10,10,10,10,10,10,10,10,10,10,10);
        }
        catch (StreamCorruptedException sce) {
            //Prevents program from crashing if start-up-jobj-file is corrupted
        }
        catch (NoSuchFileException nsfe) {
            //Prevents program from crashing if start-up-jobj-file is removed
        }
        catch (IndexOutOfBoundsException ioobe) {
            //Prevents program from crashing if computer parts that doesn't exist are added to the demo computer
        }
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