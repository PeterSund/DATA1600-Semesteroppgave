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
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import org.oslomet.ComponentClasses.*;
import org.oslomet.ComponentRegistry.*;
import org.oslomet.ExceptionClasses.*;
import org.oslomet.FileHandling.FileChooser;
import org.oslomet.FileHandling.FileOpenerJobj;
import org.oslomet.FileHandling.FileSaverJobj;

import java.io.IOException;
import java.net.URL;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

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

        for (TableView tv : tableViewArray) {
            tv.setVisible(false);
        }
        tvComputercase.setVisible(true);

        for (ChoiceBox cb : cbArray) {
            cb.setVisible(false);
        }
        cbFilterComputerCase.setVisible(true);

        final ObservableList<String> optionsHarddriveComboBox = FXCollections.observableArrayList("SSD", "HDD");
        final ObservableList<String> optionsMotherboardCombobox = FXCollections.observableArrayList("ATX", "mini-ATX", "e-ATX");
        final ObservableList<String> optionsSurroundCombobox = FXCollections.observableArrayList("Yes", "No");
        final ObservableList<String> optionsBassBoostCombobox = FXCollections.observableArrayList("Yes", "No", "Mega");
        final ObservableList<String> optionsMouseTypeCombobox = FXCollections.observableArrayList("Office", "Gaming", "Travel");
        final ObservableList<String> optionsMouseWirelessCombobox = FXCollections.observableArrayList("Yes", "No");
        final ObservableList<String> optionsKeyboardTypeCombobox = FXCollections.observableArrayList("Office", "Gaming", "Mechanical");
        final ObservableList<String> optionsKeyboardWirelessCombobox = FXCollections.observableArrayList("Yes", "No");



        colComputercasePrice.setCellFactory(TextFieldTableCell.forTableColumn(StringToDoubleConv));
        colComputercasePV.setCellFactory(TextFieldTableCell.forTableColumn(StringToDoubleConv));
        colCPUPrice.setCellFactory(TextFieldTableCell.forTableColumn(StringToDoubleConv));
        colCPUPV.setCellFactory(TextFieldTableCell.forTableColumn(StringToDoubleConv));
        colCPUClockSpeed.setCellFactory(TextFieldTableCell.forTableColumn(StringToDoubleConv));
        colCPUCores.setCellFactory(TextFieldTableCell.forTableColumn(StringToIntConv));
        colGPUPrice.setCellFactory(TextFieldTableCell.forTableColumn(StringToDoubleConv));
        colGPUPV.setCellFactory(TextFieldTableCell.forTableColumn(StringToDoubleConv));
        colGPUClockSpeed.setCellFactory(TextFieldTableCell.forTableColumn(StringToDoubleConv));
        colGPUMemory.setCellFactory(TextFieldTableCell.forTableColumn(StringToIntConv));
        colHarddrivePrice.setCellFactory(TextFieldTableCell.forTableColumn(StringToDoubleConv));
        colHarddrivePV.setCellFactory(TextFieldTableCell.forTableColumn(StringToDoubleConv));
        colHarddriveCapacity.setCellFactory(TextFieldTableCell.forTableColumn(StringToIntConv));
        colHarddriveType.setCellFactory(ComboBoxTableCell.forTableColumn(optionsHarddriveComboBox));
        colMotherboardPrice.setCellFactory(TextFieldTableCell.forTableColumn(StringToDoubleConv));
        colMotherboardPV.setCellFactory(TextFieldTableCell.forTableColumn(StringToDoubleConv));
        colMotherboardType.setCellFactory(ComboBoxTableCell.forTableColumn(optionsMotherboardCombobox));
        colRAMPrice.setCellFactory(TextFieldTableCell.forTableColumn(StringToDoubleConv));
        colRAMPV.setCellFactory(TextFieldTableCell.forTableColumn(StringToDoubleConv));
        colRAMMemorySpeed.setCellFactory(TextFieldTableCell.forTableColumn(StringToDoubleConv));
        colRAMMemory.setCellFactory(TextFieldTableCell.forTableColumn(StringToIntConv));
        colSoundcardPrice.setCellFactory(TextFieldTableCell.forTableColumn(StringToDoubleConv));
        colSoundcardPV.setCellFactory(TextFieldTableCell.forTableColumn(StringToDoubleConv));
        colSoundcardSurround.setCellFactory(ComboBoxTableCell.forTableColumn(optionsSurroundCombobox));
        colSoundcardBassBoost.setCellFactory(ComboBoxTableCell.forTableColumn(optionsBassBoostCombobox));
        colPSUPrice.setCellFactory(TextFieldTableCell.forTableColumn(StringToDoubleConv));
        colPSUPV.setCellFactory(TextFieldTableCell.forTableColumn(StringToDoubleConv));
        colPSUWatt.setCellFactory(TextFieldTableCell.forTableColumn(StringToIntConv));
        colMonitorPrice.setCellFactory(TextFieldTableCell.forTableColumn(StringToDoubleConv));
        colMonitorPV.setCellFactory(TextFieldTableCell.forTableColumn(StringToDoubleConv));
        colMonitorSize.setCellFactory(TextFieldTableCell.forTableColumn(StringToIntConv));
        colMousePrice.setCellFactory(TextFieldTableCell.forTableColumn(StringToDoubleConv));
        colMousePV.setCellFactory(TextFieldTableCell.forTableColumn(StringToDoubleConv));
        colMouseType.setCellFactory(ComboBoxTableCell.forTableColumn(optionsMouseTypeCombobox));
        colMouseWireless.setCellFactory(ComboBoxTableCell.forTableColumn(optionsMouseWirelessCombobox));
        colKeyboardPrice.setCellFactory(TextFieldTableCell.forTableColumn(StringToDoubleConv));
        colKeyboardPV.setCellFactory(TextFieldTableCell.forTableColumn(StringToDoubleConv));
        colKeyboardType.setCellFactory(ComboBoxTableCell.forTableColumn(optionsKeyboardTypeCombobox));
        colKeyboardWireless.setCellFactory(ComboBoxTableCell.forTableColumn(optionsKeyboardWirelessCombobox));

    }

    @FXML
    private TableColumn<ComputerCaseModel, Double> colComputercasePrice, colComputercasePV;

    @FXML
    private TableColumn<CPUModel, Double> colCPUPrice, colCPUPV, colCPUClockSpeed;

    @FXML
    private TableColumn<CPUModel, Integer> colCPUCores;

    @FXML
    private TableColumn<GPUModel, Double> colGPUPrice, colGPUPV,colGPUClockSpeed;

    @FXML
    private TableColumn<GPUModel, Integer> colGPUMemory;

    @FXML
    private TableColumn<HarddriveModel, Double> colHarddrivePrice, colHarddrivePV;

    @FXML
    private TableColumn<HarddriveModel, Integer> colHarddriveCapacity;

    @FXML
    private TableColumn<HarddriveModel, String> colHarddriveType;

    @FXML
    private TableColumn<MotherboardModel, Double> colMotherboardPrice, colMotherboardPV;

    @FXML
    private TableColumn<HarddriveModel, String> colMotherboardType;

    @FXML
    private TableColumn<RAMModel, Double> colRAMPrice, colRAMPV, colRAMMemorySpeed;

    @FXML
    private TableColumn<RAMModel, Integer> colRAMMemory;

    @FXML
    private TableColumn<SoundCardModel, Double> colSoundcardPrice, colSoundcardPV;

    @FXML
    private TableColumn<SoundCardModel, String> colSoundcardSurround, colSoundcardBassBoost;

    @FXML
    private TableColumn<PSUModel, Double> colPSUPrice, colPSUPV;

    @FXML
    private TableColumn<PSUModel, Integer> colPSUWatt;

    @FXML
    private TableColumn<MonitorModel, Double> colMonitorPrice, colMonitorPV;

    @FXML
    private TableColumn<MonitorModel, Integer> colMonitorSize;

    @FXML
    private TableColumn<MouseModel, Double> colMousePrice, colMousePV;

    @FXML
    private TableColumn<MouseModel, String> colMouseType, colMouseWireless;

    @FXML
    private TableColumn<KeyboardModel, Double> colKeyboardPrice, colKeyboardPV;

    @FXML
    private TableColumn<KeyboardModel, String> colKeyboardType, colKeyboardWireless;

    public List<TableView> tableViewArray = new ArrayList<>();
    public List<ChoiceBox> cbArray = new ArrayList<>();

    private ConverterStringToNumber.IntegerStringConverter StringToIntConv
            = new ConverterStringToNumber.IntegerStringConverter();
    private ConverterStringToNumber.DoubleStringConverter StringToDoubleConv
            = new ConverterStringToNumber.DoubleStringConverter();

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
    private TableView<ComputerCaseModel> tvComputercase;

    @FXML
    private TableView<CPUModel> tvCPU;

    @FXML
    private TableView<GPUModel> tvGPU;

    @FXML
    private TableView<HarddriveModel> tvHarddrive;

    @FXML
    private TableView<MotherboardModel> tvMotherboard;

    @FXML
    private TableView<RAMModel> tvRAM;

    @FXML
    private TableView<SoundCardModel> tvSoundcard;

    @FXML
    private TableView<PSUModel> tvPSU;

    @FXML
    private TableView<MonitorModel> tvMonitor;

    @FXML
    private TableView<MouseModel> tvMouse;

    @FXML
    private TableView<KeyboardModel> tvKeyboard;

    CPURegistry test = new CPURegistry();

    public void saveObj() throws IOException {
        Path path = FileChooser.saveFile();
        ArrayList arrayLists = ComponentsRegistry.addAllComponentsArraysToArray();
        FileSaverJobj.saveJobj(arrayLists, path);
    }

    public void openObj() throws IOException {
        Path path = FileChooser.openFile();
        FileOpenerJobj.openJobj(path);

    }

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

    public void editPrice(TableColumn.CellEditEvent<ComponentModel, Double> event) {
        try {
            if(StringToDoubleConv.wasSuccessful()) {
                event.getRowValue().setPrice(event.getNewValue());
            }

        } catch (InvalidPriceException ipe) {
            System.out.print(ipe.getMessage());
        }
        tableViewVisble().refresh();
    }

    public void editPerformanceValue(TableColumn.CellEditEvent<ComponentModel, Double> event) {
        try {
            if(StringToDoubleConv.wasSuccessful()) {
                event.getRowValue().setPerformanceValue(event.getNewValue());
            }

        } catch (InvalidPerformanceValueException ipe) {
            System.out.print(ipe.getMessage());
        }
        tableViewVisble().refresh();
    }

    public void editComputerCaseDimensions(TableColumn.CellEditEvent<ComputerCaseModel, String> event) {
        event.getRowValue().setDimensions(event.getNewValue());
        tableViewVisble().refresh();
    }

    public void editComputerCaseColor(TableColumn.CellEditEvent<ComputerCaseModel, String> event) {
        event.getRowValue().setColor(event.getNewValue());
        tableViewVisble().refresh();
    }

    public void editCPUClockSpeed(TableColumn.CellEditEvent<CPUModel, Double> event) {
        try {
            if(StringToDoubleConv.wasSuccessful()) {
                event.getRowValue().setClockSpeed(event.getNewValue());
            }

        } catch (InvalidClockSpeedException icse) {
            System.out.print(icse.getMessage());
        }
        tableViewVisble().refresh();
    }

    public void editCores(TableColumn.CellEditEvent<CPUModel, Integer> event) {
        try {
            if(StringToIntConv.wasSuccessful()) {
                event.getRowValue().setCores(event.getNewValue());
            }

        } catch (InvalidCoresException ice) {
            System.out.print(ice.getMessage());
        }
        tableViewVisble().refresh();
    }

    public void editGPUClockSpeed(TableColumn.CellEditEvent<GPUModel, Double> event) {
        try {
            if(StringToDoubleConv.wasSuccessful()) {
                event.getRowValue().setClockSpeed(event.getNewValue());
            }

        } catch (InvalidClockSpeedException icse) {
            System.out.print(icse.getMessage());
        }
        tableViewVisble().refresh();
    }

    public void editGPUMemory(TableColumn.CellEditEvent<GPUModel, Integer> event) {
        try {
            if(StringToIntConv.wasSuccessful()) {
                event.getRowValue().setMemory(event.getNewValue());
            }

        } catch (InvalidMemoryException ime) {
            System.out.print(ime.getMessage());
        }
        tableViewVisble().refresh();
    }


    public void editHarddriveType(TableColumn.CellEditEvent<HarddriveModel, String> event) {
        event.getRowValue().setType(event.getNewValue());
        tableViewVisble().refresh();
    }

    public void editCapacity(TableColumn.CellEditEvent<HarddriveModel, Integer> event) {
        try {
            if(StringToIntConv.wasSuccessful()) {
                event.getRowValue().setCapacity(event.getNewValue());
            }

        } catch (InvalidCapacityException ice) {
            System.out.print(ice.getMessage());
        }
        tableViewVisble().refresh();
    }


    public void editMotherboardType(TableColumn.CellEditEvent<MotherboardModel, String> event) {
        event.getRowValue().setType(event.getNewValue());
        tableViewVisble().refresh();
    }

    public void editRAMMemory(TableColumn.CellEditEvent<RAMModel, Integer> event) {
        try {
            if(StringToIntConv.wasSuccessful()) {
                event.getRowValue().setMemory(event.getNewValue());
            }

        } catch (InvalidMemoryException ime) {
            System.out.print(ime.getMessage());
        }
        tableViewVisble().refresh();
    }

    public void editMemorySpeed(TableColumn.CellEditEvent<RAMModel, Double> event) {
        try {
            if(StringToDoubleConv.wasSuccessful()) {
                event.getRowValue().setMemorySpeed(event.getNewValue());
            }

        } catch (InvalidPerformanceValueException ipe) {
            System.out.print(ipe.getMessage());
        }
        tableViewVisble().refresh();
    }


    public void editSurround(TableColumn.CellEditEvent<SoundCardModel, String> event) {
        event.getRowValue().setSurround(event.getNewValue());
        tableViewVisble().refresh();
    }

    public void editBassBoost(TableColumn.CellEditEvent<SoundCardModel, String> event) {
        event.getRowValue().setBassBoost(event.getNewValue());
        tableViewVisble().refresh();
    }

    public void editWatt(TableColumn.CellEditEvent<PSUModel, Integer> event)  {
        try {
            if(StringToIntConv.wasSuccessful()) {
                event.getRowValue().setWatt(event.getNewValue());
            }

        } catch (InvalidWattException iwe) {
            System.out.print(iwe.getMessage());
        }
        tableViewVisble().refresh();
    }

    public void editSize(TableColumn.CellEditEvent<MonitorModel, Integer> event) {
        try {
            if(StringToIntConv.wasSuccessful()) {
                event.getRowValue().setSize(event.getNewValue());
            }

        } catch (InvalidSizeException ize) {
            System.out.print(ize.getMessage());
        }
        tableViewVisble().refresh();

    }

    public void editMouseType(TableColumn.CellEditEvent<MouseModel, String> event) {
        event.getRowValue().setType(event.getNewValue());
        tableViewVisble().refresh();
    }

    public void editMouseWireless(TableColumn.CellEditEvent<MouseModel, String> event) {
        event.getRowValue().setWireless(event.getNewValue());
        tableViewVisble().refresh();
    }

    public void editKeyboardType(TableColumn.CellEditEvent<KeyboardModel, String> event) {
        event.getRowValue().setType(event.getNewValue());
        tableViewVisble().refresh();
    }

    public void editKeyboardLanguage(TableColumn.CellEditEvent<KeyboardModel, String> event) {
        event.getRowValue().setLanguage(event.getNewValue());
        tableViewVisble().refresh();
    }

    public void editKeyboardWireless(TableColumn.CellEditEvent<KeyboardModel, String> event) {
        event.getRowValue().setWireless(event.getNewValue());
        tableViewVisble().refresh();
    }

    @FXML
    private TextField txtFilter;

    @FXML
    private ChoiceBox<String> cbFilterComputerCase, cbFilterCPU, cbFilterGPU, cbFilterHarddrive, cbFilterMotherboard,
            cbFilterRAM, cbFilterSoundcard, cbFilterPSU, cbFilterMonitor, cbFilterMouse, cbFilterKeyboard;

    private ComputerCaseRegistry computerCaseRegistry = new ComputerCaseRegistry();
    private CPURegistry cpuRegistry = new CPURegistry();
    private GPURegistry gpuRegistry = new GPURegistry();
    private HardDriveRegistry hardDriveRegistry = new HardDriveRegistry();
    private KeyboardRegistry keyboardRegistry = new KeyboardRegistry();
    private MonitorRegistry monitorRegistry = new MonitorRegistry();
    private MotherboardRegistry motherboardRegistry = new MotherboardRegistry();
    private MouseRegistry mouseRegistry = new MouseRegistry();
    private PSURegistry psuRegistry = new PSURegistry();
    private RAMRegistry ramRegistry = new RAMRegistry();
    private SoundCardRegistry soundCardRegistry = new SoundCardRegistry();

    @FXML
    private void updateComputerCaseList() { ComputerCaseRegistry.attachTableView(tvComputercase);}

    private void updateCPUList() { CPURegistry.attachTableView(tvCPU);}

    private void updateGPUList() { GPURegistry.attachTableView(tvGPU);}

    private void updateHardDriveList() { HardDriveRegistry.attachTableView(tvHarddrive);}

    private void updateKeyboardList() { KeyboardRegistry.attachTableView(tvKeyboard);}

    private void updateMonitorList() { MonitorRegistry.attachTableView(tvMonitor);}

    private void updateMotherboardList() { MotherboardRegistry.attachTableView(tvMotherboard);}

    private void updateMouseList() { MouseRegistry.attachTableView(tvMouse);}

    private void updatePSUList() { PSURegistry.attachTableView(tvPSU);}

    private void updateRAMList() { RAMRegistry.attachTableView(tvRAM);}

    private void updateSoundCardList() { SoundCardRegistry.attachTableView(tvSoundcard);}

    @FXML
    private void clearFilter() {
        txtFilter.clear();
        txtFilterEntered();
    }


    @FXML
    private void txtFilterEntered() {
        TableView currentTableView = tableViewVisble();

        if (currentTableView == tvComputercase) {
            filterComputerCase();
        } else if (currentTableView == tvCPU) {
            filterCPU();
        } else if (currentTableView == tvGPU) {
            filterGPU();
        } else if (currentTableView == tvHarddrive) {
            filterHardDrive();
        } else if (currentTableView == tvKeyboard) {
            filterKeyboard();
        } else if (currentTableView == tvMonitor) {
            filterMonitor();
        } else if (currentTableView == tvMotherboard) {
            filterMotherboard();
        } else if (currentTableView == tvMouse) {
            filterMouse();
        } else if (currentTableView == tvPSU) {
            filterPSU();
        } else if (currentTableView == tvRAM) {
            filterRAM();
        } else if (currentTableView == tvSoundcard) {
            filterSoundcard();
        }
    }

    private void filterComputerCase() {
        if(txtFilter.getText().isBlank()) {
            updateComputerCaseList();
            return;
        }

        ObservableList<ComputerCaseModel> result = null;
        switch (cbFilterComputerCase.getValue().toString()) {
            case "Name" : result = computerCaseRegistry.filterByName(txtFilter.getText()); break;
            case "Brand" : result = computerCaseRegistry.filterByBrand(txtFilter.getText()); break;
            case "Price" : result = computerCaseRegistry.filterByPrice(Double.parseDouble(txtFilter.getText())); break;
            case "Performance value" : result = computerCaseRegistry.filterByPerformanceValue(Double.parseDouble(txtFilter.getText())); break;
            case "Dimension" : result = computerCaseRegistry.filterByDimension(txtFilter.getText()); break;
            case "Color" : result = computerCaseRegistry.filterByColor(txtFilter.getText()); break;
        }

        if(result == null) {
            tvComputercase.setItems(FXCollections.observableArrayList());
        } else {
            tvComputercase.setItems(result);
        }
    }

    private void filterCPU() {
        if(txtFilter.getText().isBlank()) {
            updateCPUList();
            return;
        }

        ObservableList<CPUModel> result = null;
        switch (cbFilterCPU.getValue().toString()) {
            case "Name" : result = cpuRegistry.filterByName(txtFilter.getText()); break;
            case "Brand" : result = cpuRegistry.filterByBrand(txtFilter.getText()); break;
            case "Price" : result = cpuRegistry.filterByPrice(Double.parseDouble(txtFilter.getText())); break;
            case "Performance value" : result = cpuRegistry.filterByPerformanceValue(Double.parseDouble(txtFilter.getText())); break;
            case "Dimension" : result = cpuRegistry.filterByClockSpeed(Double.parseDouble((txtFilter.getText()))); break;
            case "Color" : result = cpuRegistry.filterByCores(Integer.parseInt((txtFilter.getText()))); break;
        }

        if(result == null) {
            tvCPU.setItems(FXCollections.observableArrayList());
        } else {
            tvCPU.setItems(result);
        }
    }

    private void filterGPU() {
        if(txtFilter.getText().isBlank()) {
            updateGPUList();
            return;
        }

        ObservableList<GPUModel> result = null;
        switch (cbFilterGPU.getValue().toString()) {
            case "Name" : result = gpuRegistry.filterByName(txtFilter.getText()); break;
            case "Brand" : result = gpuRegistry.filterByBrand(txtFilter.getText()); break;
            case "Price" : result = gpuRegistry.filterByPrice(Double.parseDouble(txtFilter.getText())); break;
            case "Performance value" : result = gpuRegistry.filterByPerformanceValue(Double.parseDouble(txtFilter.getText())); break;
            case "Dimension" : result = gpuRegistry.filterByClockSpeed(Double.parseDouble((txtFilter.getText()))); break;
            case "Memory" : result = gpuRegistry.filterByMemory(Integer.parseInt((txtFilter.getText()))); break;
        }

        if(result == null) {
            tvGPU.setItems(FXCollections.observableArrayList());
        } else {
            tvGPU.setItems(result);
        }
    }

    private void filterHardDrive() {
        if(txtFilter.getText().isBlank()) {
            updateHardDriveList();
            return;
        }

        ObservableList<HarddriveModel> result = null;
        switch (cbFilterHarddrive.getValue().toString()) {
            case "Name" : result = hardDriveRegistry.filterByName(txtFilter.getText()); break;
            case "Brand" : result = hardDriveRegistry.filterByBrand(txtFilter.getText()); break;
            case "Price" : result = hardDriveRegistry.filterByPrice(Double.parseDouble(txtFilter.getText())); break;
            case "Performance value" : result = hardDriveRegistry.filterByPerformanceValue(Double.parseDouble(txtFilter.getText())); break;
            case "Type" : result = hardDriveRegistry.filterByType(txtFilter.getText()); break;
            case "Capacity" : result = hardDriveRegistry.filterByCapacity(Integer.parseInt((txtFilter.getText()))); break;
        }

        if(result == null) {
            tvHarddrive.setItems(FXCollections.observableArrayList());
        } else {
            tvHarddrive.setItems(result);
        }
    }

    private void filterKeyboard() {
        if(txtFilter.getText().isBlank()) {
            updateKeyboardList();
            return;
        }

        ObservableList<KeyboardModel> result = null;
        switch (cbFilterKeyboard.getValue().toString()) {
            case "Name" : result = keyboardRegistry.filterByName(txtFilter.getText()); break;
            case "Brand" : result = keyboardRegistry.filterByBrand(txtFilter.getText()); break;
            case "Price" : result = keyboardRegistry.filterByPrice(Double.parseDouble(txtFilter.getText())); break;
            case "Performance value" : result = keyboardRegistry.filterByPerformanceValue(Double.parseDouble(txtFilter.getText())); break;
            case "Type" : result = keyboardRegistry.filterByType(txtFilter.getText()); break;
            case "Language" : result = keyboardRegistry.filterByLanguage(txtFilter.getText()); break;
        }

        if(result == null) {
            tvKeyboard.setItems(FXCollections.observableArrayList());
        } else {
            tvKeyboard.setItems(result);
        }
    }

    private void filterMonitor() {
        if(txtFilter.getText().isBlank()) {
            updateMonitorList();
            return;
        }

        ObservableList<MonitorModel> result = null;
        switch (cbFilterMonitor.getValue().toString()) {
            case "Name" : result = monitorRegistry.filterByName(txtFilter.getText()); break;
            case "Brand" : result = monitorRegistry.filterByBrand(txtFilter.getText()); break;
            case "Price" : result = monitorRegistry.filterByPrice(Double.parseDouble(txtFilter.getText())); break;
            case "Performance value" : result = monitorRegistry.filterByPerformanceValue(Double.parseDouble(txtFilter.getText())); break;
            case "Size" : result = monitorRegistry.filterBySize(Integer.parseInt((txtFilter.getText()))); break;
        }

        if(result == null) {
            tvMonitor.setItems(FXCollections.observableArrayList());
        } else {
            tvMonitor.setItems(result);
        }
    }

    private void filterMotherboard() {
        if(txtFilter.getText().isBlank()) {
            updateMotherboardList();
            return;
        }

        ObservableList<MotherboardModel> result = null;
        switch (cbFilterMotherboard.getValue().toString()) {
            case "Name" : result = motherboardRegistry.filterByName(txtFilter.getText()); break;
            case "Brand" : result = motherboardRegistry.filterByBrand(txtFilter.getText()); break;
            case "Price" : result = motherboardRegistry.filterByPrice(Double.parseDouble(txtFilter.getText())); break;
            case "Performance value" : result = motherboardRegistry.filterByPerformanceValue(Double.parseDouble(txtFilter.getText())); break;
            case "Type" : result = motherboardRegistry.filterByType(txtFilter.getText()); break;
        }

        if(result == null) {
            tvMotherboard.setItems(FXCollections.observableArrayList());
        } else {
            tvMotherboard.setItems(result);
        }
    }

    private void filterMouse() {
        if(txtFilter.getText().isBlank()) {
            updateMouseList();
            return;
        }

        ObservableList<MouseModel> result = null;
        switch (cbFilterMouse.getValue().toString()) {
            case "Name" : result = mouseRegistry.filterByName(txtFilter.getText()); break;
            case "Brand" : result = mouseRegistry.filterByBrand(txtFilter.getText()); break;
            case "Price" : result = mouseRegistry.filterByPrice(Double.parseDouble(txtFilter.getText())); break;
            case "Performance value" : result = mouseRegistry.filterByPerformanceValue(Double.parseDouble(txtFilter.getText())); break;
            case "Type" : result = mouseRegistry.filterByType(txtFilter.getText()); break;
            case "Wireless" : result = mouseRegistry.filterByWireless(txtFilter.getText()); break;
        }

        if(result == null) {
            tvMouse.setItems(FXCollections.observableArrayList());
        } else {
            tvMouse.setItems(result);
        }
    }

    private void filterPSU() {
        if(txtFilter.getText().isBlank()) {
            updatePSUList();
            return;
        }

        ObservableList<PSUModel> result = null;
        switch (cbFilterPSU.getValue().toString()) {
            case "Name" : result = psuRegistry.filterByName(txtFilter.getText()); break;
            case "Brand" : result = psuRegistry.filterByBrand(txtFilter.getText()); break;
            case "Price" : result = psuRegistry.filterByPrice(Double.parseDouble(txtFilter.getText())); break;
            case "Performance value" : result = psuRegistry.filterByPerformanceValue(Double.parseDouble(txtFilter.getText())); break;
            case "Watt" : result = psuRegistry.filterByWatt(Integer.parseInt((txtFilter.getText()))); break;
        }

        if(result == null) {
            tvPSU.setItems(FXCollections.observableArrayList());
        } else {
            tvPSU.setItems(result);
        }
    }

    private void filterRAM() {
        if(txtFilter.getText().isBlank()) {
            updateRAMList();
            return;
        }

        ObservableList<RAMModel> result = null;
        switch (cbFilterRAM.getValue().toString()) {
            case "Name" : result = ramRegistry.filterByName(txtFilter.getText()); break;
            case "Brand" : result = ramRegistry.filterByBrand(txtFilter.getText()); break;
            case "Price" : result = ramRegistry.filterByPrice(Double.parseDouble(txtFilter.getText())); break;
            case "Performance value" : result = ramRegistry.filterByPerformanceValue(Double.parseDouble(txtFilter.getText())); break;
            case "Memory" : result = ramRegistry.filterByMemory(Integer.parseInt((txtFilter.getText()))); break;
            case "Memory speed" : result = ramRegistry.filterByMemorySpeed(Double.parseDouble((txtFilter.getText()))); break;
        }

        if(result == null) {
            tvRAM.setItems(FXCollections.observableArrayList());
        } else {
            tvRAM.setItems(result);
        }
    }

    private void filterSoundcard() {
        if(txtFilter.getText().isBlank()) {
            updateSoundCardList();
            return;
        }

        ObservableList<SoundCardModel> result = null;
        switch (cbFilterSoundcard.getValue().toString()) {
            case "Name" : result = soundCardRegistry.filterByName(txtFilter.getText()); break;
            case "Brand" : result = soundCardRegistry.filterByBrand(txtFilter.getText()); break;
            case "Price" : result = soundCardRegistry.filterByPrice(Double.parseDouble(txtFilter.getText())); break;
            case "Performance value" : result = soundCardRegistry.filterByPerformanceValue(Double.parseDouble(txtFilter.getText())); break;
        }

        if(result == null) {
            tvSoundcard.setItems(FXCollections.observableArrayList());
        } else {
            tvSoundcard.setItems(result);
        }
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
}
