package data.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public abstract class GenericDAO {
    @PersistenceContext(unitName = "CoursesPersistence")
    protected EntityManager em;
}
