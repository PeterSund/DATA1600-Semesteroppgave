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

import java.io.IOException;

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

        ComputerCaseModel computerCase = new ComputerCaseModel("CAS-54", "CompCasesInc", 400, 5, "20x20x10", "Blue");
        CPUModel cpu = new CPUModel("X2432", "Hans", 40.0, 20.0, 5.0, 4);
        GPUModel gpu = new GPUModel("Y692", "Hans", 50.0, 10.0, 4.0, 512);
        HarddriveModel hdd = new HarddriveModel("GigaDrive", "Hans",100.0, 14.0, "SSD", 400);
        KeyboardModel keyboard = new KeyboardModel("KeyMaster32", "Hans", 20.0, 1.0, "Office", "NOR", "Yes");
        KeyboardModel testKey = new KeyboardModel("Keymaster40", "ZakaBiz", 200.50, 10.5, "Dritbra", "Norsk","Yes");
        MonitorModel monitor = new MonitorModel("LCD-343", "Hans", 10.5, 5.5, 21);
        MotherboardModel motherboard = new MotherboardModel("MB360", "Hans", 12.0, 10.0, "ATX");
        SoundCardModel sc1 = new SoundCardModel("SuperSound", "Logitech", 499, 20, "yest", "nein");
        RAMModel RAM1 = new RAMModel("X-Series", "Acer", 1000, 25, 300, 400);
        PSUModel PSU1 = new PSUModel("C-F3", "Dell", 200, 40, 500);
        MouseModel Mouse1 = new MouseModel("7D", "Logitech", 300, 1, "Gaming", "INGEN TRÅD");

        ComputerCaseModel computerCase2 = new ComputerCaseModel("CAS-01", "CompCasesInc", 400, 5, "20x20x10", "Blue");
        CPUModel cpu2 = new CPUModel("AM-932", "Hans", 40.0, 20.0, 5.0, 4);
        GPUModel gpu2 = new GPUModel("G-F2", "Hans", 50.0, 10.0, 4.0, 512);
        HarddriveModel hdd2 = new HarddriveModel("MegaDrive", "Hans",100.0, 14.0, "SSD", 400);
        KeyboardModel keyboard2 = new KeyboardModel("WRITER", "Hans", 20.0, 1.0, "Office", "NOR", "Yes");
        KeyboardModel testKey2 = new KeyboardModel("WRITER240", "ZakaBiz", 200.50, 10.5, "Dritbra", "Norsk", "Yes");
        MonitorModel monitor2 = new MonitorModel("LCD-720", "Hans", 10.5, 5.5, 21);
        MotherboardModel motherboard2 = new MotherboardModel("MB900", "Hans", 12.0, 10.0, "ATX");
        SoundCardModel sc2 = new SoundCardModel("EpicSound", "Logitech", 499, 20, "sjukt", "bra");
        RAMModel RAM2 = new RAMModel("Z-Series", "Acer", 1000, 25, 300, 400);
        PSUModel PSU2 = new PSUModel("F-K9", "Dell", 200, 40, 500);
        MouseModel Mouse2 = new MouseModel("7E", "Logitech", 300, 1, "Gaming", "Yes");

        ComputerCaseRegistry.addComponent(computerCase);
        CPURegistry.addComponent(cpu);
        GPURegistry.addComponent(gpu);
        HardDriveRegistry.addComponent(hdd);
        KeyboardRegistry.addComponent(keyboard);
        KeyboardRegistry.addComponent(testKey);
        MonitorRegistry.addComponent(monitor);
        MotherboardRegistry.addComponent(motherboard);
        SoundCardRegistry.addComponent(sc1);
        RAMRegistry.addComponent(RAM1);
        PSURegistry.addComponent(PSU1);
        MouseRegistry.addComponent(Mouse1);

        ComputerCaseRegistry.addComponent(computerCase2);
        CPURegistry.addComponent(cpu2);
        GPURegistry.addComponent(gpu2);
        HardDriveRegistry.addComponent(hdd2);
        KeyboardRegistry.addComponent(keyboard2);
        KeyboardRegistry.addComponent(testKey2);
        MonitorRegistry.addComponent(monitor2);
        MotherboardRegistry.addComponent(motherboard2);
        SoundCardRegistry.addComponent(sc2);
        RAMRegistry.addComponent(RAM2);
        PSURegistry.addComponent(PSU2);
        MouseRegistry.addComponent(Mouse2);

        ComputerModel testComputer = new ComputerModel("TestComputer", computerCase, cpu, gpu, RAM1, hdd, motherboard, PSU1, sc1, keyboard, monitor, Mouse1, 0, 0);
        testComputer.setTotalPrice(ComputerRegistry.calculateTotalPrice(testComputer));
        testComputer.setTotalPerformanceValue(ComputerRegistry.calculateTotalPerformanceValue(testComputer));

        ComputerRegistry.addComputer(testComputer);

    }

    public static void main(String[] args) {
        launch();
    }

}