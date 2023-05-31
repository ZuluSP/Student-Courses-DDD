package carlos.projects.mooc.courses.infrastructure;

import carlos.projects.mooc.courses.domain.Course;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

final class InMemoryCourseRepositoryShould {
    @Test
    void save_a_valid_course() throws Exception {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();
        // The non-existing exceptions will verify this test is correct.
        repository.save(new Course("some-id", "some-name", "some-duration"));
    }

    @Test
    void search_an_existing_course() throws Exception {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();
        Course course = new Course("some-id", "some-name", "some-duration");
        repository.save(course);
        Optional<Course> currentCourse = repository.search(course.id());
        Assert.assertEquals(Optional.of(course), currentCourse);
    }

    @Test
    void not_find_a_non_existing_course() throws Exception {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();
        Assert.assertFalse(repository.search("non-existing-id").isPresent());
    }
}