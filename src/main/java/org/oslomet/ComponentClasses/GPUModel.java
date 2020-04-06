package org.oslomet.ComponentClasses;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class GPUModel extends ComponentModel {

    private SimpleIntegerProperty memory;
    private SimpleDoubleProperty clockSpeed;

    //Constructor
    public GPUModel(String name, String brand, double price, double performanceValue, double clockSpeed, int memory) {
        super(name, brand, price, performanceValue);
        this.clockSpeed = new SimpleDoubleProperty(clockSpeed);
        this.memory = new SimpleIntegerProperty(memory);

    }
    //Setters/Setters
    public double getClockSpeed() {return clockSpeed.get(); }

    public void setClockSpeed(double clockSpeed) {this.clockSpeed.set(clockSpeed); }

    public int getMemory() {return memory.get(); }

    public void setMemory(int memory) {this.memory.set(memory); }

    public String toString() {
        return this.getName();
    }

    public String toStringForConfig() {
        return this.getBrand() + " " + this.getName() + ", " + this.getClockSpeed() + ", " + this.getMemory();
    }
}

