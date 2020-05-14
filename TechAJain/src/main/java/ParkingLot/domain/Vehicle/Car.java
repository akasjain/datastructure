package main.java.ParkingLot.domain.Vehicle;

public class Car extends Vehicle {

    public Car(String plateNumber, VehicleType vehicleType) {
        super(VehicleSize.FOUR_VEHICLER_MEDIUM, plateNumber, vehicleType);
    }
}
