package carlos.projects.mooc.courses.infrastructure.persistence;

import carlos.projects.mooc.courses.CoursesModuleInfrastructureTestCaseMooc;
import carlos.projects.mooc.courses.domain.Course;
import carlos.projects.mooc.courses.domain.CourseIdMother;
import carlos.projects.mooc.courses.domain.CourseMother;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@Transactional
class MySqlCourseRepositoryShould extends CoursesModuleInfrastructureTestCaseMooc {
    @Test
    void save_a_course() {
        Course course = CourseMother.random();

        mySqlCourseRepository.save(course);
    }

    @Test
    void return_an_existing_course() {
        Course course = CourseMother.random();

        mySqlCourseRepository.save(course);

        assertEquals(Optional.of(course), mySqlCourseRepository.search(course.id()));
    }

    @Test
    void not_return_a_non_existing_course() {
        assertFalse(mySqlCourseRepository.search(CourseIdMother.random()).isPresent());
    }
}
