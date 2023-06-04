package carlos.projects.mooc;

import carlos.projects.shared.insfrastructure.InfrastructureTestCase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import carlos.projects.apps.mooc.MoocBackendApplication;

@ContextConfiguration(classes = MoocBackendApplication.class)
@SpringBootTest
public abstract class ContextInfrastructureTestCase extends InfrastructureTestCase {
}