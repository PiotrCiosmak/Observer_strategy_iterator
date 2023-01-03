package com.ciosmak.states;

import com.ciosmak.FireTruck;

public class AvailableState implements FireTruckState {
    private FireTruck fireTruck;

    public AvailableState(FireTruck fireTruck) {
        this.fireTruck = fireTruck;
    }

    public void goToIncident() {
        System.out.println("Going to incident");
        fireTruck.setState(new UnavailableState(fireTruck));
    }

    public void returnToStation() {
        // Can't return to station when already at the station
        System.out.println("Already at the station");
    }
}
