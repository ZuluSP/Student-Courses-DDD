package carlos.projects.mooc.courses.application.create;

import carlos.projects.mooc.courses.domain.Course;
import carlos.projects.mooc.courses.domain.CourseRepository;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.*;
final class CourseCreatorShould {

    @Test
    void save_a_valid_course() throws Exception {
        CourseRepository repository = mock(CourseRepository.class);
        CourseCreator creator = new CourseCreator(repository);

        Course course = new Course("some-id", "some-name", "some-duration");

        creator.create(new CreateCourseRequestDTO(course.id(), course.name(), course.duration()));

        verify(repository, atLeastOnce()).save(course);
    }
}