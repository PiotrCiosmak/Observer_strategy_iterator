package com.ciosmak.incident;

public class LocalDanger extends Incident
{
    public LocalDanger()
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
