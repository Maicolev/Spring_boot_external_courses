package service.interfaces;

import domain.Contact;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface ContactService {
    public List<Contact> findAll();

    public Contact findById(Contact contact);

    public void save(Contact contact);

    public void delete(Contact contact);

    public void update(Contact contact);
}
