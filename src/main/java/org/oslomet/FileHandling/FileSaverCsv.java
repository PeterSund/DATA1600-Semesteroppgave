package org.oslomet.FileHandling;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileSaverCsv implements FileSaver<String> {
    //Writes string to file from app
    @Override
    public void save(Path path, String obj) throws IOException {
        Files.write(path, obj.getBytes());
    }
}

