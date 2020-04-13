package org.oslomet.ComponentClasses;

import javafx.beans.property.SimpleBooleanProperty;


public class SoundCardModel extends ComponentModel {

    private SimpleBooleanProperty surround, bassBoost;

    //Constructor
    public SoundCardModel(String name, String brand, double price, double performanceValue, boolean surround, boolean bassBoost) {
        super(name, brand, price, performanceValue);
        this.surround= new SimpleBooleanProperty(surround);
        this.bassBoost = new SimpleBooleanProperty(bassBoost);
    }

    //Getters/Setters
    public boolean isSurround() {
        return surround.get();
    }

    public void setSurround(boolean surround) {
        this.surround.set(surround);
    }

    public boolean isBassBoost() {
        return bassBoost.get();
    }

    public void setBassBoost(boolean bassBoost) {
        this.bassBoost.set(bassBoost);
    }

    public String toString() {
        return this.getName();
    }

    public String toStringForConfig() {

        String output = this.getBrand() + " " + this.getName();

        if(surround.getValue()) {
            output += ", Surround";
        }
        if(bassBoost.getValue())  {
            output += ", Bass boost";
        }
        return output;
    }

    public String toStringForTxtFile() {
        String formattedComponent = "Sound card";
        formattedComponent += formatComponentForTxtFile();
        formattedComponent += isSurround() ? ";Surround: Yes" : ";Surround: No";
        formattedComponent += isBassBoost() ? ";Bass boost: Yes" : ";Bass boost: No";
        return formattedComponent;
    }

}
