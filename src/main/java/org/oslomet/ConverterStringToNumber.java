package org.oslomet;

public class ConverterStringToNumber  {


    public static class IntegerStringConverter extends javafx.util.converter.IntegerStringConverter {
        private boolean conversionSuccessful;

        @Override
        public Integer fromString(String s) {
            try {
                Integer result = super.fromString(s);
                conversionSuccessful = true;
                return result;
            } catch (NumberFormatException e) {
                conversionSuccessful = false;
                return 0;
            }
        }
        public boolean wasSuccessful() {
            return conversionSuccessful;
        }
    }

    public static class DoubleStringConverter extends javafx.util.converter.DoubleStringConverter {
        private boolean conversionSuccessful;

        @Override
        public Double fromString(String s) {
            try {
                Double result = super.fromString(s);
                conversionSuccessful = true;
                return result;
            } catch (NumberFormatException e) {

                conversionSuccessful = false;
                return 0.0;
            }
        }

        public boolean wasSuccessful() {
            return conversionSuccessful;
        }
    }
}

