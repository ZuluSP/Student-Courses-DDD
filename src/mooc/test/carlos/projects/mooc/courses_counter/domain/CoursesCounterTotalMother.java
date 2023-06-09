package carlos.projects.mooc.courses_counter.domain;


import carlos.projects.shared.domain.IntegerMother;

public final class CoursesCounterTotalMother {
    public static CoursesCounterTotal create(Integer value) {
        return new CoursesCounterTotal(value);
    }

    public static CoursesCounterTotal random() {
        return create(IntegerMother.random());
    }

    public static CoursesCounterTotal one() {
        return create(1);
    }
}
