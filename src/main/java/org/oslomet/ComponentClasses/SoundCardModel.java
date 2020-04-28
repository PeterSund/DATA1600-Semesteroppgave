package org.oslomet.ComponentClasses;

import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class SoundCardModel extends ComponentModel implements Serializable {

    private transient SimpleStringProperty surround, bassBoost;

    //Constructor
    public SoundCardModel(String name, String brand, double price, double performanceValue, String surround, String bassBoost) {
        super(name, brand, price, performanceValue);
        this.surround= new SimpleStringProperty(surround);
        this.bassBoost = new SimpleStringProperty(bassBoost);
    }

    //Getters/Setters
    public String getSurround() {
        return surround.get();
    }

    public void setSurround(String surround) {
        this.surround.set(surround);
    }

    public String getBassBoost() {
        return bassBoost.get();
    }

    public void setBassBoost(String bassBoost) {
        this.bassBoost.set(bassBoost);
    }

    public String toString() {
        return this.getName();
    }

    public String toStringForConfig() {

        String output = this.getBrand() + " " + this.getName() + ", Surround: " + this.getSurround() + ", Bassboost: " + this.getBassBoost();
        return output;
    }

    public String toStringForTxtFile() {
        String formattedComponent = "Sound card";
        formattedComponent += formatComponentForTxtFile();
        formattedComponent += ";Surround: " + getSurround();
        formattedComponent += ";BassBoost: " + getBassBoost();
        return formattedComponent;
    }


    private void writeObject(ObjectOutputStream s) throws IOException {
        s.writeUTF(getSurround());
        s.writeUTF(getBassBoost());

    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        String surround = s.readUTF();
        String bassBoost = s.readUTF();

        this.surround = new SimpleStringProperty();
        this.bassBoost = new SimpleStringProperty();

        setSurround(surround);
        setBassBoost(bassBoost);
    }

}
