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

    //Creates component
    public static SoundCardModel createComponent(Dialog addComponentDialog, GridPane grid) {
        addComponentDialog.setHeaderText("Create new soundcard component");

        TextField name = new TextField();
        name.setPromptText("Name");
        TextField brand = new TextField();
        brand.setPromptText("Brand");
        TextField price = new TextField();
        price.setPromptText("Price");
        TextField performanceValue = new TextField();
        performanceValue.setPromptText("Performance-value");
        TextField surround = new TextField();
        surround.setPromptText("Surround");
        TextField bassboost = new TextField();
        bassboost.setPromptText("Bassbost");

        grid.add(name, 1, 0);
        grid.add(brand, 1,1);
        grid.add(price, 1,2);
        grid.add(performanceValue, 1,3);
        grid.add(new Label("Surround: "), 0, 4);
        grid.add(surround, 1,4);
        grid.add(new Label("Bassboost: "), 0, 5);
        grid.add(bassboost, 1,5);


        addComponentDialog.getDialogPane().setContent(grid);
        addComponentDialog.showAndWait();

        double priceDouble = Double.parseDouble(price.getText());
        double pvDouble = Double.parseDouble(performanceValue.getText());

        String info =  name.getText() + ", " + brand.getText() + "," + price.getText() + ", " + performanceValue.getText() + ", "
                + surround + ", " + bassboost + "\n";
        System.out.print(info);



        SoundCardModel obj = new SoundCardModel(name.getText(), brand.getText(), priceDouble, pvDouble, true, true);

        return obj;
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

