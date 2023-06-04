package carlos.projects.shared.domain;

import carlos.projects.shared.domain.bus.event.DomainEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AggregateRoot {
    private List<DomainEvent> domainEvents = new ArrayList<>();

    /**
     * Gets all the events
     * @return Events.
     */
    final public List<DomainEvent> pullDomainEvents() {
        List<DomainEvent> events = domainEvents;

        // We clean the events, so we avoid finding them in a posterior pull
        domainEvents = Collections.emptyList();

        return events;
    }

    final protected void record(DomainEvent event) {
        domainEvents.add(event);
    }
}