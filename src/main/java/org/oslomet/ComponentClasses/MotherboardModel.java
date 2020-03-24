package org.oslomet.ComponentClasses;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class MotherboardModel extends ComponentModel {

    private SimpleStringProperty txtType;

    //Constructor
    public MotherboardModel(String txtName, String txtBrand, double doublePrice, double doublePerformanceValue, String txtType) {
        super(txtName, txtBrand, doublePrice, doublePerformanceValue);
        this.txtType = new SimpleStringProperty(txtType);
    }

    //Getters/Setters
    public String getTxtType() {
        return txtType.get();
    }

    public void setTxtType(String txtType) {
        this.txtType.set(txtType);
    }
}
