package carlos.projects.shared.infrastructure.bus.event.mysql;

import carlos.projects.shared.domain.Service;
import carlos.projects.shared.domain.Utils;
import carlos.projects.shared.domain.bus.event.DomainEvent;
import carlos.projects.shared.domain.bus.event.EventBus;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.context.annotation.Primary;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

// There are conflicts between different implementations of EventBus, so we put the primary to let know spring that this one is the first.
@Primary
@Service
public final class MySqlEventBus implements EventBus {
    private final SessionFactory sessionFactory;

    public MySqlEventBus(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void publish(List<DomainEvent> events) {
        events.forEach(this::publish);
    }

    private void publish(DomainEvent domainEvent) {
        String                        id          = domainEvent.eventId();
        String                        aggregateId = domainEvent.aggregateId();
        String                        name        = domainEvent.eventName();
        HashMap<String, Serializable> body        = domainEvent.toPrimitives();
        String                        occurredOn  = domainEvent.occurredOn();
        // To show more alternatives than mapping, this time we can do the flat query here.
        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(
                "INSERT INTO domain_events (id,  aggregate_id, name,  body,  occurred_on) " +
                        "VALUES (:id, :aggregateId, :name, :body, :occurredOn);"
        );

        query.setParameter("id", id)
                .setParameter("aggregateId", aggregateId)
                .setParameter("name", name)
                .setParameter("body", Utils.jsonEncode(body))
                .setParameter("occurredOn", occurredOn);

        query.executeUpdate();
    }
}
