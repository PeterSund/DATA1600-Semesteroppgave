package org.oslomet.ComponentClasses;

import javafx.beans.property.SimpleStringProperty;
import org.oslomet.ExceptionClasses.InvalidColorException;
import org.oslomet.ExceptionClasses.InvalidDimensionsException;
import org.oslomet.Validation.AdminInputValidation;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ComputerCaseModel extends ComponentModel implements Serializable {

    private transient SimpleStringProperty dimensions, color;

    //Constructor
    public ComputerCaseModel(String name, String brand, double price, double performanceValue, String dimensions, String color) {
        super(name, brand, price, performanceValue);
        if(!AdminInputValidation.dimensions(dimensions)) {
            throw new InvalidDimensionsException("Dimensions cannot be blank and must be in input-format HxLxD");
        }
        if(!AdminInputValidation.color(color)) {
            throw new InvalidColorException("Color cannot be blank and must be entered with a capital first letters. Only letters allowed");
        }
        this.dimensions = new SimpleStringProperty(dimensions);
        this.color = new SimpleStringProperty(color);
    }

    public String getDimensions() {
        return dimensions.get();
    }

    public void setDimensions(String dimensions) {
        if(!AdminInputValidation.dimensions(dimensions)) {
            throw new InvalidDimensionsException("Dimensions cannot be blank and must be in input-format HxLxD");
        }
        this.dimensions.set(dimensions);
    }

    public String getColor() {
        return color.get();
    }

    public void setColor(String color) {
        if(!AdminInputValidation.color(color)) {
            throw new InvalidColorException("Color cannot be blank and must be entered with a capital first letters. Only letters allowed");
        }
        this.color.set(color);
    }

    public String toString() {
        return this.getName();
    }

    public String toStringForConfig() {
        return this.getBrand() + " " + this.getName() + ", " + this.getDimensions() + ", " + this.getColor();
    }

    public String toStringForTxtFile() {
        String formattedComponent = "Computer case";
        formattedComponent += formatComponentForTxtFile();
        formattedComponent += ";Dimensions: " + getDimensions();
        formattedComponent += ";Color: " + getColor();
        return formattedComponent;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.writeUTF(getDimensions());
        s.writeUTF(getColor());
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
       String dimensions = s.readUTF();
       String color = s.readUTF();

       this.dimensions = new SimpleStringProperty();
       this.color = new SimpleStringProperty();

       setDimensions(dimensions);
       setColor(color);
    }
}
