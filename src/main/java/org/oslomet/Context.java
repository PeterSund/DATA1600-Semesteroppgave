package org.oslomet;

import org.oslomet.ComponentClasses.ComponentModel;

import java.util.ArrayList;
import java.util.List;

public class Context {

    private static List<String> compArray = new ArrayList<String>();

    public static void addToArray(String obj) {
        compArray.add(obj);
    }

    public static String getObj() {
        return compArray.get(compArray.size()-1);
    }


}
