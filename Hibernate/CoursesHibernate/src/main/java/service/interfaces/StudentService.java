package service.interfaces;

import domain.Student;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface StudentService {
    public List<Student> findAll();

    public Student findById(Student student);

    public void save(Student student);

    public void delete(Student student);

    public void update(Student student);
}
