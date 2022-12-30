package com.ciosmak;

public class FireTruck
{
    public FireTruck()
    {
        isAvailable = true;
    }

    public boolean dispose()
    {
        if (isAvailable)
        {
            System.out.println("POJAZD ZOSTAŁ DYSPONOWANY");
            return true;
        }
        System.out.println("POJAZD ZAJĘTY");
        return false;
    }

    private boolean isAvailable;

}
