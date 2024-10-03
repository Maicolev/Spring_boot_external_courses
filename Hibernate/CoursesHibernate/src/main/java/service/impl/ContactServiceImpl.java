package service.impl;

import data.interfaces.ContactDAO;
import domain.Contact;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import service.interfaces.ContactService;

import java.util.List;

@Stateless
public class ContactServiceImpl implements ContactService {

    @Inject
    private ContactDAO contactDAO;

    @Override
    public List<Contact> findAll() {
        return contactDAO.findAll();
    }

    @Override
    public Contact findById(Contact contact) {
        return contactDAO.findById(contact);
    }

    @Override
    public void save(Contact contact) {
        contactDAO.save(contact);
    }

    @Override
    public void delete(Contact contact) {
        contactDAO.delete(contact);
    }

    @Override
    public void update(Contact contact) {
        contactDAO.update(contact);
    }
}
