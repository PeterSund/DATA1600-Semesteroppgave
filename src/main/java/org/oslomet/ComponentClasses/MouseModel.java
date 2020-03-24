package org.oslomet.ComponentClasses;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class MouseModel extends ComponentModel {

    private SimpleStringProperty txtType;
    private SimpleBooleanProperty booleanWireless;

    public MouseModel(String txtName, String txtBrand, double doublePrice, double doublePerformanceValue, String txtType, boolean booleanWireless) {
        super(txtName, txtBrand, doublePrice, doublePerformanceValue);
        this.txtType = new SimpleStringProperty(txtType);
        this.booleanWireless = new SimpleBooleanProperty(booleanWireless);
    }

    //Getters/Setters
    public String getTxtType() {
        return txtType.get();
    }

    public void setTxtType(String txtType) {
        this.txtType.set(txtType);
    }

    public boolean isBooleanWireless() {
        return booleanWireless.get();
    }
    public void setBooleanWireless(boolean booleanWireless) {
        this.booleanWireless.set(booleanWireless);
    }

}
