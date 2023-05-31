package carlos.projects.mooc.courses;

import carlos.projects.mooc.courses.infrastructure.InMemoryCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CoursesModuleInfrastructureTestCase {
    @Autowired
    protected InMemoryCourseRepository repository;
}
