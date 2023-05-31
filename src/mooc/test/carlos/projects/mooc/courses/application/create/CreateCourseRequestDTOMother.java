package carlos.projects.mooc.courses.application.create;

import carlos.projects.mooc.courses.domain.*;

public final class CreateCourseRequestDTOMother {
    public static CreateCourseRequestDTO create(CourseId id, CourseName name, CourseDuration duration) {
        return new CreateCourseRequestDTO(id.value(), name.value(), duration.value());
    }

    public static CreateCourseRequestDTO random() {
        return create(CourseIdMother.random(), CourseNameMother.random(), CourseDurationMother.random());
    }
}
