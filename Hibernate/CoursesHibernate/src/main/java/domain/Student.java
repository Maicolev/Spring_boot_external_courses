package domain;



import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@NamedQuery(name = "Student.findAll", query = "SELECT a FROM Student a")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    @SequenceGenerator(name = "student_seq", sequenceName = "student_seq", allocationSize = 1)
    @Column(name = "id_student", nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address", referencedColumnName = "id_address")
    private Address address;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_contact", referencedColumnName = "id_contact")
    private Contact contact;

    private String name;

    @OneToMany (mappedBy = "student")
    private List<Assignment> assignments;

    @Column(name = "last_name")
    private String lastName;

    public Student() {}

    public Student(Address idAddress) {
        this.address = idAddress;
    }
    public Long getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address idAddress) {
        this.address = idAddress;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact idContact) {
        this.contact = idContact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", address=" + address +
                ", contact=" + contact +
                ", name='" + name + '\'' +
                ", assignments=" + assignments +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
