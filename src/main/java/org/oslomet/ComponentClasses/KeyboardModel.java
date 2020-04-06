package org.oslomet.ComponentClasses;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import org.oslomet.ExceptionClasses.InvalidLanguageException;

public class KeyboardModel extends ComponentModel {

    private SimpleStringProperty type, language;
    private SimpleBooleanProperty wireless;

    //Constructor
    public KeyboardModel(String name, String brand, double price, double performanceValue,
                         String type, String language, boolean wireless) {
        super(name, brand, price, performanceValue);
        if(!AdminInputValidation.language(language)) {
            throw new InvalidLanguageException();
        }
        this.type = new SimpleStringProperty(type);
        this.language = new SimpleStringProperty(language);
        this.wireless = new SimpleBooleanProperty(wireless);
    }

    //Getters/Setters
    public String getType() {
        return type.get();
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public String getLanguage() {
        return language.get();
    }

    public void setLanguage(String language) {
        if(!AdminInputValidation.language(language)) {
            throw new InvalidLanguageException();
        }
        this.language.set(language);
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

        String output = this.getBrand() + " " + this.getName() + ", " + this.getType() + ", " + this.getLanguage();

        if(wireless.getValue()) {
            output += ", " + this.isWireless();
        }
        return output;
    }

}
