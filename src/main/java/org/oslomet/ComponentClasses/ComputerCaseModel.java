package org.oslomet.ComponentClasses;

import javafx.beans.property.SimpleStringProperty;
import org.oslomet.ExceptionClasses.InvalidColorException;
import org.oslomet.ExceptionClasses.InvalidDimensionsException;

public class ComputerCaseModel extends ComponentModel {

    private SimpleStringProperty dimensions, color;

    //Constructor
    public ComputerCaseModel(String name, String brand, double price, double performanceValue, String dimensions, String color) {
        super(name, brand, price, performanceValue);
        if(!AdminInputValidation.dimensions(dimensions)) {
            throw new InvalidDimensionsException();
        }
        if(!AdminInputValidation.color(color)) {
            throw new InvalidColorException();
        }
        this.dimensions = new SimpleStringProperty(dimensions);
        this.color = new SimpleStringProperty(color);
    }

    public String getDimensions() {
        return dimensions.get();
    }

    public void setDimensions(String dimensions) {
        if(!AdminInputValidation.dimensions(dimensions)) {
            throw new InvalidDimensionsException();
        }
        this.dimensions.set(dimensions);
    }

    public String getColor() {
        return color.get();
    }

    public void setColor(String color) {
        if(!AdminInputValidation.color(color)) {
            throw new InvalidColorException();
        }
        this.color.set(color);
    }

    public String toString() {
        return this.getName();
    }

    public String toStringForConfig() {
        return this.getBrand() + " " + this.getName() + ", " + this.getDimensions() + ", " + this.getColor();
    }
}
