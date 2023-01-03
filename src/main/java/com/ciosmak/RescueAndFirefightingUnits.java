package com.ciosmak;

import com.ciosmak.generator.Generator;
import com.ciosmak.incident.Incident;
import com.ciosmak.observer.IncidentDispatcher;
import com.ciosmak.observer.Observer;
import com.ciosmak.states.UnavailableState;

import java.util.ArrayList;
import java.util.List;

public class RescueAndFirefightingUnits implements Observer
{

    public RescueAndFirefightingUnits(String name, double x, double y, IncidentDispatcher incidentDispatcher)
    {
        this.incidentDispatcher = incidentDispatcher;
        incidentDispatcher.registerObserver(this);
        this.name = name;
        this.coordinate = new Coordinate(x, y);
        this.numberOfFireTrucks = 5;
        this.fireTruckList = new ArrayList();
        for (int i = 0; i < this.numberOfFireTrucks; ++i)
        {
            this.fireTruckList.add(new FireTruck());
        }
    }

    @Override
    public List<FireTruck> update(Incident incident)
    {
        List<FireTruck> blockedFireTruckList = new ArrayList<>();
        for (int i = 0; i < numberOfFireTrucks; ++i)
        {
            if (blockedFireTruckList.size() == incident.getNumberOfFireTruckNeeded())
            {
                break;
            }
            if (fireTruckList.get(i).getState().getStateName().equals("available"))
            {
                blockedFireTruckList.add(fireTruckList.get(i));
            }
        }
        if (blockedFireTruckList.size() < incident.getNumberOfFireTruckNeeded())
        {
            blockedFireTruckList.clear();
            return blockedFireTruckList;
        }

        for(var fireTruck : blockedFireTruckList)
        {
            fireTruck.goToIncident();
            fireTruck.setTimeLockInSeconds(Generator.generateActionDuration(incident));
        }
        return blockedFireTruckList;
    }

    public String getName()
    {
        return name;
    }

    public Coordinate getCoordinate()
    {
        return coordinate;
    }

    private String name;
    private Coordinate coordinate;
    private int numberOfFireTrucks;
    private List<FireTruck> fireTruckList;
    private IncidentDispatcher incidentDispatcher;
}
