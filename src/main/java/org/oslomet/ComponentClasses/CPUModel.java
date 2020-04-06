package org.oslomet.ComponentClasses;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class CPUModel extends ComponentModel {

    private SimpleIntegerProperty cores;
    private SimpleDoubleProperty clockSpeed;

    //Constructor
    public CPUModel(String name, String brand, double price, double performanceValue, double clockSpeed, int cores) {
        super(name, brand, price, performanceValue);
        if(!AdminInputValidation.clockSpeed(clockSpeed)) {
            throw new IllegalArgumentException();
        }
        if(!AdminInputValidation.cores(cores)) {
            throw new IllegalArgumentException();
        }
        this.clockSpeed = new SimpleDoubleProperty(clockSpeed);
        this.cores = new SimpleIntegerProperty(cores);

    }

    //Getters/Setters
    /*
    public int setClockSpeed2(clockSpeed) {
        boolean isValidInput = true;
        if (!isValidInput) {
            throw new Exception("Clockspeed er feil..");
        }
    }

     */

    public double getClockSpeed() {return clockSpeed.get(); }

    public void setClockSpeed(double clockSpeed) {
        if(!AdminInputValidation.clockSpeed(clockSpeed)) {
            throw new IllegalArgumentException();
        }
        this.clockSpeed.set(clockSpeed);
    }


    public int getCores() {return cores.get(); }

    public void setCores(int cores) {
        if(!AdminInputValidation.cores(cores)) {
            throw new IllegalArgumentException();
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

