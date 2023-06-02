package carlos.projects.mooc.courses.domain;

import carlos.projects.shared.domain.Identifier;

import java.util.UUID;

public final class CourseId extends Identifier {
    public CourseId(String value) {
        super(value);
    }

    // This constructor is needed for Hibernate, because when it works with reflexion (in our case it does) what
    // expects is an empty instance of each field (CourseId in this case). At least, we can do it private,
    // so we make sure no one can create an empty instance except hibernate.
    private CourseId() {
        super(null);
    }
}
