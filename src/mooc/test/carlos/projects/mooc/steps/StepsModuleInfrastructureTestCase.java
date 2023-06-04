package carlos.projects.mooc.steps;

import carlos.projects.mooc.MoocContextInfrastructureTestCase;
import carlos.projects.mooc.steps.domain.StepRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class StepsModuleInfrastructureTestCase extends MoocContextInfrastructureTestCase {
    @Autowired
    protected StepRepository repository;
}