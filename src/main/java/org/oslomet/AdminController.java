package org.oslomet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.oslomet.ComponentClasses.ComponentModel;
import org.oslomet.ComponentClasses.MouseModel;
import org.oslomet.ComponentRegistry.*;
import org.oslomet.ExceptionClasses.InvalidBrandException;
import org.oslomet.ExceptionClasses.InvalidNameException;
import org.oslomet.ExceptionClasses.InvalidPriceException;

import java.io.IOException;
import java.net.URL;
import java.nio.file.DirectoryStream;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

    public List<TableView> tableViewArray = new ArrayList<>();
    public List<ChoiceBox> cbArray = new ArrayList<>();

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
    private TableView<MouseModel> tvMouse;

    @FXML
    private TableView<?> tvKeyboard;

    public void editName(TableColumn.CellEditEvent<ComponentModel, String> event) {
        try {
            event.getRowValue().setName(event.getNewValue());

        } catch(InvalidNameException ine) {
            System.out.print(ine.getMessage());
        }
        tableViewVisble().refresh();
    }

    public void editBrand(TableColumn.CellEditEvent<ComponentModel, String> event) {
        try {
            event.getRowValue().setBrand(event.getNewValue());

        } catch(InvalidBrandException ibe) {
            System.out.print(ibe.getMessage());
        }
        tableViewVisble().refresh();
    }
/*
    public void editType(TableColumn.CellEditEvent<? extends ComponentModel, String> event) {
        try {
            event.getRowValue().setType(event.getNewValue());

        } catch(InvalidNameException ine) {
            System.out.print(ine.getMessage());
        }
        tableViewVisble().refresh();
    }
    }

 */



    public void editPrice(TableColumn.CellEditEvent<ComponentModel, Double> event) {
        try {
            Double value = event.getNewValue();
            ComponentModel row = event.getRowValue();
            row.setPrice(value);
        } catch (InvalidPriceException ipe) {
            System.out.print(ipe.getMessage());
        }
        tableViewVisble().refresh();

    }

    public void editPerformanceValue() {

    }

    public void editText() {

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
    private TextField txtFilter;

    @FXML
    private ChoiceBox<String> cbFilterComputerCase, cbFilterCPU, cbFilterGPU, cbFilterHarddrive, cbFilterMotherboard,
            cbFilterRAM, cbFilterSoundcard, cbFilterPSU, cbFilterMonitor, cbFilterMouse, cbFilterKeyboard;

    private MouseRegistry mr = new MouseRegistry();

    @FXML
    private void updateMouseList() { MouseRegistry.attachTableView(tvMouse);}

    @FXML
    private void txtFilterEntered() { filter();}

    private void filter() {
        if(txtFilter.getText().isBlank()) {
            updateMouseList();
            return;
        }

        ObservableList<MouseModel> result = null;
        switch (cbFilterMouse.getValue().toString()) {
            case "Name" : result = mr.filterByName(txtFilter.getText()); break;
            case "Brand" : result = mr.filterByBrand(txtFilter.getText()); break;
            case "Price" : result = mr.filterByPrice(Double.parseDouble(txtFilter.getText())); break;
            case "Performance value" : result = mr.filterByPerformanceValue(Double.parseDouble(txtFilter.getText())); break;
            case "Type" : result = mr.filterByType(txtFilter.getText()); break;
            case "Wireless" : result = mr.filterByWireless(Boolean.parseBoolean((txtFilter.getText()))); break;
        }

        if(result == null) {
            tvMouse.setItems(FXCollections.observableArrayList());
        } else {
            tvMouse.setItems(result);
        }
    }


    @FXML
    private Button btnFilter;

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

    private TableView<?> tableViewVisble() {
        for (TableView tv : tableViewArray) {
            if (tv.isVisible()) {
                return tv;
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
        showFilter(component);

    }

    public void showFilter(String component) {
        for (ChoiceBox cb : cbArray) {
            if (cb.getId().equals(component)) {
                cb.setVisible(true);
            }
            else {
                cb.setVisible(false);
            }
        }
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

        cbArray.add(cbFilterComputerCase);
        cbArray.add(cbFilterCPU);
        cbArray.add(cbFilterGPU);
        cbArray.add(cbFilterHarddrive);
        cbArray.add(cbFilterKeyboard);
        cbArray.add(cbFilterPSU);
        cbArray.add(cbFilterMonitor);
        cbArray.add(cbFilterMotherboard);
        cbArray.add(cbFilterMouse);
        cbArray.add(cbFilterRAM);
        cbArray.add(cbFilterSoundcard);
        cbArray.add(cbFilterMouse);


    }
}
