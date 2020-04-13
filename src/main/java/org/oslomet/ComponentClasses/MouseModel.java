package org.oslomet.ComponentClasses;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MouseModel extends ComponentModel implements Serializable {

    private transient SimpleStringProperty type;
    private transient SimpleBooleanProperty wireless;

    public MouseModel(String name, String brand, double price, double performanceValue, String type, boolean wireless) {
        super(name, brand, price, performanceValue);
        this.type = new SimpleStringProperty(type);
        this.wireless = new SimpleBooleanProperty(wireless);
    }

    //Getters/Setters
    public String getType() {
        return type.get();
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public boolean isWireless() {
        return wireless.get();
    }
    public void setWireless(boolean wireless) {
        this.wireless.set(wireless);
    }

    public String toString() {
        return this.getName();
    }

    public String toStringForConfig() {

        String output = this.getBrand() + " " + this.getName() + ", " + this.getType();

        if(wireless.getValue()) {
           output += ", Wireless";
         }
        return output;
    }

    public String toStringForTxtFile() {
        String formattedComponent = "Mouse";
        formattedComponent += formatComponentForTxtFile();
        formattedComponent += ";Type: " + getType();
        formattedComponent += isWireless() ? ";Wireless: Yes" : ";Wireless: No";
        return formattedComponent;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.writeUTF(getType());
        s.writeBoolean(isWireless());

    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        String type = s.readUTF();
        boolean wireless = s.readBoolean();

        this.type = new SimpleStringProperty();
        this.wireless = new SimpleBooleanProperty();

        setType(type);
        setWireless(wireless);
    }
}
