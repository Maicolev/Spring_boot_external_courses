package service.interfaces;

import domain.Address;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface AddressService {
    public List<Address> findAll();

    public Address findById(Address Address);

    public void save(Address Address);

    public void delete(Address Address);

    public void update(Address Address);
}
