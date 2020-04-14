package org.oslomet.ComponentClasses;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import org.oslomet.ExceptionClasses.InvalidBrandException;
import org.oslomet.ExceptionClasses.InvalidNameException;
import org.oslomet.ExceptionClasses.InvalidPerformanceValueException;
import org.oslomet.ExceptionClasses.InvalidPriceException;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ComponentModel implements Serializable {

    private transient SimpleStringProperty name, brand;
    private transient SimpleDoubleProperty price, performanceValue;

    //Constructor
    public ComponentModel(String name, String brand, double price, double performanceValue) {
        if(!AdminInputValidation.name(name)) {
            throw new InvalidNameException("Name cannot be blank or contain characters other then letters, numbers or !#$%&'*+-/=?^_`{|};");
        }

        if(!AdminInputValidation.brand(brand)) {
            throw new InvalidBrandException("Brand cannot be blank or contain characters other then letters, numbers or !#$%&'*+-/=?^_`{|};");
        }

        if(!AdminInputValidation.price(price)) {
            throw new InvalidPriceException("Price cannot be blank and must be between 0 and " + AdminInputValidation.MAX_PRICE);
        }

        if(!AdminInputValidation.performanceValue(performanceValue)) {
            throw new InvalidPerformanceValueException("Performancevalue cannot be blank and must be between 0 and " + AdminInputValidation.MAX_PERFORMANCE_VALUE);
        }

        this.name = new SimpleStringProperty(name);
        this.brand = new SimpleStringProperty(brand);
        this.price = new SimpleDoubleProperty(price);
        this.performanceValue = new SimpleDoubleProperty(performanceValue);
    }

    //Getters/Setters
    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        if(!AdminInputValidation.name(name)) {
            throw new InvalidNameException("Name cannot be blank or contain characters other then letters, numbers or !#$%&'*+-/=?^_`{|};");
        }
        this.name.set(name);
    }

    public String getBrand() {
        return brand.get();
    }

    public void setBrand(String brand) {
        if(!AdminInputValidation.brand(brand)) {
            throw new InvalidBrandException("Brand cannot be blank or contain characters other then letters, numbers or !#$%&'*+-/=?^_`{|};");
        }
        this.brand.set(brand);
    }

    public double getPrice() {
        return price.get();
    }

    public final void setPrice(double price) {
        if (!AdminInputValidation.price(price)) {
            throw new InvalidPriceException("Price cannot be blank and must be between 0 and " + AdminInputValidation.MAX_PRICE);
        }
        this.price.set(price);
    }

    public double getPerformanceValue() {
        return performanceValue.get();
    }

    public void setPerformanceValue(double performanceValue) {
        if(!AdminInputValidation.performanceValue(performanceValue)) {
            throw new InvalidPerformanceValueException("Performancevalue cannot be blank and must be between 0 and " + AdminInputValidation.MAX_PERFORMANCE_VALUE);
        }
        this.performanceValue.set(performanceValue);
    }

    public String formatComponentForTxtFile() {
        String formattedComponent = ";Name: " + getName();
        formattedComponent += ";Brand: " + getBrand();
        formattedComponent += ";Price: " + getPrice();
        formattedComponent += ";Performance value: " + getPerformanceValue();
        return formattedComponent;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.writeUTF(getName());
        s.writeUTF(getBrand());
        s.writeDouble(getPrice());
        s.writeDouble(getPerformanceValue());
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        String name = s.readUTF();
        String brand = s.readUTF();
        double price = s.readDouble();
        double performanceValue = s.readDouble();

        this.name = new SimpleStringProperty();
        this.brand = new SimpleStringProperty();
        this.price = new SimpleDoubleProperty();
        this.performanceValue = new SimpleDoubleProperty();

        setName(name);
        setBrand(brand);
        setPrice(price);
        setPerformanceValue(performanceValue);
    }
}
