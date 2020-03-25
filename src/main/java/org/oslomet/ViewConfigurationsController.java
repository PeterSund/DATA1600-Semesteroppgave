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
import org.oslomet.ComputerClasses.ComputerRegistry;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ViewConfigurationsController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ComputerRegistry.attachTableView(tableviewMyConfigs);
    }

    @FXML
    private Button btnEditConfig;

    @FXML
    private Label lbl1;

    @FXML
    private MenuBar menubarEditConfig;

    @FXML
    private Menu loginAdmin;

    @FXML
    private Menu getHelp;

    @FXML
    private TableView<?> tableviewMyConfigs;

    @FXML
    private Button btnDeleteConfig;

    @FXML
    private Button btnSaveConfigs;

    @FXML
    void adminLogin(ActionEvent event) {

    }

    @FXML
    void deleteConfig(ActionEvent event) {
        String ut = ComputerRegistry.getValue();
        lbl1.setText(ut);

    }

    @FXML
    void saveConfigs(ActionEvent event) {

    }

    @FXML
    void showHelp(ActionEvent event) {

    }

    /*
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Context.getInstance().getList();
    }

     */

    //Change to view to primary controller
    @FXML
    void changePrimaryController(ActionEvent event) throws IOException {
        Parent viewConfParent = FXMLLoader.load(getClass().getResource("editConfiguration.fxml"));
        Scene viewConfScene = new Scene(viewConfParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow(); //Gets inforation about original stage
        window.setScene(viewConfScene);
        window.show();
    }

    @FXML
    void getLastConf(ActionEvent event) throws IOException {
        lbl1.setText(Context.getObj());
    }
}
