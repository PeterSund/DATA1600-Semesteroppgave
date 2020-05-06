package org.oslomet.FileHandling;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileSaverJobj extends FileChooser implements Serializable, FileSaver<ArrayList> {

    @Override
    public void save(Path path, ArrayList obj) throws IOException {
        try (OutputStream os = Files.newOutputStream(path);
             ObjectOutputStream out = new ObjectOutputStream(os))
        {
            out.writeObject(new ArrayList<> (obj));
        }
    }
}


