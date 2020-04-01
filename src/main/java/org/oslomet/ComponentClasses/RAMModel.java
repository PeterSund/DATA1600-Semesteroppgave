package org.oslomet.ComponentClasses;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class RAMModel extends ComponentModel {

    private SimpleIntegerProperty capacity;
    private SimpleDoubleProperty memorySpeed;

    //Constructor
    public RAMModel(String name, String brand, double price, double performanceValue, int capacity, double memorySpeed) {
        super(name, brand, price, performanceValue);
        this.capacity = new SimpleIntegerProperty(capacity);
        this.memorySpeed = new SimpleDoubleProperty(memorySpeed);
    }

    public int getCapacity() {
        return capacity.get();
    }

    public void setCapacity(int capacity) {
        this.capacity.set(capacity);
    }

    public double getMemorySpeed() {
        return memorySpeed.get();
    }

    public void setMemorySpeed(double memorySpeed) {
        this.memorySpeed.set(memorySpeed);
    }

    public String toString() {
        return this.getName();
    }

    public String toStringForConfig() {
        return this.getBrand() + " " + this.getName() + ", " + this.getCapacity() + ", " + this.getMemorySpeed();
    }
}
