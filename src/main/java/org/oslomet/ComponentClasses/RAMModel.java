package org.oslomet.ComponentClasses;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import org.oslomet.ExceptionClasses.InvalidMemoryException;
import org.oslomet.ExceptionClasses.InvalidMemorySpeedException;
import org.oslomet.Validation.AdminInputValidation;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class RAMModel extends ComponentModel implements Serializable {

    private transient SimpleIntegerProperty memory;
    private transient SimpleDoubleProperty memorySpeed;

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
        return this.getBrand() + " " + this.getName() + ", " + this.getMemory() + " MB, " + this.getMemorySpeed() + " Mhz";
    }

    public String toStringForTxtFile() {
        String formattedComponent = "RAM";
        formattedComponent += formatComponentForTxtFile();
        formattedComponent += ";Memory: " + getMemory();
        formattedComponent += ";Memory speed: " + getMemorySpeed();
        return formattedComponent;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.writeInt(getMemory());
        s.writeDouble(getMemorySpeed());
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int memory = s.readInt();
        double memorySpeed = s.readDouble();

        this.memory = new SimpleIntegerProperty();
        this.memorySpeed = new SimpleDoubleProperty();

        setMemory(memory);
        setMemorySpeed(memorySpeed);
    }
}
