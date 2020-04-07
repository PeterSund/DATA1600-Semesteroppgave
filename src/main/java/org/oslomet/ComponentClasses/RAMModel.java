package org.oslomet.ComponentClasses;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import org.oslomet.ExceptionClasses.InvalidMemoryException;
import org.oslomet.ExceptionClasses.InvalidMemorySpeedException;

public class RAMModel extends ComponentModel {

    private SimpleIntegerProperty memory;
    private SimpleDoubleProperty memorySpeed;

    //Constructor
    public RAMModel(String name, String brand, double price, double performanceValue, int memory, double memorySpeed) {
        super(name, brand, price, performanceValue);
        if(!AdminInputValidation.memory(memory)) {
            throw new InvalidMemoryException("Memory cannot be blank, must be greater then 0 and an even number");
        }
        if(!AdminInputValidation.memorySpeed(memorySpeed)) {
            throw  new InvalidMemorySpeedException("Memory-speed cannot be blank and must be greater then 0");
        }
        this.memory = new SimpleIntegerProperty(memory);
        this.memorySpeed = new SimpleDoubleProperty(memorySpeed);
    }

    public int getMemory() {
        return memory.get();
    }

    public void setMemory(int memory) {
        if(!AdminInputValidation.memory(memory)) {
            throw new InvalidMemoryException("Memory cannot be blank, must be greater then 0 and an even number");
        }
        this.memory.set(memory);
    }

    public double getMemorySpeed() {
        return memorySpeed.get();
    }

    public void setMemorySpeed(double memorySpeed) {
        if(!AdminInputValidation.memorySpeed(memorySpeed)) {
            throw  new InvalidMemorySpeedException("Memory-speed cannot be blank and must be greater then 0");
        }
        this.memorySpeed.set(memorySpeed);
    }

    public String toString() {
        return this.getName();
    }

    public String toStringForConfig() {
        return this.getBrand() + " " + this.getName() + ", " + this.getMemory() + ", " + this.getMemorySpeed();
    }
}
