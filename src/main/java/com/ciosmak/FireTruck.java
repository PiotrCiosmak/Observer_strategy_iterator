package com.ciosmak;

import com.ciosmak.states.AvailableState;
import com.ciosmak.states.FireTruckState;

public class FireTruck
{
    private FireTruckState state;

    public FireTruck()
    {
        // Set the initial state to "available"
        setState(new AvailableState(this));
    }

    public void setState(FireTruckState state)
    {
        this.state = state;
    }

    public FireTruckState getState()
    {
        return state;
    }

    public void goToIncident()
    {
        state.goToIncident();
    }

    public void returnToStation()
    {
        state.returnToStation();
    }
}
