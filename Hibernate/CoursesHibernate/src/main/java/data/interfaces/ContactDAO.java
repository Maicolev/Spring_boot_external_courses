package data.interfaces;

import domain.Contact;

import java.util.List;

public interface ContactDAO {
    public List<Contact> findAll();

    public Contact findById(Contact Contact);

    public void save(Contact Contact);

    public void delete(Contact Contact);

    public void update(Contact Contact);
}
