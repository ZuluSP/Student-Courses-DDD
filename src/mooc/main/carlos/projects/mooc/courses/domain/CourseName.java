package carlos.projects.mooc.courses.domain;

import carlos.projects.shared.domain.StringValueObject;

public final class CourseName extends StringValueObject {
    public CourseName(String value) {
        super(value);
    }

    // This constructor is needed for Hibernate, because when it works with reflexion (in our case it does) what
    // expects is an empty instance of each field (courseName in this case). At least, we can do it private,
    // so we make sure no one can create an empty instance except hibernate.
    private CourseName() {
        super(null);
    }
}
