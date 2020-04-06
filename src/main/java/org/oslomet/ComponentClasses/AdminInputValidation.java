package org.oslomet.ComponentClasses;

public class AdminInputValidation {
    public static final double MAX_PRICE = 99999;

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
        return pv > 0 && pv <= 100;
    }

    //Regex in [H x L x D] - format
    //Source: https://stackoverflow.com/questions/39452200/match-product-dimensions-with-regular-expression
    static boolean dimensions(String dimensions) {
        return !dimensions.isBlank() && dimensions.matches("(\\d+(?:,\\d+)?) x (\\d+(?:,\\d+)?)(?: x (\\d+(?:,\\d+)?))?");
    }

    //Regex accepts all letters with capital first letter
    static boolean color(String color) {
        return !color.isBlank() && color.matches("^[A-Z]{2,19}[a-z_-]{2,19}$");
    }

}
