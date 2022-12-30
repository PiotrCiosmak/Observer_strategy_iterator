package com.ciosmak;

public class Coordinate
{
    public Coordinate()
    {
        //TODO random in range
    }

    public int getLatitudeDegrees()
    {
        return latitudeDegrees;
    }

    public void setLatitudeDegrees(int latitudeDegrees)
    {
        this.latitudeDegrees = latitudeDegrees;
    }

    public int getLatitudeMinute()
    {
        return latitudeMinute;
    }

    public void setLatitudeMinute(int latitudeMinute)
    {
        this.latitudeMinute = latitudeMinute;
    }

    public int getLongitudeDegrees()
    {
        return longitudeDegrees;
    }

    public void setLongitudeDegrees(int longitudeDegrees)
    {
        this.longitudeDegrees = longitudeDegrees;
    }

    public int getLongitudeMinute()
    {
        return longitudeMinute;
    }

    public void setLongitudeMinute(int longitudeMinute)
    {
        this.longitudeMinute = longitudeMinute;
    }

    private int latitudeDegrees;
    private int latitudeMinute;
    private int longitudeDegrees;
    private int longitudeMinute;
}
