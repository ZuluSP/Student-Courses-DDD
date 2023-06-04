package carlos.projects.mooc.courses_counter.application.increment;

import carlos.projects.mooc.courses.domain.CourseId;
import carlos.projects.shared.domain.Service;
import carlos.projects.shared.domain.course.CourseCreatedDomainEvent;
import org.springframework.context.event.EventListener;


@Service
public final class IncrementCoursesCounterOnCourseCreated {
    private final CoursesCounterIncrementer incrementer;

    public IncrementCoursesCounterOnCourseCreated(CoursesCounterIncrementer incrementer) {
        this.incrementer = incrementer;
    }

    @EventListener
    public void on(CourseCreatedDomainEvent event) {
        CourseId courseId = new CourseId(event.aggregateId());

        incrementer.increment(courseId);
    }
}
