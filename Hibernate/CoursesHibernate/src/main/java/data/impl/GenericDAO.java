package data.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class GenericDAO {
    @PersistenceContext(unitName = "CoursesPersistence")
    EntityManager em;
}
