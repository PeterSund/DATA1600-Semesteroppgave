package org.oslomet.ComponentClasses;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class HarddriveModel extends ComponentModel {

    private SimpleStringProperty txtType;
    private SimpleIntegerProperty intCapacity;

    //Constructor
    public HarddriveModel(String txtName, String txtBrand, double doublePrice, double doublePerformanceValue, String txtType, int intCapacity) {
        super(txtName, txtBrand, doublePrice, doublePerformanceValue);
        this.txtType = new SimpleStringProperty(txtType);
        this.intCapacity = new SimpleIntegerProperty(intCapacity);
    }

    //Getters/Setters
    public String getTxtType() {
        return txtType.get();
    }

    public void setTxtType(String txtType) {
        this.txtType.set(txtType);
    }

    public int getIntCapacity() {
        return intCapacity.get();
    }


    public void setIntCapacity(int intCapacity) {
        this.intCapacity.set(intCapacity);
    }

}
