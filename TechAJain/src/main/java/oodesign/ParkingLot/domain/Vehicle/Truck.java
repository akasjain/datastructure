package main.java.oodesign.ParkingLot.domain.Vehicle;

import static main.java.oodesign.ParkingLot.domain.Vehicle.VehicleSize.FOUR_VEHICLER_LARGE;

public class Truck extends Vehicle {

    public Truck(VehicleSize vehicleSize, String plateNumber, VehicleType vehicleType) {
        super(FOUR_VEHICLER_LARGE, plateNumber, vehicleType);
    }
}
