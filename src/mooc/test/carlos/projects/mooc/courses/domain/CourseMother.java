package carlos.projects.mooc.courses.domain;

import carlos.projects.mooc.courses.application.create.CreateCourseRequestDTO;

public final class CourseMother {
    public static Course create(CourseId id, CourseName name, CourseDuration duration) {
        return new Course(id, name, duration);
    }

    public static Course fromRequest(CreateCourseRequestDTO request) {
        return create(
                CourseIdMother.create(request.id()),
                CourseNameMother.create(request.name()),
                CourseDurationMother.create(request.duration())
        );
    }

    public static Course random() {
        return create(CourseIdMother.random(), CourseNameMother.random(), CourseDurationMother.random());
    }
}
