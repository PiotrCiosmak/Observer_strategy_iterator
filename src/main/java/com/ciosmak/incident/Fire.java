package com.ciosmak.incident;

public class Fire extends Incident
{
    public Fire()
    {
        super();
        this.numberOfFireTruckNeeded = 3;
    }

    @Override
    public Integer getNumberOfFireTruckNeeded()
    {
        return numberOfFireTruckNeeded;
    }

    private final Integer numberOfFireTruckNeeded;
}
