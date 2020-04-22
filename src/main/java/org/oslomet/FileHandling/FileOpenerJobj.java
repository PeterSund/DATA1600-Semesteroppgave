package org.oslomet.FileHandling;

import org.oslomet.ComponentRegistry.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileOpenerJobj extends FileChooser {

    public static void openJobj(Path filePath) throws IOException {

        try (InputStream fin = Files.newInputStream(filePath);
             ObjectInputStream oin = new ObjectInputStream(fin)) {
            ArrayList<ArrayList> arrayLists = (ArrayList<ArrayList>) oin.readObject();
            ComputerCaseComponentRegistry.removeAll();
            CPUComponentRegistry.removeAll();
            GPUComponentRegistry.removeAll();
            HardDriveComponentRegistry.removeAll();
            KeyboardComponentRegistry.removeAll();
            MonitorComponentRegistry.removeAll();
            MotherboardComponentRegistry.removeAll();
            MouseComponentRegistry.removeAll();
            PSUComponentRegistry.removeAll();
            RAMComponentRegistry.removeAll();
            SoundCardComponentRegistry.removeAll();

            ComputerCaseComponentRegistry.addComputerCaseFromJobjToArray(arrayLists.get(0));
            CPUComponentRegistry.addCPUFromJobjToArray(arrayLists.get(1));
            GPUComponentRegistry.addGPUFromJobjToArray(arrayLists.get(2));
            HardDriveComponentRegistry.addHardDriveFromJobjToArray(arrayLists.get(3));
            KeyboardComponentRegistry.addKeyboardFromJobjToArray(arrayLists.get(4));
            MonitorComponentRegistry.addMonitorFromJobjToArray(arrayLists.get(5));
            MotherboardComponentRegistry.addMotherboardFromJobjToArray(arrayLists.get(6));
            MouseComponentRegistry.addMouseFromJobjToArray(arrayLists.get(7));
            PSUComponentRegistry.addPSUFromJobjToArray(arrayLists.get(8));
            RAMComponentRegistry.addRAMFromJobjToArray(arrayLists.get(9));
            SoundCardComponentRegistry.addSoundcardFromJobjToArray(arrayLists.get(10));

        } catch (ClassNotFoundException e) {
            throw new IOException("Something is wrong with the implementation. See debug information");
        }
        catch (StreamCorruptedException sce) {
            throw new StreamCorruptedException("File corrupted and cannot be opened");
        }
    }
}
