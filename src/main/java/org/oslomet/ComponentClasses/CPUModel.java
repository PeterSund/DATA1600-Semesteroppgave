package org.oslomet.ComponentClasses;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import org.oslomet.ExceptionClasses.InvalidClockSpeedException;
import org.oslomet.ExceptionClasses.InvalidCoresException;
import org.oslomet.Validation.AdminInputValidation;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CPUModel extends ComponentModel implements Serializable {

    private transient SimpleIntegerProperty cores;
    private transient SimpleDoubleProperty clockSpeed;

    //Constructor
    public CPUModel(String name, String brand, double price, double performanceValue, double clockSpeed, int cores) {
        super(name, brand, price, performanceValue);
        if(!AdminInputValidation.clockSpeed(clockSpeed)) {
            throw new InvalidClockSpeedException("Clockspeed must be between 0 and " + AdminInputValidation.MAX_CLOCK_SPEED + ". Use \".\" for decimals.");
        }
        if(!AdminInputValidation.cores(cores)) {
            throw new InvalidCoresException("Cores cannot be blank and must be between and even number");
        }
        this.clockSpeed = new SimpleDoubleProperty(clockSpeed);
        this.cores = new SimpleIntegerProperty(cores);

    }

    public double getClockSpeed() {return clockSpeed.get(); }

    public void setClockSpeed(double clockSpeed) {
        if(!AdminInputValidation.clockSpeed(clockSpeed)) {
            throw new InvalidClockSpeedException("Clockspeed must be between 0 and " + AdminInputValidation.MAX_CLOCK_SPEED+ ". Use \".\" for decimals.");
        }
        this.clockSpeed.set(clockSpeed);
    }


    public int getCores() {return cores.get(); }

    public void setCores(int cores) {
        if(!AdminInputValidation.cores(cores)) {
            throw new InvalidCoresException("Cores cannot be blank and must be an even number between 0 and "+ AdminInputValidation.MAX_CORES);
        }
        this.cores.set(cores);
    }

    public String toString() {
        return this.getName();
    }

    public String toStringForConfig() {
        return this.getBrand()  + this.getName() + ", " + this.getClockSpeed() + " GHz, " + this.getCores() +  " cores";
    }

    public String toStringForTxtFile() {
        String formattedComponent = "CPU";
        formattedComponent += formatComponentForTxtFile();
        formattedComponent += ";Cores: " + getCores();
        formattedComponent += ";Clock speed: " + getClockSpeed();
        return formattedComponent;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.writeInt(getCores());
        s.writeDouble(getClockSpeed());
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int cores = s.readInt();
        double clockSpeed = s.readDouble();

        this.cores = new SimpleIntegerProperty();
        this.clockSpeed = new SimpleDoubleProperty();

        setCores(cores);
        setClockSpeed(clockSpeed);
    }

}

