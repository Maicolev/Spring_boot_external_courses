package domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Person.findAll", query = "select p from Person p order by p.id")
})
@Table(name = "PERSON")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq")
    @SequenceGenerator(name = "person_seq", sequenceName = "PERSON_SEQ", allocationSize = 1)
    @Column(name = "PERSON_ID", nullable = false)
    private Long id;

    @Column(name = "AGE")
    private Long age;

    @Size(max = 255)
    @Column(name = "FIRSTNAME")
    private String firstname;

    @Size(max = 255)
    @Column(name = "LASTNAME")
    private String lastname;

    @Size(max = 255)
    @Column(name = "PHONE")
    private String phone;

    @Size(max = 50)
    @Column(name = "EMAIL", length = 50)
    private String email;

    @OneToMany(mappedBy = "person")
    private List<User> users;

    public Person(){}

    public Person(Long id, Long age, String firstname, String lastname, String phone, String email) {
        this.id = id;
        this.age = age;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", age=" + age +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}