package carlos.projects.mooc.courses_counter.infrastructure.persistence;

import carlos.projects.mooc.courses_counter.domain.CoursesCounter;
import carlos.projects.mooc.courses_counter.domain.CoursesCounterRepository;
import carlos.projects.shared.domain.Service;
import carlos.projects.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MySqlCoursesCounterRepository extends HibernateRepository<CoursesCounter> implements CoursesCounterRepository {
    public MySqlCoursesCounterRepository(@Qualifier("mooc-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, CoursesCounter.class);
    }

    @Override
    public void save(CoursesCounter counter) {
        persist(counter);
    }

    @Override
    public Optional<CoursesCounter> search() {
        List<CoursesCounter> coursesCounter = all();

        return 0 == coursesCounter.size() ? Optional.empty() : Optional.ofNullable(coursesCounter.get(0));
    }
}
