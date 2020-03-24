package org.oslomet.ComponentClasses;

import javafx.beans.property.SimpleStringProperty;

public class ComputerCaseModel extends ComponentModel {

    SimpleStringProperty txtDimensions, txtColor;

    public ComputerCaseModel(String txtName, String txtBrand, double doublePrice, double doublePerformanceValue, String txtDimensions, String txtColor) {
        super(txtName, txtBrand, doublePrice, doublePerformanceValue);
        this.txtDimensions = new SimpleStringProperty(txtDimensions);
        this.txtColor = new SimpleStringProperty(txtColor);
    }

    public String getTxtDimensions() {
        return txtDimensions.get();
    }

    public SimpleStringProperty txtDimensionsProperty() {
        return txtDimensions;
    }

    public void setTxtDimensions(String txtDimensions) {
        this.txtDimensions.set(txtDimensions);
    }

    public String getTxtColor() {
        return txtColor.get();
    }

    public SimpleStringProperty txtColorProperty() {
        return txtColor;
    }

    public void setTxtColor(String txtColor) {
        this.txtColor.set(txtColor);
    }
}
