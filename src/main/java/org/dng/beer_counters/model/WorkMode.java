package org.dng.beer_counters.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum WorkMode {
    PRODUCTION(1), STOPPING(2), WASHING(3);

    private int value;
    WorkMode(int i) {
        value = i;
    }

    public static List<WorkMode> getListOfItems(){
        return new ArrayList<>(Arrays.asList(WorkMode.values()));
    }

}
