package org.oslomet.ComponentRegistry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.oslomet.ComponentClasses.SoundCardModel;

public class SoundCardRegistry implements RegistryMethods  {
    //Initialize array
    private static ObservableList<SoundCardModel> soundCardArray = FXCollections.observableArrayList();
    public static void attachTableView(TableView tv) {
        tv.setItems(soundCardArray);
    }

    //Add component to array
    public static void addComponent(SoundCardModel soundCard) {
        soundCardArray.add(soundCard);
    }

    //Removes selected component from array by comparing names
    public static void removeComponent(SoundCardModel soundCard) {
        for (SoundCardModel obj : soundCardArray) {
            if (obj.getName().equals(soundCard.getName())) {
                soundCardArray.remove(soundCard);
            }
        }
    }
}

