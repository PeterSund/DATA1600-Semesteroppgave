package org.oslomet.ComponentClasses;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class RAMModel extends ComponentModel {

    private SimpleIntegerProperty intCapacity;
    private SimpleDoubleProperty doubleMemorySpeed;

    //Constructor
    public RAMModel(String txtName, String txtBrand, double doublePrice, double doublePerformanceValue, int intCapacity, double doubleMemorySpeed) {
        super(txtName, txtBrand, doublePrice, doublePerformanceValue);
        this.intCapacity = new SimpleIntegerProperty(intCapacity);
        this.doubleMemorySpeed = new SimpleDoubleProperty(doubleMemorySpeed);
    }

    public int getIntCapacity() {
        return intCapacity.get();
    }

    public void setIntCapacity(int intCapacity) {
        this.intCapacity.set(intCapacity);
    }

    public double getDoubleMemorySpeed() {
        return doubleMemorySpeed.get();
    }

    public void setDoubleMemorySpeed(double doubleMemorySpeed) {
        this.doubleMemorySpeed.set(doubleMemorySpeed);
    }
}
