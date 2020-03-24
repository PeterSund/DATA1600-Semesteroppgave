package org.oslomet.ComponentClasses;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class PSUModel extends ComponentModel {
    private SimpleIntegerProperty watt;

    //Constructor
    public PSUModel(String name, String brand, double price, double performanceValue, int watt) {
        super(name, brand, price, performanceValue);
        this.watt = new SimpleIntegerProperty(watt);
    }

    //Getters/Setters
    public int getWatt() {
        return watt.get();
    }
    public void setWatt(int watt) {
        this.watt.set(watt);
    }
}
