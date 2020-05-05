package org.oslomet;

import org.oslomet.Validation.AdminInputValidation;

import static org.junit.jupiter.api.Assertions.*;

class AdminInputValidationTest {

    @org.junit.jupiter.api.Test
    void validConfigName() {
        assertTrue(AdminInputValidation.configName("My Computer"));
        assertTrue(AdminInputValidation.configName("my computer"));
        assertTrue(AdminInputValidation.configName("demo-computer"));
        assertTrue(AdminInputValidation.configName("Computer 43"));
        assertTrue(AdminInputValidation.configName("#Computer!"));
    }

    @org.junit.jupiter.api.Test
    void invalidName() {
        assertFalse(AdminInputValidation.name(""));
    }

    @org.junit.jupiter.api.Test
    void validBrand() {
        assertTrue(AdminInputValidation.brand(""));
    }

    @org.junit.jupiter.api.Test
    void invalidBrand() {
        assertFalse(AdminInputValidation.brand(""));
    }


    @org.junit.jupiter.api.Test
    void validPrice() {
        assertTrue(AdminInputValidation.brand(""));
    }

    @org.junit.jupiter.api.Test
    void invalidPrice() {
        assertFalse(AdminInputValidation.brand(""));
    }

    @org.junit.jupiter.api.Test
    void validPerformanceValue() {
        assertTrue(AdminInputValidation.performanceValue(0));
    }

    @org.junit.jupiter.api.Test
    void invalidPerformanceValue() {
        assertFalse(AdminInputValidation.performanceValue(0));
    }

    @org.junit.jupiter.api.Test
    void validDimensions() {
        assertTrue(AdminInputValidation.dimensions(""));
    }

    @org.junit.jupiter.api.Test
    void invalidDimensions() {
        assertFalse(AdminInputValidation.dimensions(""));
    }

    @org.junit.jupiter.api.Test
    void validColor() {
        assertTrue(AdminInputValidation.color(""));
    }

    @org.junit.jupiter.api.Test
    void invalidColor() {
        assertFalse(AdminInputValidation.color(""));
    }

    @org.junit.jupiter.api.Test
    void validClockSpeed() {
        assertTrue(AdminInputValidation.clockSpeed(0));
    }

    @org.junit.jupiter.api.Test
    void invalidClockSpeed() {
        assertFalse(AdminInputValidation.clockSpeed(0));
    }

    @org.junit.jupiter.api.Test
    void validCores() {
        assertTrue(AdminInputValidation.cores(0));
    }

    @org.junit.jupiter.api.Test
    void invalidCores() {
        assertFalse(AdminInputValidation.cores(0));
    }

    @org.junit.jupiter.api.Test
    void validLanguage() {
        assertTrue(AdminInputValidation.language("NOR"));
        assertTrue(AdminInputValidation.language("ENG"));
        assertTrue(AdminInputValidation.language("FRA"));
        assertTrue(AdminInputValidation.language("SWE"));
        assertTrue(AdminInputValidation.language("TOR"));
    }

    @org.junit.jupiter.api.Test
    void invalidLanguage() {
        assertFalse(AdminInputValidation.language("Norsk"));
        assertFalse(AdminInputValidation.language("English"));
        assertFalse(AdminInputValidation.language("Engelsk"));
        assertFalse(AdminInputValidation.language("Heisan"));
        assertFalse(AdminInputValidation.language("Tegnespråk"));
    }

    @org.junit.jupiter.api.Test
    void validCapacity() {
        assertTrue(AdminInputValidation.capacity(1));
        assertTrue(AdminInputValidation.capacity(50));
        assertTrue(AdminInputValidation.capacity(5000));
        assertTrue(AdminInputValidation.capacity(20000));
    }

    @org.junit.jupiter.api.Test
    void invalidCapacity() {
        assertFalse(AdminInputValidation.capacity(-1));
        assertFalse(AdminInputValidation.capacity(-100));
        assertFalse(AdminInputValidation.capacity(0));
        assertFalse(AdminInputValidation.capacity(20001));
    }

    @org.junit.jupiter.api.Test
    void validMemory() {
        assertTrue(AdminInputValidation.memory(1));
        assertTrue(AdminInputValidation.memory(50));
        assertTrue(AdminInputValidation.memory(5000));
        assertTrue(AdminInputValidation.memory(256000));
    }

    @org.junit.jupiter.api.Test
    void invalidMemory() {
        assertFalse(AdminInputValidation.memory(-1));
        assertFalse(AdminInputValidation.memory(-100));
        assertFalse(AdminInputValidation.memory(0));
        assertFalse(AdminInputValidation.memory(256001));
    }

    @org.junit.jupiter.api.Test
    void validMemorySpeed() {
        assertTrue(AdminInputValidation.memorySpeed(1));
        assertTrue(AdminInputValidation.memorySpeed(50));
        assertTrue(AdminInputValidation.memorySpeed(5000));
        assertTrue(AdminInputValidation.memorySpeed(256000));
    }

    @org.junit.jupiter.api.Test
    void invalidMemorySpeed() {
        assertFalse(AdminInputValidation.memorySpeed(0));
        assertFalse(AdminInputValidation.memorySpeed(-1));
        assertFalse(AdminInputValidation.memorySpeed(-100));
        assertFalse(AdminInputValidation.memorySpeed(10001));
    }

    @org.junit.jupiter.api.Test
    void validWatt() {
        assertTrue(AdminInputValidation.watt(1));
        assertTrue(AdminInputValidation.watt(50));
        assertTrue(AdminInputValidation.watt(5000));
        assertTrue(AdminInputValidation.watt(10000));
    }

    @org.junit.jupiter.api.Test
    void invalidWatt() {
        assertFalse(AdminInputValidation.watt(10001));
        assertFalse(AdminInputValidation.watt(-1));
        assertFalse(AdminInputValidation.watt(-100));
        assertFalse(AdminInputValidation.watt(0));
    }

    @org.junit.jupiter.api.Test
    void validSize() {
        assertTrue(AdminInputValidation.size(1));
        assertTrue(AdminInputValidation.size(27));
        assertTrue(AdminInputValidation.size(50));
        assertTrue(AdminInputValidation.size(300));

    }

    @org.junit.jupiter.api.Test
    void invalidSize() {
        assertFalse(AdminInputValidation.size(301));
        assertFalse(AdminInputValidation.size(0));
        assertFalse(AdminInputValidation.size(-1));
        assertFalse(AdminInputValidation.size(-100));
    }
}