package main.java.FlightTrackingSystem;

import java.util.List;

import static main.java.FlightTrackingSystem.SearchCriteria.ARRIVAL_TIME;

public class TrackByArrivalTime implements TrackingSystem{

    @Override
    public List<Flight> search(SearchCriteria searchCretiera) {
        return null;
    }

    @Override
    public SearchCriteria searchAttribute() {
        return ARRIVAL_TIME;
    }
}
