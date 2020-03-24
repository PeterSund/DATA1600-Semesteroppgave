package org.oslomet.ComponentClasses;

import javafx.beans.property.SimpleBooleanProperty;


public class SoundCardModel extends ComponentModel {

    private SimpleBooleanProperty booleanSurround, booleanBassBoost;

    //Constructor
    public SoundCardModel(String txtName, String txtBrand, double doublePrice, double doublePerformanceValue, boolean booleanSurround, boolean booleanBassBoost) {
        super(txtName, txtBrand, doublePrice, doublePerformanceValue);
        this.booleanSurround= new SimpleBooleanProperty(booleanSurround);
        this.booleanBassBoost = new SimpleBooleanProperty(booleanBassBoost);
    }

    //Getters/Setters
    public boolean isBooleanSurround() {
        return booleanSurround.get();
    }

    public void setBooleanSurround(boolean booleanSurround) {
        this.booleanSurround.set(booleanSurround);
    }

    public boolean isBooleanBassBoost() {
        return booleanBassBoost.get();
    }

    public void setBooleanBassBoost(boolean booleanBassBoost) {
        this.booleanBassBoost.set(booleanBassBoost);
    }
}
