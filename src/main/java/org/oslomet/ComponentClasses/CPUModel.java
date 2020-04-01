package org.oslomet.ComponentClasses;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class CPUModel extends ComponentModel {

    private SimpleIntegerProperty clockSpeed, cores;
    private SimpleDoubleProperty frequency;

    //Constructor
    public CPUModel(String name, String brand, double price, double performanceValue, int clockSpeed, double frequency, int cores) {
        super(name, brand, price, performanceValue);
        this.clockSpeed = new SimpleIntegerProperty(clockSpeed);
        this.frequency = new SimpleDoubleProperty(frequency);
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

    public int getClockSpeed() {return clockSpeed.get(); }

    public void setClockSpeed(int clockSpeed) {this.clockSpeed.set(clockSpeed); }

    public double getFrequency() {return frequency.get(); }

    public void setFrequency(int frequency) {this.frequency.set(frequency); }

    public int getCores() {return cores.get(); }

    public void setCores(int cores) {this.cores.set(cores); }

    public String toString() {
        return this.getName();
    }

    public String toStringForConfig() {
        return this.getBrand() + " " + this.getName() + ", " + this.getClockSpeed() + ", " + this.getFrequency() +
                ", " + this.getCores();
    }

}

