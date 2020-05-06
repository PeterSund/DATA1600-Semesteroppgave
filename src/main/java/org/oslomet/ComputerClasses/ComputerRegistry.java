package org.oslomet.ComputerClasses;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import org.oslomet.ComponentClasses.*;
import org.oslomet.ComponentRegistry.*;
import org.oslomet.ExceptionClasses.CorruptedFileException;
import org.oslomet.FileHandling.FileChooser;
import org.oslomet.FileHandling.FileOpenerCsv;
import java.io.IOException;
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

    //Calculates and returns the total price of the computer
    public static double calculateTotalPrice(ComputerModel computer) {

        double totalPrice = 0;

        totalPrice += computer.getComputerCase() != null ? computer.getComputerCase().getPrice() : 0;
        totalPrice += computer.getCpu() != null ? computer.getCpu().getPrice() : 0;
        totalPrice += computer.getGpu() != null ? computer.getGpu().getPrice() : 0;
        totalPrice += computer.getHardDrive() != null ? computer.getHardDrive().getPrice() : 0;
        totalPrice += computer.getMotherboard() != null ? computer.getMotherboard().getPrice() : 0;
        totalPrice += computer.getRam() != null ? computer.getRam().getPrice() : 0;
        totalPrice += computer.getSoundCard() != null ? computer.getSoundCard().getPrice() : 0;
        totalPrice += computer.getPsu() != null ? computer.getPsu().getPrice() : 0;
        totalPrice += computer.getMonitor() != null ? computer.getMonitor().getPrice() : 0;
        totalPrice += computer.getMouse() != null ? computer.getMouse().getPrice() : 0;
        totalPrice += computer.getKeyboard() != null ? computer.getKeyboard().getPrice() : 0;

        computer.setTotalPrice(totalPrice);
        return totalPrice;
    }

    //Calculates and returns the total performance value of the computer
    public static double calculateTotalPerformanceValue(ComputerModel computer) {

        double totalPerformanceValue = 0;

        totalPerformanceValue += computer.getComputerCase() != null ? computer.getComputerCase().getPerformanceValue() : 0;
        totalPerformanceValue += computer.getCpu() != null ? computer.getCpu().getPerformanceValue() : 0;
        totalPerformanceValue += computer.getGpu() != null ? computer.getGpu().getPerformanceValue() : 0;
        totalPerformanceValue += computer.getHardDrive() != null ? computer.getHardDrive().getPerformanceValue() : 0;
        totalPerformanceValue += computer.getMotherboard() != null ? computer.getMotherboard().getPerformanceValue() : 0;
        totalPerformanceValue += computer.getRam() != null ? computer.getRam().getPerformanceValue() : 0;
        totalPerformanceValue += computer.getSoundCard() != null ? computer.getSoundCard().getPerformanceValue(): 0;
        totalPerformanceValue += computer.getPsu() != null ? computer.getPsu().getPerformanceValue() : 0;
        totalPerformanceValue += computer.getMonitor() != null ? computer.getMonitor().getPerformanceValue() : 0;
        totalPerformanceValue += computer.getMouse() != null ? computer.getMouse().getPerformanceValue() : 0;
        totalPerformanceValue += computer.getKeyboard() != null ? computer.getKeyboard().getPerformanceValue() : 0;

        computer.setTotalPerformanceValue(totalPerformanceValue);
        return totalPerformanceValue;
    }


    //Add computer from file
    public static ComputerModel readFromFile() throws IOException {
        FileOpenerCsv fileOpenerCsv = new FileOpenerCsv();
        ArrayList<String> computerFromFile = (ArrayList<String>) fileOpenerCsv.open(FileChooser.openTxtFile());

        try {
            //Gets the name of all components
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


            //Checks if the components exist based on their name
            //If the component exist, set the component to the variable. Otherwise, set the variable to null
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

            //If the component exists, set it to the computer
            if (computerCase != null) {
                computer.setComputerCase(computerCase);
            }
            if (cpu != null) {
                computer.setCpu(cpu);
            }
            if (gpu != null) {
                computer.setGpu(gpu);
            }
            if (ram != null) {
                computer.setRam(ram);
            }
            if (hardDrive != null) {
                computer.setHardDrive(hardDrive);
            }
            if (motherBoard != null) {
                computer.setMotherboard(motherBoard);
            }
            if (psu != null) {
                computer.setPsu(psu);
            }
            if (soundCard != null) {
                computer.setSoundCard(soundCard);
            }
            if (monitor != null) {
                computer.setMonitor(monitor);
            }
            if (keyboard != null) {
                computer.setKeyboard(keyboard);
            }
            if (mouse != null) {
                computer.setMouse(mouse);
            }
            return computer;
        }
        catch (IndexOutOfBoundsException ioobe) {
            throw new CorruptedFileException("Text file is corrupted and can't be opened!");
        }
    }
}
