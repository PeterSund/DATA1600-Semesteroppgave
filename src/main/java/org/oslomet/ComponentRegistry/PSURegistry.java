package org.oslomet.ComponentRegistry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.oslomet.ComponentClasses.CPUModel;
import org.oslomet.ComponentClasses.MouseModel;
import org.oslomet.ComponentClasses.PSUModel;
import org.oslomet.ComponentClasses.RAMModel;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class PSURegistry implements RegistryMethods  {
    //Initialize array
    private static ObservableList<PSUModel> psuArray = FXCollections.observableArrayList();
    public static void attachTableView(TableView tv) {
        tv.setItems(psuArray);
    }

    //Add component to array
    public static void addComponent(PSUModel psu) {
        psuArray.add(psu);
    }

    //Removes selected component from array by comparing names
    public static void removeComponent(PSUModel psu) {
        psuArray.remove(psu);
    }

    public static void removeAll() {
        psuArray.clear();
    }

    public static ArrayList returnArray() {
        ArrayList psuList = new ArrayList();
        for (PSUModel psu : psuArray) {
            psuList.add(psu);
        }
        return psuList;
    }

    public static void addPSUFromJobjToArray(ArrayList<PSUModel> list) {
        for (PSUModel psu : list) {
            psuArray.add(psu);
        }
    }

    public ObservableList<PSUModel> filterByName(String name) {
        return psuArray.stream().filter(psu -> psu.getName().
                toLowerCase().matches(String.format("%s%s%s", ".*", name.toLowerCase(),
                ".*"))).collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<PSUModel> filterByBrand(String brand) {
        return psuArray.stream().filter(psu -> psu.getBrand().
                toLowerCase().matches(String.format("%s%s%s", ".*", brand.toLowerCase(),
                ".*"))).collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<PSUModel> filterByPrice(double price) {
        return psuArray.stream().
                filter(psu -> psu.getPrice() == price).
                collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<PSUModel> filterByPerformanceValue(double performanceValue) {
        return psuArray.stream().
                filter(psu -> psu.getPerformanceValue() == performanceValue).
                collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<PSUModel> filterByWatt(int watt) {
        return psuArray.stream().
                filter(psu -> psu.getWatt() == watt).
                collect(Collectors.toCollection(FXCollections::observableArrayList));
    }

    public static PSUModel psuExists(String psuName) {

        for (PSUModel psu : psuArray) {
            if (psu.getName().equals(psuName)) {
                return psu;
            }
        }

        return null;
    }
}
