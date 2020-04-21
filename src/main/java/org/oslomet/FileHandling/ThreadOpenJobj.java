package org.oslomet.FileHandling;

import javafx.concurrent.Task;

import java.io.File;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class ThreadOpenJobj extends Task<Void> {

    private final Path path;

    public ThreadOpenJobj(Path path) {
        this.path = path;
    }

    @Override
    protected Void call() throws Exception {
        try {
            Thread.sleep(6000);
            FileOpenerJobj.openJobj(path);
        }
        catch (InterruptedException e) {
            return null;
        }
        return null;
    }
}

