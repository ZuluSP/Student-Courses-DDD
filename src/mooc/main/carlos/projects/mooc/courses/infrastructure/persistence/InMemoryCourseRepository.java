package carlos.projects.mooc.courses.infrastructure.persistence;

import carlos.projects.mooc.courses.domain.Course;
import carlos.projects.mooc.courses.domain.CourseId;
import carlos.projects.mooc.courses.domain.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public class InMemoryCourseRepository implements CourseRepository {
    private HashMap<CourseId, Course> courses = new HashMap<>();

    @Override
    public void save(Course course) {
        this.courses.put(course.id(), course);
    }

    @Override
    public Optional<Course> search(CourseId id) {
        return Optional.ofNullable(courses.get(id));
    }
}
