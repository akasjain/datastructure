package main.java.FlightTrackingSystem;

import java.util.List;

import static main.java.FlightTrackingSystem.SearchCriteria.DEPARTURE_TIME;

public class TrackByDepartureTime implements TrackingSystem{

    TrackingSystem next;
    @Override
    public List<Flight> search(SearchCriteria searchCriteria) {
        return next.search(searchCriteria);
    }

    @Override
    public SearchCriteria searchAttribute() {
        return DEPARTURE_TIME;
    }
}
