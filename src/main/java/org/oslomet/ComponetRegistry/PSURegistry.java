package org.oslomet.ComponetRegistry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import org.oslomet.ComponentClasses.PSUModel;

public class PSURegistry implements RegistryMethods  {
    //Initialize array
    private static ObservableList<PSUModel> psuArray = FXCollections.observableArrayList();
    public static void attachTableView(TableView tv) {
        tv.setItems(psuArray);
    }

    //Add component to array
    public static void addComponent(PSUModel psu) {
        psuArray.add(psu);
    }

    //Removes selected component from array by comparing names
    public static void removeComponent(PSUModel psu) {
        for (PSUModel obj : psuArray) {
            if (obj.getName().equals(psu.getName())) {
                psuArray.remove(psu);
            }
        }
    }
}
