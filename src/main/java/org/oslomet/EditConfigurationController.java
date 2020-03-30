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
import org.oslomet.ComputerClasses.ComputerModel;
import org.oslomet.ComputerClasses.ComputerRegistry;

public class EditConfigurationController implements Initializable {

    ComputerRegistry configs = new ComputerRegistry();

    @FXML
    private Button btnComputerCase;

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
    private Button btnKeyboard;

    @FXML
    private MenuBar menubarEditConfig;

    @FXML
    private Menu loginAdmin;

    @FXML
    private Menu getHelp;

    @FXML
    private TableView<?> tableviewMyConfig;

    @FXML
    private Button btnRemoveComp;

    @FXML
    private Button btnSaveConfig;

    @FXML
    private TableView<?> twComputercase;

    @FXML
    private TableView<?> twCPU;

    @FXML
    private TableView<?> twGPU;

    @FXML
    private TableView<?> twHardDrive;

    @FXML
    private TableView<?> twMotherboard;

    @FXML
    private TableView<?> twRAM;

    @FXML
    private TableView<?> twSoundcard;

    @FXML
    private TableView<?> twPSU;

    @FXML
    private TableView<?> twMonitor;

    @FXML
    private TableView<?> twMouse;

    @FXML
    private TableView<?> twKeyboard;


    public TableView[] tableViewArray2 = {twComputercase, twCPU, twGPU, twHardDrive, twKeyboard, twMonitor, twMotherboard, twMouse, twPSU, twRAM, twSoundcard};

    public List<TableView> tableViewArray = new ArrayList<>();

    @FXML
    void adminLogin(ActionEvent event) {

    }

    @FXML
    void removeComponent(ActionEvent event) {
        ComputerCaseModel case1 = new ComputerCaseModel("Case", "Hans", 20.0, 20.0, "qwd","blue");
        CPUModel cpu = new CPUModel("CPU", "Hans", 40.0, 20.0, 5, 3.2, 4);
        GPUModel gpu = new GPUModel("GPU", "Hans", 50.0, 10.0, 4, 512);
        HarddriveModel hdd = new HarddriveModel("HDD", "Hans",100.0, 14.0, "SSD", 400);
        KeyboardModel keyboard = new KeyboardModel("Keys", "Hans", 20.0, 1.0, "Office", "NOR", true);
        MonitorModel monitor = new MonitorModel("Monitor", "Hans", 10.5, 5.5, 21);
        MotherboardModel motherboard = new MotherboardModel("Motherboard", "Hans", 12.0, 10.0, "ATX");
        SoundCardModel sc1 = new SoundCardModel("SC1", "Logitech", 499, 20, true, true);
        RAMModel RAM1 = new RAMModel("RAM1", "Acer", 1000, 25, 300, 400);
        PSUModel PSU1 = new PSUModel("PSU1", "Dell", 200, 400, 500);
        MouseModel Mouse1 = new MouseModel("Mouse1", "Logitech", 300, 0, "Gaming", true);

        ComputerModel testPC = new ComputerModel("TestPC", case1, cpu, gpu, RAM1, hdd, motherboard, PSU1, sc1, keyboard, monitor, Mouse1, 100.5, 100);

        configs.addComputer(testPC);


    }

    @FXML
    void saveConfig(ActionEvent event) {

    }



    public void showTableView(String component) {

        for (TableView tv : tableViewArray) {
            System.out.print(tv.getId());
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

    @FXML
    void showHelp(ActionEvent event) {

    }

    @FXML
    private TextField txt1;

    //Change view
    @FXML
    void changeToViewConfigurations(ActionEvent event) throws IOException {
        Parent viewConfParent = FXMLLoader.load(getClass().getResource("viewConfiguration.fxml"));
        Scene viewConfScene = new Scene(viewConfParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow(); //Gets inforation about original stage
        window.setScene(viewConfScene);
        window.show();
    }

    @FXML
    void addToArray(ActionEvent event) throws IOException {
        Context.addToArray(txt1.getText());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableViewArray.add(twComputercase);
        tableViewArray.add(twCPU);
        tableViewArray.add(twGPU);
        tableViewArray.add(twHardDrive);
        tableViewArray.add(twKeyboard);
        tableViewArray.add(twMonitor);
        tableViewArray.add(twMotherboard);
        tableViewArray.add(twMouse);
        tableViewArray.add(twPSU);
        tableViewArray.add(twRAM);
        tableViewArray.add(twSoundcard);
    }
}


