import Markers.Marker;

public class ViewMap {
    Mediator mediator;
    void setMediator( Mediator mediator){
        this.mediator=mediator;
    }
    Marker[] markers;
    void setMarkers(Marker[] markers){
        this.markers=markers;
    }
    void selectMarker(Marker marker){
        if(!marker.clickable){
            return;
        }
        mediator.selectMarker(marker);
    }
    ViewMap(){
    }
}
