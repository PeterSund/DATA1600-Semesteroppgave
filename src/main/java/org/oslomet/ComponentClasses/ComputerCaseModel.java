package org.oslomet.ComponentClasses;

import javafx.beans.property.SimpleStringProperty;

public class ComputerCaseModel extends ComponentModel {

    private SimpleStringProperty txtDimensions, txtColor;

    //Constructor
    public ComputerCaseModel(String txtName, String txtBrand, double doublePrice, double doublePerformanceValue, String txtDimensions, String txtColor) {
        super(txtName, txtBrand, doublePrice, doublePerformanceValue);
        this.txtDimensions = new SimpleStringProperty(txtDimensions);
        this.txtColor = new SimpleStringProperty(txtColor);
    }

    public String getTxtDimensions() {
        return txtDimensions.get();
    }

    public void setTxtDimensions(String txtDimensions) {
        this.txtDimensions.set(txtDimensions);
    }

    public String getTxtColor() {
        return txtColor.get();
    }

    public void setTxtColor(String txtColor) {
        this.txtColor.set(txtColor);
    }
}
