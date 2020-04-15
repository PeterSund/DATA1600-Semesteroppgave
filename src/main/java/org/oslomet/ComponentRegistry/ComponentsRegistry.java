package org.oslomet.ComponentRegistry;

import javafx.collections.ObservableList;
import org.oslomet.ComponentClasses.CPUModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ComponentsRegistry {

    private static ArrayList<ArrayList> allComponents = new ArrayList<>();

    public static ArrayList addAllComponentsArraysToArray() {
        allComponents.add(ComputerCaseRegistry.returnArray());
        allComponents.add(CPURegistry.returnArray());
        allComponents.add(GPURegistry.returnArray());
        allComponents.add(HardDriveRegistry.returnArray());
        allComponents.add(KeyboardRegistry.returnArray());
        allComponents.add(MonitorRegistry.returnArray());
        allComponents.add(MotherboardRegistry.returnArray());
        allComponents.add(MouseRegistry.returnArray());
        allComponents.add(PSURegistry.returnArray());
        allComponents.add(RAMRegistry.returnArray());
        allComponents.add(SoundCardRegistry.returnArray());
        return allComponents;
    }


}
