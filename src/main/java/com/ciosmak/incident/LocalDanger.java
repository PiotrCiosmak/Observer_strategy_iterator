package com.ciosmak.incident;

import com.ciosmak.Coordinate;

import java.util.Random;

public class LocalDanger
{
    public LocalDanger()
    {
        this.coordinate = new Coordinate();
        this.isFalseAlarm = new Random().nextDouble() <= 0.05;
    }

    public Coordinate getCoordinate()
    {
        return coordinate;
    }

    public boolean isFalseAlarm()
    {
        return isFalseAlarm;
    }

    private Coordinate coordinate;
    private boolean isFalseAlarm;
}
