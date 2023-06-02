package carlos.projects.mooc.courses.application.create;

import carlos.projects.mooc.courses.domain.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public final class CourseCreator {
    private CourseRepository repository;

    public CourseCreator(@Qualifier("mySqlCourseRepository") CourseRepository repository) {
        this.repository = repository;
    }

    public void create(CreateCourseRequestDTO request) {
        Course course = new Course(new CourseId(request.id()), new CourseName(request.name()), new CourseDuration(request.duration()));

        repository.save(course);
    }
}
