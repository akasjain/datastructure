package main.java.ParkingLot.domain.Parking;

import main.java.ParkingLot.domain.Vehicle.Vehicle;

import static main.java.ParkingLot.domain.Parking.ParkingStatus.*;

public class ParkingSpot {
    ParkingSize parkingSize;
    ParkingType parkingType;
    int spotNumber;
    ParkingStatus parkingStatus = FREE;
    Vehicle vehicle;

    public ParkingSpot(ParkingSize parkingSize, ParkingType parkingType, int spotNumber) {
        this.parkingSize = parkingSize;
        this.parkingType = parkingType;
        this.spotNumber = spotNumber;
    }
}
