package carlos.projects.mooc.courses.domain;

import carlos.projects.shared.domain.UuidMother;

public class CourseIdMother {
    public static CourseId create(String value) {
        return new CourseId(value);
    }

    public static CourseId random() {
        return create(UuidMother.random());
    }
}
