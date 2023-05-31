package carlos.projects.mooc.courses.domain;

import java.util.Objects;

public final class Course {

    private final CourseId id;
    private final CourseName name;
    private final CourseDuration duration;

    public Course(CourseId id, CourseName name, CourseDuration duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
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
