package domain;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@NamedQuery(name = "Assignment.findAll", query = "SELECT a FROM Assignment a")
public class Assignment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "assignment_seq")
    @SequenceGenerator(name = "assignment_seq", sequenceName = "assignment_seq", allocationSize = 1)
    @Column(name = "id_assignment", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="id_student",referencedColumnName = "id_student")
    private Student student;

    @ManyToOne
    @JoinColumn(name="id_course",referencedColumnName = "id_course")
    private Course course;

    private String turn;

    public Long getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getTurn() {
        return turn;
    }

    public void setTurn(String turn) {
        this.turn = turn;
    }
}
