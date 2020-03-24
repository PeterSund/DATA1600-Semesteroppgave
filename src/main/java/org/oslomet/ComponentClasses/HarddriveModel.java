package org.oslomet.ComponentClasses;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class HarddriveModel extends ComponentModel {

    private SimpleStringProperty type;
    private SimpleIntegerProperty capacity;

    //Constructor
    public HarddriveModel(String name, String brand, double price, double performanceValue, String type, int capacity) {
        super(name, brand, price, performanceValue);
        this.type = new SimpleStringProperty(type);
        this.capacity = new SimpleIntegerProperty(capacity);
    }

    //Getters/Setters
    public String getType() {
        return type.get();
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public int getCapacity() {
        return capacity.get();
    }


    public void setCapacity(int capacity) {
        this.capacity.set(capacity);
    }

}
