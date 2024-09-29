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
    public Address findById(Address Address) {
        return em.find(Address.getClass(), Address.getId());
    }

    @Override
    public void save(Address Address) {
        em.persist(Address);
    }

    @Override
    public void delete(Address Address) {
        em.remove(Address);
    }

    @Override
    public void update(Address Address) {
        em.merge(Address);
    }
}
