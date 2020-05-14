package main.java.ParkingLot.services;

import main.java.ParkingLot.domain.Parking.ParkingType;
import main.java.ParkingLot.domain.Vehicle.Vehicle;

import java.time.Instant;

public class ParkingRequest {
    Vehicle vehicle;
    Instant time;
    ParkingType parkingNeeds;
    RequestType requestType;
}
