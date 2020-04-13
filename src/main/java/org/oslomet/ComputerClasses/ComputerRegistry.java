package org.oslomet.ComputerClasses;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import org.oslomet.ComponentClasses.CPUModel;
import org.oslomet.ComponentClasses.ComputerCaseModel;
import org.oslomet.ComponentRegistry.CPURegistry;
import org.oslomet.FileHandling.FileChooser;
import org.oslomet.FileHandling.FileOpenerTxt;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class ComputerRegistry {

    private final static String DELIMITER = ";";

    //Initialize array
    private static ObservableList<ComputerModel> computerArray = FXCollections.observableArrayList();
    public static void attachTableView(TableView tv) {
        tv.setItems(computerArray);
    }

    //Add computer
    public static void addComputer(ComputerModel computer) {
        computerArray.add(computer);
    }

    public static String getValue() {
       String test = computerArray.get(0).getConfigName();
       return test;
    }

    //Returns index of computer if name matches
    public static int findComputer(ComputerModel inputComputer) {
        for (ComputerModel computer : computerArray) {
            if (computer.getConfigName().equals(inputComputer.getConfigName())) {
                return computerArray.indexOf(computer);
            }
        }
        return -1;
    }

    //Replaces computer in the array with a new compuer in the position of a given index
    public static void replaceComputer(ComputerModel inputComputer, int index) {
        computerArray.set(index, inputComputer);
    }

    //Deletes a computer from the array
    public static void deleteComputer(ComputerModel inputComputer) {
        computerArray.remove(inputComputer);
    }

    //Checks if a computer name is already in use
    public static Boolean computerNameExists(String computerName) {

        for (ComputerModel computer : computerArray) {
            if (computer.getConfigName().equals(computerName)) {
                return true;
            }
        }

        return false;
    }

    //Add computer from file
    public static void readFromFile() throws IOException {
        ArrayList<String> computerFromFile = FileOpenerTxt.readFile(FileChooser.openFile());

        //IF computer name exists

        //IF computer name does not exist
        String computerName = computerFromFile.get(0).split(DELIMITER)[1];
        String computerCase = computerFromFile.get(3).split(DELIMITER)[1].split(":")[1].strip();
        String computerCPU = computerFromFile.get(4).split(DELIMITER)[1].split(":")[1].strip();
        String computerGPU = computerFromFile.get(5).split(DELIMITER)[1].split(":")[1].strip();
        String computerRAM = computerFromFile.get(6).split(DELIMITER)[1].split(":")[1].strip();
        String computerHardDrive = computerFromFile.get(7).split(DELIMITER)[1].split(":")[1].strip();
        String computerMotherBoard = computerFromFile.get(8).split(DELIMITER)[1].split(":")[1].strip();
        String computerPSU = computerFromFile.get(9).split(DELIMITER)[1].split(":")[1].strip();
        String computerSoundCard = computerFromFile.get(10).split(DELIMITER)[1].split(":")[1].strip();
        String computerMonitor = computerFromFile.get(11).split(DELIMITER)[1].split(":")[1].strip();
        String computerKeyboard = computerFromFile.get(12).split(DELIMITER)[1].split(":")[1].strip();
        String computerMouse = computerFromFile.get(13).split(DELIMITER)[1].split(":")[1].strip();

        System.out.println(computerName);
        System.out.println(computerCase);
        System.out.println(computerCPU);
        System.out.println(computerGPU);
        System.out.println(computerRAM);
        System.out.println(computerHardDrive);
        System.out.println(computerMotherBoard);
        System.out.println(computerPSU);
        System.out.println(computerSoundCard);
        System.out.println(computerMonitor);
        System.out.println(computerKeyboard);
        System.out.println(computerMouse);

        /*CPUModel cpu = CPURegistry.cpuExists(computerCPU);

        if (cpu != null) {
            System.out.println(cpu.toStringForConfig());
        }
        else {
            System.out.print("Could not find CPU");
        }
        
         */

    }
}
