package data.interfaces;

import domain.Student;

import java.util.List;

public interface StudentDAO {
    public List<Student> findAll();

    public Student findById(Student Student);

    Student findStudentByEmail(Student Student);

    public void save(Student Student);

    public void delete(Student Student);

    public void update(Student Student);
}
