package carlos.projects.mooc.steps.infrastructure.persistence;


import carlos.projects.mooc.steps.domain.Step;
import carlos.projects.mooc.steps.domain.StepId;
import carlos.projects.mooc.steps.domain.StepRepository;
import carlos.projects.shared.domain.Service;
import carlos.projects.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class MySqlStepRepository extends HibernateRepository<Step> implements StepRepository {
    public MySqlStepRepository(SessionFactory sessionFactory) {
        super(sessionFactory, Step.class);
    }

    @Override
    public void save(Step step) {
        persist(step);
    }

    @Override
    public Optional<? extends Step> search(StepId id) {
        return byId(id);
    }
}