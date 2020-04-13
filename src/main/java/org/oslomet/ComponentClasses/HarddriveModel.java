package org.oslomet.ComponentClasses;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import org.oslomet.ExceptionClasses.InvalidCapacityException;

public class HarddriveModel extends ComponentModel {

    private SimpleStringProperty type;
    private SimpleIntegerProperty capacity;

    //Constructor
    public HarddriveModel(String name, String brand, double price, double performanceValue, String type, int capacity) {
        super(name, brand, price, performanceValue);
        if(!AdminInputValidation.capacity(capacity)) {
            throw new InvalidCapacityException("Capacity cannot be blank and must be between 0 and " + AdminInputValidation.MAX_CAPACITY);
        }
        this.type = new SimpleStringProperty(type);
        this.capacity = new SimpleIntegerProperty(capacity);
    }

    //Getters/Setters
    public String getType() {
        return type.get();
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public int getCapacity() {
        return capacity.get();
    }


    public void setCapacity(int capacity) {
        if(!AdminInputValidation.capacity(capacity)) {
            throw new InvalidCapacityException("Capacity cannot be blank and must be between 0 and " + AdminInputValidation.MAX_CAPACITY);
        }
        this.capacity.set(capacity);
    }

    public String toString() {
        return this.getName();
    }

    public String toStringForConfig() {
        return this.getBrand() + " " + this.getName() + ", " + this.getType() + ", " + this.getCapacity();
    }

    public String toStringForTxtFile() {
        String formattedComponent = "Hard drive";
        formattedComponent += formatComponentForTxtFile();
        formattedComponent += ";Type: " + getType();
        formattedComponent += ";Capacity: " + getCapacity();
        return formattedComponent;
    }

}
