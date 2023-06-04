package carlos.projects.mooc.courses_counter.application.find;

import carlos.projects.mooc.courses_counter.domain.CoursesCounter;
import carlos.projects.mooc.courses_counter.domain.CoursesCounterNotInitialized;
import carlos.projects.mooc.courses_counter.domain.CoursesCounterRepository;
import carlos.projects.shared.domain.Service;

@Service
public final class CoursesCounterFinder {
    private CoursesCounterRepository repository;

    public CoursesCounterFinder(CoursesCounterRepository repository) {
        this.repository = repository;
    }

    public CoursesCounterResponse find() {
        CoursesCounter coursesCounter = repository.search().orElseGet(() -> {
            throw new CoursesCounterNotInitialized();
        });

        return new CoursesCounterResponse(coursesCounter.total().value());
    }
}
