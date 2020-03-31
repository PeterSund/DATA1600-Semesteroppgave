package org.oslomet.ComponentRegistry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;
import org.oslomet.ComponentClasses.ComputerCaseModel;

import java.util.Optional;

public class ComputerCaseRegistry implements RegistryMethods {

    //Initialize array
    private static ObservableList<ComputerCaseModel> computerCaseArray = FXCollections.observableArrayList();
    public static void attachTableView(TableView tv) {
        tv.setItems(computerCaseArray);
    }

    //Creates component
    public static void createComponent(Dialog addComponentDialog, GridPane grid) {

        addComponentDialog.setHeaderText("Create new computer-case component");

        TextField name = new TextField();
        name.setPromptText("Name");
        TextField brand = new TextField();
        brand.setPromptText("Brand");
        TextField price = new TextField();
        price.setPromptText("Price");
        TextField performanceValue = new TextField();
        performanceValue.setPromptText("Performance-value");
        TextField dimensions = new TextField();
        dimensions.setPromptText("H x L x D");
        TextField color = new TextField();
        color.setPromptText("Color");

        grid.add(name, 1, 0);
        grid.add(brand, 1,1);
        grid.add(price, 1,2);
        grid.add(performanceValue, 1,3);

        grid.add(new Label("Dimensions (HxLxD):"), 0, 4);
        grid.add(dimensions, 1,4);
        grid.add(new Label("Color:"), 0, 5);
        grid.add(color, 1,5);
        addComponentDialog.getDialogPane().setContent(grid);
        addComponentDialog.showAndWait();

        String info =  name.getText() + ", " + brand.getText() + "," + price.getText() + ", " + performanceValue.getText() + ", "
                + dimensions.getText() + ", " + color.getText();
        System.out.print(info);

        String innPrice = price.getText();
        double priceDouble = Double.parseDouble(innPrice);

        String innPV = performanceValue.getText();
        double pvDouble = Double.parseDouble(innPV);

        ComputerCaseModel test = new ComputerCaseModel(name.getText(), brand.getText(), priceDouble, pvDouble,
                 dimensions.getText(), color.getText());

        addComponent(test);
    }


    //Add component to array
    public static void addComponent(ComputerCaseModel computerCase) {
        computerCaseArray.add(computerCase);
    }

    //Removes selected component from array by comparing names
    public static void removeComponent(ComputerCaseModel computerCase) {
        for(ComputerCaseModel obj : computerCaseArray) {
            if(obj.getName().equals(computerCase.getName())) {
                computerCaseArray.remove(computerCase);
            }
        }
    }
}


