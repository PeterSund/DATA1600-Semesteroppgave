package org.oslomet.ComponentRegistry;

import java.util.ArrayList;

public class ComponentsRegistry {

    private static ArrayList<ArrayList> allComponents = new ArrayList<>();

    public static ArrayList addAllComponentsArraysToArray() {
        allComponents.clear();
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
