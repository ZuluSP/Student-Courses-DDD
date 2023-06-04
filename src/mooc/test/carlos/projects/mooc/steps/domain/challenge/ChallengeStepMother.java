package carlos.projects.mooc.steps.domain.challenge;

import carlos.projects.mooc.steps.domain.StepId;
import carlos.projects.mooc.steps.domain.StepIdMother;
import carlos.projects.mooc.steps.domain.StepTitle;
import carlos.projects.mooc.steps.domain.StepTitleMother;

public final class ChallengeStepMother {
    public static ChallengeStep create(StepId id, StepTitle title, ChallengeStepStatement statement) {
        return new ChallengeStep(id, title, statement);
    }

    public static ChallengeStep random() {
        return create(StepIdMother.random(), StepTitleMother.random(), ChallengeStepStatementMother.random());
    }
}