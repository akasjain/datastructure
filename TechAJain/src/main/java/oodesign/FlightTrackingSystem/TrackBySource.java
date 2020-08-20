package main.java.FlightTrackingSystem;

import java.util.List;

import static main.java.FlightTrackingSystem.SearchCriteria.SOURCE;

public class TrackBySource implements TrackingSystem{

    @Override
    public List<Flight> search(SearchCriteria searchCretiera) {
        return null;
    }

    @Override
    public SearchCriteria searchAttribute() {
        return SOURCE;
    }
}
