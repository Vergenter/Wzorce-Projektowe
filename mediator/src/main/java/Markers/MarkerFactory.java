package Markers;

import Locations.LocationData;
public class MarkerFactory {
    public static Marker getMarker(LocationData location,boolean clickable){
        return new Marker(location.coordinates,clickable);
    }
}
