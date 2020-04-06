package org.oslomet;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import org.oslomet.ComponentClasses.*;
import org.oslomet.ComponentRegistry.*;


public class GenerateDialogBox {

    //Selects the correct dialog-box to generate based on the active tableview/object in GUI.
    public static void selectDialogToGenerate(String activeTableviewID) {
        Dialog addComponentDialog = addComponentDialog();
        GridPane grid = addComponentGridPane();

        switch (activeTableviewID) {
            case "Computercase":
                createComputerCaseComponentDialog(addComponentDialog, grid);
                break;

            case "CPU":
                generateCPUComponentDialog(addComponentDialog, grid);
                break;

            case "GPU":
                generateGPUComponentDialog(addComponentDialog, grid);
                break;

            case "Hard drive":
                generateHardDriveComponentDialog(addComponentDialog, grid);
                break;

            case "Motherboard":
                generateMotherboardComponentDialog(addComponentDialog, grid);
                break;

            case "RAM":
                generateRAMComponentDialog(addComponentDialog, grid);
                break;

            case "Soundcard":
                generateSoundCardComponentDialog(addComponentDialog, grid);
                break;

            case "PSU":
                generatePSUComponentDialog(addComponentDialog, grid);
                break;

            case "Monitor":
                generateMonitorComponentDialog(addComponentDialog, grid);
                break;

            case "Mouse":
                generateMouseComponentDialog(addComponentDialog, grid);
                break;

            case "Keyboard":
                generateKeyboardComponentDialog(addComponentDialog, grid);
                break;
        }
    }

    //TextFields for template dialog-box
    private static TextField name = new TextField();
    private static TextField brand = new TextField();
    private static TextField price = new TextField();
    private static TextField performanceValue = new TextField();

    //Clear input text when dialog is opened
    public static void clearTextFields() {
        name.clear();
        brand.clear();
        price.clear();
        performanceValue.clear();
    }

    //Template dialog-box
    public static Dialog addComponentDialog() {
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Create new component");

        ButtonType add = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(add, ButtonType.CANCEL);
        return dialog;
    }

    //Template grid for dialog-box
    public static GridPane addComponentGridPane() {
        GridPane grid = new GridPane();
        clearTextFields();
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(name, 1, 0);
        grid.add(brand, 1,1);
        grid.add(price, 1,2);
        grid.add(performanceValue, 1,3);

        name.setPromptText("Name");
        brand.setPromptText("Brand");
        price.setPromptText("Price");
        performanceValue.setPromptText("Performance-value");

        grid.add(new Label("Name:"), 0, 0);
        grid.add(new Label("Brand:"), 0, 1);
        grid.add(new Label("Price:"), 0, 2);
        grid.add(new Label("Performance-value (0-100):"), 0, 3);

        return grid;
    }

    //Generate dialog window for adding component. Method modifies the template dialog-box.
    public static void createComputerCaseComponentDialog(Dialog addComponentDialog, GridPane grid) {

        addComponentDialog.setHeaderText("Create new computer-case component");

        TextField dimensions = new TextField();
        dimensions.setPromptText("H x L x D");
        TextField color = new TextField();
        color.setPromptText("Color");

        grid.add(new Label("Dimensions (HxLxD):"), 0, 4);
        grid.add(dimensions, 1,4);
        grid.add(new Label("Color:"), 0, 5);
        grid.add(color, 1,5);
        addComponentDialog.getDialogPane().setContent(grid);
        addComponentDialog.showAndWait();

        //TEST
        double pri = Double.parseDouble(price.getText());
        double per = Double.parseDouble(performanceValue.getText());

        ComputerCaseModel test = new ComputerCaseModel(name.getText(), brand.getText(), pri, per, dimensions.getText(),color.getText());
        ComputerCaseRegistry.addComponent(test);

    }

    //Generate dialog window for adding component. Method modifies the template dialog-box.
    public static void generateCPUComponentDialog(Dialog addComponentDialog, GridPane grid) {
        addComponentDialog.setHeaderText("Create new CPU component");

        TextField clockSpeed = new TextField();
        clockSpeed.setPromptText("Clockspeed (GHz)");
        TextField cores = new TextField();
        cores.setPromptText("No. cores");

        grid.add(new Label("Clockspeed:"), 0, 4);
        grid.add(clockSpeed, 1,4);
        grid.add(new Label("No. cores:"), 0, 5);
        grid.add(cores, 1,5);

        addComponentDialog.getDialogPane().setContent(grid);
        addComponentDialog.showAndWait();

        //TEST
        double pri = Double.parseDouble(price.getText());
        double per = Double.parseDouble(performanceValue.getText());
        int clock = Integer.parseInt(clockSpeed.getText());
        int mem = Integer.parseInt(cores.getText());

        CPUModel test = new CPUModel(name.getText(), brand.getText(), pri, per, clock, mem);
        CPURegistry.addComponent(test);
    }

    //Generate dialog window for adding component. Method modifies the template dialog-box.
    public static void generateGPUComponentDialog(Dialog addComponentDialog, GridPane grid) {
        addComponentDialog.setHeaderText("Create new GPU component");

        TextField clockSpeed = new TextField();
        clockSpeed.setPromptText("Clockspeed (GHz)");
        TextField memory = new TextField();
        memory.setPromptText("Memory (MB)");

        grid.add(new Label("Clockspeed):"), 0, 4);
        grid.add(clockSpeed, 1,4);
        grid.add(new Label("Memory:"), 0, 5);
        grid.add(memory, 1,5);
        addComponentDialog.getDialogPane().setContent(grid);
        addComponentDialog.showAndWait();

        //TEST
        double pri = Double.parseDouble(price.getText());
        double per = Double.parseDouble(performanceValue.getText());
        int clock = Integer.parseInt(clockSpeed.getText());
        int mem = Integer.parseInt(memory.getText());

        GPUModel test = new GPUModel(name.getText(), brand.getText(), pri, per, clock, mem);
        GPURegistry.addComponent(test);
    }

    //Generate dialog window for adding component. Method modifies the template dialog-box.
    public static void generateHardDriveComponentDialog (Dialog addComponentDialog, GridPane grid) {
        addComponentDialog.setHeaderText("Create new Hard-drive component");

        TextField type = new TextField();
        type.setPromptText("Type (HDD/SSD/other)");
        TextField capacity = new TextField();
        capacity.setPromptText("Capacity (GB)");

        grid.add(new Label("Type):"), 0, 4);
        grid.add(type, 1,4);
        grid.add(new Label("Capacity:"), 0, 5);
        grid.add(capacity, 1,5);
        addComponentDialog.getDialogPane().setContent(grid);
        addComponentDialog.showAndWait();

        //TEST
        double pri = Double.parseDouble(price.getText());
        double per = Double.parseDouble(performanceValue.getText());
        int cap = Integer.parseInt(capacity.getText());
        HarddriveModel test = new HarddriveModel(name.getText(), brand.getText(), pri, per, type.getText(), cap);
        HardDriveRegistry.addComponent(test);
    }

    //Generate dialog window for adding component. Method modifies the template dialog-box.
    public static void generateKeyboardComponentDialog(Dialog addComponentDialog, GridPane grid) {
        addComponentDialog.setHeaderText("Create new keyboard component");

        TextField type = new TextField();
        type.setPromptText("Type");
        TextField language = new TextField();
        language.setPromptText("Language");
        TextField wireless = new TextField();
        wireless.setPromptText("Wireless");

        grid.add(new Label("Type):"), 0, 4);
        grid.add(type, 1, 4);
        grid.add(new Label("Language:"), 0, 5);
        grid.add(language, 1, 5);
        grid.add(new Label("Wireless:"), 0, 6);
        grid.add(wireless, 1, 6);
        addComponentDialog.getDialogPane().setContent(grid);
        addComponentDialog.showAndWait();

        //TEST
        double pri = Double.parseDouble(price.getText());
        double per = Double.parseDouble(performanceValue.getText());
        KeyboardModel test = new KeyboardModel(name.getText(), brand.getText(), pri, per, type.getText(), language.getText(), true);
        KeyboardRegistry.addComponent(test);
    }

    //Generate dialog window for adding component. Method modifies the template dialog-box.
    public static void generateMonitorComponentDialog(Dialog addComponentDialog, GridPane grid) {
        addComponentDialog.setHeaderText("Create new monitor component");

        TextField size = new TextField();
        size.setPromptText("Size (inches)");

        grid.add(new Label("Size):"), 0, 4);
        grid.add(size, 1,4);
        addComponentDialog.getDialogPane().setContent(grid);
        addComponentDialog.showAndWait();

        //TEST
        double pri = Double.parseDouble(price.getText());
        double per = Double.parseDouble(performanceValue.getText());

        int siz = Integer.parseInt(size.getText());

        MonitorModel test = new MonitorModel(name.getText(), brand.getText(), pri, per, siz);
        MonitorRegistry.addComponent(test);


    }

    //Generate dialog window for adding component. Method modifies the template dialog-box.
    public static void generateMotherboardComponentDialog(Dialog addComponentDialog, GridPane grid) {
        addComponentDialog.setHeaderText("Create new motherboard component");

        TextField type = new TextField();
        type.setPromptText("Type");
        grid.add(new Label("Type:"), 0, 4);
        grid.add(type, 1,4);


        addComponentDialog.getDialogPane().setContent(grid);
        addComponentDialog.showAndWait();

        //TEST
        double pri = Double.parseDouble(price.getText());
        double per = Double.parseDouble(performanceValue.getText());
        MotherboardModel test = new MotherboardModel(name.getText(), brand.getText(), pri, per, type.getText());

        MotherboardRegistry.addComponent(test);
    }

    //Generate dialog window for adding component. Method modifies the template dialog-box.
    public static void generateMouseComponentDialog(Dialog addComponentDialog, GridPane grid) {
        addComponentDialog.setHeaderText("Create new mouse component");

        TextField type = new TextField();
        type.setPromptText("Type");
        TextField wireless = new TextField();
        wireless.setPromptText("Wireless");

        grid.add(new Label("Type:"), 0, 4);
        grid.add(type, 1,4);
        grid.add(new Label("Wireless:"), 0, 5);
        grid.add(wireless, 1,5);

        addComponentDialog.getDialogPane().setContent(grid);
        addComponentDialog.showAndWait();

        //TEST
        double pri = Double.parseDouble(price.getText());
        double per = Double.parseDouble(performanceValue.getText());
        MouseModel test = new MouseModel(name.getText(), brand.getText(), pri, per, type.getText(), true);
        MouseRegistry.addComponent(test);
    }

    //Generate dialog window for adding component. Method modifies the template dialog-box.
    public static void generatePSUComponentDialog(Dialog addComponentDialog, GridPane grid) {
        addComponentDialog.setHeaderText("Create new PSU component");

        TextField watt = new TextField();
        watt.setPromptText("Watt");

        grid.add(new Label("Watt: "), 0, 4);
        grid.add(watt, 1,4);


        addComponentDialog.getDialogPane().setContent(grid);
        addComponentDialog.showAndWait();

        //TEST
        double pri = Double.parseDouble(price.getText());
        double per = Double.parseDouble(performanceValue.getText());

        int what = Integer.parseInt(watt.getText());

        PSUModel test = new PSUModel(name.getText(), brand.getText(), pri, per, what);
        PSURegistry.addComponent(test);
    }

    //Generate dialog window for adding component. Method modifies the template dialog-box.
    public static void generateRAMComponentDialog(Dialog addComponentDialog, GridPane grid) {
        addComponentDialog.setHeaderText("Create new RAM component");

        TextField capacity = new TextField();
        capacity.setPromptText("Capacity (MB)");
        TextField memorySpeed = new TextField();
        memorySpeed.setPromptText("Memoryspeed (MHz)");

        grid.add(new Label("Capacity:"), 0, 4);
        grid.add(capacity, 1,4);
        grid.add(new Label("Memoryspeed (MHz): "), 0, 5);
        grid.add(memorySpeed, 1,5);


        addComponentDialog.getDialogPane().setContent(grid);
        addComponentDialog.showAndWait();

        //TEST
        double pri = Double.parseDouble(price.getText());
        double per = Double.parseDouble(performanceValue.getText());

        int cap = Integer.parseInt(capacity.getText());
        double mem = Double.parseDouble(memorySpeed.getText());

        RAMModel test = new RAMModel(name.getText(), brand.getText(), pri, per, cap, mem);
        RAMRegistry.addComponent(test);
    }

    //Generate dialog window for adding component. Method modifies the template dialog-box.
    public static void generateSoundCardComponentDialog(Dialog addComponentDialog, GridPane grid) {
        addComponentDialog.setHeaderText("Create new soundcard component");

        TextField surround = new TextField();
        surround.setPromptText("Surround");
        TextField bassboost = new TextField();
        bassboost.setPromptText("Bassboost");

        grid.add(new Label("Surround: "), 0, 4);
        grid.add(surround, 1,4);
        grid.add(new Label("Bassboost: "), 0, 5);
        grid.add(bassboost, 1,5);

        addComponentDialog.getDialogPane().setContent(grid);
        addComponentDialog.showAndWait();

        //TEST
        double pri = Double.parseDouble(price.getText());
        double per = Double.parseDouble(performanceValue.getText());

        SoundCardModel test = new SoundCardModel(name.getText(), brand.getText(), pri, per, true, true);
        SoundCardRegistry.addComponent(test);
    }
}
