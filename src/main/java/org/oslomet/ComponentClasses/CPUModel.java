package org.oslomet.ComponentClasses;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class CPUModel extends ComponentModel {

    private SimpleIntegerProperty intClockSpeed, intCores;
    private SimpleDoubleProperty doubleFrequency;

    //Constructor
    public CPUModel(String txtName, String txtBrand, double doublePrice, double doublePerformanceValue, int intClockSpeed, double doubleFrequency, int intCores) {
        super(txtName, txtBrand, doublePrice, doublePerformanceValue);
        this.intClockSpeed = new SimpleIntegerProperty(intClockSpeed);
        this.doubleFrequency = new SimpleDoubleProperty(doubleFrequency);
        this.intCores = new SimpleIntegerProperty(intCores);

    }

    //Getters/Setters
    public int getIntClockSpeed() {return intClockSpeed.get(); }

    public void setIntClockSpeed(int intClockSpeed) {this.intClockSpeed.set(intClockSpeed); }

    public double getDoubleFrequency() {return doubleFrequency.get(); }

    public void setDoubleFrequency(int doubleFrequency) {this.doubleFrequency.set(doubleFrequency); }

    public int getIntCores() {return intCores.get(); }

    public void setIntCores(int intCores) {this.intCores.set(intCores); }

}

