package org.oslomet.FileHandling;

import org.oslomet.ComponentRegistry.CPURegistry;
import org.oslomet.ComponentRegistry.ComponentsRegistry;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSaverJobj extends FileChooser{

    public static void saveJobj(CPURegistry registry, Path filePath) throws IOException {
        try (OutputStream os = Files.newOutputStream(filePath);
             ObjectOutputStream out = new ObjectOutputStream(os))
        {
            out.writeObject(registry);
        }
    }
}


