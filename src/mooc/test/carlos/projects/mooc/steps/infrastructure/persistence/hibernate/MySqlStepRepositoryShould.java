package carlos.projects.mooc.steps.infrastructure.persistence.hibernate;

import carlos.projects.mooc.steps.StepsModuleInfrastructureTestCase;
import carlos.projects.mooc.steps.domain.Step;
import carlos.projects.mooc.steps.domain.StepIdMother;
import carlos.projects.mooc.steps.domain.challenge.ChallengeStepMother;
import carlos.projects.mooc.steps.domain.video.VideoStepMother;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@Transactional
class MySqlStepRepositoryShould extends StepsModuleInfrastructureTestCase {
    @Test
    void save_a_step() {
        for (Step step : steps()) {
            repository.save(step);
        }
    }

    @Test
    void return_an_existing_step() {
        for (Step step : steps()) {
            repository.save(step);

            assertEquals(Optional.of(step), repository.search(step.id()));
        }
    }

    @Test
    void not_return_a_non_existing_course() {
        assertFalse(repository.search(StepIdMother.random()).isPresent());
    }

    private List<? extends Step> steps() {
        return Arrays.asList(ChallengeStepMother.random(), VideoStepMother.random());
    }
}