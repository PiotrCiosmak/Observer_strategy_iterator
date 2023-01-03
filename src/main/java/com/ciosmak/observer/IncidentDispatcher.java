package com.ciosmak.observer;

import com.ciosmak.FireTruck;
import com.ciosmak.incident.Incident;

import java.util.ArrayList;
import java.util.List;

public class IncidentDispatcher implements Subject
{
    private List<Observer> observers;

    public IncidentDispatcher()
    {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o)
    {
        observers.add(o);
    }

    @Override
    public List<FireTruck> notifyObservers(Incident incident)
    {
        for (Observer o : observers)
        {
            return o.update(incident);
        }
        return null;
    }
}
