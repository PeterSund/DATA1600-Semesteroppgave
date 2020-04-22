package org.oslomet;

import org.oslomet.Validation.AdminInputValidation;

import static org.junit.jupiter.api.Assertions.*;

class AdminInputValidationTest {

    @org.junit.jupiter.api.Test
    void validName() {
        assertTrue(AdminInputValidation.name(""));
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