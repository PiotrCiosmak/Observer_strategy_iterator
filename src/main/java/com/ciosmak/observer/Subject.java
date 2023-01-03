package com.ciosmak.observer;

import com.ciosmak.FireTruck;
import com.ciosmak.incident.Incident;

import java.util.List;

public interface Subject
{

    void registerObserver(Observer o);

    List<FireTruck> notifyObservers(Incident incident);
}
