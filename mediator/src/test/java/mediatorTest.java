import Locations.Coordinates;
import Locations.LocationData;
import Markers.Marker;
import Markers.MarkerFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class mediatorTest {
    private Manager manager;
    private LocationData[] locations;
    @BeforeEach
    public void prepareOutput(){
        locations= new LocationData[]{
            new LocationData(new Coordinates(10f,12f),"Shop"),
            new LocationData(new Coordinates(15,15),"Farmacy")
        };
        LocationFinder locationFinder = new LocationFinder();
        ViewMap viewMap = new ViewMap();
        Details details = new Details();
        manager = new Manager(locationFinder,viewMap,details);
        locationFinder.setMediator(manager);
        viewMap.setMediator(manager);
        details.setMediator(manager);
    }
    @Test
    public void GotFoundMarkerInViewMap() {
        Marker[] expected = new Marker[]{
                MarkerFactory.getMarker(locations[0],true)
        };
        manager.locationFinder.sendMarkersFound(expected);
        Marker[] actual=manager.viewMap.markers;
        assertEquals(expected,actual);
    }
    @Test
    public void GotClickedMarkerInDetails() {
        Marker expected = MarkerFactory.getMarker(locations[0],true);
        manager.viewMap.selectMarker(expected);
        Marker actual= manager.details.marker;
        assertEquals(expected,actual);
    }
    @Test
    public void DidNotGetClickedMarkerInDetails() {
        Marker expected = MarkerFactory.getMarker(locations[0],false);
        manager.viewMap.selectMarker(expected);
        Marker actual= manager.details.marker;
        assertNotEquals(expected,actual);
    }
}
