package org.oslomet.FileHandling;

import javafx.collections.ObservableList;
import org.oslomet.ComponentRegistry.CPURegistry;
import org.oslomet.ComponentRegistry.ComponentsRegistry;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileSaverJobj extends FileChooser implements Serializable {

    public static void saveJobj(ArrayList registry, Path filePath) throws IOException {
        try (OutputStream os = Files.newOutputStream(filePath);
             ObjectOutputStream out = new ObjectOutputStream(os))
        {
            out.writeObject(new ArrayList<> (registry));
        }
    }
}


