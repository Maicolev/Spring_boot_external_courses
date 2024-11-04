package data.impl;

import data.interfaces.AddressDAO;
import domain.Address;
import jakarta.ejb.Stateless;
import jakarta.transaction.Transactional;

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
    @Transactional
    public void save(Address address) {
        if (address.getId() == null) {
            em.persist(address);
            em.flush(); // Asegura que el ID se genere y se sincronice
        } else {
            em.merge(address);
        }
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
