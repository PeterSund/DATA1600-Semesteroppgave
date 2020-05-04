package org.oslomet.Validation;

import org.oslomet.ComputerClasses.ComputerRegistry;

public class AdminInputValidation {

    public static final double MAX_PRICE = 99999;
    public static final double MAX_PERFORMANCE_VALUE = 100;
    public static final double MAX_PERFORMANCE_TOTALVALUE = 1100;
    public static final double MAX_CLOCK_SPEED = 100;
    public static final double MAX_CAPACITY = 20000;
    public static final int MAX_SIZE_MONITOR = 300;
    public static final int MAX_WATT = 10000;
    public static final int MAX_CORES = 128;
    public static final int MAX_MEMORY = 256000;
    public static final double MAX_MEMORYSPEED = 10000;


    //Regex accepts all letters, digits and some special characters
    public static boolean name(String name) {
        return !name.isBlank() && name.matches("[a-zA-Z0-9!#$%&'*+-/=?^_`{|}\\s]*");
    }

    public static boolean configName(String name) {
        return !name.isBlank() && !ComputerRegistry.computerNameExists(name);
    }

    //Regex accepts all letters, digits and some special characters
    public static boolean brand(String brand) {
        return !brand.isBlank() && brand.matches("[a-zA-Z0-9!#$%&'*+-/=?^_`{|}\\s]*");
    }

    public static boolean price(double price) {
        return price > 0 && price <= MAX_PRICE;
    }

    public static boolean performanceValue(double pv) {
        return pv > 0 && pv <= MAX_PERFORMANCE_VALUE;
    }

    //Regex in [H x L x D] - format
    //Source: https://stackoverflow.com/questions/39452200/match-product-dimensions-with-regular-expression
    public static boolean dimensions(String dimensions) {
        return !dimensions.isBlank() && dimensions.matches("^\\d+(x\\d+)*$");
    }

    //Regex accepts all letters with capital first letter
    public static boolean color(String color) {
        return !color.isBlank() && color.matches("^[A-Z]{1,19}[a-z]{2,19}$");
    }

    public static boolean clockSpeed(double clockSpeed) {
        return clockSpeed > 0 && clockSpeed <= MAX_CLOCK_SPEED;
    }

    public static boolean cores(int cores) {
        return cores % 2 == 0 && cores > 0 && cores <= MAX_CORES;
    }

    public static boolean memory(int memory) {
        return memory % 2 == 0 && memory > 0 && memory <= MAX_MEMORY;
    }

    public static boolean capacity(int capacity) {
        return capacity > 0 && capacity <= MAX_CAPACITY;
    }

    //Regex accepts 3 capital letters (NOR / ENG / SWE..)
    public static boolean language(String language) {
        return !language.isBlank() && language.matches("[A-Z]{3}");
    }

    public static boolean size(int size) {
        return size > 0 && size  <= MAX_SIZE_MONITOR;
    }

    public static boolean watt(int watt) {
        return watt > 0 && watt <= MAX_WATT;
    }

    public static boolean memorySpeed(double memorySpeed) {
        return memorySpeed > 0 && memorySpeed <= MAX_MEMORYSPEED;
    }


}
