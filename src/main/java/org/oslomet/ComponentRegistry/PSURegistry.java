package org.oslomet.ComponentRegistry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.oslomet.ComponentClasses.PSUModel;

public class PSURegistry implements RegistryMethods  {
    //Initialize array
    private static ObservableList<PSUModel> psuArray = FXCollections.observableArrayList();
    public static void attachTableView(TableView tv) {
        tv.setItems(psuArray);
    }

    //Creates component
    public static PSUModel createComponent(Dialog addComponentDialog, GridPane grid) {
        addComponentDialog.setHeaderText("Create new PSU component");

        TextField name = new TextField();
        name.setPromptText("Name");
        TextField brand = new TextField();
        brand.setPromptText("Brand");
        TextField price = new TextField();
        price.setPromptText("Price");
        TextField performanceValue = new TextField();
        performanceValue.setPromptText("Performance-value");
        TextField watt = new TextField();
        watt.setPromptText("Watt");

        grid.add(name, 1, 0);
        grid.add(brand, 1,1);
        grid.add(price, 1,2);
        grid.add(performanceValue, 1,3);
        grid.add(new Label("Watt: "), 0, 4);
        grid.add(watt, 1,4);


        addComponentDialog.getDialogPane().setContent(grid);
        addComponentDialog.showAndWait();

        double priceDouble = Double.parseDouble(price.getText());
        double pvDouble = Double.parseDouble(performanceValue.getText());
        int wattInt = Integer.parseInt(watt.getText());

        String info =  name.getText() + ", " + brand.getText() + "," + price.getText() + ", " + performanceValue.getText() + ", "
                + wattInt + "\n";
        System.out.print(info);


        PSUModel obj = new PSUModel(name.getText(), brand.getText(), priceDouble, pvDouble, wattInt);

        return obj;
    }

    //Add component to array
    public static void addComponent(PSUModel psu) {
        psuArray.add(psu);
    }

    //Removes selected component from array by comparing names
    public static void removeComponent(PSUModel psu) {
        for (PSUModel obj : psuArray) {
            if (obj.getName().equals(psu.getName())) {
                psuArray.remove(psu);
            }
        }
    }
}
