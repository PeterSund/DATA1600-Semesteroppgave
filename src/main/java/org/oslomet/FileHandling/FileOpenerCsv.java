package org.oslomet.FileHandling;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileOpenerCsv {

    //Reads from selected file, add string to array and returns array of string from file
    public static ArrayList<String> readFile(Path path) throws IOException {
        ArrayList<String> computer = new ArrayList<String>();

        try(var reader = Files.newBufferedReader(path)) {
            String line;
            while((line = reader.readLine()) != null) {
                computer.add(line);
            }
        }
        return computer;
    }

}
