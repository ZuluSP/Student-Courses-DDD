package carlos.projects.mooc.steps.domain;

import carlos.projects.shared.domain.StringValueObject;

public final class StepTitle extends StringValueObject {
    public StepTitle(String value) {
        super(value);
    }

    private StepTitle() {
        super(null);
    }
}