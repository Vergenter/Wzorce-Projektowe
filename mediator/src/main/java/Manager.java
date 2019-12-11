import Markers.Marker;

public class Manager implements Mediator {
    LocationFinder locationFinder;
    ViewMap viewMap;
    Details details;

    public void addFoundMarkers(Marker[] markers) {
        if(viewMap==null){
            return;
        }
        this.viewMap.setMarkers(markers);
    }

    public void selectMarker(Marker marker) {
        if(details==null){
            return;
        }
        this.details.setMarker(marker);
    }

    Manager(LocationFinder locationFinder,ViewMap viewMap,Details details){
        this.locationFinder=locationFinder;
        this.viewMap=viewMap;
        this.details=details;
    }
}
