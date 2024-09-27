package data.interfaces;

import domain.Course;

import java.util.List;

public interface CourseDAO {
    public List<Course> findAll();

    public Course findById(Course Course);

    Course findCourseByEmail(Course Course);

    public void save(Course Course);

    public void delete(Course Course);

    public void update(Course Course);
}
