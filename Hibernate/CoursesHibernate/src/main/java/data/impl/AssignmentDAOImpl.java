package data.impl;

import data.interfaces.AssignmentDAO;
import domain.Assignment;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class AssignmentDAOImpl extends GenericDAO implements AssignmentDAO {
    @Override
    public List<Assignment> findAll() {
        return em.createNamedQuery("Assignment.findAll", Assignment.class).getResultList();
    }

    @Override
    public Assignment findById(Assignment assignment) {
        return em.find(assignment.getClass(), assignment.getId());
    }

    @Override
    public void save(Assignment assignment) {
        em.persist(assignment);
    }

    @Override
    public void delete(Assignment assignment) {
        em.remove(assignment);
    }

    @Override
    public void update(Assignment assignment) {
        em.merge(assignment);
    }
}
