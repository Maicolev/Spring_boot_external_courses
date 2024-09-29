package domain;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    @SequenceGenerator(name = "address_seq", sequenceName = "address_seq", allocationSize = 1)
    @Column(name = "id_address", nullable = false)
    private Long idAddress;

    private String street;

    private String city;

    private String state;

    public Address () {}

    public Address(Long idAddress) {
        this.idAddress = idAddress;
    }

    public Long getId() {return idAddress;}

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
