package main.java.oodesign.ParkingLot.services;

import main.java.oodesign.ParkingLot.domain.Parking.ParkingLot;
import main.java.oodesign.ParkingLot.domain.Parking.ParkingSpot;

import java.util.List;

public class ParkingService implements ParkingClient {

    PaymentService paymentService;
    ParkingLot parkingLot;
    DisplayService displayService;

    public ParkingService(PaymentService paymentService, ParkingLot parkingLot, DisplayService displayService) {
        this.paymentService = paymentService;
        this.parkingLot = parkingLot;
        this.displayService = displayService;
    }

    @Override
    public List<ParkingSpot> request(ParkingRequest parkingRequest) {
        return null;
    }

    @Override
    public ParkingSpot action(ParkingRequest parkingRequest) {
        return null;
    }
}
