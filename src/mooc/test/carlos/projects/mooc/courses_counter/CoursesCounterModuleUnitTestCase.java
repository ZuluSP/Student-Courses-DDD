package carlos.projects.mooc.courses_counter;

import carlos.projects.mooc.courses_counter.domain.CoursesCounter;
import carlos.projects.mooc.courses_counter.domain.CoursesCounterRepository;
import carlos.projects.shared.insfrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.Mockito.*;

public abstract class CoursesCounterModuleUnitTestCase extends UnitTestCase {
    protected CoursesCounterRepository repository;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        repository = mock(CoursesCounterRepository.class);
    }

    public void shouldSearch(CoursesCounter course) {
        Mockito.when(repository.search()).thenReturn(Optional.of(course));
    }

    public void shouldSearch() {
        Mockito.when(repository.search()).thenReturn(Optional.empty());
    }

    public void shouldHaveSaved(CoursesCounter course) {
        verify(repository, atLeastOnce()).save(course);
    }
}
