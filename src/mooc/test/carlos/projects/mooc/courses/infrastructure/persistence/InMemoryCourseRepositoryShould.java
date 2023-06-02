package carlos.projects.mooc.courses.infrastructure.persistence;

import carlos.projects.mooc.courses.CoursesModuleInfrastructureTestCase;
import carlos.projects.mooc.courses.domain.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

// Integration test, infrastracture layer.
final class InMemoryCourseRepositoryShould extends CoursesModuleInfrastructureTestCase {
    @Test
    void save_a_valid_course() throws Exception {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();
        Course course = CourseMother.random();

        // The non-existing exceptions will verify this test is correct.
        repository.save(course);
    }

    @Test
    void search_an_existing_course() throws Exception {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();
        Course course = CourseMother.random();

        repository.save(course);

        Optional<Course> currentCourse = repository.search(course.id());
        assertEquals(Optional.of(course), currentCourse);
    }

    @Test
    void not_find_a_non_existing_course() throws Exception {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();
        Assert.assertFalse(repository.search(CourseIdMother.random()).isPresent());
    }
}