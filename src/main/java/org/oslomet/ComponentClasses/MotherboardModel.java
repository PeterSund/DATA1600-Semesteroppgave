package org.oslomet.ComponentClasses;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class MotherboardModel extends ComponentModel {

    private SimpleStringProperty type;

    //Constructor
    public MotherboardModel(String name, String brand, double price, double performanceValue, String type) {
        super(name, brand, price, performanceValue);
        this.type = new SimpleStringProperty(type);
    }

    //Getters/Setters
    public String getType() {
        return type.get();
    }

    public void setType(String type) {
        this.type.set(type);
    }
}
