package service.impl;

import data.interfaces.AddressDAO;
import domain.Address;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import service.interfaces.AddressService;

import java.util.List;

@Stateless
public class AddressServiceImpl implements AddressService {

    @Inject
    private AddressDAO addressDAO;

    @Override
    public List<Address> findAll() {
        return addressDAO.findAll();
    }

    @Override
    public Address findById(Address Address) {
        return addressDAO.findById(Address);
    }

    @Override
    public void save(Address Address) {
        addressDAO.save(Address);
    }

    @Override
    public void delete(Address Address) {
        addressDAO.delete(Address);
    }

    @Override
    public void update(Address Address) {
        addressDAO.update(Address);
    }
}
