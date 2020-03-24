package org.oslomet.ComponentClasses;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class KeyboardModel extends ComponentModel {

    private SimpleStringProperty txtType, txtLanguage;
    private SimpleBooleanProperty booleanWireless;

    //Constructor
    public KeyboardModel(String txtName, String txtBrand, double doublePrice, double doublePerformanceValue,
                         String txtType, String txtLanguage, boolean booleanWireless) {
        super(txtName, txtBrand, doublePrice, doublePerformanceValue);
        this.txtType = new SimpleStringProperty(txtType);
        this.txtLanguage = new SimpleStringProperty(txtLanguage);
        this.booleanWireless = new SimpleBooleanProperty(booleanWireless);
    }

    //Getters/Setters
    public String getTxtType() {
        return txtType.get();
    }

    public void setTxtType(String txtType) {
        this.txtType.set(txtType);
    }

    public String getTxtLanguage() {
        return txtLanguage.get();
    }

    public void setTxtLanguage(String txtLanguage) {
        this.txtLanguage.set(txtLanguage);
    }

    public boolean isBooleanWireless() {
        return booleanWireless.get();
    }

    public void setBooleanWireless(boolean booleanWireless) {
        this.booleanWireless.set(booleanWireless);
    }
}
