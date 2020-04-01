package org.oslomet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.oslomet.ComponentRegistry.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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

    @FXML
    void changeToEditConfigurations(ActionEvent event) throws IOException {
        Parent viewConfParent = FXMLLoader.load(getClass().getResource("editConfiguration.fxml"));
        Scene viewConfScene = new Scene(viewConfParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow(); //Gets inforation about original stage
        window.setScene(viewConfScene);
        window.show();
    }

    private String isVisible() {
        for (TableView tv : tableViewArray) {
            if (tv.isVisible()) {
                return tv.getId();
            }
        }
        return null; //Trenger exeption
    }

    public void generateDialogAddComponent() {
        String activeTableviewID = isVisible();
        GenerateDialogBox.selectDialogToGenerate(activeTableviewID);
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

    }
}
