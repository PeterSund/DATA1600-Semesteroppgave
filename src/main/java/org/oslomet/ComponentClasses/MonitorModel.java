package org.oslomet.ComponentClasses;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import org.oslomet.ExceptionClasses.InvalidSizeException;

public class MonitorModel extends ComponentModel {

    private SimpleIntegerProperty size;

    //Constructor
    public MonitorModel(String name, String brand, double price, double performanceValue, int size) {
        super(name, brand, price, performanceValue);
        if(!AdminInputValidation.size(size)) {
            throw new InvalidSizeException();
        }
        this.size = new SimpleIntegerProperty(size);
    }

    //Getters/Setters
    public int getSize() {
        return size.get();
    }

    public void setSize(int size) {
        if(!AdminInputValidation.size(size)) {
            throw new InvalidSizeException();
        }
        this.size.set(size);
    }

    public String toString() {
        return this.getName();
    }

    public String toStringForConfig() {
        return this.getBrand() + " " + this.getName() + ", " + this.getSize();
    }
}
