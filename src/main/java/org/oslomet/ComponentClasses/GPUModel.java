package org.oslomet.ComponentClasses;

import javafx.beans.property.SimpleIntegerProperty;

public class GPUModel extends ComponentModel {

    private SimpleIntegerProperty clockSpeed, memory;

    //Constructor
    public GPUModel(String name, String brand, double price, double performanceValue, int clockSpeed, int memory) {
        super(name, brand, price, performanceValue);
        this.clockSpeed = new SimpleIntegerProperty(clockSpeed);
        this.memory = new SimpleIntegerProperty(memory);

    }
    //Setters/Setters
    public int getClockSpeed() {return clockSpeed.get(); }

    public void setClockSpeed(int clockSpeed) {this.clockSpeed.set(clockSpeed); }

    public int getMemory() {return memory.get(); }

    public void setMemory(int memory) {this.memory.set(memory); }
    }

