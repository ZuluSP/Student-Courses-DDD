package carlos.projects.mooc.courses.infrastructure.persistence;


import carlos.projects.mooc.courses.domain.Course;
import carlos.projects.mooc.courses.domain.CourseId;
import carlos.projects.mooc.courses.domain.CourseRepository;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class MySqlCourseRepository implements CourseRepository {
    // This comes automatically because of the Autowire.
    private SessionFactory sessionFactory;
    public MySqlCourseRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    @Override
    public void save(Course course) {
            sessionFactory.getCurrentSession().save(course);
    }

    @Override
    public Optional<Course> search(CourseId id) {
        return Optional.empty();
    }

}