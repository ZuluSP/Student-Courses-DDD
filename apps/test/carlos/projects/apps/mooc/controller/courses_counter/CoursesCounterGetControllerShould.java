package carlos.projects.apps.mooc.controller.courses_counter;

import carlos.projects.apps.mooc.MoocApplicationTestCase;
import carlos.projects.shared.domain.course.CourseCreatedDomainEvent;
import org.junit.jupiter.api.Test;


public final class CoursesCounterGetControllerShould extends MoocApplicationTestCase {
    @Test
    void get_the_counter_with_one_course() throws Exception {
        givenISendEventsToTheBus(
            new CourseCreatedDomainEvent("5d6b099d-8ff9-440e-8807-3bfa8ece67a2", "DDD in Java", "10 days")
        );

        assertResponse("/courses-counter", 200, "{'total': 1}");
    }

    @Test
    void get_the_counter_with_more_than_one_course() throws Exception {
        givenISendEventsToTheBus(
            new CourseCreatedDomainEvent("5d6b099d-8ff9-440e-8807-3bfa8ece67a2", "DDD in Java", "10 days"),
            new CourseCreatedDomainEvent("661d5ffd-2c01-4a8c-9e19-4ca138ec5469", "DDD in Typescript", "3 days"),
            new CourseCreatedDomainEvent("7f6ec8b5-ed12-4489-b508-d51094188fb4", "DDD in R", "5 years")
        );

        assertResponse("/courses-counter", 200, "{'total': 3}");
    }

    @Test
    void get_the_counter_with_more_than_one_course_having_duplicated_events() throws Exception {
        givenISendEventsToTheBus(
            new CourseCreatedDomainEvent("5d6b099d-8ff9-440e-8807-3bfa8ece67a2", "DDD in Java", "10 days"),
            new CourseCreatedDomainEvent("5d6b099d-8ff9-440e-8807-3bfa8ece67a2", "DDD in Java", "10 days"),
            new CourseCreatedDomainEvent("5d6b099d-8ff9-440e-8807-3bfa8ece67a2", "DDD in Java", "10 days"),
            new CourseCreatedDomainEvent("661d5ffd-2c01-4a8c-9e19-4ca138ec5469", "DDD in Typescript", "3 days"),
            new CourseCreatedDomainEvent("661d5ffd-2c01-4a8c-9e19-4ca138ec5469", "DDD in Typescript", "3 days"),
            new CourseCreatedDomainEvent("661d5ffd-2c01-4a8c-9e19-4ca138ec5469", "DDD in Typescript", "3 days"),
            new CourseCreatedDomainEvent("7f6ec8b5-ed12-4489-b508-d51094188fb4", "DDD in R", "5 years"),
            new CourseCreatedDomainEvent("7f6ec8b5-ed12-4489-b508-d51094188fb4", "DDD in R", "5 years")
        );

        assertResponse("/courses-counter", 200, "{'total': 3}");
    }
}
