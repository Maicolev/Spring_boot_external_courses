package data.impl;

import data.interfaces.CourseDAO;
import domain.Course;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class CourseDAOImpl extends GenericDAO implements CourseDAO {
    @Override
    public List<Course> findAll() {
        return em.createNamedQuery("Course.findAll", Course.class).getResultList();
    }

    @Override
    public Course findById(Course course) {
        return em.find(course.getClass(), course.getId());
    }

    @Override
    public void save(Course course) {
        em.persist(course);
    }

    @Override
    public void delete(Course course) {
        em.remove(course);
    }

    @Override
    public void update(Course course) {
        em.merge(course);
    }
}
