package carlos.projects.mooc.courses.infrastructure.persistence;


import carlos.projects.mooc.courses.domain.Course;
import carlos.projects.mooc.courses.domain.CourseId;
import carlos.projects.mooc.courses.domain.CourseRepository;

import carlos.projects.shared.domain.Service;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class MySqlCourseRepository implements CourseRepository {
    private SessionFactory sessionFactory;
    public MySqlCourseRepository(@Qualifier("mooc-session_factory")SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void save(Course course) {
            sessionFactory.getCurrentSession().save(course);
    }

    @Override
    public Optional<Course> search(CourseId id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().find(Course.class, id));
    }

}