package carlos.projects.mooc.courses_counter.application.increment;


import carlos.projects.mooc.courses.domain.CourseId;
import carlos.projects.mooc.courses_counter.domain.CoursesCounter;
import carlos.projects.mooc.courses_counter.domain.CoursesCounterRepository;
import carlos.projects.shared.domain.Service;
import carlos.projects.shared.domain.UuidGenerator;


@Service
public final class CoursesCounterIncrementer {
    private CoursesCounterRepository repository;
    private UuidGenerator uuidGenerator;

    public CoursesCounterIncrementer(CoursesCounterRepository repository, UuidGenerator uuidGenerator) {
        this.repository    = repository;
        this.uuidGenerator = uuidGenerator;
    }

    public void increment(CourseId id) {
        // we use the lamda to not execute the expression directly and doing it only if the search doesn't find anything.
        CoursesCounter counter = repository.search()
                                           .orElseGet(() -> CoursesCounter.initialize(uuidGenerator.generate()));

            counter.increment(id);

            repository.save(counter);
    }
}
