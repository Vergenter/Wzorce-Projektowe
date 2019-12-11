import Markers.Marker;

public class LocationFinder {
    Mediator mediator;
    void setMediator( Mediator mediator){
        this.mediator=mediator;
    }
    LocationFinder(){

    }
    void sendMarkersFound(Marker[] markers){
        this.mediator.addFoundMarkers(markers);
    }
}
