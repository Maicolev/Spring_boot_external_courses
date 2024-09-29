package domain;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@NamedQuery(name = "Contact.findAll", query = "SELECT a FROM Contact a")
public class Contact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_seq")
    @SequenceGenerator(name = "contact_seq", sequenceName = "contact_seq", allocationSize = 1)
    @Column(name = "id_contact", nullable = false)
    private Long idContact;

    private String phone;

    private String email;

    public Contact() {}

    public Contact(String phone, String email) {
        this.phone = phone;
        this.email = email;
    }

    public Long getId() {
        return idContact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
