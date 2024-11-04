package service.impl;

import data.interfaces.AssignmentDAO;
import domain.Assignment;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import service.interfaces.AssignmentService;

import java.util.List;

@Stateless
public class AssignmentServiceImpl implements AssignmentService {

    @Inject
    private AssignmentDAO assignmentDAO;

    @Override
    public List<Assignment> findAll() {
        return assignmentDAO.findAll();
    }

    @Override
    public Assignment findById(Assignment assignment) {
        return assignmentDAO.findById(assignment);
    }

    @Override
    public void save(Assignment assignment) {
        assignmentDAO.save(assignment);
    }

    @Override
    public void delete(Assignment assignment) {
        assignmentDAO.delete(assignment);
    }

    @Override
    public void update(Assignment assignment) {
        assignmentDAO.update(assignment);
    }
}
