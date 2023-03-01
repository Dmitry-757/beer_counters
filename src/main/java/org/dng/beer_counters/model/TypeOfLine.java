package org.dng.beer_counters.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum TypeOfLine {
    Line05(1), Line135(2), MetalKeg(3), PETKeg(4), MiniBrewery(5);

    private final int lineNumber;

    TypeOfLine(int i) {
        lineNumber = i;
    }

    public static List<TypeOfLine> getListOfItems(){
        return new ArrayList<>(Arrays.asList(TypeOfLine.values()));
    }
}

