package carlos.projects.mooc.courses.application.create;

import carlos.projects.mooc.courses.CoursesModuleUnitTestCase;
import carlos.projects.mooc.courses.domain.*;
import carlos.projects.shared.domain.course.CourseCreatedDomainEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

final class CourseCreatorShould extends CoursesModuleUnitTestCase {

    private CourseCreator creator;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        creator = new CourseCreator(repository, eventBus);
    }

    @Test
    void create_a_valid_course() throws Exception {
        CreateCourseRequestDTO requestedCourse = CreateCourseRequestDTOMother.random();

        Course course = CourseMother.fromRequest(requestedCourse);
        // We create the domain event from Course because it is needed to have all the course properties that we are recording.
        CourseCreatedDomainEvent domainEvent = CourseCreatedDomainEventMother.fromCourse(course);
        creator.create(
                CourseIdMother.create(requestedCourse.id()),
                CourseNameMother.create(requestedCourse.name()),
                CourseDurationMother.create(requestedCourse.duration())
        );

        shouldHaveSaved(course);
        shouldHavePublished(domainEvent);
    }
}