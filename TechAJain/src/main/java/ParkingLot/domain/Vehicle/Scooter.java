package main.java.ParkingLot.domain.Vehicle;

import static main.java.ParkingLot.domain.Vehicle.VehicleSize.TWO_VEHICLER;

public class Scooter extends Vehicle {
    public Scooter(String plateNumber, VehicleType vehicleType) {
        super(TWO_VEHICLER, plateNumber, vehicleType);
    }
}
