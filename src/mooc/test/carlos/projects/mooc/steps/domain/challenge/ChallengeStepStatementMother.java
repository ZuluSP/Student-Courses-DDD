package carlos.projects.mooc.steps.domain.challenge;

import carlos.projects.shared.domain.WordMother;

public final class ChallengeStepStatementMother {
    public static ChallengeStepStatement create(String value) {
        return new ChallengeStepStatement(value);
    }

    public static ChallengeStepStatement random() {
        return create(WordMother.random());
    }
}
