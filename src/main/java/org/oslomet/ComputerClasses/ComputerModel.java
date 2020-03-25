package org.oslomet.ComputerClasses;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import org.oslomet.ComponentClasses.*;

public class ComputerModel {

    private SimpleStringProperty configName;
    private SimpleObjectProperty<ComputerCaseModel> computerCase;
    private SimpleObjectProperty<CPUModel> cpu;
    private SimpleObjectProperty<GPUModel> gpu;
    private SimpleObjectProperty<RAMModel> ram;
    private SimpleObjectProperty<HarddriveModel> hardDrive;
    private SimpleObjectProperty<MotherboardModel> motherboard;
    private SimpleObjectProperty<PSUModel> psu;
    private SimpleObjectProperty<SoundCardModel> soundCard;
    private SimpleObjectProperty<KeyboardModel> keyboard;
    private SimpleObjectProperty<MonitorModel> monitor;
    private SimpleObjectProperty<MouseModel> mouse;


    //Constructor
    public ComputerModel(String configName, ComputerCaseModel computerCase, CPUModel cpu, GPUModel gpu, RAMModel ram, HarddriveModel hardDrive,
                         MotherboardModel motherboard, PSUModel psu, SoundCardModel soundCard, KeyboardModel keyboard, MonitorModel monitor,
                         MouseModel mouse) {
        this.configName = new SimpleStringProperty(configName);
        this.computerCase = new SimpleObjectProperty<>(computerCase);
        this.cpu = new SimpleObjectProperty<>(cpu);
        this.gpu = new SimpleObjectProperty<>(gpu);
        this.ram = new SimpleObjectProperty<>(ram);
        this.hardDrive = new SimpleObjectProperty<>(hardDrive);
        this.motherboard = new SimpleObjectProperty<>(motherboard);
        this.psu = new SimpleObjectProperty<>(psu);
        this.soundCard = new SimpleObjectProperty<>(soundCard);
        this.keyboard = new SimpleObjectProperty<>(keyboard);
        this.monitor = new SimpleObjectProperty<>(monitor);
        this.mouse = new SimpleObjectProperty<>(mouse);
    }

    //Getters/Setters
    public String getConfigName() {
        return configName.get();
    }

    public void setConfigName(String configName) {
        this.configName.set(configName);
    }


}
