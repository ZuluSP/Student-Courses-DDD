package carlos.projects.mooc.courses.domain;
import carlos.projects.shared.domain.AggregateRoot;
import carlos.projects.shared.domain.course.CourseCreatedDomainEvent;

import java.util.Objects;

public final class Course extends AggregateRoot {

    private final CourseId id;
    private final CourseName name;
    private final CourseDuration duration;

    public Course(CourseId id, CourseName name, CourseDuration duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
    }
    private Course() {
        id       = null;
        name     = null;
        duration = null;
    }

    public static Course create(CourseId id, CourseName name, CourseDuration duration) {
        Course course = new Course(id, name, duration);

        course.record(new CourseCreatedDomainEvent(id.value(), name.value(), duration.value()));

        return course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id) && Objects.equals(name, course.name) && Objects.equals(duration, course.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, duration);
    }

    public CourseId id() {
        return id;
    }
    public CourseName name() {
        return name;
    }

    public CourseDuration duration() {
        return duration;
    }
}
