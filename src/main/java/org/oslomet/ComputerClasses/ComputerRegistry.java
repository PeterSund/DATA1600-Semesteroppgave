package org.oslomet.ComputerClasses;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import java.io.Serializable;

public class ComputerRegistry implements Serializable {

    //Initialize array
    private transient static ObservableList<ComputerModel> computerArray = FXCollections.observableArrayList();
    public void attachTableView(TableView tv) {
        tv.setItems(computerArray);
    }

    //Add computer
    public static void addComputer(ComputerModel computer) {
        computerArray.add(computer);
    }
}
