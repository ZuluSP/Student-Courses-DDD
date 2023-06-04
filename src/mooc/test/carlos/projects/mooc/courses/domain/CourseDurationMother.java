package carlos.projects.mooc.courses.domain;

import carlos.projects.shared.domain.IntegerMother;
import carlos.projects.shared.domain.RandomElementPicker;

public class CourseDurationMother {
    public static CourseDuration create(String value) {
        return new CourseDuration(value);
    }

    public static CourseDuration random() {
        return create(
                String.format(
                        "%s %s",
                        IntegerMother.random(),
                        RandomElementPicker.from("years", "months", "days", "hours", "minutes", "seconds")
                )
        );

    }
}
