package carlos.projects.shared.domain;

import net.datafaker.Faker;

public final class WordMother {
    public static String random() {
        return MotherCreator.random().lorem().toString();
    }
}
