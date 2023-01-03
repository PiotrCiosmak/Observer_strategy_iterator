package com.ciosmak.generator;

import com.ciosmak.incident.Incident;

import java.util.Random;

public class Generator
{
    public static Integer generateActionDuration(Incident incident)
    {
        Integer time = 0;
        time += new Random().nextInt(4);
        if (!incident.isFalseAlarm())
        {
            time += new Random().nextInt(21) + 5;
        }
        time += new Random().nextInt(4);
        return time;
    }
}
