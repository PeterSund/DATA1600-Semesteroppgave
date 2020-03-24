package org.oslomet.ComponentClasses;

import javafx.beans.property.SimpleIntegerProperty;

public class GPUModel extends ComponentModel {

    private SimpleIntegerProperty intClockSpeed, intMemory;

    //Constructor
    public GPUModel(String txtName, String txtBrand, double doublePrice, double doublePerformanceValue, int intClockSpeed, int intMemory) {
        super(txtName, txtBrand, doublePrice, doublePerformanceValue);
        this.intClockSpeed = new SimpleIntegerProperty(intClockSpeed);
        this.intMemory = new SimpleIntegerProperty(intMemory);

    }
    //Setters/Setters
    public int getIntClockSpeed() {return intClockSpeed.get(); }

    public void setIntClockSpeed(int intClockSpeed) {this.intClockSpeed.set(intClockSpeed); }

    public int getIntMemory() {return intMemory.get(); }

    public void setIntMemory(int intMemory) {this.intMemory.set(intMemory); }
    }

