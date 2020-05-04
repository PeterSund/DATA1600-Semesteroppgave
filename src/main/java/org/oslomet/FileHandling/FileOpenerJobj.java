package org.oslomet.FileHandling;

import org.oslomet.ComponentRegistry.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileOpenerJobj extends FileChooser {

    public static void openJobj(Path filePath) throws IOException {

        try (InputStream fin = Files.newInputStream(filePath);
             ObjectInputStream oin = new ObjectInputStream(fin)) {
            ArrayList<ArrayList> arrayLists = (ArrayList<ArrayList>) oin.readObject();
            ComputerCaseRegistry.removeAll();
            CPURegistry.removeAll();
            GPURegistry.removeAll();
            HardDriveRegistry.removeAll();
            KeyboardRegistry.removeAll();
            MonitorRegistry.removeAll();
            MotherboardRegistry.removeAll();
            MouseRegistry.removeAll();
            PSURegistry.removeAll();
            RAMRegistry.removeAll();
            SoundCardRegistry.removeAll();

            ComputerCaseRegistry.addComputerCaseFromJobjToArray(arrayLists.get(0));
            CPURegistry.addCPUFromJobjToArray(arrayLists.get(1));
            GPURegistry.addGPUFromJobjToArray(arrayLists.get(2));
            HardDriveRegistry.addHardDriveFromJobjToArray(arrayLists.get(3));
            KeyboardRegistry.addKeyboardFromJobjToArray(arrayLists.get(4));
            MonitorRegistry.addMonitorFromJobjToArray(arrayLists.get(5));
            MotherboardRegistry.addMotherboardFromJobjToArray(arrayLists.get(6));
            MouseRegistry.addMouseFromJobjToArray(arrayLists.get(7));
            PSURegistry.addPSUFromJobjToArray(arrayLists.get(8));
            RAMRegistry.addRAMFromJobjToArray(arrayLists.get(9));
            SoundCardRegistry.addSoundcardFromJobjToArray(arrayLists.get(10));

        } catch (ClassNotFoundException e) {
            throw new IOException("File corrupted and cannot be opened");
        }
        catch (StreamCorruptedException sce) {
            throw new StreamCorruptedException("File corrupted and cannot be opened");
        }
        catch (EOFException eofe) {
            throw new EOFException("File corrupted and cannot be opened");
        }
    }
}
