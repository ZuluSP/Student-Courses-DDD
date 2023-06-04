package carlos.projects.mooc.courses_counter.domain;

import carlos.projects.shared.domain.IntValueObject;

public final class CoursesCounterTotal extends IntValueObject {
    public CoursesCounterTotal(Integer value) {
        super(value);
    }

    public CoursesCounterTotal() {
        super(null);
    }

    public static CoursesCounterTotal initialize() {
        return new CoursesCounterTotal(0);
    }

    public CoursesCounterTotal increment() {
        // we create a new instance to not modify the mutability of the object so what we change is the status of the aggregate.
        return new CoursesCounterTotal(value() + 1);
    }
}
