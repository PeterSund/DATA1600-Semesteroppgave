package org.oslomet.ComponentClasses;

import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MouseModel extends ComponentModel implements Serializable {

    private transient SimpleStringProperty type, wireless;


    public MouseModel(String name, String brand, double price, double performanceValue, String type, String wireless) {
        super(name, brand, price, performanceValue);
        this.type = new SimpleStringProperty(type);
        this.wireless = new SimpleStringProperty(wireless);
    }

    //Getters/Setters
    public String getType() {
        return type.get();
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public String getWireless() {
        return wireless.get();
    }
    public void setWireless(String wireless) {
        this.wireless.set(wireless);
    }

    public String toString() {
        return this.getName();
    }

    public String toStringForConfig() {
        String output = this.getBrand() + " " + this.getName() + ", " + this.getType() + ", " + this.getWireless();
        return output;
    }

    public String toStringForTxtFile() {
        String formattedComponent = "Mouse";
        formattedComponent += formatComponentForTxtFile();
        formattedComponent += ";Type: " + getType();
        formattedComponent += ";Wireless: " + getWireless();
        return formattedComponent;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.writeUTF(getType());
        s.writeUTF(getWireless());
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        String type = s.readUTF();
        String wireless = s.readUTF();

        this.type = new SimpleStringProperty();
        this.wireless = new SimpleStringProperty();

        setType(type);
        setWireless(wireless);
    }
}
