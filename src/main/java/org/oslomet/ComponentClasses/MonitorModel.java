package org.oslomet.ComponentClasses;

import javafx.beans.property.SimpleIntegerProperty;
import org.oslomet.ExceptionClasses.InvalidSizeException;
import org.oslomet.Validation.AdminInputValidation;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MonitorModel extends ComponentModel implements Serializable {

    private transient SimpleIntegerProperty size;

    //Constructor
    public MonitorModel(String name, String brand, double price, double performanceValue, int size) {
        super(name, brand, price, performanceValue);
        if(!AdminInputValidation.size(size)) {
            throw new InvalidSizeException("Size cannot be blank and must be between 0 and " + AdminInputValidation.MAX_SIZE_MONITOR);
        }
        this.size = new SimpleIntegerProperty(size);
    }

    //Getters/Setters
    public int getSize() {
        return size.get();
    }

    public void setSize(int size) {
        if(!AdminInputValidation.size(size)) {
            throw new InvalidSizeException("Size cannot be blank and must be between 0 and " + AdminInputValidation.MAX_SIZE_MONITOR);
        }
        this.size.set(size);
    }

    public String toString() {
        return this.getName();
    }

    public String toStringForConfig() {
        return this.getBrand() + " " + this.getName() + ", " + this.getSize() + "''";
    }

    public String toStringForTxtFile() {
        String formattedComponent = "Monitor";
        formattedComponent += formatComponentForTxtFile();
        formattedComponent += ";Size: " + getSize();
        return formattedComponent;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.writeInt(getSize());

    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int size = s.readInt();

        this.size = new SimpleIntegerProperty();

        setSize(size);
    }
}
