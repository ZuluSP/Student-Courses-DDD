package carlos.projects.shared.infrastructure.bus.event.spring;

import carlos.projects.shared.domain.Service;
import carlos.projects.shared.domain.bus.event.DomainEvent;
import carlos.projects.shared.domain.bus.event.EventBus;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Primary;

import java.util.List;


@Service
public class SpringApplicationEventBus implements EventBus {

    // Event publisher by spring. Will take all the @EventListener tags.
    private final ApplicationEventPublisher publisher;

    public SpringApplicationEventBus(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void publish(List<DomainEvent> events) {
        events.forEach(this::publish);
    }

    // With the publishEvent spring knows how to publish the event.
    private void publish(final DomainEvent event) {
        this.publisher.publishEvent(event);
    }
}
