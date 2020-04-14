package org.oslomet.FileHandling;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.oslomet.ComponentClasses.CPUModel;
import org.oslomet.ComponentRegistry.CPURegistry;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileOpenerJobj extends FileChooser {

    public static ObservableList<CPUModel> openJobj(Path filePath) throws IOException {
        try (InputStream fin = Files.newInputStream(filePath);
             ObjectInputStream oin = new ObjectInputStream(fin)) {
            ArrayList<CPUModel> cpuArray = (ArrayList<CPUModel>) oin.readObject();
            return FXCollections.observableArrayList(cpuArray);

        } catch (ClassNotFoundException e) {
            throw new IOException("Something is wrong with the implementation. See debug information");
        }
    }
}
