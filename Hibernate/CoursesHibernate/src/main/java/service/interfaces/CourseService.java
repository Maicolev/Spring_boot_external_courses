package service.interfaces;

import domain.Course;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface CourseService {
    public List<Course> findAll();

    public Course findById(Course course);

    public void save(Course course);

    public void delete(Course course);

    public void update(Course course);
}
