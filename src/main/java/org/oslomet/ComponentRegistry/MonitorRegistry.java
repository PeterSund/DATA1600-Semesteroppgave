package org.oslomet.ComponentRegistry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.oslomet.ComponentClasses.KeyboardModel;
import org.oslomet.ComponentClasses.MonitorModel;

public class MonitorRegistry implements RegistryMethods  {

    //Initialize array
    private static ObservableList<MonitorModel> monitorArray = FXCollections.observableArrayList();
    public static void attachTableView(TableView tv) {
        tv.setItems(monitorArray);
    }

    //Creates component
    public static MonitorModel createComponent(Dialog addComponentDialog, GridPane grid) {
        addComponentDialog.setHeaderText("Create new monitor component");

        TextField name = new TextField();
        name.setPromptText("Name");
        TextField brand = new TextField();
        brand.setPromptText("Brand");
        TextField price = new TextField();
        price.setPromptText("Price");
        TextField performanceValue = new TextField();
        performanceValue.setPromptText("Performance-value");
        TextField size = new TextField();
        size.setPromptText("Size (inches)");


        grid.add(name, 1, 0);
        grid.add(brand, 1,1);
        grid.add(price, 1,2);
        grid.add(performanceValue, 1,3);

        grid.add(new Label("Size):"), 0, 4);
        grid.add(size, 1,4);
        addComponentDialog.getDialogPane().setContent(grid);
        addComponentDialog.showAndWait();

        double priceDouble = Double.parseDouble(price.getText());
        double pvDouble = Double.parseDouble(performanceValue.getText());

        int sizeInt = Integer.parseInt(size.getText());

        String info =  name.getText() + ", " + brand.getText() + "," + price.getText() + ", " + performanceValue.getText() + ", "
                + sizeInt + "\n";
        System.out.print(info);

        MonitorModel obj = new MonitorModel(name.getText(), brand.getText(), priceDouble, pvDouble, sizeInt);

        return obj;

    }

    //Add component to array
    public static void addComponent(MonitorModel monitor) {
        monitorArray.add(monitor);
    }

    //Removes selected component from array by comparing names
    public static void removeComponent(MonitorModel monitor) {
        for (MonitorModel obj : monitorArray) {
            if (obj.getName().equals(monitor.getName())) {
                monitorArray.remove(monitor);
            }
        }
    }
}

