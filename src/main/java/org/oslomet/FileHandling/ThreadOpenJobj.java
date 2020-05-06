package org.oslomet.FileHandling;

import javafx.concurrent.Task;
import org.oslomet.ComponentRegistry.ComponentsRegistry;

import java.nio.file.Path;
import java.util.ArrayList;

public class ThreadOpenJobj extends Task<Void> {

    private final Path path;
    private FileOpenerJobj fileOpenerJobj = new FileOpenerJobj();
    private ComponentsRegistry componentsRegistry = new ComponentsRegistry();

    public ThreadOpenJobj(Path path) {
        this.path = path;
    }

    @Override
    protected Void call() throws Exception {
        try {
            Thread.sleep(4000);
            componentsRegistry.removeAllComponents();
            componentsRegistry.addComponentsToRegisters((ArrayList<ArrayList>) fileOpenerJobj.open(path));
        }
        catch (InterruptedException e) {
            return null;
        }
        return null;
    }
}

