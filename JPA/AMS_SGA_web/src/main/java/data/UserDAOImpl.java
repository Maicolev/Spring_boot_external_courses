package data;

import domain.User;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

@Stateless
public class UserDAOImpl implements UserDAO {
    @PersistenceContext(unitName = "PersonPersistence")
    EntityManager em;

    @Override
    public List<User> findAll() {
        return em.createNamedQuery("User.findAll", User.class).getResultList();
    }

    @Override
    public User findById(User user) {
        return em.find(User.class, user.getId());
    }

    @Override
    public User findUserByUsername(User user) {
        Query query = em.createQuery(
                "from User u where u.username =: username"
        );
        query.setParameter("username", user.getUsername());

        return (User) query.getSingleResult();
    }

    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public void delete(User user) {
        em.remove(em.merge(user));
    }

    @Override
    public void update(User user) {
        em.remove(em.merge(user));
    }
}
