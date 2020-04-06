package org.oslomet.ComponentClasses;

public class AdminInputValidation {

    public static final double MAX_PRICE = 99999;
    public static final double MAX_PERFORMANCE_VALUE = 100;
    public static final double MAX_CLOCK_SPEED = 100;
    public static final double MAX_CAPACITY = 100000;
    public static final int MAX_SIZE_MONITOR = 300;
    public static final int MAX_WATT = 10000;


    //Regex accepts all letters, digits and some special characters
    static boolean name(String name) {
        return !name.isBlank() && name.matches("^[a-zA-Z0-9!#$%&'*+-/=?^_`{|};]+$");
    }

    //Regex accepts all letters, digits and some special characters
    static boolean brand(String brand) {
        return !brand.isBlank() && brand.matches("^[a-zA-Z0-9!#$%&'*+-/=?^_`{|};]+$");
    }

    static boolean price(double price) {
        return price > 0 && price <= MAX_PRICE;
    }

    static boolean performanceValue(double pv) {
        return pv > 0 && pv <= MAX_PERFORMANCE_VALUE;
    }

    //Regex in [H x L x D] - format
    //Source: https://stackoverflow.com/questions/39452200/match-product-dimensions-with-regular-expression
    static boolean dimensions(String dimensions) {
        return !dimensions.isBlank() && dimensions.matches("^\\d+(x\\d+)*$");
    }

    //Regex accepts all letters with capital first letter
    static boolean color(String color) {
        return !color.isBlank() && color.matches("^[A-Z]{1,19}[a-z]{2,19}$");
    }

    static boolean clockSpeed(double clockSpeed) {
        return clockSpeed > 0 && clockSpeed <= MAX_CLOCK_SPEED;
    }

    static boolean cores(int cores) {
        return cores % 2 == 0;
    }

    static boolean memory(int memory) {
        return memory % 2 == 0 && memory > 0;
    }

    static boolean capacity(int capacity) {
        return capacity > 0 && capacity <= MAX_CAPACITY;
    }

    //Regex accepts all letters with capital first letter
    static boolean language(String language) {
        return !language.isBlank() && language.matches("[A-Z]*[a-z]*");
    }

    static boolean size(int size) {
        return size > 0 && size  <= MAX_SIZE_MONITOR;
    }

    static boolean watt(int watt) {
        return watt > 0 && watt <= MAX_WATT;
    }

    static boolean memorySpeed(double memorySpeed) {
        return memorySpeed > 0;
    }


}
