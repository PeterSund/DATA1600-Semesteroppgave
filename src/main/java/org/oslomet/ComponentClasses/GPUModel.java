package org.oslomet.ComponentClasses;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import org.oslomet.ExceptionClasses.InvalidClockSpeedException;
import org.oslomet.ExceptionClasses.InvalidMemoryException;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class GPUModel extends ComponentModel implements Serializable {

    private transient SimpleDoubleProperty clockSpeed;
    private transient SimpleIntegerProperty memory;

    //Constructor
    public GPUModel(String name, String brand, double price, double performanceValue, double clockSpeed, int memory) {
        super(name, brand, price, performanceValue);
        if(!AdminInputValidation.clockSpeed(clockSpeed)) {
            throw new InvalidClockSpeedException("Clockspeed must be between 0 and " + AdminInputValidation.MAX_CLOCK_SPEED);
        }
        if(!AdminInputValidation.memory(memory)) {
            throw new InvalidMemoryException("Memory cannot be blank, must be greater then 0 and an even number");
        }
        this.clockSpeed = new SimpleDoubleProperty(clockSpeed);
        this.memory = new SimpleIntegerProperty(memory);
    }

    //Setters/Setters
    public double getClockSpeed() {return clockSpeed.get(); }

    public void setClockSpeed(double clockSpeed) {
        if(!AdminInputValidation.clockSpeed(clockSpeed)) {
            throw new InvalidClockSpeedException("Clockspeed must be between 0 and " + AdminInputValidation.MAX_CLOCK_SPEED);
        }
        this.clockSpeed.set(clockSpeed);
    }

    public int getMemory() {return memory.get(); }

    public void setMemory(int memory) {
        if(!AdminInputValidation.memory(memory)) {
            throw new InvalidMemoryException("Memory cannot be blank, must be greater then 0 and an even number");
        }
        this.memory.set(memory);
    }

    public String toString() {
        return this.getName();
    }

    public String toStringForConfig() {
        return this.getBrand() + " " + this.getName() + ", " + this.getClockSpeed() + ", " + this.getMemory();
    }

    public String toStringForTxtFile() {
        String formattedComponent = "GPU";
        formattedComponent += formatComponentForTxtFile();
        formattedComponent += ";Clock speed: " + getClockSpeed();
        formattedComponent += ";Memory: " + getMemory();
        return formattedComponent;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.writeDouble(getClockSpeed());
        s.writeInt(getMemory());

    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        double clockSpeed = s.readDouble();
        int memory = s.readInt();

        this.clockSpeed = new SimpleDoubleProperty();
        this.memory = new SimpleIntegerProperty();

        setClockSpeed(clockSpeed);
        setMemory(memory);
    }

}

