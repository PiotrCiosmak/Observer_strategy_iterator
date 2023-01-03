package com.ciosmak.incident;

public class Fire extends Incident
{
    public Fire(Integer numberOfFireTruckNeeded)
    {
        super();
        this.numberOfFireTruckNeeded = 3;
    }

    private final Integer numberOfFireTruckNeeded;
}
