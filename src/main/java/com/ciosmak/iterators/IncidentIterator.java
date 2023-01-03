package com.ciosmak.iterators;

import com.ciosmak.incident.Incident;

public interface IncidentIterator
{
    boolean hasNext();

    Incident next();
}
