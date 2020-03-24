package org.oslomet.ComponentClasses;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class MouseModel extends ComponentModel {

    private SimpleStringProperty type;
    private SimpleBooleanProperty wireless;

    public MouseModel(String name, String brand, double price, double performanceValue, String type, boolean wireless) {
        super(name, brand, price, performanceValue);
        this.type = new SimpleStringProperty(type);
        this.wireless = new SimpleBooleanProperty(wireless);
    }

    //Getters/Setters
    public String type() {
        return type.get();
    }

    public void type(String type) {
        this.type.set(type);
    }

    public boolean wireless() {
        return wireless.get();
    }
    public void setWireless(boolean wireless) {
        this.wireless.set(wireless);
    }

}
