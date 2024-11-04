package data.impl;

import data.interfaces.StudentDAO;
import domain.Student;
import jakarta.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import web.StudentBean;

import java.util.List;

@Stateless
public class StudentDAOImpl extends GenericDAO implements StudentDAO {
    private static Logger logger = LoggerFactory.getLogger(StudentBean.class);
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
        // Asegurarse de que Address y Contact estén correctamente persistidos
        logger.info("StudentDAOImpl" + student.toString());
        logger.info("StudentDAOImpl contact" + student.getContact().getId());
        logger.info("StudentDAOImpl address" + student.getAddress().getId());
        if (student.getAddress() != null && student.getContact() != null) {
            em.persist(student);
        } else {
            throw new IllegalArgumentException("Address or Contact is null");
        }
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
