package carlos.projects.mooc.courses_counter.domain;

import java.util.Optional;

public interface CoursesCounterRepository {
    void save(CoursesCounter counter);

    Optional<CoursesCounter> search();
}
