package org.oslomet;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.oslomet.ComponentClasses.*;
import org.oslomet.ComponentRegistry.*;
import org.oslomet.ComputerClasses.ComputerModel;
import org.oslomet.ComputerClasses.ComputerRegistry;
import org.oslomet.ExceptionClasses.*;
import org.oslomet.FileHandling.FileChooser;
import org.oslomet.FileHandling.FileSaverTxt;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import static javafx.scene.control.DialogEvent.DIALOG_CLOSE_REQUEST;

public class ViewConfigurationsController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ComputerRegistry.attachTableView(tableviewMyConfigs);


        ComputerCaseModel computerCase = new ComputerCaseModel("MyComp", "Comp", 400, 5, "20x20x10", "Blue");
        CPUModel cpu = new CPUModel("CPU", "Hans", 40.0, 20.0, 5.0, 4);
        GPUModel gpu = new GPUModel("GPU", "Hans", 50.0, 10.0, 4.0, 512);
        HarddriveModel hdd = new HarddriveModel("HDD", "Hans",100.0, 14.0, "SSD", 400);
        KeyboardModel keyboard = new KeyboardModel("Keys", "Hans", 20.0, 1.0, "Office", "Norsk", true);
        KeyboardModel testKey = new KeyboardModel("Tast", "ZakaBiz", 200.50, 10.5, "Dritbra", "Norsk", true);
        MonitorModel monitor = new MonitorModel("Monitor", "Hans", 10.5, 5.5, 21);
        MotherboardModel motherboard = new MotherboardModel("Motherboard", "Hans", 12.0, 10.0, "ATX");
        SoundCardModel sc1 = new SoundCardModel("SC1", "Logitech", 499, 20, true, true);
        RAMModel RAM1 = new RAMModel("RAM1", "Acer", 1000, 25, 300, 400);
        PSUModel PSU1 = new PSUModel("Psu1", "Dell", 200, 40, 500);
        MouseModel Mouse1 = new MouseModel("Mouse1", "Logitech", 300, 1, "Gaming", true);

        ComputerModel demoComputer = new ComputerModel("Demo Computer", computerCase, cpu, gpu, RAM1, hdd, motherboard,PSU1, sc1, testKey,monitor, Mouse1, 10000, 100);
        ComputerRegistry.addComputer(demoComputer);

        ComputerCaseModel computerCase2 = new ComputerCaseModel("MyComputerCase", "CompCaseInc", 400, 5, "20x20x10", "Blue");
        CPUModel cpu2 = new CPUModel("CPU", "Hans", 40.0, 20.0, 5, 4);
        GPUModel gpu2 = new GPUModel("GPU", "Hans", 50.0, 10.0, 4, 512);
        HarddriveModel hdd2 = new HarddriveModel("HDD", "Hans",100.0, 14.0, "SSD", 400);
        KeyboardModel keyboard2 = new KeyboardModel("Keys", "Hans", 20.0, 1.0, "Office", "NOR", true);
        KeyboardModel testKey2 = new KeyboardModel("Tast", "ZakaBiz", 200.50, 10.5, "Dritbra", "Norsk", true);
        MonitorModel monitor2 = new MonitorModel("Monitor", "Hans", 10.5, 5.5, 21);
        MotherboardModel motherboard2 = new MotherboardModel("Motherboard", "Hans", 12.0, 10.0, "ATX");
        SoundCardModel sc2 = new SoundCardModel("SC1", "Logitech", 499, 20, true, true);
        RAMModel RAM2 = new RAMModel("RAM1", "Acer", 1000, 25, 300, 400);
        PSUModel PSU2 = new PSUModel("PSU1", "Dell", 200, 40, 500);
        MouseModel Mouse2 = new MouseModel("AnotherMouse", "Logitech", 300, 1, "Gaming", true);

        ComputerModel demoComputer2 = new ComputerModel("Demo Computer 2", computerCase2, cpu2, gpu2, RAM2, hdd2, motherboard2,PSU2, sc2, testKey2,monitor2, Mouse2, 10000, 100);
        ComputerRegistry.addComputer(demoComputer2);

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
    }

    @FXML
    private Button btnEditConfig;

    @FXML
    private Label lbl1;

    @FXML
    private MenuBar menubarEditConfig;

    @FXML
    private Menu loginAdmin;

    @FXML
    private Menu getHelp;

    @FXML
    private TableView<?> tableviewMyConfigs;

    @FXML
    private Button btnDeleteConfig;

    @FXML
    private Button btnSaveConfig, btnOpenConfig;

    @FXML
    void adminLogin(ActionEvent event) {

    }

    @FXML
    void deleteConfig(ActionEvent event) {

        ComputerModel selectedComputer = (ComputerModel) tableviewMyConfigs.getSelectionModel().getSelectedItem();

        if (selectedComputer == null) {
            System.out.print("Need to select a computer");
        }

        else {
            ComputerRegistry.deleteComputer(selectedComputer);
        }
    }

    @FXML
    void saveConfig(ActionEvent event) throws IOException {

        ComputerModel selectedComputer = (ComputerModel) tableviewMyConfigs.getSelectionModel().getSelectedItem();

        if (selectedComputer == null) {
            System.out.print("Need to select a computer");
        }

        else {
            Path savedFilepath = FileChooser.saveFile();
            String formattedComputer = selectedComputer.formatComputerForFile();
            FileSaverTxt.writeFile(savedFilepath, formattedComputer);
        }
    }

    @FXML
    void openConfig() throws IOException {
        ComputerRegistry.readFromFile();
    }

    @FXML
    void showHelp(ActionEvent event) {

    }


    //Change to view to primary controller: NOT IN USE!
    @FXML
    void changePrimaryController(ActionEvent event) throws IOException {
        Parent viewConfParent = FXMLLoader.load(getClass().getResource("editConfiguration.fxml"));
        Scene viewConfScene = new Scene(viewConfParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow(); //Gets inforation about original stage
        window.setScene(viewConfScene);
        window.show();
    }

    //Edit selected computer
    public void editConfig(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("editConfiguration.fxml"));
        Parent root = loader.load();
        EditConfigurationController editConfigurationController = loader.getController();


        ComputerModel selectedComputer = (ComputerModel) tableviewMyConfigs.getSelectionModel().getSelectedItem();

        //Checks if user has selectet a computer
        if (selectedComputer == null) {
            System.out.print("Need to select a computer!");
        }

        else {
            editConfigurationController.setComputer(selectedComputer);
            Scene viewConfScene = new Scene(root);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow(); //Gets inforation about original stage
            window.setScene(viewConfScene);
            window.show();

        }
        
    }
    
    //Create new computer
    @FXML
    void newConf(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("editConfiguration.fxml"));
        Parent root = loader.load();
        EditConfigurationController editConfigurationController = loader.getController();

        //Create input dialog to set computer name
        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText("Choose name");

        String computerName;
        Optional<String> computerNameFromDialog;
        
        boolean correctName = false;
        while (!correctName) {
            
            computerNameFromDialog = dialog.showAndWait();
            
            if (computerNameFromDialog.isPresent()) {
                if (!ComputerRegistry.computerNameExists(dialog.getResult())) {
                    correctName = true;
                    computerName = computerNameFromDialog.get();

                    ComputerModel newComputer = new ComputerModel(computerName, null, null, null, null, null, null, null, null, null, null, null, 0,0);
                    editConfigurationController.setComputer(newComputer);

                    Scene viewConfScene = new Scene(root);
                    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow(); //Gets inforation about original stage
                    window.setScene(viewConfScene);
                    window.show();
                }

                else {
                    System.err.println("Please choose name that has not been used before");
                }
            }
            else {
                break;
            }

        }


    }
    
}
