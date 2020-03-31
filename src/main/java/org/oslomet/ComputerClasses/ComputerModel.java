package org.oslomet.ComputerClasses;

import javafx.beans.property.SimpleDoubleProperty;
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
    private SimpleDoubleProperty totalPrice;
    private SimpleDoubleProperty totalPerformanceValue;

    //Constructor
    public ComputerModel(String configName, ComputerCaseModel computerCase, CPUModel cpu, GPUModel gpu, RAMModel ram, HarddriveModel hardDrive,
                         MotherboardModel motherboard, PSUModel psu, SoundCardModel soundCard, KeyboardModel keyboard, MonitorModel monitor,
                         MouseModel mouse, double totalPrice, double totalPerformanceValue) {
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
        this.totalPrice = new SimpleDoubleProperty(totalPrice);
        this.totalPerformanceValue = new SimpleDoubleProperty(totalPerformanceValue);
    }

    //Getters/Setters
    public String getConfigName() {
        return configName.get();
    }

    public void setConfigName(String configName) {
        this.configName.set(configName);
    }

    public ComputerCaseModel getComputerCase() {
        return computerCase.get();
    }

    public SimpleObjectProperty<ComputerCaseModel> computerCaseProperty() {
        return computerCase;
    }

    public void setComputerCase(ComputerCaseModel computerCase) {
        this.computerCase.set(computerCase);
    }

    public CPUModel getCpu() {
        return cpu.get();
    }

    public SimpleObjectProperty<CPUModel> cpuProperty() {
        return cpu;
    }

    public void setCpu(CPUModel cpu) {
        this.cpu.set(cpu);
    }

    public GPUModel getGpu() {
        return gpu.get();
    }

    public SimpleObjectProperty<GPUModel> gpuProperty() {
        return gpu;
    }

    public void setGpu(GPUModel gpu) {
        this.gpu.set(gpu);
    }

    public RAMModel getRam() {
        return ram.get();
    }

    public SimpleObjectProperty<RAMModel> ramProperty() {
        return ram;
    }

    public void setRam(RAMModel ram) {
        this.ram.set(ram);
    }

    public HarddriveModel getHardDrive() {
        return hardDrive.get();
    }

    public SimpleObjectProperty<HarddriveModel> hardDriveProperty() {
        return hardDrive;
    }

    public void setHardDrive(HarddriveModel hardDrive) {
        this.hardDrive.set(hardDrive);
    }

    public MotherboardModel getMotherboard() {
        return motherboard.get();
    }

    public SimpleObjectProperty<MotherboardModel> motherboardProperty() {
        return motherboard;
    }

    public void setMotherboard(MotherboardModel motherboard) {
        this.motherboard.set(motherboard);
    }

    public PSUModel getPsu() {
        return psu.get();
    }

    public SimpleObjectProperty<PSUModel> psuProperty() {
        return psu;
    }

    public void setPsu(PSUModel psu) {
        this.psu.set(psu);
    }

    public SoundCardModel getSoundCard() {
        return soundCard.get();
    }

    public SimpleObjectProperty<SoundCardModel> soundCardProperty() {
        return soundCard;
    }

    public void setSoundCard(SoundCardModel soundCard) {
        this.soundCard.set(soundCard);
    }

    public KeyboardModel getKeyboard() {
        return keyboard.get();
    }

    public SimpleObjectProperty<KeyboardModel> keyboardProperty() {
        return keyboard;
    }

    public void setKeyboard(KeyboardModel keyboard) {
        this.keyboard.set(keyboard);
    }

    public MonitorModel getMonitor() {
        return monitor.get();
    }

    public SimpleObjectProperty<MonitorModel> monitorProperty() {
        return monitor;
    }

    public void setMonitor(MonitorModel monitor) {
        this.monitor.set(monitor);
    }

    public MouseModel getMouse() {
        return mouse.get();
    }

    public SimpleObjectProperty<MouseModel> mouseProperty() {
        return mouse;
    }

    public void setMouse(MouseModel mouse) {
        this.mouse.set(mouse);
    }

    public double getTotalPrice() {
        return totalPrice.get();
    }

    public SimpleDoubleProperty totalPriceProperty() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice.set(totalPrice);
    }

    public double getTotalPerformanceValue() {
        return totalPerformanceValue.get();
    }

    public SimpleDoubleProperty totalPerformanceValueProperty() {
        return totalPerformanceValue;
    }

    public void setTotalPerformanceValue(double totalPerformanceValue) {
        this.totalPerformanceValue.set(totalPerformanceValue);
    }
}
