package org.oslomet.FileHandling;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileSaverCsv {
    //Writes string to file from app
    public static void writeFile(Path p, String str) throws IOException {
        Files.write(p, str.getBytes());
    }
}

