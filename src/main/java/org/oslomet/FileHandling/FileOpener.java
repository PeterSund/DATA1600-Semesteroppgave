package org.oslomet.FileHandling;

import java.io.IOException;

import java.nio.file.Path;
import java.util.ArrayList;

public interface FileOpener {
    ArrayList<?> open(Path path) throws IOException;
}
