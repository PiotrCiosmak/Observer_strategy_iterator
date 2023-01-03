package com.ciosmak.incident;

public class LocalDanger extends Incident
{
    public LocalDanger()
    {
        super();
        this.numberOfFireTruckNeeded = 2;
    }

    @Override
    public Integer getNumberOfFireTruckNeeded()
    {
        return numberOfFireTruckNeeded;
    }

    private final Integer numberOfFireTruckNeeded;
}
