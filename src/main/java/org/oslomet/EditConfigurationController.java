package org.oslomet;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableView;
import org.oslomet.ComponentClasses.*;
import org.oslomet.ComponentRegistry.*;
import org.oslomet.ComputerClasses.ComputerModel;
import org.oslomet.ComputerClasses.ComputerRegistry;

public class EditConfigurationController implements Initializable {

    @FXML
    private TableView<?> tableviewMyConfig;

    @FXML
    private Button btnRemoveComp;

    @FXML
    private Button btnSaveConfig;

    @FXML
    private TableView<?> tvMouse;

    @FXML
    private TableView<?> tvCPU;

    @FXML
    private TableView<?> tvGPU;

    @FXML
    private TableView<?> tvHarddrive;

    @FXML
    private TableView<?> tvMotherboard;

    @FXML
    private TableView<?> tvRAM;

    @FXML
    private TableView<?> tvSoundcard;

    @FXML
    private TableView<?> tvPSU;

    @FXML
    private TableView<?> tvMonitor;

    @FXML
    private TableView<?> tvComputercase;

    @FXML
    private TableView<?> tvKeyboard;

    @FXML
    private Label lblComputerCase, lblCPU, lblGPU, lblHardDrive, lblMotherBoard, lblRAM, lblSoundcard, lblPSU, lblMonitor, lblMouse, lblKeyboard, lblName;

    private ComputerModel computer;

    public List<TableView> tableViewArray = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ComputerCaseRegistry.attachTableView(tvComputercase);
        CPURegistry.attachTableView(tvCPU);
        GPURegistry.attachTableView(tvGPU);
        HardDriveRegistry.attachTableView(tvHarddrive);
        KeyboardRegistry.attachTableView(tvKeyboard);
        MonitorRegistry.attachTableView(tvMonitor);
        MotherboardRegistry.attachTableView(tvMotherboard);
        SoundCardRegistry.attachTableView(tvSoundcard);
        RAMRegistry.attachTableView(tvRAM);
        PSURegistry.attachTableView(tvPSU);
        MouseRegistry.attachTableView(tvMouse);

        ComputerCaseModel computerCase = new ComputerCaseModel("MyComputerCase", "CompCasesInc", 400, 5, "20x20x10", "Blue");
        CPUModel cpu = new CPUModel("CPU", "Hans", 40.0, 20.0, 5.0, 4);
        GPUModel gpu = new GPUModel("GPU", "Hans", 50.0, 10.0, 4.0, 512);
        HarddriveModel hdd = new HarddriveModel("HDD", "Hans",100.0, 14.0, "SSD", 400);
        KeyboardModel keyboard = new KeyboardModel("Keys", "Hans", 20.0, 1.0, "Office", "NOR", true);
        KeyboardModel testKey = new KeyboardModel("Tast", "ZakaBiz", 200.50, 10.5, "Dritbra", "Norsk", true);
        MonitorModel monitor = new MonitorModel("Monitor", "Hans", 10.5, 5.5, 21);
        MotherboardModel motherboard = new MotherboardModel("Motherboard", "Hans", 12.0, 10.0, "ATX");
        SoundCardModel sc1 = new SoundCardModel("SC1", "Logitech", 499, 20, true, true);
        RAMModel RAM1 = new RAMModel("RAM1", "Acer", 1000, 25, 300, 400);
        PSUModel PSU1 = new PSUModel("Psu1", "Dell", 200, 40, 500);
        MouseModel Mouse1 = new MouseModel("Mouse1", "Logitech", 300, 1, "Gaming", true);


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

        tableViewArray.add(tvComputercase);
        tableViewArray.add(tvCPU);
        tableViewArray.add(tvGPU);
        tableViewArray.add(tvHarddrive);
        tableViewArray.add(tvKeyboard);
        tableViewArray.add(tvMonitor);
        tableViewArray.add(tvMotherboard);
        tableViewArray.add(tvMouse);
        tableViewArray.add(tvPSU);
        tableViewArray.add(tvRAM);
        tableViewArray.add(tvSoundcard);

        for (TableView tv : tableViewArray) {
            tv.setVisible(false);
        }
        tvComputercase.setVisible(true);

    }

    //Change table view
    @FXML
    void showComponent(ActionEvent event) {
        String component = event.getSource().toString();
        component = component.split("]")[1];
        component = component.substring(1,component.length()-1);
        showTableView(component);
    }

    public void showTableView(String component) {

        for (TableView tv : tableViewArray) {
            if (tv.getId().equals(component)) {
                tv.setVisible(true);
            }
            else {
                tv.setVisible(false);
            }
        }
    }

    //Change view to View Configurations
    @FXML
    void changeToViewConfigurations(ActionEvent event) throws IOException {
        Parent viewConfParent = FXMLLoader.load(getClass().getResource("viewConfiguration.fxml"));
        Scene viewConfScene = new Scene(viewConfParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow(); //Gets inforation about original stage
        window.setScene(viewConfScene);
        window.show();
    }

    //Change view to Admin
    @FXML
    void adminLoginFromBtn(ActionEvent event) throws IOException {
        Parent viewConfParent = FXMLLoader.load(getClass().getResource("admin.fxml"));
        Scene viewConfScene = new Scene(viewConfParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow(); //Gets information about original stage
        window.setScene(viewConfScene);
        window.show();
    }

    //Returns the table view that is visible
    private TableView isVisible() {
        for (TableView tv : tableViewArray) {
            if (tv.isVisible()) {
                return tv;
            }
        }
        return null; //Trenger exeption
    }

    //Add component
    @FXML
    void addComponent(ActionEvent event) {
        TableView currentTableView = isVisible();
        ComponentModel component = (ComponentModel) currentTableView.getSelectionModel().getSelectedItem();

        if (component == null) {
            System.out.println("Choose a component!");
        }

        else if (currentTableView.getId().equals("Computercase")) {
            lblComputerCase.setText(((ComputerCaseModel) component).toStringForConfig());
            computer.setComputerCase((ComputerCaseModel) component);
        }

        else if (currentTableView.getId().equals("CPU")) {
            computer.setCpu((CPUModel) component);
            lblCPU.setText(((CPUModel) component).toStringForConfig());

        }

        else if (currentTableView.getId().equals("GPU")) {
            lblGPU.setText(((GPUModel) component).toStringForConfig());
            computer.setGpu((GPUModel) component);
        }

        else if (currentTableView.getId().equals("RAM")) {
            lblRAM.setText(((RAMModel) component).toStringForConfig());
            computer.setRam((RAMModel) component);
        }

        else if (currentTableView.getId().equals("Hard drive")) {
            lblHardDrive.setText(((HarddriveModel) component).toStringForConfig());
            computer.setHardDrive((HarddriveModel) component);
        }

        else if (currentTableView.getId().equals("Motherboard")) {
            lblMotherBoard.setText(((MotherboardModel) component).toStringForConfig());
            computer.setMotherboard((MotherboardModel) component);
        }

        else if (currentTableView.getId().equals("PSU")) {
            lblPSU.setText(((PSUModel) component).toStringForConfig());
            computer.setPsu((PSUModel) component);
        }

        else if (currentTableView.getId().equals("Soundcard")) {
            lblSoundcard.setText(((SoundCardModel) component).toStringForConfig());
            computer.setSoundCard((SoundCardModel) component);
        }

        else if (currentTableView.getId().equals("Keyboard")) {
            lblKeyboard.setText(((KeyboardModel) component).toStringForConfig());
            computer.setKeyboard((KeyboardModel) component);
        }

        else if (currentTableView.getId().equals("Monitor")) {
            lblMonitor.setText(((MonitorModel) component).toStringForConfig());
            computer.setMonitor((MonitorModel) component);
        }

        else if (currentTableView.getId().equals("Mouse")) {
            lblMouse.setText(((MouseModel) component).toStringForConfig());
            computer.setMouse((MouseModel) component);
        }

    }

    //Delete component
    @FXML
    void deleteComponent(ActionEvent event) {

    }

    @FXML
    void saveConfiguration(ActionEvent event) throws IOException {
        if ( !(computer.getComputerCase()==null) && !(computer.getCpu()==null) && !(computer.getGpu()==null) && !(computer.getRam()==null)
                && !(computer.getHardDrive()==null) && !(computer.getMotherboard()==null) && !(computer.getPsu()==null)
                && !(computer.getSoundCard()==null) && !(computer.getKeyboard()==null) && !(computer.getMonitor()==null) && !(computer.getMouse()==null)) {

            //Adds new computer to computer registry OR replaces computer in registry if it already exists
            int computerIndex = ComputerRegistry.findComputer(computer);

            if (computerIndex < 0) {
                ComputerRegistry.addComputer(computer);
            }

            else {
                ComputerRegistry.replaceComputer(computer, computerIndex);
            }


            Parent viewConfParent = FXMLLoader.load(getClass().getResource("viewConfiguration.fxml"));
            Scene viewConfScene = new Scene(viewConfParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow(); //Gets information about original stage
            window.setScene(viewConfScene);
            window.show();
        }

        else {
            System.out.println("Please select all parts for the computer");
        }
    }

    public void setComputer(ComputerModel computerEdited) {
        computer = computerEdited;
        showComputer();
    }

    public void showComputer() {

        //Shows computer's components only if the computer is not a new computer
        if (computer.getComputerCase() != null) {
            lblComputerCase.setText(computer.getComputerCase().toStringForConfig());
            lblCPU.setText(computer.getCpu().toStringForConfig());
            lblGPU.setText(computer.getCpu().toStringForConfig());
            lblHardDrive.setText(computer.getHardDrive().toStringForConfig());
            lblMotherBoard.setText(computer.getMotherboard().toStringForConfig());
            lblRAM.setText(computer.getRam().toStringForConfig());
            lblSoundcard.setText(computer.getSoundCard().toStringForConfig());
            lblPSU.setText(computer.getPsu().toStringForConfig());
            lblMonitor.setText(computer.getMonitor().toStringForConfig());
            lblMouse.setText(computer.getMouse().toStringForConfig());
            lblKeyboard.setText(computer.getKeyboard().toStringForConfig());
        }

        lblName.setText(computer.getConfigName());

    }

}


