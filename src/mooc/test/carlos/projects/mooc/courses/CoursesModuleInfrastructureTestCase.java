package carlos.projects.mooc.courses;

import carlos.projects.mooc.ContextInfrastructureTestCase;
import carlos.projects.mooc.courses.domain.CourseRepository;
import carlos.projects.mooc.courses.infrastructure.persistence.InMemoryCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CoursesModuleInfrastructureTestCase extends ContextInfrastructureTestCase {
    protected InMemoryCourseRepository repository = new InMemoryCourseRepository();

    @Autowired
    protected CourseRepository mySqlCourseRepository;
}
