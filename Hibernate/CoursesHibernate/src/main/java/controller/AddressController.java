package controller;

import domain.Address;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import service.interfaces.AddressService;

import java.util.List;

@Path("/ad")
@Stateless
public class AddressController {

    @Inject
    private AddressService addressService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Address> getAddresses() {
        return addressService.findAll();
    }
}
