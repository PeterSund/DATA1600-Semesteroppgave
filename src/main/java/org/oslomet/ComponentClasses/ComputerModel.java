package org.oslomet.ComponentClasses;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

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


    public ComputerModel(String configName, ComputerCaseModel computerCase, CPUModel cpu, GPUModel gpu, RAMModel ram, HarddriveModel hardDrive,
                         MotherboardModel motherboard, PSUModel psu, SoundCardModel soundCard, KeyboardModel keyboard, MonitorModel monitor,
                         MouseModel mouse) {
        this.configName = new SimpleStringProperty(configName);
        this.computerCase = new SimpleObjectProperty<ComputerCaseModel>(computerCase);
        this.cpu = new SimpleObjectProperty<CPUModel>(cpu);
        this.gpu = new SimpleObjectProperty<GPUModel>(gpu);
        this.ram = new SimpleObjectProperty<RAMModel>(ram);
        this.hardDrive = new SimpleObjectProperty<HarddriveModel>(hardDrive);
        this.motherboard = new SimpleObjectProperty<MotherboardModel>(motherboard);
        this.psu = new SimpleObjectProperty<PSUModel>(psu);
        this.soundCard = new SimpleObjectProperty<SoundCardModel>(soundCard);
        this.keyboard = new SimpleObjectProperty<KeyboardModel>(keyboard);
        this.monitor = new SimpleObjectProperty<MonitorModel>(monitor);
        this.mouse = new SimpleObjectProperty<MouseModel>(mouse);
    }


    public String getConfigName() {
        return configName.get();
    }

    public void setConfigName(String configName) {
        this.configName.set(configName);
    }


}
