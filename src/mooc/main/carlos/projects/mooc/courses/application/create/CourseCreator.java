package carlos.projects.mooc.courses.application.create;

import carlos.projects.mooc.courses.domain.Course;
import carlos.projects.mooc.courses.domain.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public final class CourseCreator {
    private CourseRepository repository;

    public CourseCreator(CourseRepository repository) {
        this.repository = repository;
    }

    public void create(CreateCourseRequestDTO request) {
        Course course = new Course(request.id(), request.name(), request.duration());

        repository.save(course);
    }
}
