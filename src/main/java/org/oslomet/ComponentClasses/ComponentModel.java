package org.oslomet.ComponentClasses;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class ComponentModel {

    private transient SimpleStringProperty name, brand;
    private transient SimpleDoubleProperty price, performanceValue;

    //Constructor
    public ComponentModel(String name, String brand, double price, double performanceValue) {
        if(!AdminInputValidation.name(name)) {
            throw new IllegalArgumentException();
        }

        if(!AdminInputValidation.brand(brand)) {
            throw new IllegalArgumentException();
        }

        if(!AdminInputValidation.price(price)) {
            throw new IllegalArgumentException();
        }

        if(!AdminInputValidation.performanceValue(performanceValue)) {
            throw new IllegalArgumentException();
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
            throw new IllegalArgumentException();
        }
        this.name.set(name);
    }

    public String getBrand() {
        return brand.get();
    }

    public void setBrand(String brand) {
        if(!AdminInputValidation.brand(brand)) {
            throw new IllegalArgumentException();
        }
        this.brand.set(brand);
    }

    public double getPrice() {
        return price.get();
    }

    public final void setPrice(double price) {
        if (!AdminInputValidation.price(price)) {
            throw new IllegalArgumentException();
        }
        this.price.set(price);
    }


    public double getPerformanceValue() {
        return performanceValue.get();
    }

    public void setPerformanceValue(double performanceValue) {
        if(!AdminInputValidation.performanceValue(performanceValue)) {
            throw new IllegalArgumentException();
        }
        this.performanceValue.set(performanceValue);
    }
}
