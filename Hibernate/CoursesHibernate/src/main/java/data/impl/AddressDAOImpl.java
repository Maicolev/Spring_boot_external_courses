package data.impl;

import data.interfaces.AddressDAO;
import domain.Address;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class AddressDAOImpl extends GenericDAO implements AddressDAO {
    @Override
    public List<Address> findAll() {
        return em.createNamedQuery("Address.findAll", Address.class).getResultList();
    }

    @Override
    public Address findById(Address address) {
        return em.find(address.getClass(), address.getId());
    }

    @Override
    public void save(Address address) {
        em.persist(address);
    }

    @Override
    public void delete(Address address) {
        em.remove(address);
    }

    @Override
    public void update(Address address) {
        em.merge(address);
    }
}
