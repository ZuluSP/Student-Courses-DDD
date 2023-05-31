package carlos.projects.mooc.courses.application.create;

import carlos.projects.mooc.courses.domain.*;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.*;
final class CourseCreatorShould {

    @Test
    void create_a_valid_course() throws Exception {
        CourseRepository repository = mock(CourseRepository.class);
        CourseCreator creator = new CourseCreator(repository);

        CreateCourseRequestDTO requestedCourse = new CreateCourseRequestDTO("some-id", "some-name", "some-duration");
        Course course = new Course(new CourseId(requestedCourse.id()), new CourseName(requestedCourse.name()), new CourseDuration(requestedCourse.duration()));

        creator.create(requestedCourse);

        verify(repository, atLeastOnce()).save(course);
    }
}