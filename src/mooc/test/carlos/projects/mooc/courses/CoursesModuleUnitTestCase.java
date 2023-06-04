package carlos.projects.mooc.courses;

import carlos.projects.mooc.courses.domain.Course;
import carlos.projects.mooc.courses.domain.CourseRepository;
import carlos.projects.shared.insfrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.*;

public class CoursesModuleUnitTestCase extends UnitTestCase {

    protected CourseRepository repository;

    @BeforeEach
    protected void setUp() {
       repository = mock(CourseRepository.class);
    }

    protected void shouldHaveSaved(Course course) {
        verify(repository, atLeastOnce()).save(course);
    }
}
