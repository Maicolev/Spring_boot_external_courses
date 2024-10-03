package data.impl;

import data.interfaces.StudentDAO;
import domain.Student;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class StudentDAOImpl extends GenericDAO implements StudentDAO {
    @Override
    public List<Student> findAll() {
        return em.createNamedQuery("Student.findAll", Student.class).getResultList();
    }

    @Override
    public Student findById(Student student) {
        return em.find(student.getClass(), student.getId());
    }

    @Override
    public void save(Student student) {
        em.persist(student);
    }

    @Override
    public void delete(Student student) {
        em.remove(student);
    }

    @Override
    public void update(Student student) {
        em.merge(student);
    }
}
