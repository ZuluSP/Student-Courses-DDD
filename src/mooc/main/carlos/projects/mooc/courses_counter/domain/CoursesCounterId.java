package carlos.projects.mooc.courses_counter.domain;


import carlos.projects.shared.domain.Identifier;

public final class CoursesCounterId extends Identifier {
    public CoursesCounterId(String value) {
        super(value);
    }

    private CoursesCounterId() {
    }
}
