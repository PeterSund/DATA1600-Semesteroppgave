package org.oslomet.ComponentClasses;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import org.oslomet.ExceptionClasses.InvalidWattException;

public class PSUModel extends ComponentModel {
    private SimpleIntegerProperty watt;

    //Constructor
    public PSUModel(String name, String brand, double price, double performanceValue, int watt) {
        super(name, brand, price, performanceValue);
        if(!AdminInputValidation.watt(watt)) {
            throw new InvalidWattException("Watt cannot be blank and must be between 0 and " + AdminInputValidation.MAX_WATT);
        }
        this.watt = new SimpleIntegerProperty(watt);
    }

    //Getters/Setters
    public int getWatt() {
        return watt.get();
    }
    public void setWatt(int watt) {
        if(!AdminInputValidation.watt(watt)) {
            throw new InvalidWattException("Watt cannot be blank and must be between 0 and " + AdminInputValidation.MAX_WATT);
        }
        this.watt.set(watt);
    }

    public String toString() {
        return this.getName();
    }

    public String toStringForConfig() {
        return this.getBrand() + " " + this.getName() + ", " + this.getWatt();
    }

    public String toStringForTxtFile() {
        String formattedComponent = "PSU";
        formattedComponent += formatComponentForTxtFile();
        formattedComponent += ";Watt: " + getWatt();
        return formattedComponent;
    }
}
