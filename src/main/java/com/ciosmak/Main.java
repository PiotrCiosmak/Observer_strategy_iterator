package com.ciosmak;

import com.ciosmak.incident.Fire;
import com.ciosmak.incident.Incident;
import com.ciosmak.incident.IncidentCollection;
import com.ciosmak.incident.LocalDanger;
import com.ciosmak.iterators.IncidentIterator;
import com.ciosmak.observer.IncidentDispatcher;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main
{
    static private final Integer DURATION_OF_THE_PROGRAM_IN_SECONDS = 60;
    static private final Double CHANCE_OF_AN_INCIDENT = 0.5;

    static IncidentDispatcher incidentDispatcher = new IncidentDispatcher();

    public static void main(String[] args) throws InterruptedException
    {
        List<RescueAndFirefightingUnits> rescueAndFirefightingUnitsList = loadRescueAndFirefightingUnits();
        Map<RescueAndFirefightingUnits, Double> distanceOfTheEventFromRescueAndFirefightingUnit = new HashMap<>();
        List<FireTruck> blockedFireTruckList = new ArrayList<>();
        int counter = 0;

        IncidentCollection incidents = new IncidentCollection();

        for (int i = 0; i < DURATION_OF_THE_PROGRAM_IN_SECONDS; ++i)
        {
            incidents.addIncident(newIncident());
        }

        IncidentIterator iterator = incidents.iterator();

        while (iterator.hasNext())
        {
            TimeUnit.SECONDS.sleep(1);
            Incident incident = iterator.next();
            for (var fireTruck : blockedFireTruckList)
            {
                fireTruck.setTimeLockInSeconds(fireTruck.getTimeLockInSeconds() - 1);
                if (fireTruck.getTimeLockInSeconds() == 0)
                {
                    fireTruck.returnToStation();
                }
            }


            if (incident != null)
            {
                for (var rescueAndFirefightingUnits : rescueAndFirefightingUnitsList)
                {
                    distanceOfTheEventFromRescueAndFirefightingUnit.put(rescueAndFirefightingUnits, calculateDistance(incident, rescueAndFirefightingUnits));
                }
            }
            else
            {
                continue;
            }

            while (true)
            {
                if (counter == 10)
                {
                    System.out.println("INCYDENT PRZEPADŁ PONIEWAŻ BRAKUJE WOLNYCH JEDNOSTEK");
                    break;
                }
                RescueAndFirefightingUnits nearestRescueAndFirefightingUnits = findNearestRescueFirefightingUnitName(distanceOfTheEventFromRescueAndFirefightingUnit);

                List<FireTruck> tmpBlockedFireTruckList = new ArrayList<>();
                tmpBlockedFireTruckList = nearestRescueAndFirefightingUnits.update(incident);
                //tmpBlockedFireTruckList = nearestRescueAndFirefightingUnits.dispose(incident);

                for (var fireTruck : tmpBlockedFireTruckList)
                {
                    blockedFireTruckList.add(fireTruck);
                }

                if (!tmpBlockedFireTruckList.isEmpty())
                {
                    System.out.println("W AKCJI BRAŁY UDZIAŁ: " + incident.getNumberOfFireTruckNeeded() + " POJAZDY Z JEDNOSTKI " + nearestRescueAndFirefightingUnits.getName());
                    break;
                }
                else
                {
                    counter++;
                    System.out.println("BRAK WOLNYCH POJAZDÓW W JEDNOSTCE: " + nearestRescueAndFirefightingUnits.getName());
                    distanceOfTheEventFromRescueAndFirefightingUnit.remove(nearestRescueAndFirefightingUnits);
                }
            }
            distanceOfTheEventFromRescueAndFirefightingUnit.clear();
            counter = 0;
        }
        System.out.println("KONTROLOWANY KONIEC PROGRAMU");
    }

    private static List<RescueAndFirefightingUnits> loadRescueAndFirefightingUnits()
    {
        List<RescueAndFirefightingUnits> rescueAndFirefightingUnitsList = new ArrayList<>();
        rescueAndFirefightingUnitsList.add(new RescueAndFirefightingUnits("JRG-1", 50.0334788502075, 19.94311273940794, incidentDispatcher));
        rescueAndFirefightingUnitsList.add(new RescueAndFirefightingUnits("JRG-2", 50.0334788502075, 19.9359033914334, incidentDispatcher));
        rescueAndFirefightingUnitsList.add(new RescueAndFirefightingUnits("JRG-3", 50.075782424336374, 19.887523751004867, incidentDispatcher));
        rescueAndFirefightingUnitsList.add(new RescueAndFirefightingUnits("JRG-4", 50.037798842647675, 20.00614171409626, incidentDispatcher));
        rescueAndFirefightingUnitsList.add(new RescueAndFirefightingUnits("JRG-5", 50.09173580126222, 19.920381753047778, incidentDispatcher));
        rescueAndFirefightingUnitsList.add(new RescueAndFirefightingUnits("JRG-6", 50.016213431628586, 20.01607871649386, incidentDispatcher));
        rescueAndFirefightingUnitsList.add(new RescueAndFirefightingUnits("JRG-7", 50.09408065317086, 19.977735182621227, incidentDispatcher));
        rescueAndFirefightingUnitsList.add(new RescueAndFirefightingUnits("JRG Szkoly Aspirantow PSP", 50.077461950994866, 20.033159628860805, incidentDispatcher));
        rescueAndFirefightingUnitsList.add(new RescueAndFirefightingUnits("JRG Skawina", 49.968484671124315, 19.799516377610022, incidentDispatcher));
        rescueAndFirefightingUnitsList.add(new RescueAndFirefightingUnits("LSP Lotniska w Balicach", 50.07365368416614, 19.785828235745207, incidentDispatcher));

        return rescueAndFirefightingUnitsList;
    }

    private static Incident newIncident()
    {
        if (new Random().nextDouble() <= CHANCE_OF_AN_INCIDENT)
        {
            if (new Random().nextDouble() <= 0.3)
            {
                return new Fire();
            }
            return new LocalDanger();
        }
        return null;
    }

    private static Double calculateDistance(Incident incident, RescueAndFirefightingUnits rescueAndFirefightingUnits)
    {
        double dx = Math.abs(incident.getCoordinate().getX() - rescueAndFirefightingUnits.getCoordinate().getX());
        double dy = Math.abs(incident.getCoordinate().getY() - rescueAndFirefightingUnits.getCoordinate().getY());
        double distanceSquared = dx * dx + dy * dy;
        return Math.sqrt(distanceSquared);
    }

    private static RescueAndFirefightingUnits findNearestRescueFirefightingUnitName(Map<RescueAndFirefightingUnits, Double> distanceOfTheEventFromRescueAndFirefightingUnit)
    {
        RescueAndFirefightingUnits minKey = null;
        double minValue = Double.MAX_VALUE;

        for (Map.Entry<RescueAndFirefightingUnits, Double> entry : distanceOfTheEventFromRescueAndFirefightingUnit.entrySet())
        {
            if (entry.getValue() < minValue)
            {
                minValue = entry.getValue();
                minKey = entry.getKey();
            }
        }

        return minKey;
    }
}