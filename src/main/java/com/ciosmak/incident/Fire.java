package com.ciosmak.incident;

import com.ciosmak.Coordinate;

import java.util.Random;

public class Fire
{
    public Fire()
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

    private final Coordinate coordinate;
    private final boolean isFalseAlarm;
}