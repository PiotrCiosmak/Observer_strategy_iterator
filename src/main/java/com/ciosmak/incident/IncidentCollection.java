package com.ciosmak.incident;

import com.ciosmak.iterators.IncidentIterator;

import java.util.ArrayList;
import java.util.List;

public class IncidentCollection implements IncidentIterator
{
    private List<Incident> incidents;

    private int currentIndex;

    public IncidentCollection()
    {
        this.incidents = new ArrayList<>();
        this.currentIndex = 0;
    }

    public void addIncident(Incident incident)
    {
        this.incidents.add(incident);
    }

    @Override
    public boolean hasNext()
    {
        return currentIndex < incidents.size();
    }

    @Override
    public Incident next()
    {
        if (hasNext())
        {
            return incidents.get(currentIndex++);
        }
        return null;
    }

    public IncidentIterator iterator()
    {
        return this;
    }
}
