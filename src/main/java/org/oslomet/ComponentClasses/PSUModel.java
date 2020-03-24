package org.oslomet.ComponentClasses;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class PSUModel extends ComponentModel {
    private SimpleIntegerProperty intWatt;

    //Constructor
    public PSUModel(String txtName, String txtBrand, double doublePrice, double doublePerformanceValue, int intWatt) {
        super(txtName, txtBrand, doublePrice, doublePerformanceValue);
        this.intWatt = new SimpleIntegerProperty(intWatt);
    }

    //Getters/Setters
    public int getIntWatt() {
        return intWatt.get();
    }
    public void setIntWatt(int intWatt) {
        this.intWatt.set(intWatt);
    }
}
