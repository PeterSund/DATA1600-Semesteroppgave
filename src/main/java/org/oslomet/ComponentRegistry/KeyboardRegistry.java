package org.oslomet.ComponentRegistry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.oslomet.ComponentClasses.HarddriveModel;
import org.oslomet.ComponentClasses.KeyboardModel;

public class KeyboardRegistry implements RegistryMethods {

    //Initialize array
    private static ObservableList<KeyboardModel> keyboardArray = FXCollections.observableArrayList();
    public static void attachTableView(TableView tv) {
        tv.setItems(keyboardArray);
    }

    //Creates component
    public static KeyboardModel createComponent(Dialog addComponentDialog, GridPane grid) {
        addComponentDialog.setHeaderText("Create new keyboard component");

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
        TextField language = new TextField();
        language.setPromptText("Language");
        TextField wireless = new TextField();
        wireless.setPromptText("Wireless");

        grid.add(name, 1, 0);
        grid.add(brand, 1,1);
        grid.add(price, 1,2);
        grid.add(performanceValue, 1,3);

        grid.add(new Label("Type):"), 0, 4);
        grid.add(type, 1,4);
        grid.add(new Label("Language:"), 0, 5);
        grid.add(language, 1,5);
        grid.add(new Label("Wireless:"), 0, 6);
        grid.add(wireless, 1,6);
        addComponentDialog.getDialogPane().setContent(grid);
        addComponentDialog.showAndWait();

        double priceDouble = Double.parseDouble(price.getText());
        double pvDouble = Double.parseDouble(performanceValue.getText());

        String info =  name.getText() + ", " + brand.getText() + "," + price.getText() + ", " + performanceValue.getText() + ", "
                + type.getText() + ", " + language.getText() + "\n";
        System.out.print(info);

        KeyboardModel obj = new KeyboardModel(name.getText(), brand.getText(), priceDouble, pvDouble, type.getText(), language.getText(), true);

        return obj;
    }

    //Add component to array
    public static void addComponent(KeyboardModel keyboard) {
        keyboardArray.add(keyboard);
    }

    //Removes selected component from array by comparing names
    public static void removeComponent(KeyboardModel keyboard) {
        for (KeyboardModel obj : keyboardArray) {
            if (obj.getName().equals(keyboard.getName())) {
                keyboardArray.remove(keyboard);
            }
        }
    }
}