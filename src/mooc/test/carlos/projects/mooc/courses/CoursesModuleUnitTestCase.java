package carlos.projects.mooc.courses;

import carlos.projects.mooc.courses.domain.Course;
import carlos.projects.mooc.courses.domain.CourseRepository;
import carlos.projects.shared.domain.bus.event.DomainEvent;
import carlos.projects.shared.domain.bus.event.EventBus;
import carlos.projects.shared.insfrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

public class CoursesModuleUnitTestCase extends UnitTestCase {
    protected EventBus eventBus;
    protected CourseRepository repository;

    @BeforeEach
    protected void setUp() {
       repository = mock(CourseRepository.class);
    }

    protected void shouldHaveSaved(Course course) {
        verify(repository, atLeastOnce()).save(course);
    }
    public void shouldHavePublished(List<DomainEvent> domainEvents) {
        verify(eventBus, atLeastOnce()).publish(domainEvents);
    }

    public void shouldHavePublished(DomainEvent domainEvent) {
        shouldHavePublished(Collections.singletonList(domainEvent));
    }
}
