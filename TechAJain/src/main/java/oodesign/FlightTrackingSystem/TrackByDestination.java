package main.java.FlightTrackingSystem;

import java.util.List;

import static main.java.FlightTrackingSystem.SearchCriteria.DESTINATION;

public class TrackByDestination implements TrackingSystem{

    @Override
    public List<Flight> search(SearchCriteria searchCretiera) {
        return null;
    }

    @Override
    public SearchCriteria searchAttribute() {
        return DESTINATION;
    }
}
