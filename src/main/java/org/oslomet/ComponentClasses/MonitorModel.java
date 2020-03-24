package org.oslomet.ComponentClasses;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class MonitorModel extends ComponentModel {

    private SimpleIntegerProperty intSize;

    //Constructor
    public MonitorModel(String txtName, String txtBrand, double doublePrice, double doublePerformanceValue, int intSize) {
        super(txtName, txtBrand, doublePrice, doublePerformanceValue);
        this.intSize = new SimpleIntegerProperty(intSize);
    }

    //Getters/Setters
    public int getIntSize() {
        return intSize.get();
    }

    public void setIntSize(int intSize) {
        this.intSize.set(intSize);
    }
}
