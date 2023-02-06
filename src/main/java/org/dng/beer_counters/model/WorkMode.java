package org.dng.beer_counters.model;

public enum WorkMode {
    PRODUCTION(1), STOPPING(2), WASHING(3);

    private int value;
    WorkMode(int i) {
        value = i;
    }

    public int getValue() {
        return value;
    }
}
