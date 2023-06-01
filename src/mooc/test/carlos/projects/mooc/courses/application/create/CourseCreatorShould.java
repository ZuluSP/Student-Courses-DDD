package carlos.projects.mooc.courses.application.create;

import carlos.projects.mooc.courses.CoursesModuleUnitTestCase;
import carlos.projects.mooc.courses.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

final class CourseCreatorShould extends CoursesModuleUnitTestCase {

    private CourseCreator creator;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        creator = new CourseCreator(repository);
    }

    @Test
    void create_a_valid_course() throws Exception {
        CreateCourseRequestDTO requestedCourse = CreateCourseRequestDTOMother.random();

        Course course = CourseMother.fromRequest(requestedCourse);

        creator.create(requestedCourse);

        shouldHaveSaved(course);
    }
}