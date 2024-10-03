package data.impl;

import data.interfaces.ContactDAO;
import domain.Contact;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class ContactDAOImpl extends GenericDAO implements ContactDAO {
    @Override
    public List<Contact> findAll() {
        return em.createNamedQuery("Contact.findAll", Contact.class).getResultList();
    }

    @Override
    public Contact findById(Contact contact) {
        return em.find(contact.getClass(), contact.getId());
    }

    @Override
    public void save(Contact contact) {
        em.persist(contact);
    }

    @Override
    public void delete(Contact contact) {
        em.remove(contact);
    }

    @Override
    public void update(Contact contact) {
        em.merge(contact);
    }
}
