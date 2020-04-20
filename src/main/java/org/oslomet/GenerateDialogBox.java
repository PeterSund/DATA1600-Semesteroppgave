package org.oslomet;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import org.oslomet.ComponentClasses.*;
import org.oslomet.ComponentRegistry.*;
import org.oslomet.ExceptionClasses.*;
import javax.swing.JButton;



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

    //Labels for displaying error in templae dialog-box
    private static Label nameErrorLbl = new Label();
    private static Label brandErrorLbl = new Label();
    private static Label priceErrorLbl = new Label();
    private static Label performanceValueErrorLbl = new Label();

    //Clear input text when dialog is opened
    public static void clearTextFields() {
        name.clear();
        brand.clear();
        price.clear();
        performanceValue.clear();
    }

    public static void clearErrorLabels() {
        nameErrorLbl.setText("");
        brandErrorLbl.setText("");
        priceErrorLbl.setText("");
        performanceValueErrorLbl.setText("");
    }


    //Template dialog-box
    public static Dialog addComponentDialog() {
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Create new component");

        ButtonType add = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        dialog.getDialogPane().getButtonTypes().addAll(add, cancel);

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

        grid.add(nameErrorLbl, 2, 0);
        grid.add(brandErrorLbl, 2, 1);
        grid.add(priceErrorLbl, 2,2);
        grid.add(performanceValueErrorLbl, 2, 3);


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

        Label dimensionsErrorLbl = new Label("");
        grid.add(dimensionsErrorLbl, 2, 4);
        Label colorErrorLbl = new Label("");
        grid.add(colorErrorLbl,2,5);

        grid.add(new Label("Dimensions (HxLxD):"), 0, 4);
        grid.add(dimensions, 1,4);
        grid.add(new Label("Color:"), 0, 5);
        grid.add(color, 1,5);
        addComponentDialog.getDialogPane().setContent(grid);


        boolean createObject = false;
        while (!createObject) {
            addComponentDialog.showAndWait();
            try {
                clearErrorLabels();
                colorErrorLbl.setText("");
                dimensionsErrorLbl.setText("");
                double priceDouble = 0;
                double pvDouble = 0;
                try {
                    priceDouble = Double.parseDouble(price.getText());
                } catch (NumberFormatException nfe) {
                    priceErrorLbl.setText("Price must be a number");
                }
                try {
                    pvDouble = Double.parseDouble(performanceValue.getText());
                } catch (NumberFormatException nfe) {
                    performanceValueErrorLbl.setText("Performancevalue must be a number");
                }

                ComputerCaseRegistry.addComponent(new ComputerCaseModel(name.getText(), brand.getText(), priceDouble, pvDouble, dimensions.getText(),color.getText()));
                createObject = true;

            }

            catch (InvalidNameException ine) {
                nameErrorLbl.setText(ine.getMessage());
            } catch (InvalidBrandException ibe) {
                brandErrorLbl.setText(ibe.getMessage());
            } catch (InvalidPriceException ipe) {
                priceErrorLbl.setText(ipe.getMessage());
            } catch (InvalidPerformanceValueException ipve) {
                performanceValueErrorLbl.setText(ipve.getMessage());
            } catch (InvalidDimensionsException ide) {
                dimensionsErrorLbl.setText(ide.getMessage());
            } catch (InvalidColorException ise) {
                colorErrorLbl.setText(ise.getMessage());
            }
        }
    }

    //Generate dialog window for adding component. Method modifies the template dialog-box.
    public static void generateCPUComponentDialog(Dialog addComponentDialog, GridPane grid) {
        addComponentDialog.setHeaderText("Create new CPU component");

        TextField clockSpeed = new TextField();
        clockSpeed.setPromptText("Clockspeed (GHz)");
        TextField cores = new TextField();
        cores.setPromptText("No. cores");


        Label clockspeedErrorLbl = new Label("");
        grid.add(clockspeedErrorLbl, 2, 4);
        Label coresErrorLbl = new Label("");
        grid.add(coresErrorLbl,2,5);

        grid.add(new Label("Clockspeed:"), 0, 4);
        grid.add(clockSpeed, 1,4);
        grid.add(new Label("No. cores:"), 0, 5);
        grid.add(cores, 1,5);

        addComponentDialog.getDialogPane().setContent(grid);

        boolean createObject = false;
        while (!createObject) {
            addComponentDialog.showAndWait();
            try {
                clearErrorLabels();
                clockspeedErrorLbl.setText("");
                coresErrorLbl.setText("");
                double priceDouble = 0;
                double pvDouble = 0;
                double clockSpeedDouble = 0;
                int coresInt = 0;
                try {
                    priceDouble = Double.parseDouble(price.getText());
                } catch (NumberFormatException nfe) {
                    priceErrorLbl.setText("Price must be a number");
                }
                try {
                    pvDouble = Double.parseDouble(performanceValue.getText());
                } catch (NumberFormatException nfe) {
                    performanceValueErrorLbl.setText("Performancevalue must be a number");
                }
                try {
                    clockSpeedDouble = Double.parseDouble(clockSpeed.getText());
                } catch (NumberFormatException nfe) {
                    clockspeedErrorLbl.setText("Clockspeed must be a number");
                }
                try {
                    coresInt = Integer.parseInt(cores.getText());
                } catch (NumberFormatException nfe) {
                    coresErrorLbl.setText("Cores must be a number");
                }

                CPURegistry.addComponent(new CPUModel(name.getText(), brand.getText(), priceDouble, pvDouble, clockSpeedDouble, coresInt));
                createObject = true;
            }

            catch (InvalidNameException ine) {
                nameErrorLbl.setText(ine.getMessage());
            } catch (InvalidBrandException ibe) {
                brandErrorLbl.setText(ibe.getMessage());
            } catch (InvalidPriceException ipe) {
                priceErrorLbl.setText(ipe.getMessage());
            } catch (InvalidPerformanceValueException ipve) {
                performanceValueErrorLbl.setText(ipve.getMessage());
            } catch (InvalidClockSpeedException icse) {
                clockspeedErrorLbl.setText(icse.getMessage());
            } catch (InvalidCoresException ice) {
                coresErrorLbl.setText(ice.getMessage());
            }
        }
    }

    //Generate dialog window for adding component. Method modifies the template dialog-box.
    public static void generateGPUComponentDialog(Dialog addComponentDialog, GridPane grid) {
        addComponentDialog.setHeaderText("Create new GPU component");

        TextField clockSpeed = new TextField();
        clockSpeed.setPromptText("Clockspeed (GHz)");
        TextField memory = new TextField();
        memory.setPromptText("Memory (MB)");

        Label clockSpeedErrorLbl = new Label("");
        grid.add(clockSpeedErrorLbl, 2, 4);
        Label memoryErrorLbl = new Label("");
        grid.add(memoryErrorLbl,2,5);

        grid.add(new Label("Memory clockspeed):"), 0, 4);
        grid.add(clockSpeed, 1,4);
        grid.add(new Label("Memory:"), 0, 5);
        grid.add(memory, 1,5);
        addComponentDialog.getDialogPane().setContent(grid);

        boolean createObject = false;
        while (!createObject) {
            addComponentDialog.showAndWait();
            try {
                clearErrorLabels();
                clockSpeedErrorLbl.setText("");
                memoryErrorLbl.setText("");
                double priceDouble = 0;
                double pvDouble = 0;
                double clockSpeedDouble = 0;
                int memoryInt = 0;
                try {
                    priceDouble = Double.parseDouble(price.getText());
                } catch (NumberFormatException nfe) {
                    priceErrorLbl.setText("Price must be a number");
                }
                try {
                    pvDouble = Double.parseDouble(performanceValue.getText());
                } catch (NumberFormatException nfe) {
                    performanceValueErrorLbl.setText("Performancevalue must be a number");
                }
                try {
                    clockSpeedDouble = Double.parseDouble(clockSpeed.getText());
                } catch (NumberFormatException nfe) {
                    clockSpeedErrorLbl.setText("Clockspeed speed must be a number");
                }
                try {
                    memoryInt = Integer.parseInt(memory.getText());
                } catch (NumberFormatException nfe) {
                    memoryErrorLbl.setText("Memory must be a number");
                }

                GPURegistry.addComponent(new GPUModel(name.getText(), brand.getText(), priceDouble, pvDouble, clockSpeedDouble, memoryInt));
                createObject = true;
            }

            catch (InvalidNameException ine) {
                nameErrorLbl.setText(ine.getMessage());
            } catch (InvalidBrandException ibe) {
                brandErrorLbl.setText(ibe.getMessage());
            } catch (InvalidPriceException ipe) {
                priceErrorLbl.setText(ipe.getMessage());
            } catch (InvalidPerformanceValueException ipve) {
                performanceValueErrorLbl.setText(ipve.getMessage());
            } catch (InvalidMemorySpeedException imse) {
                clockSpeedErrorLbl.setText(imse.getMessage());
            } catch (InvalidMemoryException ime) {
                memoryErrorLbl.setText(ime.getMessage());
            }
        }
    }


    //Generate dialog window for adding component. Method modifies the template dialog-box.
    public static void generateHardDriveComponentDialog (Dialog addComponentDialog, GridPane grid) {
        addComponentDialog.setHeaderText("Create new Hard-drive component");

        ComboBox type = new ComboBox();
        type.getItems().addAll("HDD", "SSD");
        type.setValue("HDD");
        TextField capacity = new TextField();
        capacity.setPromptText("Capacity (GB)");

        Label typeErrorLBl = new Label("");
        grid.add(typeErrorLBl, 2, 4);
        Label capacityErrorLbl = new Label("");
        grid.add(capacityErrorLbl, 2, 5);


        grid.add(new Label("Type):"), 0, 4);
        grid.add(type, 1, 4);
        grid.add(new Label("Capacity:"), 0, 5);
        grid.add(capacity, 1, 5);
        addComponentDialog.getDialogPane().setContent(grid);

        boolean createObject = false;
        while (!createObject) {
            addComponentDialog.showAndWait();
            try {
                clearErrorLabels();
                typeErrorLBl.setText("");
                capacityErrorLbl.setText("");
                double priceDouble = 0;
                double pvDouble = 0;
                int capacityInt = 0;
                String typeString = type.getValue().toString();
                try {
                    priceDouble = Double.parseDouble(price.getText());
                } catch (NumberFormatException nfe) {
                    priceErrorLbl.setText("Price must be a number");
                }
                try {
                    pvDouble = Double.parseDouble(performanceValue.getText());
                } catch (NumberFormatException nfe) {
                    performanceValueErrorLbl.setText("Performancevalue must be a number");
                }
                try {
                    capacityInt = Integer.parseInt(capacity.getText());
                } catch (NumberFormatException nfe) {
                    capacityErrorLbl.setText("Memory must be a number");
                }

                HardDriveRegistry.addComponent(new HarddriveModel(name.getText(), brand.getText(), priceDouble, pvDouble, typeString, capacityInt));
                createObject = true;
            } catch (InvalidNameException ine) {
                nameErrorLbl.setText(ine.getMessage());
            } catch (InvalidBrandException ibe) {
                brandErrorLbl.setText(ibe.getMessage());
            } catch (InvalidPriceException ipe) {
                priceErrorLbl.setText(ipe.getMessage());
            } catch (InvalidPerformanceValueException ipve) {
                performanceValueErrorLbl.setText(ipve.getMessage());
            } catch (InvalidCapacityException ice) {
                capacityErrorLbl.setText(ice.getMessage());
            }
        }
    }


    //Generate dialog window for adding component. Method modifies the template dialog-box.
    public static void generateKeyboardComponentDialog(Dialog addComponentDialog, GridPane grid) {
        addComponentDialog.setHeaderText("Create new keyboard component");

        ComboBox type = new ComboBox();
        type.getItems().addAll("Office", "Gaming", "Mechanical");
        type.setPromptText("Select");


        TextField language = new TextField();
        language.setPromptText("Language");
        ComboBox wireless = new ComboBox();
        wireless.getItems().addAll("Yes", "No");

        Label languageErrorLbl = new Label("");
        grid.add(languageErrorLbl, 2, 5);

        grid.add(new Label("Type:"), 0, 4);
        grid.add(type, 1, 4);
        grid.add(new Label("Language:"), 0, 5);
        grid.add(language, 1, 5);
        grid.add(new Label("Wireless:"), 0, 6);
        grid.add(wireless, 1, 6);
        addComponentDialog.getDialogPane().setContent(grid);

        boolean createObject = false;
        while (!createObject) {
            addComponentDialog.showAndWait();
            try {
                clearErrorLabels();
                languageErrorLbl.setText("");
                double priceDouble = 0;
                double pvDouble = 0;
                String typeString = type.getValue().toString();
                String wirelessString = wireless.getValue().toString();


                    try {
                        priceDouble = Double.parseDouble(price.getText());
                    } catch (NumberFormatException nfe) {
                        priceErrorLbl.setText("Price must be a number");
                    }
                    try {
                        pvDouble = Double.parseDouble(performanceValue.getText());
                    } catch (NumberFormatException nfe) {
                        performanceValueErrorLbl.setText("Performancevalue must be a number");
                    }

                    KeyboardRegistry.addComponent(new KeyboardModel(name.getText(), brand.getText(), priceDouble, pvDouble, typeString, language.getText(), wirelessString));
                    createObject = true;

            } catch (InvalidNameException ine) {
                nameErrorLbl.setText(ine.getMessage());
            } catch (InvalidBrandException ibe) {
                brandErrorLbl.setText(ibe.getMessage());
            } catch (InvalidPriceException ipe) {
                priceErrorLbl.setText(ipe.getMessage());
            } catch (InvalidPerformanceValueException ipve) {
                performanceValueErrorLbl.setText(ipve.getMessage());
            } catch (InvalidLanguageException ile) {
                languageErrorLbl.setText(ile.getMessage());
            }
        }
    }



    //Generate dialog window for adding component. Method modifies the template dialog-box.
    public static void generateMonitorComponentDialog(Dialog addComponentDialog, GridPane grid) {
        addComponentDialog.setHeaderText("Create new monitor component");

        TextField size = new TextField();
        size.setPromptText("Size (inches)");

        Label sizeErrorLlb = new Label("");
        grid.add(sizeErrorLlb, 2, 4);
        grid.add(new Label("Size:"), 0, 4);
        grid.add(size, 1, 4);
        addComponentDialog.getDialogPane().setContent(grid);

        boolean createObject = false;
        while (!createObject) {
            addComponentDialog.showAndWait();
            try {
                clearErrorLabels();
                sizeErrorLlb.setText("");
                double priceDouble = 0;
                double pvDouble = 0;
                int sizeInt = 0;
                    try {
                        priceDouble = Double.parseDouble(price.getText());
                    } catch (NumberFormatException nfe) {
                        priceErrorLbl.setText("Price must be a number");
                    }
                    try {
                        pvDouble = Double.parseDouble(performanceValue.getText());
                    } catch (NumberFormatException nfe) {
                        performanceValueErrorLbl.setText("Performancevalue must be a number");
                    }
                    try {
                        sizeInt = Integer.parseInt(size.getText());
                    } catch (NumberFormatException nfe) {
                        sizeErrorLlb.setText("Size must be a number");
                    }

                MonitorRegistry.addComponent(new MonitorModel(name.getText(), brand.getText(), priceDouble, pvDouble, sizeInt));
                createObject = true;

                }

            catch (InvalidNameException ine) {
                nameErrorLbl.setText(ine.getMessage());
            } catch (InvalidBrandException ibe) {
                brandErrorLbl.setText(ibe.getMessage());
            } catch (InvalidPriceException ipe) {
                priceErrorLbl.setText(ipe.getMessage());
            } catch (InvalidPerformanceValueException ipve) {
                performanceValueErrorLbl.setText(ipve.getMessage());
            } catch (InvalidSizeException ise) {
                sizeErrorLlb.setText(ise.getMessage());
            }
        }
    }



    //Generate dialog window for adding component. Method modifies the template dialog-box.
    public static void generateMotherboardComponentDialog(Dialog addComponentDialog, GridPane grid) {
        addComponentDialog.setHeaderText("Create new motherboard component");

        ComboBox type = new ComboBox();
        type.getItems().addAll("ATX", "mini-ATX", "E-ATX");
        type.setValue("ATX");


        grid.add(new Label("Type:"), 0, 4);
        grid.add(type, 1, 4);

        addComponentDialog.getDialogPane().setContent(grid);

        boolean createObject = false;
        while (!createObject) {
            addComponentDialog.showAndWait();
            try {
                clearErrorLabels();
                double priceDouble = 0;
                double pvDouble = 0;
                String typeString = type.getValue().toString();
                try {
                    priceDouble = Double.parseDouble(price.getText());
                } catch (NumberFormatException nfe) {
                    priceErrorLbl.setText("Price must be a number");
                }
                try {
                    pvDouble = Double.parseDouble(performanceValue.getText());
                } catch (NumberFormatException nfe) {
                    performanceValueErrorLbl.setText("Performancevalue must be a number");
                }

                MotherboardRegistry.addComponent(new MotherboardModel(name.getText(), brand.getText(), priceDouble, pvDouble, typeString));
                createObject = true;

            } catch (InvalidNameException ine) {
                nameErrorLbl.setText(ine.getMessage());
            } catch (InvalidBrandException ibe) {
                brandErrorLbl.setText(ibe.getMessage());
            } catch (InvalidPriceException ipe) {
                priceErrorLbl.setText(ipe.getMessage());
            } catch (InvalidPerformanceValueException ipve) {
                performanceValueErrorLbl.setText(ipve.getMessage());
            }
        }
    }


    //Generate dialog window for adding component. Method modifies the template dialog-box.
    public static void generateMouseComponentDialog(Dialog addComponentDialog, GridPane grid) {
        addComponentDialog.setHeaderText("Create new mouse component");

        ComboBox type = new ComboBox();
        type.getItems().addAll("Office", "Gaming");
        type.setValue("Office");
        String typeString = type.getValue().toString();

        ComboBox wireless = new ComboBox();
        wireless.getItems().addAll("Yes", "No");
        wireless.setValue("Yes");

        grid.add(new Label("Type:"), 0, 4);
        grid.add(type, 1,4);
        grid.add(new Label("Wireless:"), 0, 5);
        grid.add(wireless, 1,5);

        addComponentDialog.getDialogPane().setContent(grid);

        boolean createObject = false;
        while (!createObject) {
            addComponentDialog.showAndWait();
            try {
                clearErrorLabels();
                double priceDouble = 0;
                double pvDouble = 0;
                String wireslessString = type.getValue().toString();

                try {
                    priceDouble = Double.parseDouble(price.getText());
                } catch (NumberFormatException nfe) {
                    priceErrorLbl.setText("Price must be a number");
                }
                try {
                    pvDouble = Double.parseDouble(performanceValue.getText());
                } catch (NumberFormatException nfe) {
                    performanceValueErrorLbl.setText("Performancevalue must be a number");
                }

                MouseRegistry.addComponent(new MouseModel(name.getText(), brand.getText(), priceDouble, pvDouble, typeString, wireslessString));
                createObject = true;

            } catch (InvalidNameException ine) {
                nameErrorLbl.setText(ine.getMessage());
            } catch (InvalidBrandException ibe) {
                brandErrorLbl.setText(ibe.getMessage());
            } catch (InvalidPriceException ipe) {
                priceErrorLbl.setText(ipe.getMessage());
            } catch (InvalidPerformanceValueException ipve) {
                performanceValueErrorLbl.setText(ipve.getMessage());
            }
        }
    }

    //Generate dialog window for adding component. Method modifies the template dialog-box.
    public static void generatePSUComponentDialog(Dialog addComponentDialog, GridPane grid) {
        addComponentDialog.setHeaderText("Create new PSU component");

        TextField watt = new TextField();
        watt.setPromptText("Watt");

        Label wattErrorLbl = new Label("");
        grid.add(wattErrorLbl, 2,4);

        grid.add(new Label("Watt: "), 0, 4);
        grid.add(watt, 1,4);


        addComponentDialog.getDialogPane().setContent(grid);

        boolean createObject = false;
        while (!createObject) {
            addComponentDialog.showAndWait();
            try {
                clearErrorLabels();
                double priceDouble = 0;
                double pvDouble = 0;
                int wattInt = 0;

                try {
                    priceDouble = Double.parseDouble(price.getText());
                } catch (NumberFormatException nfe) {
                    priceErrorLbl.setText("Price must be a number");
                }
                try {
                    pvDouble = Double.parseDouble(performanceValue.getText());
                } catch (NumberFormatException nfe) {
                    performanceValueErrorLbl.setText("Performancevalue must be a number");
                }
                try {
                    wattInt = Integer.parseInt(watt.getText());
                } catch (NumberFormatException nfe) {
                    wattErrorLbl.setText("Watt must be a number");
                }

                PSURegistry.addComponent(new PSUModel(name.getText(), brand.getText(), priceDouble, pvDouble, wattInt));
                createObject = true;

            } catch (InvalidNameException ine) {
                nameErrorLbl.setText(ine.getMessage());
            } catch (InvalidBrandException ibe) {
                brandErrorLbl.setText(ibe.getMessage());
            } catch (InvalidPriceException ipe) {
                priceErrorLbl.setText(ipe.getMessage());
            } catch (InvalidPerformanceValueException ipve) {
                performanceValueErrorLbl.setText(ipve.getMessage());
            } catch (InvalidWattException iwe) {
                wattErrorLbl.setText(iwe.getMessage());
            }
        }
    }

    //Generate dialog window for adding component. Method modifies the template dialog-box.
    public static void generateRAMComponentDialog(Dialog addComponentDialog, GridPane grid) {
        addComponentDialog.setHeaderText("Create new RAM component");

        TextField memory = new TextField();
        memory.setPromptText("Memory (MB)");
        TextField memorySpeed = new TextField();
        memorySpeed.setPromptText("Memoryspeed (MHz)");

        Label memoryErrorLbl = new Label("");
        grid.add(memoryErrorLbl, 2, 4);
        Label memoryspeedErrorLbl = new Label("");
        grid.add(memoryspeedErrorLbl, 2, 5);


        grid.add(new Label("Memory:"), 0, 4);
        grid.add(memory, 1, 4);
        grid.add(new Label("Memoryspeed (MHz): "), 0, 5);
        grid.add(memorySpeed, 1, 5);


        addComponentDialog.getDialogPane().setContent(grid);

        boolean createObject = false;
        while (!createObject) {
            addComponentDialog.showAndWait();
            try {
                clearErrorLabels();
                memoryErrorLbl.setText("");
                memoryspeedErrorLbl.setText("");
                double priceDouble = 0;
                double pvDouble = 0;
                int memoryInt = 0;
                double memorySpeedDouble = 0;
                try {
                    priceDouble = Double.parseDouble(price.getText());
                } catch (NumberFormatException nfe) {
                    priceErrorLbl.setText("Price must be a number");
                }
                try {
                    pvDouble = Double.parseDouble(performanceValue.getText());
                } catch (NumberFormatException nfe) {
                    performanceValueErrorLbl.setText("Performancevalue must be a number");
                }
                try {
                    memoryInt = Integer.parseInt(memory.getText());
                } catch (NumberFormatException nfe) {
                    memoryErrorLbl.setText("Memory must be a number");
                }
                try {
                    memorySpeedDouble = Double.parseDouble(memorySpeed.getText());
                } catch (NumberFormatException nfe) {
                    memoryspeedErrorLbl.setText("Memoryspeed must be a number");
                }

                RAMRegistry.addComponent(new RAMModel(name.getText(), brand.getText(), priceDouble, pvDouble, memoryInt, memorySpeedDouble));
                createObject = true;

            }

            catch (InvalidNameException ine) {
                nameErrorLbl.setText(ine.getMessage());
            } catch (InvalidBrandException ibe) {
                brandErrorLbl.setText(ibe.getMessage());
            } catch (InvalidPriceException ipe) {
                priceErrorLbl.setText(ipe.getMessage());
            } catch (InvalidPerformanceValueException ipve) {
                performanceValueErrorLbl.setText(ipve.getMessage());
            } catch (InvalidMemoryException ime) {
                memoryErrorLbl.setText(ime.getMessage());
            } catch (InvalidMemorySpeedException imse) {
                memoryspeedErrorLbl.setText(imse.getMessage());
            }
        }
    }

    //Generate dialog window for adding component. Method modifies the template dialog-box.
    public static void generateSoundCardComponentDialog(Dialog addComponentDialog, GridPane grid) {
        addComponentDialog.setHeaderText("Create new soundcard component");

        ComboBox surround = new ComboBox();
        surround.getItems().addAll("Yes", "No");
        surround.setValue("Yes");

        ComboBox bassboost = new ComboBox();
        bassboost.getItems().addAll("Yes", "No");
        bassboost.setValue("Yes");

        grid.add(new Label("Surround: "), 0, 4);
        grid.add(surround, 1,4);
        grid.add(new Label("Bassboost: "), 0, 5);
        grid.add(bassboost, 1,5);

        addComponentDialog.getDialogPane().setContent(grid);


        boolean createObject = false;
        while (!createObject) {
            addComponentDialog.showAndWait();
            try {
                clearErrorLabels();
                double priceDouble = 0;
                double pvDouble = 0;
                String surroundString = surround.getValue().toString();
                String bassboostString = bassboost.getValue().toString();

                try {
                    priceDouble = Double.parseDouble(price.getText());
                } catch (NumberFormatException nfe) {
                    priceErrorLbl.setText("Price must be a number");
                }
                try {
                    pvDouble = Double.parseDouble(performanceValue.getText());
                } catch (NumberFormatException nfe) {
                    performanceValueErrorLbl.setText("Performancevalue must be a number");
                }

                SoundCardRegistry.addComponent(new SoundCardModel(name.getText(), brand.getText(), priceDouble, pvDouble, surroundString, bassboostString));
                createObject = true;

            } catch (InvalidNameException ine) {
                nameErrorLbl.setText(ine.getMessage());
            } catch (InvalidBrandException ibe) {
                brandErrorLbl.setText(ibe.getMessage());
            } catch (InvalidPriceException ipe) {
                priceErrorLbl.setText(ipe.getMessage());
            } catch (InvalidPerformanceValueException ipve) {
                performanceValueErrorLbl.setText(ipve.getMessage());
            }
        }
    }
}
