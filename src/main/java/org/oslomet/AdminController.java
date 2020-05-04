package org.oslomet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.oslomet.ComponentClasses.*;
import org.oslomet.ComponentRegistry.*;
import org.oslomet.Dialogs.*;
import org.oslomet.ExceptionClasses.*;
import org.oslomet.FileHandling.FileChooser;
import org.oslomet.FileHandling.FileSaverJobj;
import org.oslomet.FileHandling.ThreadOpenJobj;
import org.oslomet.Validation.ConverterStringToNumber;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.PatternSyntaxException;

public class AdminController implements Initializable {

    //Lists for holding tableviews, choiceboxes and buttons. All elements are added to these lists in initialize.
    public List<TableView> tableViewArray = new ArrayList<>();
    public List<ChoiceBox> cbArray = new ArrayList<>();
    public List<Button> chooseComponentButtons = new ArrayList<>();

    //Converters used when editing integer or double values
    private ConverterStringToNumber.IntegerStringConverter StringToIntConv
            = new ConverterStringToNumber.IntegerStringConverter();
    private ConverterStringToNumber.DoubleStringConverter StringToDoubleConv
            = new ConverterStringToNumber.DoubleStringConverter();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Adds tableviews, choiceboxes (filtering) and buttons to lists. Lists are used to easier control which components are visible to the user
        tableViewArray = Arrays.asList(tvComputercase, tvCPU, tvGPU, tvHarddrive, tvKeyboard, tvPSU, tvMonitor, tvMotherboard, tvMouse, tvRAM, tvSoundcard);
        cbArray = Arrays.asList(cbFilterComputerCase, cbFilterCPU, cbFilterGPU, cbFilterHarddrive, cbFilterKeyboard, cbFilterPSU, cbFilterMonitor, cbFilterMotherboard, cbFilterMouse, cbFilterRAM, cbFilterSoundcard);
        chooseComponentButtons = Arrays.asList(btnComputercase, btnCPU, btnGPU, btnHarddrive, btnKeyboard, btnMonitor, btnMotherboard, btnMouse, btnPSU, btnRAM, btnSoundcard);

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

        //Sets computercase tableview as visible when Admin is opened, sets all other tableviews to not visible
        for (TableView tv : tableViewArray) {
            tv.setVisible(false);
        }
        tvCPU.setVisible(true);

        //Sets computercase combo-box as visible when Admin is opened, sets all other combo-box to not visible
        for (ChoiceBox cb : cbArray) {
            cb.setVisible(false);
        }
        cbFilterCPU.setVisible(true);

        btnCPU.setStyle("-fx-background-color: #4F4F4F; -fx-text-fill: white");

        //Options for choiceboxes used when changing values of attriubutes in component-tableviews
        final ObservableList<String> optionsHarddriveComboBox = FXCollections.observableArrayList("SSD", "HDD");
        final ObservableList<String> optionsMotherboardCombobox = FXCollections.observableArrayList("ATX", "mini-ATX", "e-ATX");
        final ObservableList<String> optionsSurroundCombobox = FXCollections.observableArrayList("Yes", "No");
        final ObservableList<String> optionsBassBoostCombobox = FXCollections.observableArrayList("Yes", "No", "Mega");
        final ObservableList<String> optionsMouseTypeCombobox = FXCollections.observableArrayList("Office", "Gaming", "Travel");
        final ObservableList<String> optionsMouseWirelessCombobox = FXCollections.observableArrayList("Yes", "No");
        final ObservableList<String> optionsKeyboardTypeCombobox = FXCollections.observableArrayList("Office", "Gaming", "Mechanical");
        final ObservableList<String> optionsKeyboardWirelessCombobox = FXCollections.observableArrayList("Yes", "No");


        //Sets CellFactory for all tableview columns containing numbers or choiceboxes. Numbers are linked to converter for
        //String to number (Integer or double)
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
    private TableColumn<GPUModel, Double> colGPUPrice, colGPUPV, colGPUClockSpeed;

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

    @FXML
    private Button btnCPU, btnGPU, btnHarddrive, btnMotherboard, btnRAM, btnSoundcard, btnPSU, btnMonitor, btnMouse, btnComputercase, btnKeyboard;

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

    @FXML
    private AnchorPane ap;

    //Calls on methods for saving jobj files
    @FXML
    private void saveObj() throws IOException {
        try {
            Path path = FileChooser.saveJobjFile();
            ArrayList arrayLists = ComponentsRegistry.addAllComponentsArraysToArray();
            FileSaverJobj.saveJobj(arrayLists, path);
        } catch (NullPointerException npe) {
            //Prevents program from crashing when user closes filechooser without action
        }
    }

    //Calls on methods for opening jobj files
    @FXML
    private void openObj() {
        try {
            Path path = FileChooser.openJobjFile();
            ThreadOpenJobj task = new ThreadOpenJobj(path);
            task.setOnSucceeded(this::threadDone);
            task.setOnFailed(this::threadFailed);
            Thread th = new Thread(task);
            ap.setDisable(true);
            th.start();
        } catch (NullPointerException npe) {
            //Prevents program from crashing when user closes filechooser without action
        }
    }

    //Enables anchorpane (window) when thread is done
    private void threadDone(WorkerStateEvent e) {
        ap.setDisable(false);
    }

    //Enables anchorpane (window) if thread fails, generates error messages which is displayed to user
    private void threadFailed(WorkerStateEvent event) {
        var e = event.getSource().getException();
        ErrorDialog.showErrorDialog(e.getMessage(), e.getMessage());
        ap.setDisable(false);
    }

    //Sets new name when the cell is edited, displays exception if input is invalid
    @FXML
    private void editName(TableColumn.CellEditEvent<ComponentModel, String> event) {
        try {
            event.getRowValue().setName(event.getNewValue());

        } catch (InvalidNameException ine) {
            ErrorDialog.showErrorDialog(ine.getMessage(), "Invalid input");
        }
        tableViewVisible().refresh();
    }

    //Sets new brand when the cell is edited, displays exception if input is invalid
    @FXML
    private void editBrand(TableColumn.CellEditEvent<ComponentModel, String> event) {
        try {
            event.getRowValue().setBrand(event.getNewValue());

        } catch (InvalidBrandException ibe) {
            ErrorDialog.showErrorDialog(ibe.getMessage(), "Invalid input");
        }
        tableViewVisible().refresh();
    }

    //Sets new price when the cell is edited, displays exception if input is invalid
    @FXML
    private void editPrice(TableColumn.CellEditEvent<ComponentModel, Double> event) {
        try {
            if (StringToDoubleConv.wasSuccessful()) {
                event.getRowValue().setPrice(event.getNewValue());
            } else {
                ErrorDialog.showErrorDialog("Price must be a number. Use \".\" for decimals.", "Invalid input");
            }

        } catch (InvalidPriceException ipe) {
            ErrorDialog.showErrorDialog(ipe.getMessage(), "Invalid input");
        } catch (NullPointerException npe) {
            ErrorDialog.showErrorDialog("Price cannot be blank.", "Invalid input");
        }
        tableViewVisible().refresh();
    }

    //Sets new performancevalue when the cell is edited, displays exception if input is invalid
    @FXML
    private void editPerformanceValue(TableColumn.CellEditEvent<ComponentModel, Double> event) {
        try {
            if (StringToDoubleConv.wasSuccessful()) {
                event.getRowValue().setPerformanceValue(event.getNewValue());
            } else {
                ErrorDialog.showErrorDialog("Performancevalue must be a number. Use \".\" for decimals.", "Invalid input");
            }

        } catch (InvalidPerformanceValueException ipe) {
            ErrorDialog.showErrorDialog(ipe.getMessage(), "Invalid input");
        } catch (NullPointerException npe) {
            ErrorDialog.showErrorDialog("Performancevalue cannot be blank", "Invalid input");
        }
        tableViewVisible().refresh();
    }

    //Sets new attribute value when the cell is edited, displays exception if input is invalid
    @FXML
    private void editComputerCaseDimensions(TableColumn.CellEditEvent<ComputerCaseModel, String> event) {
        try {
            event.getRowValue().setDimensions(event.getNewValue());
        } catch (InvalidDimensionsException ide) {
            ErrorDialog.showErrorDialog(ide.getMessage(), "Invalid input");
        }
        tableViewVisible().refresh();
    }

    //Sets new attribute value when the cell is edited, displays exception if input is invalid
    @FXML
    private void editComputerCaseColor(TableColumn.CellEditEvent<ComputerCaseModel, String> event) {
        try {
            event.getRowValue().setColor(event.getNewValue());
        } catch (InvalidColorException ice) {
            ErrorDialog.showErrorDialog(ice.getMessage(), "Invalid input");
        }
        tableViewVisible().refresh();
    }

    //Sets new attribute value when the cell is edited, displays exception if input is invalid
    @FXML
    private void editCPUClockSpeed(TableColumn.CellEditEvent<CPUModel, Double> event) {
        try {
            if (StringToDoubleConv.wasSuccessful()) {
                event.getRowValue().setClockSpeed(event.getNewValue());
            } else {
                ErrorDialog.showErrorDialog("CPU clockspeed must be a number. Use \".\" for decimals.", "Invalid input");
            }
        } catch (InvalidClockSpeedException icse) {
            ErrorDialog.showErrorDialog(icse.getMessage(), "Invalid input");
        } catch (NullPointerException npe) {
            ErrorDialog.showErrorDialog("CPU clockspeed cannot be blank", "Invalid input");
        }
        tableViewVisible().refresh();
    }

    //Sets new no. cpu cores when the cell is edited, displays exception if input is invalid
    @FXML
    private void editCores(TableColumn.CellEditEvent<CPUModel, Integer> event) {
        try {
            if (StringToIntConv.wasSuccessful()) {
                event.getRowValue().setCores(event.getNewValue());
            } else {
                ErrorDialog.showErrorDialog("No. cores must be a number", "Invalid input");
            }
        } catch (InvalidCoresException ice) {
            ErrorDialog.showErrorDialog(ice.getMessage(), "Invalid input");
        } catch (NullPointerException npe) {
            ErrorDialog.showErrorDialog("No. cores cannot be blank", "Invalid input");
        }
        tableViewVisible().refresh();
    }

    //Sets new attribute value when the cell is edited, displays exception if input is invalid
    @FXML
    private void editGPUClockSpeed(TableColumn.CellEditEvent<GPUModel, Double> event) {
        try {
            if (StringToDoubleConv.wasSuccessful()) {
                event.getRowValue().setClockSpeed(event.getNewValue());
            } else {
                ErrorDialog.showErrorDialog("GPU clockspeed must be a number. Use \".\" for decimals.", "Invalid input");
            }

        } catch (InvalidClockSpeedException icse) {
            ErrorDialog.showErrorDialog(icse.getMessage(), "Invalid input");
        } catch (NullPointerException npe) {
            ErrorDialog.showErrorDialog("GPU clockspeed cannot be blank", "Invalid input");
        }
        tableViewVisible().refresh();
    }

    //Sets new attribute value when the cell is edited, displays exception if input is invalid
    @FXML
    private void editGPUMemory(TableColumn.CellEditEvent<GPUModel, Integer> event) {
        try {
            if (StringToIntConv.wasSuccessful()) {
                event.getRowValue().setMemory(event.getNewValue());
            } else {
                ErrorDialog.showErrorDialog("GPU memory must be a number", "Invalid input");
            }
        } catch (InvalidMemoryException ime) {
            ErrorDialog.showErrorDialog(ime.getMessage(), "Invalid input");
        } catch (NullPointerException npe) {
            ErrorDialog.showErrorDialog("GPU memory cannot be blank", "Invalid input");
        }
        tableViewVisible().refresh();
    }

    //Sets new type (String) when value (type) of choicebox in cell is changed
    @FXML
    private void editHarddriveType(TableColumn.CellEditEvent<HarddriveModel, String> event) {
        event.getRowValue().setType(event.getNewValue());
        tableViewVisible().refresh();
    }

    //Sets new attribute value when the cell is edited, displays exception if input is invalid
    @FXML
    private void editCapacity(TableColumn.CellEditEvent<HarddriveModel, Integer> event) {
        try {
            if (StringToIntConv.wasSuccessful()) {
                event.getRowValue().setCapacity(event.getNewValue());
            } else {
                ErrorDialog.showErrorDialog("Capacity must be a number", "Invalid input");
            }

        } catch (InvalidCapacityException ice) {
            ErrorDialog.showErrorDialog(ice.getMessage(), "Invalid input");
        } catch (NullPointerException npe) {
            ErrorDialog.showErrorDialog("Capacity cannot be blank", "Invalid input");
        }
        tableViewVisible().refresh();
    }

    //Sets new type (String) when value (type) of choicebox in cell is changed
    @FXML
    private void editMotherboardType(TableColumn.CellEditEvent<MotherboardModel, String> event) {
        event.getRowValue().setType(event.getNewValue());
        tableViewVisible().refresh();
    }

    //Sets new attribute value when the cell is edited, displays exception if input is invalid
    @FXML
    private void editRAMMemory(TableColumn.CellEditEvent<RAMModel, Integer> event) {
        try {
            if (StringToIntConv.wasSuccessful()) {
                event.getRowValue().setMemory(event.getNewValue());
            } else {
                ErrorDialog.showErrorDialog("Memory must be a number", "Invalid input");
            }

        } catch (InvalidMemoryException ime) {
            ErrorDialog.showErrorDialog("Memory cannot be blank, must be greater then 0 and an even number", "Invalid input");
        } catch (NullPointerException npe) {
            ErrorDialog.showErrorDialog("Memory cannot be blank", "Invalid input");
        }
        tableViewVisible().refresh();
    }

    //Sets new attribute value when the cell is edited, displays exception if input is invalid
    @FXML
    private void editMemorySpeed(TableColumn.CellEditEvent<RAMModel, Double> event) {
        try {
            if (StringToDoubleConv.wasSuccessful()) {
                event.getRowValue().setMemorySpeed(event.getNewValue());
            } else {
                ErrorDialog.showErrorDialog("Memoryspeed must be a number. Use \".\" for decimals.", "Invalid input");
            }
        } catch (InvalidPerformanceValueException ipe) {
            ErrorDialog.showErrorDialog(ipe.getMessage(), "Invalid input");
        } catch (NullPointerException npe) {
            ErrorDialog.showErrorDialog("Memoryspeed cannot be blank", "Invalid input");
        }
        tableViewVisible().refresh();
    }

    //Sets new value when value of choicebox in cell is changed
    @FXML
    private void editSurround(TableColumn.CellEditEvent<SoundCardModel, String> event) {
        event.getRowValue().setSurround(event.getNewValue());
        tableViewVisible().refresh();
    }

    //Sets new value when value of choicebox in cell is changed
    @FXML
    private void editBassBoost(TableColumn.CellEditEvent<SoundCardModel, String> event) {
        event.getRowValue().setBassBoost(event.getNewValue());
        tableViewVisible().refresh();
    }

    //Sets new attribute value when the cell is edited, displays exception if input is invalid
    @FXML
    private void editWatt(TableColumn.CellEditEvent<PSUModel, Integer> event) {
        try {
            if (StringToIntConv.wasSuccessful()) {
                event.getRowValue().setWatt(event.getNewValue());
            } else {
                ErrorDialog.showErrorDialog("Watt must be a number", "Invalid input");
            }

        } catch (InvalidWattException iwe) {
            ErrorDialog.showErrorDialog(iwe.getMessage(), "Invalid input");
        } catch (NullPointerException npe) {
            ErrorDialog.showErrorDialog("Watt cannot be blank", "Invalid input");
        }
        tableViewVisible().refresh();
    }

    //Sets new attribute value when the cell is edited, displays exception if input is invalid
    @FXML
    private void editSize(TableColumn.CellEditEvent<MonitorModel, Integer> event) {
        try {
            if (StringToIntConv.wasSuccessful()) {
                event.getRowValue().setSize(event.getNewValue());
            } else {
                ErrorDialog.showErrorDialog("Size must be a number", "Invalid input");
            }

        } catch (InvalidSizeException ize) {
            ErrorDialog.showErrorDialog(ize.getMessage(), "Invalid input");
        } catch (NullPointerException npe) {
            ErrorDialog.showErrorDialog("Size cannot be blank", "Invalid input");
        }
        tableViewVisible().refresh();
    }

    //Sets new type (String) when value (type) of choicebox in cell is changed
    @FXML
    private void editMouseType(TableColumn.CellEditEvent<MouseModel, String> event) {
        event.getRowValue().setType(event.getNewValue());
        tableViewVisible().refresh();
    }

    //Sets new value when value of choicebox in cell is changed
    @FXML
    private void editMouseWireless(TableColumn.CellEditEvent<MouseModel, String> event) {
        event.getRowValue().setWireless(event.getNewValue());
        tableViewVisible().refresh();
    }

    //Sets new type (String) when value (type) of choicebox in cell is changed
    @FXML
    private void editKeyboardType(TableColumn.CellEditEvent<KeyboardModel, String> event) {
        event.getRowValue().setType(event.getNewValue());
        tableViewVisible().refresh();
    }

    //Sets new attribute value when the cell is edited, displays exception if input is invalid
    @FXML
    private void editKeyboardLanguage(TableColumn.CellEditEvent<KeyboardModel, String> event) {
        try {
            event.getRowValue().setLanguage(event.getNewValue());
        } catch (InvalidLanguageException ile) {
            ErrorDialog.showErrorDialog(ile.getMessage(), "Invalid input");
        } catch (NullPointerException npe) {
            ErrorDialog.showErrorDialog("Language cannot be blank", "Invalid input");
        }
        tableViewVisible().refresh();
    }

    //Sets new value when value of choicebox in cell is changed
    @FXML
    private void editKeyboardWireless(TableColumn.CellEditEvent<KeyboardModel, String> event) {
        event.getRowValue().setWireless(event.getNewValue());
        tableViewVisible().refresh();
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
    private void updateComputerCaseList() {
        ComputerCaseRegistry.attachTableView(tvComputercase);
    }

    private void updateCPUList() {
        CPURegistry.attachTableView(tvCPU);
    }

    private void updateGPUList() {
        GPURegistry.attachTableView(tvGPU);
    }

    private void updateHardDriveList() {
        HardDriveRegistry.attachTableView(tvHarddrive);
    }

    private void updateKeyboardList() {
        KeyboardRegistry.attachTableView(tvKeyboard);
    }

    private void updateMonitorList() {
        MonitorRegistry.attachTableView(tvMonitor);
    }

    private void updateMotherboardList() {
        MotherboardRegistry.attachTableView(tvMotherboard);
    }

    private void updateMouseList() {
        MouseRegistry.attachTableView(tvMouse);
    }

    private void updatePSUList() {
        PSURegistry.attachTableView(tvPSU);
    }

    private void updateRAMList() {
        RAMRegistry.attachTableView(tvRAM);
    }

    private void updateSoundCardList() {
        SoundCardRegistry.attachTableView(tvSoundcard);
    }

    @FXML
    private void clearFilter() {
        txtFilter.clear();
        txtFilterEntered();
    }

    //Runs different filter functions based on active tableview when text is written in filter textfield.
    @FXML
    private void txtFilterEntered() {
        TableView currentTableView = tableViewVisible();
        try {
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
        } catch (PatternSyntaxException pse) {
            // Prevents program from crashing when entered "*" in filter
        }
    }

    //Filters tableview based on input in filter textfield and attribute selected in choicebox. Displays all objects in tableview
    //if textfield is empty, displays none if component is not found.
    private void filterComputerCase() {
        if(txtFilter.getText().isBlank()) {
            updateComputerCaseList();
            return;
        }

        ObservableList<ComputerCaseModel> result = null;
        switch (cbFilterComputerCase.getValue()) {
            case "Name" : result = computerCaseRegistry.filterByName(txtFilter.getText()); break;
            case "Brand" : result = computerCaseRegistry.filterByBrand(txtFilter.getText()); break;
            case "Price" : result = computerCaseRegistry.filterByPrice(txtFilter.getText()); break;
            case "Performance value" : result = computerCaseRegistry.filterByPerformanceValue(txtFilter.getText()); break;
            case "Dimension" : result = computerCaseRegistry.filterByDimension(txtFilter.getText()); break;
            case "Color" : result = computerCaseRegistry.filterByColor(txtFilter.getText()); break;
        }

        if(result == null) {
            tvComputercase.setItems(FXCollections.observableArrayList());
        } else {
            tvComputercase.setItems(result);
        }
    }

    //Filters tableview based on input in filter textfield and attribute selected in choicebox. Displays all objects in tableview
    //if textfield is empty, displays none if component is not found.
    private void filterCPU() {
        if(txtFilter.getText().isBlank()) {
            updateCPUList();
            return;
        }

        ObservableList<CPUModel> result = null;
        switch (cbFilterCPU.getValue()) {
            case "Name" : result = cpuRegistry.filterByName(txtFilter.getText()); break;
            case "Brand" : result = cpuRegistry.filterByBrand(txtFilter.getText()); break;
            case "Price" : result = cpuRegistry.filterByPrice(txtFilter.getText()); break;
            case "Performance value" : result = cpuRegistry.filterByPerformanceValue(txtFilter.getText()); break;
            case "Dimension" : result = cpuRegistry.filterByClockSpeed((txtFilter.getText())); break;
            case "Color" : result = cpuRegistry.filterByCores((txtFilter.getText())); break;
        }

        if(result == null) {
            tvCPU.setItems(FXCollections.observableArrayList());
        } else {
            tvCPU.setItems(result);
        }
    }

    //Filters tableview based on input in filter textfield and attribute selected in choicebox. Displays all objects in tableview
    //if textfield is empty, displays none if component is not found.
    private void filterGPU() {
        if(txtFilter.getText().isBlank()) {
            updateGPUList();
            return;
        }

        ObservableList<GPUModel> result = null;
        switch (cbFilterGPU.getValue()) {
            case "Name" : result = gpuRegistry.filterByName(txtFilter.getText()); break;
            case "Brand" : result = gpuRegistry.filterByBrand(txtFilter.getText()); break;
            case "Price" : result = gpuRegistry.filterByPrice(txtFilter.getText()); break;
            case "Performance value" : result = gpuRegistry.filterByPerformanceValue(txtFilter.getText()); break;
            case "Dimension" : result = gpuRegistry.filterByClockSpeed((txtFilter.getText())); break;
            case "Memory" : result = gpuRegistry.filterByMemory((txtFilter.getText())); break;
        }

        if(result == null) {
            tvGPU.setItems(FXCollections.observableArrayList());
        } else {
            tvGPU.setItems(result);
        }
    }

    //Filters tableview based on input in filter textfield and attribute selected in choicebox. Displays all objects in tableview
    //if textfield is empty, displays none if component is not found.
    private void filterHardDrive() {
        if(txtFilter.getText().isBlank()) {
            updateHardDriveList();
            return;
        }

        ObservableList<HarddriveModel> result = null;
        switch (cbFilterHarddrive.getValue()) {
            case "Name" : result = hardDriveRegistry.filterByName(txtFilter.getText()); break;
            case "Brand" : result = hardDriveRegistry.filterByBrand(txtFilter.getText()); break;
            case "Price" : result = hardDriveRegistry.filterByPrice(txtFilter.getText()); break;
            case "Performance value" : result = hardDriveRegistry.filterByPerformanceValue(txtFilter.getText()); break;
            case "Type" : result = hardDriveRegistry.filterByType(txtFilter.getText()); break;
            case "Capacity" : result = hardDriveRegistry.filterByCapacity((txtFilter.getText())); break;
        }

        if(result == null) {
            tvHarddrive.setItems(FXCollections.observableArrayList());
        } else {
            tvHarddrive.setItems(result);
        }
    }

    //Filters tableview based on input in filter textfield and attribute selected in choicebox. Displays all objects in tableview
    //if textfield is empty, displays none if component is not found.
    private void filterKeyboard() {
        if(txtFilter.getText().isBlank()) {
            updateKeyboardList();
            return;
        }

        ObservableList<KeyboardModel> result = null;
        switch (cbFilterKeyboard.getValue()) {
            case "Name" : result = keyboardRegistry.filterByName(txtFilter.getText()); break;
            case "Brand" : result = keyboardRegistry.filterByBrand(txtFilter.getText()); break;
            case "Price" : result = keyboardRegistry.filterByPrice(txtFilter.getText()); break;
            case "Performance value" : result = keyboardRegistry.filterByPerformanceValue(txtFilter.getText()); break;
            case "Type" : result = keyboardRegistry.filterByType(txtFilter.getText()); break;
            case "Language" : result = keyboardRegistry.filterByLanguage(txtFilter.getText()); break;
            case "Wireless" : result = keyboardRegistry.filterByWireless(txtFilter.getText()); break;
        }

        if(result == null) {
            tvKeyboard.setItems(FXCollections.observableArrayList());
        } else {
            tvKeyboard.setItems(result);
        }
    }

    //Filters tableview based on input in filter textfield and attribute selected in choicebox. Displays all objects in tableview
    //if textfield is empty, displays none if component is not found.
    private void filterMonitor() {
        if(txtFilter.getText().isBlank()) {
            updateMonitorList();
            return;
        }

        ObservableList<MonitorModel> result = null;
        switch (cbFilterMonitor.getValue().toString()) {
            case "Name" : result = monitorRegistry.filterByName(txtFilter.getText()); break;
            case "Brand" : result = monitorRegistry.filterByBrand(txtFilter.getText()); break;
            case "Price" : result = monitorRegistry.filterByPrice(txtFilter.getText()); break;
            case "Performance value" : result = monitorRegistry.filterByPerformanceValue(txtFilter.getText()); break;
            case "Size" : result = monitorRegistry.filterBySize(txtFilter.getText()); break;
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
        switch (cbFilterMotherboard.getValue()) {
            case "Name" : result = motherboardRegistry.filterByName(txtFilter.getText()); break;
            case "Brand" : result = motherboardRegistry.filterByBrand(txtFilter.getText()); break;
            case "Price" : result = motherboardRegistry.filterByPrice(txtFilter.getText()); break;
            case "Performance value" : result = motherboardRegistry.filterByPerformanceValue(txtFilter.getText()); break;
            case "Type" : result = motherboardRegistry.filterByType(txtFilter.getText()); break;
        }

        if(result == null) {
            tvMotherboard.setItems(FXCollections.observableArrayList());
        } else {
            tvMotherboard.setItems(result);
        }
    }

    //Filters tableview based on input in filter textfield and attribute selected in choicebox. Displays all objects in tableview
    //if textfield is empty, displays none if component is not found.
    private void filterMouse() {
        if(txtFilter.getText().isBlank()) {
            updateMouseList();
            return;
        }

        ObservableList<MouseModel> result = null;
        switch (cbFilterMouse.getValue()) {
            case "Name" : result = mouseRegistry.filterByName(txtFilter.getText()); break;
            case "Brand" : result = mouseRegistry.filterByBrand(txtFilter.getText()); break;
            case "Price" : result = mouseRegistry.filterByPrice(txtFilter.getText()); break;
            case "Performance value" : result = mouseRegistry.filterByPerformanceValue(txtFilter.getText()); break;
            case "Type" : result = mouseRegistry.filterByType(txtFilter.getText()); break;
            case "Wireless" : result = mouseRegistry.filterByWireless(txtFilter.getText()); break;
        }

        if(result == null) {
            tvMouse.setItems(FXCollections.observableArrayList());
        } else {
            tvMouse.setItems(result);
        }
    }

    //Filters tableview based on input in filter textfield and attribute selected in choicebox. Displays all objects in tableview
    //if textfield is empty, displays none if component is not found.
    private void filterPSU() {
        if(txtFilter.getText().isBlank()) {
            updatePSUList();
            return;
        }

        ObservableList<PSUModel> result = null;
        switch (cbFilterPSU.getValue()) {
            case "Name" : result = psuRegistry.filterByName(txtFilter.getText()); break;
            case "Brand" : result = psuRegistry.filterByBrand(txtFilter.getText()); break;
            case "Price" : result = psuRegistry.filterByPrice(txtFilter.getText()); break;
            case "Performance value" : result = psuRegistry.filterByPerformanceValue(txtFilter.getText()); break;
            case "Watt" : result = psuRegistry.filterByWatt(txtFilter.getText()); break;
        }

        if(result == null) {
            tvPSU.setItems(FXCollections.observableArrayList());
        } else {
            tvPSU.setItems(result);
        }
    }

    //Filters tableview based on input in filter textfield and attribute selected in choicebox. Displays all objects in tableview
    //if textfield is empty, displays none if component is not found.
    private void filterRAM() {
        if(txtFilter.getText().isBlank()) {
            updateRAMList();
            return;
        }

        ObservableList<RAMModel> result = null;
        switch (cbFilterRAM.getValue()) {
            case "Name" : result = ramRegistry.filterByName(txtFilter.getText()); break;
            case "Brand" : result = ramRegistry.filterByBrand(txtFilter.getText()); break;
            case "Price" : result = ramRegistry.filterByPrice(txtFilter.getText()); break;
            case "Performance value" : result = ramRegistry.filterByPerformanceValue(txtFilter.getText()); break;
            case "Memory" : result = ramRegistry.filterByMemory(txtFilter.getText()); break;
            case "Memory speed" : result = ramRegistry.filterByMemorySpeed(txtFilter.getText()); break;
        }

        if(result == null) {
            tvRAM.setItems(FXCollections.observableArrayList());
        } else {
            tvRAM.setItems(result);
        }
    }

    //Filters tableview based on input in filter textfield and attribute selected in choicebox. Displays all objects in tableview
    //if textfield is empty, displays none if component is not found.
    private void filterSoundcard() {
        if(txtFilter.getText().isBlank()) {
            updateSoundCardList();
            return;
        }

        ObservableList<SoundCardModel> result = null;
        switch (cbFilterSoundcard.getValue()) {
            case "Name" : result = soundCardRegistry.filterByName(txtFilter.getText()); break;
            case "Brand" : result = soundCardRegistry.filterByBrand(txtFilter.getText()); break;
            case "Price" : result = soundCardRegistry.filterByPrice(txtFilter.getText()); break;
            case "Performance value" : result = soundCardRegistry.filterByPerformanceValue(txtFilter.getText()); break;
            case "Surround" : result = soundCardRegistry.filterBySurround(txtFilter.getText()); break;
            case "Bass boost" : result = soundCardRegistry.filterByBassBoost(txtFilter.getText()); break;
        }

        if(result == null) {
            tvSoundcard.setItems(FXCollections.observableArrayList());
        } else {
            tvSoundcard.setItems(result);
        }
    }

    //Changes window to edit configuration
    @FXML
    void adminLogOut(ActionEvent event) throws IOException {
        Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
        Parent root = FXMLLoader.load(getClass().getResource("viewConfiguration.fxml"));
        Scene viewConfScene = new Scene(root, screenSize.getWidth(), screenSize.getHeight());
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow(); //Gets information about original stage
        window.setScene(viewConfScene);
        window.setMaximized(true);
        window.show();
    }

    //Returns active (visible) tableview
    private TableView<?> tableViewVisible() {
        for (TableView tv : tableViewArray) {
            if (tv.isVisible()) {
                return tv;
            }
        }
        return tvComputercase; //If no tw is visible. Should never happen, but will prevent program from crashing.
    }

    //Switch for generating dialogboxes based on the active tableview (type of component user is working with).
    public void generateDialogAddComponent() {
        String activeTableviewID = tableViewVisible().getId();

        switch (activeTableviewID) {
            case "Computercase":
                ComputerCaseDialog computerCaseDialog = new ComputerCaseDialog();
                computerCaseDialog.display();
                break;

            case "CPU":
                CPUDialog cpuDialog = new CPUDialog();
                cpuDialog.display();
                break;

            case "GPU":
                GPUDialog gpuDialog = new GPUDialog();
                gpuDialog.display();
                break;

            case "Hard drive":
                HardDriveDialog hardDriveDialog = new HardDriveDialog();
                hardDriveDialog.display();
                break;

            case "Motherboard":
                MotherBoardDialog motherBoardDialog = new MotherBoardDialog();
                motherBoardDialog.display();
                break;

            case "RAM":
                RAMDialog ramDialog = new RAMDialog();
                ramDialog.display();
                break;

            case "Soundcard":
                SoundCardDialog soundCardDialog = new SoundCardDialog();
                soundCardDialog.display();
                break;

            case "PSU":
                PSUDialog psuDialog = new PSUDialog();
                psuDialog.display();
                break;

            case "Monitor":
                MonitorDialog monitorDialog = new MonitorDialog();
                monitorDialog.display();
                break;

            case "Mouse":
                MouseDialog mouseDialog = new MouseDialog();
                mouseDialog.display();
                break;

            case "Keyboard":
                KeyboardDialog keyboardDialog = new KeyboardDialog();
                keyboardDialog.display();
                break;
        }
        clearFilter();
    }

    //Displays dialog boxes when deleting components.
    public void deleteComponent() {
        DeleteComponentDialog deleteDialog = new DeleteComponentDialog();
        TableView activeTableview = tableViewVisible();
        Object checkIfItemSelected = activeTableview.getSelectionModel().getSelectedItem();
        if(checkIfItemSelected != null) {
            if(deleteDialog.confirmDeleteDialog()) {
                deleteSelectedComponent();
            }
        }
        else {
            DeleteComponentDialog.noComponentSelected();
        }
    }

    //Deletes selected component (row in tw).
    public void deleteSelectedComponent() {
         TableView activeTableview = tableViewVisible();
         String activeTableviewID = tableViewVisible().getId();

             switch (activeTableviewID) {
                 case "Computercase":
                     ComputerCaseRegistry.removeComponent((ComputerCaseModel) activeTableview.getSelectionModel().getSelectedItem());
                     break;

                 case "CPU":
                     CPURegistry.removeComponent((CPUModel) activeTableview.getSelectionModel().getSelectedItem());
                     break;

                 case "GPU":
                     GPURegistry.removeComponent((GPUModel) activeTableview.getSelectionModel().getSelectedItem());
                     break;

                 case "Hard drive":
                     HardDriveRegistry.removeComponent((HarddriveModel) activeTableview.getSelectionModel().getSelectedItem());
                     break;

                 case "Motherboard":
                     MotherboardRegistry.removeComponent((MotherboardModel) activeTableview.getSelectionModel().getSelectedItem());
                     break;

                 case "RAM":
                     RAMRegistry.removeComponent((RAMModel) activeTableview.getSelectionModel().getSelectedItem());
                     break;

                 case "Soundcard":
                     SoundCardRegistry.removeComponent((SoundCardModel) activeTableview.getSelectionModel().getSelectedItem());
                     break;

                 case "PSU":
                     PSURegistry.removeComponent((PSUModel) activeTableview.getSelectionModel().getSelectedItem());
                     break;

                 case "Monitor":
                     MonitorRegistry.removeComponent((MonitorModel) activeTableview.getSelectionModel().getSelectedItem());
                     break;

                 case "Mouse":
                     MouseRegistry.removeComponent((MouseModel) activeTableview.getSelectionModel().getSelectedItem());
                     break;

                 case "Keyboard":
                     KeyboardRegistry.removeComponent((KeyboardModel) activeTableview.getSelectionModel().getSelectedItem());
                     break;
                 }
         activeTableview.refresh();
     }

    //Calls on showTableview and showFilter to change when button for component is pressed.
    @FXML
    void changeActiveTableview(ActionEvent event) {
        //Gets the name of the component belonging to the button that was pressed
        String component = event.getSource().toString();
        component = component.split("]")[1];
        component = component.substring(1,component.length()-1);

        for (Button btn : chooseComponentButtons) {
            if (btn.getText().equals(component)) {
                btn.setStyle("-fx-background-color: #4F4F4F; -fx-text-fill: white");
            }
            else {
                btn.setStyle("-fx-background-color: #929292; -fx-text-fill: black;");
            }
        }
        showTableView(component);
        showFilter(component);
    }


    //Displays tableview with input from changeActiveTableview (CPU btn pressed -> CPU tableview set to visible)
    private void showTableView(String component) {
        for (TableView tv : tableViewArray) {
            if (tv.getId().equals(component)) {
                tv.setVisible(true);
            }
            else {
                tv.setVisible(false);
            }
        }
    }

    //Displays choicebox with input from changeActiveTableview (CPU btn pressed, CPU choicebox set to visible)
    private void showFilter(String component) {
        for (ChoiceBox cb : cbArray) {
            if (cb.getId().equals(component)) {
                cb.setVisible(true);
            }
            else {
                cb.setVisible(false);
            }
        }
    }

    //Displays dialogbox with information/"helptext" related to admin
    @FXML
    private void showHelp() {
        HelpDialog helpDialog = new HelpDialog();
        helpDialog.showAdminHelp();
    }

    //Mouse-hover function
    @FXML
    private void onHoverCompButton(MouseEvent event) {
        //Gets the name of the component belonging to the button that was pressed
        String component = event.getSource().toString();
        component = component.split("]")[1];
        component = component.substring(1, component.length() - 1);

        for (Button btn : chooseComponentButtons) {
            if (btn.getText().equals(component)) {
                btn.setStyle("-fx-background-color: #4F4F4F; -fx-text-fill: white");
            }
        }
    }

    //Mouse-hover function
    @FXML
    private void mouseExitCompButton(MouseEvent event) {
        //Gets the name of the component belonging to the button that was pressed
        String component = event.getSource().toString();
        component = component.split("]")[1];
        component = component.substring(1, component.length() - 1);
        if (!tableViewVisible().getId().equals(component)) {
            for (Button btn : chooseComponentButtons) {
                if (btn.getText().equals(component)) {
                    btn.setStyle("-fx-background-color: #929292; -fx-text-fill: black");
                }
            }

        }
    }
}
