package org.oslomet.ComponentRegistry;

import org.oslomet.ComponentClasses.ComponentModel;

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

    public void removeAllComponents() {
        ComputerCaseRegistry.removeAll();
        CPURegistry.removeAll();
        GPURegistry.removeAll();
        HardDriveRegistry.removeAll();
        KeyboardRegistry.removeAll();
        MonitorRegistry.removeAll();
        MotherboardRegistry.removeAll();
        MouseRegistry.removeAll();
        PSURegistry.removeAll();
        RAMRegistry.removeAll();
        SoundCardRegistry.removeAll();
    }

    public void addComponentsToRegisters(ArrayList<ArrayList> arrayLists) {
        ComputerCaseRegistry.addComputerCaseFromJobjToArray(arrayLists.get(0));
        CPURegistry.addCPUFromJobjToArray(arrayLists.get(1));
        GPURegistry.addGPUFromJobjToArray(arrayLists.get(2));
        HardDriveRegistry.addHardDriveFromJobjToArray(arrayLists.get(3));
        KeyboardRegistry.addKeyboardFromJobjToArray(arrayLists.get(4));
        MonitorRegistry.addMonitorFromJobjToArray(arrayLists.get(5));
        MotherboardRegistry.addMotherboardFromJobjToArray(arrayLists.get(6));
        MouseRegistry.addMouseFromJobjToArray(arrayLists.get(7));
        PSURegistry.addPSUFromJobjToArray(arrayLists.get(8));
        RAMRegistry.addRAMFromJobjToArray(arrayLists.get(9));
        SoundCardRegistry.addSoundcardFromJobjToArray(arrayLists.get(10));
    }

}
