package org.oslomet.ComponentRegistry;

import java.util.ArrayList;

public class ComponentsRegistry {

    private static ArrayList<ArrayList> allComponents = new ArrayList<>();

    public static ArrayList addAllComponentsArraysToArray() {
        allComponents.clear();
        allComponents.add(ComputerCaseComponentRegistry.returnArray());
        allComponents.add(CPUComponentRegistry.returnArray());
        allComponents.add(GPUComponentRegistry.returnArray());
        allComponents.add(HardDriveComponentRegistry.returnArray());
        allComponents.add(KeyboardComponentRegistry.returnArray());
        allComponents.add(MonitorComponentRegistry.returnArray());
        allComponents.add(MotherboardComponentRegistry.returnArray());
        allComponents.add(MouseComponentRegistry.returnArray());
        allComponents.add(PSUComponentRegistry.returnArray());
        allComponents.add(RAMComponentRegistry.returnArray());
        allComponents.add(SoundCardComponentRegistry.returnArray());
        return allComponents;
    }


}
