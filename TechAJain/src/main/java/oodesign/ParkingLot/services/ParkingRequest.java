package main.java.oodesign.ParkingLot.services;

import main.java.oodesign.ParkingLot.domain.Parking.ParkingType;
import main.java.oodesign.ParkingLot.domain.Vehicle.Vehicle;

import java.time.Instant;

public class ParkingRequest {
    Vehicle vehicle;
    Instant time;
    ParkingType parkingNeeds;
    RequestType requestType;
}
