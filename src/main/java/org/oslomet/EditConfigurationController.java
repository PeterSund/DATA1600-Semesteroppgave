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
import javafx.scene.input.MouseEvent;
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
import org.oslomet.Dialogs.ErrorDialog;
import org.oslomet.Dialogs.SaveConfigurationDialog;

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
    private Label lblComputerCase, lblCPU, lblGPU, lblHardDrive, lblMotherBoard, lblRAM, lblSoundcard,
            lblPSU, lblMonitor, lblMouse, lblKeyboard, lblName, lblTotalPrice, lblTotalPerformanceValue;

    @FXML
    private Button btnDeleteComputerCase, btnDeleteCPU, btnDeleteGPU, btnDeleteHardDrive, btnDeleteMotherBoard,
            btnDeleteRAM, btnDeleteSoundCard, btnDeletePSU, btnDeleteMonitor, btnDeleteMouse, btnDeleteKeyboard;

    private ComputerModel computer;

    public List<TableView> tableViewArray = new ArrayList<>();

    public List<Button> buttonDeleteArray = new ArrayList<>();

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

        buttonDeleteArray.add(btnDeleteComputerCase);
        buttonDeleteArray.add(btnDeleteCPU);
        buttonDeleteArray.add(btnDeleteGPU);
        buttonDeleteArray.add(btnDeleteHardDrive);
        buttonDeleteArray.add(btnDeleteMotherBoard);
        buttonDeleteArray.add(btnDeleteRAM);
        buttonDeleteArray.add(btnDeleteSoundCard);
        buttonDeleteArray.add(btnDeletePSU);
        buttonDeleteArray.add(btnDeleteMonitor);
        buttonDeleteArray.add(btnDeleteMouse);
        buttonDeleteArray.add(btnDeleteKeyboard);


        for (TableView tv : tableViewArray) {
            tv.setVisible(false);
        }
        tvComputercase.setVisible(true);

        for (Button btn : buttonDeleteArray) {
            btn.setVisible(false);
        }


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


    //Delete component
    @FXML
    void deleteComponent(ActionEvent event) {

        String buttonPressed = event.getSource().toString().split("id")[1].substring(1).split(",")[0];


        if (buttonPressed.equals("ComputerCase")) {
            computer.setComputerCase(null);
            lblComputerCase.setText("");
            btnDeleteComputerCase.setVisible(false);
            lblTotalPrice.setText(String.valueOf(ComputerRegistry.calculateTotalPrice(computer)));
            lblTotalPerformanceValue.setText(String.valueOf(ComputerRegistry.calculateTotalPerformanceValue(computer)));
        }
        else if (buttonPressed.equals("CPU")) {
            computer.setCpu(null);
            lblCPU.setText("");
            btnDeleteCPU.setVisible(false);
            lblTotalPrice.setText(String.valueOf(ComputerRegistry.calculateTotalPrice(computer)));
            lblTotalPerformanceValue.setText(String.valueOf(ComputerRegistry.calculateTotalPerformanceValue(computer)));
        }
        else if (buttonPressed.equals("GPU")) {
            computer.setGpu(null);
            lblGPU.setText("");
            btnDeleteGPU.setVisible(false);
            lblTotalPrice.setText(String.valueOf(ComputerRegistry.calculateTotalPrice(computer)));
            lblTotalPerformanceValue.setText(String.valueOf(ComputerRegistry.calculateTotalPerformanceValue(computer)));
        }
        else if (buttonPressed.equals("HardDrive")) {
            computer.setHardDrive(null);
            lblHardDrive.setText("");
            btnDeleteHardDrive.setVisible(false);
            lblTotalPrice.setText(String.valueOf(ComputerRegistry.calculateTotalPrice(computer)));
            lblTotalPerformanceValue.setText(String.valueOf(ComputerRegistry.calculateTotalPerformanceValue(computer)));
        }
        else if (buttonPressed.equals("MotherBoard")) {
            computer.setMotherboard(null);
            lblMotherBoard.setText("");
            btnDeleteMotherBoard.setVisible(false);
            lblTotalPrice.setText(String.valueOf(ComputerRegistry.calculateTotalPrice(computer)));
            lblTotalPerformanceValue.setText(String.valueOf(ComputerRegistry.calculateTotalPerformanceValue(computer)));
        }
        else if (buttonPressed.equals("RAM")) {
            computer.setRam(null);
            lblRAM.setText("");
            btnDeleteRAM.setVisible(false);
            lblTotalPrice.setText(String.valueOf(ComputerRegistry.calculateTotalPrice(computer)));
            lblTotalPerformanceValue.setText(String.valueOf(ComputerRegistry.calculateTotalPerformanceValue(computer)));
        }
        else if (buttonPressed.equals("SoundCard")) {
            computer.setSoundCard(null);
            lblSoundcard.setText("");
            btnDeleteSoundCard.setVisible(false);
            lblTotalPrice.setText(String.valueOf(ComputerRegistry.calculateTotalPrice(computer)));
            lblTotalPerformanceValue.setText(String.valueOf(ComputerRegistry.calculateTotalPerformanceValue(computer)));
        }
        else if (buttonPressed.equals("PSU")) {
            computer.setPsu(null);
            lblPSU.setText("");
            btnDeletePSU.setVisible(false);
            lblTotalPrice.setText(String.valueOf(ComputerRegistry.calculateTotalPrice(computer)));
            lblTotalPerformanceValue.setText(String.valueOf(ComputerRegistry.calculateTotalPerformanceValue(computer)));
        }
        else if (buttonPressed.equals("Monitor")) {
            computer.setMonitor(null);
            lblMonitor.setText("");
            btnDeleteMonitor.setVisible(false);
            lblTotalPrice.setText(String.valueOf(ComputerRegistry.calculateTotalPrice(computer)));
            lblTotalPerformanceValue.setText(String.valueOf(ComputerRegistry.calculateTotalPerformanceValue(computer)));
        }
        else if (buttonPressed.equals("Mouse")) {
            computer.setMouse(null);
            lblMouse.setText("");
            btnDeleteMouse.setVisible(false);
            lblTotalPrice.setText(String.valueOf(ComputerRegistry.calculateTotalPrice(computer)));
            lblTotalPerformanceValue.setText(String.valueOf(ComputerRegistry.calculateTotalPerformanceValue(computer)));
        }
        else if (buttonPressed.equals("Keyboard")) {
            computer.setKeyboard(null);
            lblKeyboard.setText("");
            btnDeleteKeyboard.setVisible(false);
            lblTotalPrice.setText(String.valueOf(ComputerRegistry.calculateTotalPrice(computer)));
            lblTotalPerformanceValue.setText(String.valueOf(ComputerRegistry.calculateTotalPerformanceValue(computer)));
        }
    }

    @FXML
    void saveConfiguration(ActionEvent event) throws IOException {

        List<String> componentsNotChosen = new ArrayList<String>();

        //Checks that user has chosen all components for the computer
        if (computer.getComputerCase()==null) {
            componentsNotChosen.add("computer case");
        }
        if (computer.getCpu()==null) {
            componentsNotChosen.add("CPU");
        }
        if (computer.getGpu()==null) {
            componentsNotChosen.add("GPU");
        }
        if (computer.getRam()==null) {
            componentsNotChosen.add("RAM");
        }
        if (computer.getHardDrive()==null) {
            componentsNotChosen.add("hard drive");
        }
        if (computer.getMotherboard()==null) {
            componentsNotChosen.add("motherboard");
        }
        if (computer.getPsu()==null) {
            componentsNotChosen.add("PSU");
        }
        if (computer.getSoundCard()==null) {
            componentsNotChosen.add("sound card");
        }
        if (computer.getKeyboard()==null) {
            componentsNotChosen.add("keyboard");
        }
        if (computer.getMonitor()==null) {
            componentsNotChosen.add("monitor");
        }
        if (computer.getMouse()==null) {
            componentsNotChosen.add("mouse");
        }

        if (computer.getComputerCase()!=null && computer.getCpu()!=null && computer.getGpu()!=null && computer.getRam()!=null && computer.getHardDrive()!=null && computer.getMouse()!=null
        && computer.getMotherboard()!=null && computer.getPsu()!=null && computer.getSoundCard()!=null && computer.getKeyboard()!=null && computer.getMonitor()!=null) {
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
            SaveConfigurationDialog saveConfigurationDialog = new SaveConfigurationDialog();
            if (saveConfigurationDialog.display(componentsNotChosen)) {
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
        }
    }

    public void setComputer(ComputerModel userComputer) {
        computer = userComputer;
        showComputer();
    }

    public void showComputer() {

        //Shows computer's components only if the computer is not a new computer
        if (computer.getComputerCase() != null) {
            lblComputerCase.setText(computer.getComputerCase().toStringForConfig());
            btnDeleteComputerCase.setVisible(true);
        }
        if (computer.getCpu() != null) {
            lblCPU.setText(computer.getCpu().toStringForConfig());
            btnDeleteCPU.setVisible(true);
        }
        if (computer.getGpu() != null) {
            lblGPU.setText(computer.getGpu().toStringForConfig());
            btnDeleteGPU.setVisible(true);
        }
        if (computer.getHardDrive() != null) {
            lblHardDrive.setText(computer.getHardDrive().toStringForConfig());
            btnDeleteHardDrive.setVisible(true);
        }
        if (computer.getMotherboard() != null) {
            lblMotherBoard.setText(computer.getMotherboard().toStringForConfig());
            btnDeleteMotherBoard.setVisible(true);
        }
        if (computer.getPsu() != null) {
            lblPSU.setText(computer.getPsu().toStringForConfig());
            btnDeletePSU.setVisible(true);
        }
        if (computer.getRam() != null) {
            lblRAM.setText(computer.getRam().toStringForConfig());
            btnDeleteRAM.setVisible(true);
        }
        if (computer.getSoundCard() != null) {
            lblSoundcard.setText(computer.getSoundCard().toStringForConfig());
            btnDeleteSoundCard.setVisible(true);
        }
        if (computer.getMonitor() != null) {
            lblMonitor.setText(computer.getMonitor().toStringForConfig());
            btnDeleteMonitor.setVisible(true);
        }
        if (computer.getMouse() != null) {
            lblMouse.setText(computer.getMouse().toStringForConfig());
            btnDeleteMouse.setVisible(true);
        }
        if (computer.getKeyboard() != null) {
            lblKeyboard.setText(computer.getKeyboard().toStringForConfig());
            btnDeleteKeyboard.setVisible(true);
        }

        lblName.setText(computer.getConfigName());
        lblTotalPrice.setText(String.valueOf(ComputerRegistry.calculateTotalPrice(computer)));
        lblTotalPerformanceValue.setText(String.valueOf(ComputerRegistry.calculateTotalPerformanceValue(computer)));
    }

    @FXML
    void addComponent(MouseEvent event) {

        TableView currentTableView = isVisible();

        if (currentTableView.getSelectionModel().getSelectedItem() != null && event.getClickCount() == 2) {

            ComponentModel component = (ComponentModel) currentTableView.getSelectionModel().getSelectedItem();

            if (currentTableView.getId().equals("Computercase")) {
                lblComputerCase.setText(((ComputerCaseModel) component).toStringForConfig());
                computer.setComputerCase((ComputerCaseModel) component);
                lblTotalPrice.setText(String.valueOf(ComputerRegistry.calculateTotalPrice(computer)));
                lblTotalPerformanceValue.setText(String.valueOf(ComputerRegistry.calculateTotalPerformanceValue(computer)));
                btnDeleteComputerCase.setVisible(true);
            }

            else if (currentTableView.getId().equals("CPU")) {
                computer.setCpu((CPUModel) component);
                lblCPU.setText(((CPUModel) component).toStringForConfig());
                lblTotalPrice.setText(String.valueOf(ComputerRegistry.calculateTotalPrice(computer)));
                lblTotalPerformanceValue.setText(String.valueOf(ComputerRegistry.calculateTotalPerformanceValue(computer)));
                btnDeleteCPU.setVisible(true);
            }

            else if (currentTableView.getId().equals("GPU")) {
                lblGPU.setText(((GPUModel) component).toStringForConfig());
                computer.setGpu((GPUModel) component);
                lblTotalPrice.setText(String.valueOf(ComputerRegistry.calculateTotalPrice(computer)));
                lblTotalPerformanceValue.setText(String.valueOf(ComputerRegistry.calculateTotalPerformanceValue(computer)));
                btnDeleteGPU.setVisible(true);
            }

            else if (currentTableView.getId().equals("RAM")) {
                lblRAM.setText(((RAMModel) component).toStringForConfig());
                computer.setRam((RAMModel) component);
                lblTotalPrice.setText(String.valueOf(ComputerRegistry.calculateTotalPrice(computer)));
                lblTotalPerformanceValue.setText(String.valueOf(ComputerRegistry.calculateTotalPerformanceValue(computer)));
                btnDeleteRAM.setVisible(true);
            }

            else if (currentTableView.getId().equals("Hard drive")) {
                lblHardDrive.setText(((HarddriveModel) component).toStringForConfig());
                computer.setHardDrive((HarddriveModel) component);
                lblTotalPrice.setText(String.valueOf(ComputerRegistry.calculateTotalPrice(computer)));
                lblTotalPerformanceValue.setText(String.valueOf(ComputerRegistry.calculateTotalPerformanceValue(computer)));
                btnDeleteHardDrive.setVisible(true);
            }

            else if (currentTableView.getId().equals("Motherboard")) {
                lblMotherBoard.setText(((MotherboardModel) component).toStringForConfig());
                computer.setMotherboard((MotherboardModel) component);
                lblTotalPrice.setText(String.valueOf(ComputerRegistry.calculateTotalPrice(computer)));
                lblTotalPerformanceValue.setText(String.valueOf(ComputerRegistry.calculateTotalPerformanceValue(computer)));
                btnDeleteMotherBoard.setVisible(true);
            }

            else if (currentTableView.getId().equals("PSU")) {
                lblPSU.setText(((PSUModel) component).toStringForConfig());
                computer.setPsu((PSUModel) component);
                lblTotalPrice.setText(String.valueOf(ComputerRegistry.calculateTotalPrice(computer)));
                lblTotalPerformanceValue.setText(String.valueOf(ComputerRegistry.calculateTotalPerformanceValue(computer)));
                btnDeletePSU.setVisible(true);
            }

            else if (currentTableView.getId().equals("Soundcard")) {
                lblSoundcard.setText(((SoundCardModel) component).toStringForConfig());
                computer.setSoundCard((SoundCardModel) component);
                lblTotalPrice.setText(String.valueOf(ComputerRegistry.calculateTotalPrice(computer)));
                lblTotalPerformanceValue.setText(String.valueOf(ComputerRegistry.calculateTotalPerformanceValue(computer)));
                btnDeleteSoundCard.setVisible(true);
            }

            else if (currentTableView.getId().equals("Keyboard")) {
                lblKeyboard.setText(((KeyboardModel) component).toStringForConfig());
                computer.setKeyboard((KeyboardModel) component);
                lblTotalPrice.setText(String.valueOf(ComputerRegistry.calculateTotalPrice(computer)));
                lblTotalPerformanceValue.setText(String.valueOf(ComputerRegistry.calculateTotalPerformanceValue(computer)));
                btnDeleteKeyboard.setVisible(true);
            }

            else if (currentTableView.getId().equals("Monitor")) {
                lblMonitor.setText(((MonitorModel) component).toStringForConfig());
                computer.setMonitor((MonitorModel) component);
                lblTotalPrice.setText(String.valueOf(ComputerRegistry.calculateTotalPrice(computer)));
                lblTotalPerformanceValue.setText(String.valueOf(ComputerRegistry.calculateTotalPerformanceValue(computer)));
                btnDeleteMonitor.setVisible(true);
            }

            else if (currentTableView.getId().equals("Mouse")) {
                lblMouse.setText(((MouseModel) component).toStringForConfig());
                computer.setMouse((MouseModel) component);
                lblTotalPrice.setText(String.valueOf(ComputerRegistry.calculateTotalPrice(computer)));
                lblTotalPerformanceValue.setText(String.valueOf(ComputerRegistry.calculateTotalPerformanceValue(computer)));
                btnDeleteMouse.setVisible(true);
            }
        }
    }


   

}


