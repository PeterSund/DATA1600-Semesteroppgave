package org.oslomet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.oslomet.ComponentClasses.*;
import org.oslomet.ComponentRegistry.*;
import org.oslomet.ComputerClasses.ComputerModel;
import org.oslomet.ComputerClasses.ComputerRegistry;
import org.oslomet.Dialogs.HelpDialog;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import org.oslomet.Dialogs.LoginDialog;
import org.oslomet.Dialogs.SaveConfigurationDialog;
import org.oslomet.Validation.AdminInputValidation;


public class EditConfigurationController implements Initializable {

    @FXML
    private TableView<?> tvMouse, tvCPU, tvGPU, tvHarddrive, tvMotherboard, tvRAM, tvSoundcard, tvPSU, tvMonitor, tvComputercase, tvKeyboard;

    @FXML
    private Label lblComputerCase, lblCPU, lblGPU, lblHardDrive, lblMotherBoard, lblRAM, lblSoundcard,  lblPSU, lblMonitor,
            lblMouse, lblKeyboard, lblName, lblTotalPrice, lblTotalPerformanceValue, lblPerformanceValueProgressText;

    @FXML
    private Button btnDeleteComputerCase, btnDeleteCPU, btnDeleteGPU, btnDeleteHardDrive, btnDeleteMotherBoard,
            btnDeleteRAM, btnDeleteSoundCard, btnDeletePSU, btnDeleteMonitor, btnDeleteMouse, btnDeleteKeyboard;

    @FXML
    private ProgressIndicator progressbarPV;

    public List<TableView> tableViewArray = new ArrayList<>();

    public List<Button> buttonDeleteArray = new ArrayList<>();

    private ComputerModel computer;

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

        tableViewArray = Arrays.asList(tvMouse, tvCPU, tvGPU, tvHarddrive, tvMotherboard, tvRAM, tvSoundcard, tvPSU, tvMonitor, tvComputercase, tvKeyboard);

        buttonDeleteArray = Arrays.asList(btnDeleteComputerCase, btnDeleteCPU, btnDeleteGPU, btnDeleteHardDrive, btnDeleteMotherBoard,
                btnDeleteRAM, btnDeleteSoundCard, btnDeletePSU, btnDeleteMonitor, btnDeleteMouse, btnDeleteKeyboard);

        //Makes all tableviews invisible except for computer case tableview
        for (TableView tv : tableViewArray) {
            tv.setVisible(false);
        }
        tvComputercase.setVisible(true);

        //Makes all delete buttons invisible
        for (Button btn : buttonDeleteArray) {
            btn.setVisible(false);
        }
    }

    //Change table view
    @FXML
    private void changeActiveTableView(ActionEvent event) {

        //Gets the name of the component belonging to the button that was pressed
        String component = event.getSource().toString();
        component = component.split("]")[1];
        component = component.substring(1,component.length()-1);



        //Makes all table views invisible except for the table view that belongs to the component
        for (TableView tv : tableViewArray) {
            if (tv.getId().equals(component)) {
                tv.setVisible(true);
            }
            else {
                tv.setVisible(false);
            }
        }
    }

    //Change view to Admin
    @FXML
    private void adminLoginFromBtn(ActionEvent event) throws IOException {
        LoginDialog loginDialog = new LoginDialog();
        if (loginDialog.display()) {
            Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
            Parent root = FXMLLoader.load(getClass().getResource("admin.fxml"));
            Scene viewConfScene = new Scene(root, screenSize.getWidth(), screenSize.getHeight());
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow(); //Gets information about original stage
            window.setScene(viewConfScene);
            window.setMaximized(true);
            window.show();
        }
    }

    //Returns the table view that is visible
    private TableView tableViewVisible() {
        for (TableView tv : tableViewArray) {
            if (tv.isVisible()) {
                return tv;
            }
        }
        return tvComputercase;
    }

    //Deletes selected component and updates computer, labels and progress indicator
    @FXML
    private void deleteComponent(ActionEvent event) {

        //Gets the name of component belonging to the delete button that was pressed
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
        updateProgIndicatorTotalPV();
    }

    //Adds the configuration to the ComputerRegistry array
    @FXML
    private void saveConfiguration(ActionEvent event) throws IOException {

        List<String> componentsNotChosen = new ArrayList<String>();

        //Checks if the configuration is missing any components
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

        //If there are no missing components, save configuration
        if (computer.getComputerCase()!=null && computer.getCpu()!=null && computer.getGpu()!=null && computer.getRam()!=null && computer.getHardDrive()!=null && computer.getMouse()!=null
        && computer.getMotherboard()!=null && computer.getPsu()!=null && computer.getSoundCard()!=null && computer.getKeyboard()!=null && computer.getMonitor()!=null) {
            save(computer, event);
        }

        //Displays a warning to the user that the configuration is missing components
        //The user can then choose to cancel the save operation and continure editing the configuration
        //OR save the configuration with missing components
        else {
            SaveConfigurationDialog saveConfigurationDialog = new SaveConfigurationDialog();
            if (saveConfigurationDialog.display(componentsNotChosen)) {
               save(computer, event);
            }
        }
    }

    //Gets computer from ViewConfiguration controller
    public void setComputer(ComputerModel userComputer) {
        computer = userComputer;
        showComputer();
    }

    //Updates labels and makes delete buttons visible for all the existing components
    private void showComputer() {
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
        updateProgIndicatorTotalPV();
    }

    //Updates computer, labels and progress indicator when a new component is selected
    @FXML
    void addComponent(MouseEvent event) {

        TableView currentTableView = tableViewVisible();

        //Checks if user has double clicked a component
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
        updateProgIndicatorTotalPV();
    }

    //Displays help dialog
    public void showHelp() {
        HelpDialog helpDialog = new HelpDialog();
        helpDialog.showEditConfigHelp();
    }

    //Updates the progress indicator based on the computer's curret performance value
    //The color will gradually change when the performance value becomes higher
    private void updateProgIndicatorTotalPV() {
        double totalPV = computer.getTotalPerformanceValue() / AdminInputValidation.MAX_PERFORMANCE_TOTALVALUE;
        progressbarPV.setProgress(totalPV);

        if(totalPV < 0.3) {
            progressbarPV.setStyle(" -fx-progress-color: red;");
            lblPerformanceValueProgressText.setText("Your computer will have a low performance");
            lblPerformanceValueProgressText.setStyle(" -fx-text-base-color: red;");

        }

        if(totalPV > 0.3 && totalPV < 0.6) {
            progressbarPV.setStyle(" -fx-progress-color: orange;");
            lblPerformanceValueProgressText.setText("Your computer will have a OK performance");
            lblPerformanceValueProgressText.setStyle(" -fx-text-base-color: orange;");
        }

        if(totalPV > 0.6) {
            progressbarPV.setStyle(" -fx-progress-color: green;");
            lblPerformanceValueProgressText.setText("Your computer will have a good performance");
            lblPerformanceValueProgressText.setStyle(" -fx-text-base-color: green;");
        }
        if(totalPV > 0.9) {
            lblPerformanceValueProgressText.setText("Your computer will have a BEAST performance");
            lblPerformanceValueProgressText.setStyle(" -fx-text-base-color: darkgreen;");
        }
    }

    //Adds current configuration to computer registry array
    private void save(ComputerModel computer, ActionEvent event) throws IOException {
        int computerIndex = ComputerRegistry.findComputer(computer);

        //If the computer doesn't exist, add it
        if (computerIndex < 0) {
            ComputerRegistry.addComputer(computer);
        }

        //If it exists, replace it
        else {
            ComputerRegistry.replaceComputer(computer, computerIndex);
        }

        //Change view to viewConfiguration controller
        Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
        Parent root = FXMLLoader.load(getClass().getResource("viewConfiguration.fxml"));
        Scene viewConfScene = new Scene(root, screenSize.getWidth(), screenSize.getHeight());
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow(); //Gets information about original stage
        window.setScene(viewConfScene);
        window.setMaximized(true);
        window.show();
    }

}


