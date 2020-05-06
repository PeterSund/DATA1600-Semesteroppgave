package org.oslomet.FileHandling;

import java.io.IOException;
import java.nio.file.Path;

public interface FileSaver<T> {
    void save(Path path, T obj) throws IOException;
}
