package com.ciosmak.incident;

public class LocalDanger extends Incident
{
    public LocalDanger(Integer numberOfFireTruckNeeded)
    {
        super();
        this.numberOfFireTruckNeeded = 3;
    }

    public Integer getNumberOfFireTruckNeeded()
    {
        return numberOfFireTruckNeeded;
    }

    private final Integer numberOfFireTruckNeeded;
}
