package com.ciosmak;

import java.util.Random;

public class Coordinate
{
    public Coordinate()
    {
        double x1 = 50.154564013341734;
        double y1 = 19.688292482742394;

        double x2 = 49.95855025648944;
        double y2 = 20.02470275868903;

        Random random = new Random();
        this.x = x1 + (x2 - x1) * random.nextDouble();
        this.y = y1 + (y2 - y1) * random.nextDouble();
    }

    public Coordinate(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    private final double x;
    private final double y;
}
