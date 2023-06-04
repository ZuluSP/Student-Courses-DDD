package carlos.projects.mooc.courses_counter;

import carlos.projects.mooc.MoocContextInfrastructureTestCase;
import carlos.projects.mooc.courses_counter.domain.CoursesCounterRepository;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class CoursesCounterModuleInfrastructureTestCase extends MoocContextInfrastructureTestCase {
    @Autowired
    protected CoursesCounterRepository repository;
}
