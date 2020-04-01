package org.oslomet.ComponentRegistry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.oslomet.ComponentClasses.GPUModel;
import org.oslomet.ComponentClasses.HarddriveModel;

public class HardDriveRegistry implements RegistryMethods {

    //Initialize array
    private static ObservableList<HarddriveModel> hardDriveArray = FXCollections.observableArrayList();

    public static void attachTableView(TableView tv) {
        tv.setItems(hardDriveArray);
    }

    //Creates component
    public static HarddriveModel createComponent(Dialog addComponentDialog, GridPane grid) {
        addComponentDialog.setHeaderText("Create new Hard-drive component");

        TextField name = new TextField();
        name.setPromptText("Name");
        TextField brand = new TextField();
        brand.setPromptText("Brand");
        TextField price = new TextField();
        price.setPromptText("Price");
        TextField performanceValue = new TextField();
        performanceValue.setPromptText("Performance-value");
        TextField type = new TextField();
        type.setPromptText("Type (HDD/SSD/other)");
        TextField capacity = new TextField();
        capacity.setPromptText("Capacity (GB)");

        grid.add(name, 1, 0);
        grid.add(brand, 1,1);
        grid.add(price, 1,2);
        grid.add(performanceValue, 1,3);

        grid.add(new Label("Type):"), 0, 4);
        grid.add(type, 1,4);
        grid.add(new Label("Capacity:"), 0, 5);
        grid.add(capacity, 1,5);
        addComponentDialog.getDialogPane().setContent(grid);
        addComponentDialog.showAndWait();

        double priceDouble = Double.parseDouble(price.getText());
        double pvDouble = Double.parseDouble(performanceValue.getText());

        int capacityInt = Integer.parseInt(capacity.getText());

        String info =  name.getText() + ", " + brand.getText() + "," + price.getText() + ", " + performanceValue.getText() + ", "
                + type.getText() + ", " + capacityInt + "\n";
        System.out.print(info);

        HarddriveModel obj = new HarddriveModel(name.getText(), brand.getText(), priceDouble, pvDouble, type.getText(), capacityInt);

        return obj;
    }

    //Add component to array
    public static void addComponent(HarddriveModel hardDrive) {
        hardDriveArray.add(hardDrive);
    }

    //Removes selected component from array by comparing names
    public static void removeComponent(HarddriveModel hardDrive) {
        for (HarddriveModel obj : hardDriveArray) {
            if (obj.getName().equals(hardDrive.getName())) {
                hardDriveArray.remove(hardDrive);
            }
        }
    }
}
