package carlos.projects.mooc.shared.infrastructure.bus.event.mysql;

import carlos.projects.mooc.MoocContextInfrastructureTestCase;
import carlos.projects.mooc.courses.domain.CourseCreatedDomainEventMother;
import carlos.projects.shared.domain.course.CourseCreatedDomainEvent;
import carlos.projects.shared.infrastructure.bus.event.mysql.MySqlDomainEventsConsumer;
import carlos.projects.shared.infrastructure.bus.event.mysql.MySqlEventBus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Collections;

@Transactional
class MySqlEventBusShould extends MoocContextInfrastructureTestCase {
    @Autowired
    private MySqlEventBus eventBus;
    @Autowired
    private MySqlDomainEventsConsumer consumer;

    // Here we just check that there are no exceptions
    @Test
    void publish_and_consume_domain_events_from_msql() throws InterruptedException {
        CourseCreatedDomainEvent domainEvent = CourseCreatedDomainEventMother.random();

        eventBus.publish(Collections.singletonList(domainEvent));

        Thread consumerProcess = new Thread(() -> consumer.consume());
        consumerProcess.start();

        Thread.sleep(100);

        consumer.stop();
    }
}