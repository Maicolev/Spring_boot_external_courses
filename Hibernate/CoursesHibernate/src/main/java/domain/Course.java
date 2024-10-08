package domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    @SequenceGenerator(name = "course_seq", sequenceName = "course_seq", allocationSize = 1)
    @Column(name = "id_course", nullable = false)
    private Long idCourse;

    @Column(name = "course_name")
    private String courseName;

    private String price;

    @OneToMany (mappedBy = "course")
    private List<Assignment> assignments;

    public Course() {}

    public Course(Long idCourse) {
        this.idCourse = idCourse;
    }

    public Long getIdCourse() {
        return idCourse;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }
}
