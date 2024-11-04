package data.interfaces;

import domain.Address;

import java.util.List;

public interface AddressDAO {
    public List<Address> findAll();

    public Address findById(Address Address);

    public void save(Address Address);

    public void delete(Address Address);

    public void update(Address Address);
}
