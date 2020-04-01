package org.oslomet.ComponentRegistry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.oslomet.ComponentClasses.MotherboardModel;
import org.oslomet.ComponentClasses.PSUModel;

public class MotherboardRegistry implements RegistryMethods {
    //Initialize array
    private static ObservableList<MotherboardModel> motherboardArray = FXCollections.observableArrayList();
    public static void attachTableView(TableView tv) {
        tv.setItems(motherboardArray);
    }

    //Creates component
    public static MotherboardModel createComponent(Dialog addComponentDialog, GridPane grid) {
        addComponentDialog.setHeaderText("Create new motherboard component");

        TextField name = new TextField();
        name.setPromptText("Name");
        TextField brand = new TextField();
        brand.setPromptText("Brand");
        TextField price = new TextField();
        price.setPromptText("Price");
        TextField performanceValue = new TextField();
        performanceValue.setPromptText("Performance-value");
        TextField type = new TextField();
        type.setPromptText("Type");

        grid.add(name, 1, 0);
        grid.add(brand, 1,1);
        grid.add(price, 1,2);
        grid.add(performanceValue, 1,3);
        grid.add(new Label("Type:"), 0, 4);
        grid.add(type, 1,4);


        addComponentDialog.getDialogPane().setContent(grid);
        addComponentDialog.showAndWait();

        double priceDouble = Double.parseDouble(price.getText());
        double pvDouble = Double.parseDouble(performanceValue.getText());

        String info =  name.getText() + ", " + brand.getText() + "," + price.getText() + ", " + performanceValue.getText() + ", "
                + type.getText() + "\n";
        System.out.print(info);

        MotherboardModel obj = new MotherboardModel(name.getText(), brand.getText(), priceDouble, pvDouble, type.getText());

        return obj;
    }


    //Add component to array
    public static void addComponent(MotherboardModel motherboard) {
        motherboardArray.add(motherboard);
    }

    //Removes selected component from array by comparing names
    public static void removeComponent(MotherboardModel motherboard) {
        for (MotherboardModel obj : motherboardArray) {
            if (obj.getName().equals(motherboard.getName())) {
                motherboardArray.remove(motherboard);
            }
        }
    }
}
