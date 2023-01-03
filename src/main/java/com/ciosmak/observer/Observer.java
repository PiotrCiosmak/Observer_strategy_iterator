package com.ciosmak.observer;

import com.ciosmak.FireTruck;
import com.ciosmak.incident.Incident;

import java.util.List;

public interface Observer
{
    List<FireTruck> update(Incident incident);
}
