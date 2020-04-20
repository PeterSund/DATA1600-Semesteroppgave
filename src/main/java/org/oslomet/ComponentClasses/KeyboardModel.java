package org.oslomet.ComponentClasses;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import org.oslomet.ExceptionClasses.InvalidLanguageException;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class KeyboardModel extends ComponentModel implements Serializable {

    private transient SimpleStringProperty type, language, wireless;

    //Constructor
    public KeyboardModel(String name, String brand, double price, double performanceValue,
                         String type, String language, String wireless) {
        super(name, brand, price, performanceValue);
        if(!AdminInputValidation.language(language)) {
            throw new InvalidLanguageException("Language cannot be blank and must contain only letters with a capital first letter");
        }
        this.type = new SimpleStringProperty(type);
        this.language = new SimpleStringProperty(language);
        this.wireless = new SimpleStringProperty(wireless);
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
            throw new InvalidLanguageException("Language cannot be blank and must contain only letters with a capital first letter");
        }
        this.language.set(language);
    }

    public String getWireless() {
        return wireless.get();
    }

    public void setWireless(String wireless) {
        this.wireless.set(wireless);
    }

    public String toString() {
        return this.getName();
    }

    public String toStringForConfig() {

        String output = this.getBrand() + " " + this.getName() + ", " + this.getType() + ", " + this.getLanguage() + ", " + this.getWireless();

        return output;
    }

    public String toStringForTxtFile() {
        String formattedComponent = "Keyboard";
        formattedComponent += formatComponentForTxtFile();
        formattedComponent += ";Type: " + getType();
        formattedComponent += ";Language: " + getLanguage();
        formattedComponent += ";Wireless " + getWireless();
        return formattedComponent;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.writeUTF(getType());
        s.writeUTF(getLanguage());
        s.writeUTF(getWireless());

    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        String type = s.readUTF();
        String language = s.readUTF();
        String wireless = s.readUTF();

        this.type = new SimpleStringProperty();
        this.language = new SimpleStringProperty();
        this.wireless = new SimpleStringProperty();

        setType(type);
        setLanguage(language);
        setWireless(wireless);
    }

}
