package org.oslomet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.oslomet.Dialogs.ComputerNameDialog;
import org.oslomet.Dialogs.LoginDialog;
import org.oslomet.ComputerClasses.ComputerModel;
import org.oslomet.ComputerClasses.ComputerRegistry;
import org.oslomet.Dialogs.ErrorDialog;
import org.oslomet.Dialogs.HelpDialog;
import org.oslomet.ExceptionClasses.*;
import org.oslomet.FileHandling.FileChooser;
import org.oslomet.FileHandling.FileSaverTxt;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ResourceBundle;

public class ViewConfigurationsController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ComputerRegistry.attachTableView(tableviewMyConfigs);
    }


    @FXML
    private TableView<?> tableviewMyConfigs;

    @FXML
    //Login dialog box appears when you click login button and sends user to admin page
    void adminLogin(ActionEvent event) throws IOException {
        LoginDialog loginDialog = new LoginDialog();
        if(loginDialog.display()) {
            Parent viewConfParent = FXMLLoader.load(getClass().getResource("admin.fxml"));
            Scene viewConfScene = new Scene(viewConfParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow(); //Gets information about original stage
            window.setScene(viewConfScene);
            window.show();
        }
    }

    @FXML
    void deleteConfig(ActionEvent event) {

        ComputerModel selectedComputer = (ComputerModel) tableviewMyConfigs.getSelectionModel().getSelectedItem();

        if (selectedComputer == null) {
            ErrorDialog.showErrorDialog("Need to select a computer", "No computer selected");
        }

        else {
            ComputerRegistry.deleteComputer(selectedComputer);
        }
    }

    @FXML
    void saveConfig(ActionEvent event) throws IOException {

        ComputerModel selectedComputer = (ComputerModel) tableviewMyConfigs.getSelectionModel().getSelectedItem();

        if (selectedComputer == null) {
            ErrorDialog.showErrorDialog("Need to select a computer", "No computer selected");
        }

        else {
            Path savedFilepath = FileChooser.saveTxtFile();
            String formattedComputer = selectedComputer.formatComputerForFile();
            FileSaverTxt.writeFile(savedFilepath, formattedComputer);
        }
    }

    @FXML
    void openConfig(ActionEvent event) throws IOException {

        try {
            ComputerModel computerFromFile = ComputerRegistry.readFromFile();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("editConfiguration.fxml"));
            Parent root = loader.load();
            EditConfigurationController editConfigurationController = loader.getController();

            editConfigurationController.setComputer(computerFromFile);
            Scene viewConfScene = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow(); //Gets inforation about original stage
            window.setScene(viewConfScene);
            window.show();
        }
        catch (NullPointerException npe) {
            ErrorDialog.showErrorDialog("Text file is corrupted and can't be opened!", "File corrupted");
        }
    }

    @FXML
    void showHelp(ActionEvent event) {
        HelpDialog helpDialog = new HelpDialog();
        helpDialog.showConfigHelp();
    }

    //Edit selected computer
    public void editConfig(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("editConfiguration.fxml"));
        Parent root = loader.load();
        EditConfigurationController editConfigurationController = loader.getController();


        ComputerModel selectedComputer = (ComputerModel) tableviewMyConfigs.getSelectionModel().getSelectedItem();

        //Checks if user has selectet a computer
        if (selectedComputer == null) {
            ErrorDialog.showErrorDialog("Need to select a computer!", "No computer selected");
        }

        else {
            editConfigurationController.setComputer(selectedComputer);
            Scene viewConfScene = new Scene(root);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow(); //Gets inforation about original stage
            window.setScene(viewConfScene);
            window.show();

        }
        
    }

    public void editConfigName(TableColumn.CellEditEvent<ComputerModel, String> event) {
        try {
            event.getRowValue().setConfigName(event.getNewValue());

        } catch(InvalidConfigNameException icne) {
            ErrorDialog.showErrorDialog(icne.getMessage(), "Invalid name");
        }
        tableviewMyConfigs.refresh();
    }

    //Create new computer
    @FXML
    void newConf(ActionEvent event) throws IOException {

        ComputerNameDialog cnd = new ComputerNameDialog();
        String name = cnd.display();

        if (name != null) {
            ComputerModel newComputer = new ComputerModel(name, null, null, null, null, null, null, null, null, null, null, null, 0,0);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("editConfiguration.fxml"));
            Parent root = loader.load();
            EditConfigurationController editConfigurationController = loader.getController();
            editConfigurationController.setComputer(newComputer);
            Scene viewConfScene = new Scene(root);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow(); //Gets inforation about original stage
            window.setScene(viewConfScene);
            window.show();
        }

    }
    
}
