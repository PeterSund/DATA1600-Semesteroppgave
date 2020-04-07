package org.oslomet.ComponentClasses;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import org.oslomet.ExceptionClasses.InvalidBrandException;
import org.oslomet.ExceptionClasses.InvalidNameException;
import org.oslomet.ExceptionClasses.InvalidPerformanceValueException;
import org.oslomet.ExceptionClasses.InvalidPriceException;

public class ComponentModel {

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
}
