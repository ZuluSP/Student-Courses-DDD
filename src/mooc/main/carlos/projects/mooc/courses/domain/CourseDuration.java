package carlos.projects.mooc.courses.domain;

import carlos.projects.shared.domain.StringValueObject;

public class CourseDuration extends StringValueObject {
    public CourseDuration(String value) {
        super(value);
    }

    // This constructor is needed for Hibernate, because when it works with reflexion (in our case it does) what
    // expects is an empty instance of each field (CourseDuration in this case). At least, we can do it private,
    // so we make sure no one can create an empty instance except hibernate.
    private CourseDuration() {
        super(null);
    }
}

