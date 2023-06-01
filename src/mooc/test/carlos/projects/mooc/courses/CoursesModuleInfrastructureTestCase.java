package carlos.projects.mooc.courses;

import carlos.projects.mooc.courses.infrastructure.InMemoryCourseRepository;
import carlos.projects.shared.insfrastructure.InfrastructureTestCase;
import org.springframework.beans.factory.annotation.Autowired;

public class CoursesModuleInfrastructureTestCase extends InfrastructureTestCase {
    @Autowired
    protected InMemoryCourseRepository repository;
}
