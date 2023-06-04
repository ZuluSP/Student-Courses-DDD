package carlos.projects.mooc.courses;

import carlos.projects.mooc.MoocContextInfrastructureTestCase;
import carlos.projects.mooc.courses.domain.CourseRepository;
import carlos.projects.mooc.courses.infrastructure.persistence.InMemoryCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CoursesModuleInfrastructureTestCaseMooc extends MoocContextInfrastructureTestCase {
    protected InMemoryCourseRepository repository = new InMemoryCourseRepository();

    @Autowired
    protected CourseRepository mySqlCourseRepository;
}
