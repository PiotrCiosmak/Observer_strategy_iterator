package com.ciosmak.states;

import com.ciosmak.FireTruck;

public class UnavailableState implements FireTruckState
{
    private FireTruck fireTruck;

    public UnavailableState(FireTruck fireTruck)
    {
        this.fireTruck = fireTruck;
    }

    public void goToIncident()
    {
        // Can't go to incident when already on the way to an incident
        System.out.println("Already on the way to an incident");
    }

    public void returnToStation()
    {
        System.out.println("Returning to station");
        fireTruck.setState(new AvailableState(fireTruck));
    }
    public String getStateName()
    {
        return "unavailable";
    }
}
