package data.interfaces;

import domain.Assignment;

import java.util.List;

public interface AssignmentDAO {
    public List<Assignment> findAll();

    public Assignment findById(Assignment Assignment);

    Assignment findAssignmentByEmail(Assignment Assignment);

    public void save(Assignment Assignment);

    public void delete(Assignment Assignment);

    public void update(Assignment Assignment);
}
