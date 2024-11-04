package service.interfaces;

import domain.Address;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface AddressService {
    public List<Address> findAll();

    public Address findById(Address address);

    public void save(Address address);

    public void delete(Address address);

    public void update(Address address);
}
