package com.ciosmak;

import com.ciosmak.states.AvailableState;
import com.ciosmak.states.FireTruckState;

public class FireTruck
{
    private FireTruckState state;
    private Integer timeLockInSeconds;

    public FireTruck()
    {
        // Set the initial state to "available"
        setState(new AvailableState(this));
        this.timeLockInSeconds = 0;
    }

    public void setState(FireTruckState state)
    {
        this.state = state;
    }

    public FireTruckState getState()
    {
        return state;
    }

    public Integer getTimeLockInSeconds()
    {
        return timeLockInSeconds;
    }

    public void setTimeLockInSeconds(Integer timeLockInSeconds)
    {
        this.timeLockInSeconds = timeLockInSeconds;
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
