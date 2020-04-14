package org.oslomet.ComponentRegistry;

import javafx.collections.ObservableList;

import java.util.ArrayList;

public class ComponentsRegistry {

    ArrayList<ObservableList> allComponents = new ArrayList<>();

    private void addAllComponentsArraysToArray() {
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
    }


}
