package org.oslomet.ComputerClasses;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import org.oslomet.ComponentClasses.*;
import org.oslomet.ComponentRegistry.*;
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

        String computerName = computerFromFile.get(0).split(DELIMITER)[1];
        String computerCaseName = computerFromFile.get(3).split(DELIMITER)[1].split(":")[1].strip();
        String computerCPUName = computerFromFile.get(4).split(DELIMITER)[1].split(":")[1].strip();
        String computerGPUName = computerFromFile.get(5).split(DELIMITER)[1].split(":")[1].strip();
        String computerRAMName = computerFromFile.get(6).split(DELIMITER)[1].split(":")[1].strip();
        String computerHardDriveName = computerFromFile.get(7).split(DELIMITER)[1].split(":")[1].strip();
        String computerMotherBoardName = computerFromFile.get(8).split(DELIMITER)[1].split(":")[1].strip();
        String computerPSUName = computerFromFile.get(9).split(DELIMITER)[1].split(":")[1].strip();
        String computerSoundCardName = computerFromFile.get(10).split(DELIMITER)[1].split(":")[1].strip();
        String computerMonitorName = computerFromFile.get(11).split(DELIMITER)[1].split(":")[1].strip();
        String computerKeyboardName = computerFromFile.get(12).split(DELIMITER)[1].split(":")[1].strip();
        String computerMouseName = computerFromFile.get(13).split(DELIMITER)[1].split(":")[1].strip();

        ComputerCaseModel computerCase = ComputerCaseRegistry.computerCaseExists(computerCaseName);
        CPUModel cpu = CPURegistry.cpuExists(computerCPUName);
        GPUModel gpu = GPURegistry.gpuExists(computerGPUName);
        RAMModel ram = RAMRegistry.ramExists(computerRAMName);
        HarddriveModel hardDrive = HardDriveRegistry.hardDriveExists(computerHardDriveName);
        MotherboardModel motherBoard = MotherboardRegistry.motherBoardExists(computerMotherBoardName);
        PSUModel psu = PSURegistry.psuExists(computerPSUName);
        SoundCardModel soundCard = SoundCardRegistry.soundCardExists(computerSoundCardName);
        MonitorModel monitor = MonitorRegistry.monitorExists(computerMonitorName);
        KeyboardModel keyboard = KeyboardRegistry.keyBoardExists(computerKeyboardName);
        MouseModel mouse = MouseRegistry.mouseExists(computerMouseName);

        ComputerModel computer = new ComputerModel(computerName, null, null, null, null,
                null, null, null, null, null, null, null,
                0, 0);

        if (computerCase != null) {
            computer.setComputerCase(computerCase);
        }
        if (cpu != null) {
            computer.setCpu(cpu);
        }
        if (gpu != null) {
            //
        }

        //If computer name does exist
        if (computerNameExists(computerName)) {

        }

        //If computer name does not exist
        else {

        }


      



        


    }
}
