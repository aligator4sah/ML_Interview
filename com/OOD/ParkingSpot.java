package com.OOD;

public class ParkingSpot {
    private final VehicleSize size;
    private Vehicle currentVehicle;

    ParkingSpot(VehicleSize size) {
        this.size = size;
    }

    boolean fit(Vehicle v) {
        return currentVehicle == null && size.getSize() >= v.getSize().getSize();
    }
    
    // record a vehicle is parked in by updating the current vehicle
    void park(Vehicle v) {
        this.currentVehicle = v;
    }

    void leave() {
        this.currentVehicle = null;
    }

    Vehicle getVehicle() {
        return this.currentVehicle;
    }
}
