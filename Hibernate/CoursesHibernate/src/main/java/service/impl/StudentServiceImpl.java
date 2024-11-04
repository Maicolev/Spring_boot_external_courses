package service.impl;

import data.interfaces.StudentDAO;
import domain.Address;
import domain.Contact;
import domain.Student;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import service.interfaces.StudentService;

import java.util.List;

@Stateless
public class StudentServiceImpl implements StudentService {

    @Inject
    private StudentDAO studentDAO;

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public Student findById(Student student) {
        return studentDAO.findById(student);
    }

    @Override
    public void save(Student student) {
        studentDAO.save(student);
    }

    @Override
    public void delete(Student student) {
        studentDAO.delete(student);
    }

    @Override
    public void update(Student student) {
        studentDAO.update(student);
    }
}
