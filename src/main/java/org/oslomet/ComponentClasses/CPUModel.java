package org.oslomet.ComponentClasses;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import org.oslomet.ExceptionClasses.InvalidClockSpeedException;
import org.oslomet.ExceptionClasses.InvalidCoresException;

public class CPUModel extends ComponentModel {

    private SimpleIntegerProperty cores;
    private SimpleDoubleProperty clockSpeed;

    //Constructor
    public CPUModel(String name, String brand, double price, double performanceValue, double clockSpeed, int cores) {
        super(name, brand, price, performanceValue);
        if(!AdminInputValidation.clockSpeed(clockSpeed)) {
            throw new InvalidClockSpeedException();
        }
        if(!AdminInputValidation.cores(cores)) {
            throw new InvalidCoresException();
        }
        this.clockSpeed = new SimpleDoubleProperty(clockSpeed);
        this.cores = new SimpleIntegerProperty(cores);

    }

    public double getClockSpeed() {return clockSpeed.get(); }

    public void setClockSpeed(double clockSpeed) {
        if(!AdminInputValidation.clockSpeed(clockSpeed)) {
            throw new InvalidClockSpeedException();
        }
        this.clockSpeed.set(clockSpeed);
    }


    public int getCores() {return cores.get(); }

    public void setCores(int cores) {
        if(!AdminInputValidation.cores(cores)) {
            throw new InvalidCoresException();
        }
        this.cores.set(cores);
    }

    public String toString() {
        return this.getName();
    }

    public String toStringForConfig() {
        return this.getBrand() + " " + this.getName() + ", " + this.getClockSpeed() + ", "  +  ", " + this.getCores();
    }

}

