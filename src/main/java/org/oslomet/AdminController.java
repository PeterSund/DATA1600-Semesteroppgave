package org.oslomet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import org.oslomet.ComponentClasses.CPUModel;
import org.oslomet.ComponentClasses.KeyboardModel;
import org.oslomet.ComponentRegistry.*;
import org.oslomet.ComputerClasses.ComputerRegistry;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

    public List<TableView> tableViewArray = new ArrayList<>();

    @FXML
    private Button btnLogOut;

    @FXML
    private Button btnCPU;

    @FXML
    private Button btnGPU;

    @FXML
    private Button btnHarddrive;

    @FXML
    private Button btnMotherboard;

    @FXML
    private Button btnRAM;

    @FXML
    private Button btnSoundcard;

    @FXML
    private Button btnPSU;

    @FXML
    private Button btnMonitor;

    @FXML
    private Button btnMouse;

    @FXML
    private Button btnComputercase;

    @FXML
    private Button btnKeyboard;

    @FXML
    private Button btnAddComponent;

    @FXML
    private Button btnLoadComponent;

    @FXML
    private Button btnSaveComponent;

    @FXML
    private TableView<?> tvComputercase;

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
    private TableView<?> tvMouse;

    @FXML
    private TableView<?> tvKeyboard;

    public void editText() {

    }

    public void editPrice() {

    }

    public void editPerformanceValue() {

    }

    public void editBooleanAttribute() {

    }

    public void editSize() {

    }

    public void editClockSpeed() {

    }

    public void editMemory() {

    }

    public void editWatt() {

    }

    public void editCapacity() {

    }

    public void editFrequency() {

    }

    public void editCores() {

    }

    public void editMemorySpeed() {

    }

    private String isVisible() {
        for (TableView tv : tableViewArray) {
            if (tv.isVisible()) {
                return tv.getId();
            }
        }
        return null; //Trenger exeption
    }

    public void createComponent() {
        String activeTableviewID = isVisible();
        Dialog addComponentDialog = AdminDialog.addComponentDialog();
        GridPane grid = AdminDialog.addComponentGridPane();

        if(activeTableviewID.equals("Computercase")) {
            ComputerCaseRegistry.createComponent(addComponentDialog, grid);
        }

        if(activeTableviewID.equals("CPU")) {
            CPURegistry.createComponent(addComponentDialog, grid);
        }

        if(activeTableviewID.equals("GPU")) {
            GPURegistry.createComponent(addComponentDialog, grid);
        }

        if(activeTableviewID.equals("Hard drive")) {
            HardDriveRegistry.createComponent(addComponentDialog, grid);
        }

        if(activeTableviewID.equals("Motherboard")) {
            MotherboardRegistry.createComponent(addComponentDialog, grid);
        }

        if(activeTableviewID.equals("RAM")) {
            RAMRegistry.createComponent(addComponentDialog, grid);
        }

        if(activeTableviewID.equals("Soundcard")) {
            SoundCardRegistry.createComponent(addComponentDialog, grid);
        }

        if(activeTableviewID.equals("PSU")) {
            PSURegistry.createComponent(addComponentDialog, grid);
        }

        if(activeTableviewID.equals("Monitor")) {
            MonitorRegistry.createComponent(addComponentDialog, grid);
        }

        if(activeTableviewID.equals("Mouse")) {
            MouseRegistry.createComponent(addComponentDialog, grid);
        }

        if(activeTableviewID.equals("Keyboard")) {
            MouseRegistry.createComponent(addComponentDialog, grid);
        }
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

    @FXML
    void showComponent(ActionEvent event) {
        String component = event.getSource().toString();
        component = component.split("]")[1];
        component = component.substring(1,component.length()-1);
        showTableView(component);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        KeyboardRegistry.attachTableView(tvKeyboard);
        KeyboardModel testKey = new KeyboardModel("Tast", "ZakaBiz", 200.50, 10.5, "Dritbra", "Norsk", true);
        KeyboardRegistry.addComponent(testKey);
        tableViewArray.add(tvComputercase);
        tableViewArray.add(tvCPU);
        tableViewArray.add(tvGPU);
        tableViewArray.add(tvHarddrive);
        tableViewArray.add(tvKeyboard);
        tableViewArray.add(tvPSU);
        tableViewArray.add(tvMonitor);
        tableViewArray.add(tvMotherboard);
        tableViewArray.add(tvMouse);
        tableViewArray.add(tvRAM);
        tableViewArray.add(tvSoundcard);
        tableViewArray.add(tvMouse);
        tableViewArray.add(tvKeyboard);
    }
}
