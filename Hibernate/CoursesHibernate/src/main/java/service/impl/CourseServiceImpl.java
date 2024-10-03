package service.impl;

import data.interfaces.CourseDAO;
import domain.Course;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import service.interfaces.CourseService;

import java.util.List;

@Stateless
public class CourseServiceImpl implements CourseService {

    @Inject
    private CourseDAO courseDAO;

    @Override
    public List<Course> findAll() {
        return courseDAO.findAll();
    }

    @Override
    public Course findById(Course course) {
        return courseDAO.findById(course);
    }

    @Override
    public void save(Course course) {
        courseDAO.save(course);
    }

    @Override
    public void delete(Course course) {
        courseDAO.delete(course);
    }

    @Override
    public void update(Course course) {
        courseDAO.update(course);
    }
}
