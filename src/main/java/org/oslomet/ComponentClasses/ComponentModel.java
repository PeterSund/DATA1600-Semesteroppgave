package org.oslomet.ComponentClasses;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ComponentModel {

    private SimpleStringProperty txtName, txtBrand;
    private SimpleDoubleProperty doublePrice, doublePerformanceValue;

    //Constructor
    public ComponentModel(String txtName, String txtBrand, double doublePrice, double doublePerformanceValue) {
        this.txtName = new SimpleStringProperty(txtName);
        this.txtBrand = new SimpleStringProperty(txtBrand);
        this.doublePrice = new SimpleDoubleProperty(doublePrice);
        this.doublePerformanceValue = new SimpleDoubleProperty(doublePerformanceValue);
    }

    //Getters/Setters
    public String getTxtName() {
        return txtName.get();
    }

    public void setTxtName(String txtName) {
        this.txtName.set(txtName);
    }

    public String getTxtBrand() {
        return txtBrand.get();
    }

    public void setTxtBrand(String txtBrand) {
        this.txtBrand.set(txtBrand);
    }

    public double getDoublePrice() {
        return doublePrice.get();
    }

    public void setDoublePrice(double doublePrice) {
        this.doublePrice.set(doublePrice);
    }

    public double getDoublePerformanceValue() {
        return doublePerformanceValue.get();
    }

    public void setDoublePerformanceValue(double doublePerformanceValue) {
        this.doublePerformanceValue.set(doublePerformanceValue);
    }
}
