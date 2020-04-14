package org.oslomet.FileHandling;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.oslomet.ComponentClasses.CPUModel;
import org.oslomet.ComponentClasses.GPUModel;
import org.oslomet.ComponentRegistry.CPURegistry;
import org.oslomet.ComponentRegistry.GPURegistry;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileOpenerJobj extends FileChooser {

    public static void openJobj(Path filePath) throws IOException {

        try (InputStream fin = Files.newInputStream(filePath);
             ObjectInputStream oin = new ObjectInputStream(fin)) {
            ArrayList<ArrayList> arrayLists = (ArrayList<ArrayList>) oin.readObject();
            CPURegistry.removeAll();
            GPURegistry.removeAll();
            CPURegistry.addCPUFromJobjToArray(arrayLists.get(0));
            GPURegistry.addGPUFromJobjToArray(arrayLists.get(1));


        } catch (ClassNotFoundException e) {
            throw new IOException("Something is wrong with the implementation. See debug information");
        }
    }
}
