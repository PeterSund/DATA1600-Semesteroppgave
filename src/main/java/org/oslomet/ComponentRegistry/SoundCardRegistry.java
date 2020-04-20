package org.oslomet.ComponentRegistry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.oslomet.ComponentClasses.CPUModel;
import org.oslomet.ComponentClasses.PSUModel;
import org.oslomet.ComponentClasses.SoundCardModel;

import java.util.ArrayList;
import java.util.stream.Collectors;

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

    public static void removeAll() {
        soundCardArray.clear();
    }

    public static ArrayList returnArray() {
        ArrayList soundCardList = new ArrayList();
        for (SoundCardModel soundCard : soundCardArray) {
            soundCardList.add(soundCard);
        }
        return soundCardList;
    }

    public static  void addSoundcardFromJobjToArray(ArrayList<SoundCardModel> list) {
        for (SoundCardModel soundcard : list) {
            soundCardArray.add(soundcard);
        }
    }


    public ObservableList<SoundCardModel> filterByName(String name) {
        return soundCardArray.stream().filter(sc -> sc.getName().
                toLowerCase().matches(String.format("%s%s%s", ".*", name.toLowerCase(),
                ".*"))).collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<SoundCardModel> filterByBrand(String brand) {
        return soundCardArray.stream().filter(sc -> sc.getBrand().
                toLowerCase().matches(String.format("%s%s%s", ".*", brand.toLowerCase(),
                ".*"))).collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<SoundCardModel> filterByPrice(double price) {
        return soundCardArray.stream().
                filter(sc -> sc.getPrice() == price).
                collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<SoundCardModel> filterByPerformanceValue(double performanceValue) {
        return soundCardArray.stream().
                filter(r -> r.getPerformanceValue() == performanceValue).
                collect(Collectors.toCollection(FXCollections::observableArrayList));
    }

    public ObservableList<SoundCardModel> filterBySurround(String surround) {
        return soundCardArray.stream().filter(sc -> sc.getName().
                toLowerCase().matches(String.format("%s%s%s", ".*", surround.toLowerCase(),
                ".*"))).collect(Collectors.toCollection(FXCollections::observableArrayList));
    }

    public ObservableList<SoundCardModel> filterByBassBoost(String bassBoost) {
        return soundCardArray.stream().filter(sc -> sc.getName().
                toLowerCase().matches(String.format("%s%s%s", ".*", bassBoost.toLowerCase(),
                ".*"))).collect(Collectors.toCollection(FXCollections::observableArrayList));
    }

    public static SoundCardModel soundCardExists(String soundCardName) {

        for (SoundCardModel soundCard : soundCardArray) {
            if (soundCard.getName().equals(soundCardName)) {
                return soundCard;
            }
        }

        return null;
    }
}

