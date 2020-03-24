package org.oslomet.ComponentClasses;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ComponentModel {

    private SimpleStringProperty name, brand;
    private SimpleDoubleProperty price, performanceValue;

    //Constructor
    public ComponentModel(String name, String brand, double price, double performanceValue) {
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
        this.name.set(name);
    }

    public String getBrand() {
        return brand.get();
    }

    public void setBrand(String brand) {
        this.brand.set(brand);
    }

    public double getPrice() {
        return price.get();
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public double getPerformanceValue() {
        return performanceValue.get();
    }

    public void setPerformanceValue(double performanceValue) {
        this.performanceValue.set(performanceValue);
    }
}
