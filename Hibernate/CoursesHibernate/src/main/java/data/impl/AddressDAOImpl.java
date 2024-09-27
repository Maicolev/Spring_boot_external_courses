package data.impl;

import data.interfaces.AddressDAO;
import domain.Address;

import java.util.List;

public class AddressDAOImpl implements AddressDAO {
    @Override
    public List<Address> findAll() {
        return List.of();
    }

    @Override
    public Address findById(Address Address) {
        return null;
    }

    @Override
    public Address findAddressByEmail(Address Address) {
        return null;
    }

    @Override
    public void save(Address Address) {

    }

    @Override
    public void delete(Address Address) {

    }

    @Override
    public void update(Address Address) {

    }
}
