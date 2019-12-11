package Markers;

import Locations.Coordinates;

public class Marker {
    public final Coordinates coordinates;
    public final boolean clickable;
    Marker(Coordinates coordinates, boolean clickable){
        this.coordinates=coordinates;
        this.clickable=clickable;
    }
}
