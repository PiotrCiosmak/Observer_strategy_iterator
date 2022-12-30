package com.ciosmak;

import java.util.ArrayList;
import java.util.List;

public class RescueAndFirefightingUnits
{
    public RescueAndFirefightingUnits()
    {
        this.numberOfFireTrucks = 5;
        fireTruckList = new ArrayList();
        for (int i = 0; i < 5; ++i)
        {
            fireTruckList.add(new FireTruck());
        }
    }

    private int numberOfFireTrucks;

    private List<FireTruck> fireTruckList;
}
