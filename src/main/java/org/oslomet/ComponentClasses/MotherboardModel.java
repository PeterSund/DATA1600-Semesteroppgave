package org.oslomet.ComponentClasses;

import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MotherboardModel extends ComponentModel implements Serializable {

    private transient SimpleStringProperty type;

    //Constructor
    public MotherboardModel(String name, String brand, double price, double performanceValue, String type) {
        super(name, brand, price, performanceValue);
        this.type = new SimpleStringProperty(type);
    }

    //Getters/Setters
    public String getType() {
        return type.get();
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public String toString() {
        return this.getName();
    }

    public String toStringForConfig() {
        return this.getBrand() + " " + this.getName() + ", " + this.getType();
    }

    public String toStringForTxtFile() {
        String formattedComponent = "Motherboard";
        formattedComponent += formatComponentForTxtFile();
        formattedComponent += ";Type: " + getType();
        return formattedComponent;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.writeUTF(getType());
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        String type = s.readUTF();

        this.type = new SimpleStringProperty();

        setType(type);
    }
}
