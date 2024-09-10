package domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@NamedQueries({
        @NamedQuery(name = "User.findAll", query = "select u from User u order by u.id")
})
@Table(name = "\"USER\"")
public class User {
    @Id
    @Column(name = "USER_ID", nullable = false)
    private Long id;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_ID", nullable = false)
    private Person person;

    @Size(max = 50)
    @Column(name = "USERNAME", length = 50)
    private String username;

    @Size(max = 50)
    @Column(name = "PASSWORD", length = 50)
    private String password;

    public User(Long id, Person person, String username, String password) {
        this.id = id;
        this.person = person;
        this.username = username;
        this.password = password;
    }

    public User() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}