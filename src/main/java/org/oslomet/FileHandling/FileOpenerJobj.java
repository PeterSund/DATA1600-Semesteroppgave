package org.oslomet.FileHandling;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileOpenerJobj extends FileChooser implements FileOpener {

    @Override
    public ArrayList<?> open(Path filePath) throws IOException {
        try (InputStream fin = Files.newInputStream(filePath);
             ObjectInputStream oin = new ObjectInputStream(fin)) {
            ArrayList<?> fileContent = (ArrayList<ArrayList>) oin.readObject();
            return fileContent;

        } catch (ClassNotFoundException e) {
            throw new IOException("File corrupted and cannot be opened");
        } catch (StreamCorruptedException sce) {
            throw new StreamCorruptedException("File corrupted and cannot be opened");
        }
    }
}

