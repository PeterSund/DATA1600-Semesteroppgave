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
        assertTrue(AdminInputValidation.configName("4094320823"));
    }

    @org.junit.jupiter.api.Test
    void invalidConfigName() {
        assertFalse(AdminInputValidation.name(""));
        assertFalse(AdminInputValidation.name("   "));
        assertFalse(AdminInputValidation.name("My;Computer"));
        assertFalse(AdminInputValidation.name("My:Computer"));
    }

    @org.junit.jupiter.api.Test
    void validName() {
        assertTrue(AdminInputValidation.name("x230"));
        assertTrue(AdminInputValidation.name("X230"));
        assertTrue(AdminInputValidation.name("X 230"));
        assertTrue(AdminInputValidation.name("X-230!"));
        assertTrue(AdminInputValidation.name("4299032"));
    }

    @org.junit.jupiter.api.Test
    void invalidName() {
        assertFalse(AdminInputValidation.name(""));
        assertFalse(AdminInputValidation.name("   "));
        assertFalse(AdminInputValidation.name("X;230"));
    }

    @org.junit.jupiter.api.Test
    void validBrand() {
        assertTrue(AdminInputValidation.brand("Intel"));
        assertTrue(AdminInputValidation.brand("intel"));
        assertTrue(AdminInputValidation.brand("Intel Corporations"));
        assertTrue(AdminInputValidation.brand("Intel-Corporations"));
        assertTrue(AdminInputValidation.brand("8491289"));
    }

    @org.junit.jupiter.api.Test
    void invalidBrand() {
        assertFalse(AdminInputValidation.brand(""));
        assertFalse(AdminInputValidation.brand("   "));
        assertFalse(AdminInputValidation.brand("Intel;corporations"));
    }


    @org.junit.jupiter.api.Test
    void validPrice() {
        assertTrue(AdminInputValidation.price(0.1));
        assertTrue(AdminInputValidation.price(99999));
        assertTrue(AdminInputValidation.price(5.5));
    }

    @org.junit.jupiter.api.Test
    void invalidPrice() {
        assertFalse(AdminInputValidation.price(0));
        assertFalse(AdminInputValidation.price(-1));
        assertFalse(AdminInputValidation.price(100000));
    }

    @org.junit.jupiter.api.Test
    void validPerformanceValue() {
        assertTrue(AdminInputValidation.performanceValue(0.1));
        assertTrue(AdminInputValidation.performanceValue(100));
    }

    @org.junit.jupiter.api.Test
    void invalidPerformanceValue() {
        assertFalse(AdminInputValidation.performanceValue(-1));
        assertFalse(AdminInputValidation.performanceValue(0));
        assertFalse(AdminInputValidation.performanceValue(101));
    }

    @org.junit.jupiter.api.Test
    void validDimensions() {
        assertTrue(AdminInputValidation.dimensions("5x5x5"));
        assertTrue(AdminInputValidation.dimensions("999x999x999"));
    }

    @org.junit.jupiter.api.Test
    void invalidDimensions() {
        assertFalse(AdminInputValidation.dimensions("5X5X5"));
        assertFalse(AdminInputValidation.dimensions("-1x-1x-1"));
        assertFalse(AdminInputValidation.dimensions(""));
        assertFalse(AdminInputValidation.dimensions("      "));
        assertFalse(AdminInputValidation.dimensions("12 by 12 by 12"));
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
        assertTrue(AdminInputValidation.language(""));
    }

    @org.junit.jupiter.api.Test
    void invalidLanguage() {
        assertFalse(AdminInputValidation.language(""));
    }

    @org.junit.jupiter.api.Test
    void validCapacity() {
        assertTrue(AdminInputValidation.capacity(0));
    }

    @org.junit.jupiter.api.Test
    void invalidCapacity() {
        assertFalse(AdminInputValidation.capacity(0));
    }

    @org.junit.jupiter.api.Test
    void validMemory() {
        assertTrue(AdminInputValidation.memory(0));
    }

    @org.junit.jupiter.api.Test
    void invalidMemory() {
        assertFalse(AdminInputValidation.memory(0));
    }

    @org.junit.jupiter.api.Test
    void validMemorySpeed() {
        assertTrue(AdminInputValidation.memorySpeed(0));
    }

    @org.junit.jupiter.api.Test
    void invalidMemorySpeed() {
        assertFalse(AdminInputValidation.memorySpeed(0));
    }

    @org.junit.jupiter.api.Test
    void validWatt() {
        assertTrue(AdminInputValidation.watt(0));
    }

    @org.junit.jupiter.api.Test
    void invalidWatt() {
        assertFalse(AdminInputValidation.watt(0));
    }

    @org.junit.jupiter.api.Test
    void validSize() {
        assertTrue(AdminInputValidation.size(0));
    }

    @org.junit.jupiter.api.Test
    void invalidSize() {
        assertFalse(AdminInputValidation.size(0));
    }



}