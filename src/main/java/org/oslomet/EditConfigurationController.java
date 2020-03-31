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
import org.oslomet.ComponentRegistry.KeyboardRegistry;
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
    private Label lblComputerCase, blCPU, lblGPU, lblHardDrive, getLblMotherBoard, lblRAM, lblSoundcard, lblPSU, lblMinitor, lblMouse, lblKeyboard;

    private ComputerModel computer = new ComputerModel(null, null, null, null, null, null, null, null, null, null, null, null, 0,0);

    public List<TableView> tableViewArray = new ArrayList<>();

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
        tableViewArray.add(tvMonitor);
        tableViewArray.add(tvMotherboard);
        tableViewArray.add(tvMouse);
        tableViewArray.add(tvPSU);
        tableViewArray.add(tvRAM);
        tableViewArray.add(tvSoundcard);
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
        System.out.println("knapp");
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
            System.out.print("Choose a component!");
        }

        else if (currentTableView.getId().equals("Computercase")) {
            lblKeyboard.setText(component.getName()); //ToString?
            computer.setKeyboard((KeyboardModel)component);
        }

       
    }

    //Delete component
    @FXML
    void deleteComponent(ActionEvent event) {

    }

    @FXML
    void saveConfiguration(ActionEvent event) {

    }

}


