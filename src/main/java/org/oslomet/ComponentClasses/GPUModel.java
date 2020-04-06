package org.oslomet.ComponentClasses;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import org.oslomet.ExceptionClasses.InvalidClockSpeedException;
import org.oslomet.ExceptionClasses.InvalidMemoryException;


public class GPUModel extends ComponentModel {

    private SimpleDoubleProperty clockSpeed;
    private SimpleIntegerProperty memory;

    //Constructor
    public GPUModel(String name, String brand, double price, double performanceValue, double clockSpeed, int memory) {
        super(name, brand, price, performanceValue);
        if(!AdminInputValidation.clockSpeed(clockSpeed)) {
            throw new InvalidClockSpeedException();
        }
        if(!AdminInputValidation.memory(memory)) {
            throw new InvalidMemoryException();
        }
        this.clockSpeed = new SimpleDoubleProperty(clockSpeed);
        this.memory = new SimpleIntegerProperty(memory);
    }

    //Setters/Setters
    public double getClockSpeed() {return clockSpeed.get(); }

    public void setClockSpeed(double clockSpeed) {
        if(!AdminInputValidation.clockSpeed(clockSpeed)) {
            throw new InvalidClockSpeedException();
        }
        this.clockSpeed.set(clockSpeed);
    }

    public int getMemory() {return memory.get(); }

    public void setMemory(int memory) {
        if(!AdminInputValidation.memory(memory)) {
            throw new InvalidMemoryException();
        }
        this.memory.set(memory);
    }

    public String toString() {
        return this.getName();
    }

    public String toStringForConfig() {
        return this.getBrand() + " " + this.getName() + ", " + this.getClockSpeed() + ", " + this.getMemory();
    }
}

