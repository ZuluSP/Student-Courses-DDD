package carlos.projects.mooc.courses.domain;

import carlos.projects.shared.domain.Identifier;

import java.util.UUID;

public final class CourseId extends Identifier {
    public CourseId(String value) {
        super(value);
    }
}
