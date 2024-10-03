package service.interfaces;

import domain.Assignment;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface AssignmentService {
    public List<Assignment> findAll();

    public Assignment findById(Assignment assignment);

    public void save(Assignment assignment);

    public void delete(Assignment assignment);

    public void update(Assignment assignment);
}
