import Markers.Marker;

public interface Mediator {
    void addFoundMarkers(Marker[] markers);
    void selectMarker(Marker marker);
}
