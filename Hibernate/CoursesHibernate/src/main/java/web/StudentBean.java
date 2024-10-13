package web;

import domain.Student;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.primefaces.event.RowEditEvent;
import service.interfaces.StudentService;

import java.util.List;

@Named("studentBean")
@RequestScoped
public class StudentBean {

    @Inject
    private StudentService studentService;

    private Student studentSelected;

    List<Student> students;

    @PostConstruct
    public void initialize() {
        students = studentService.findAll();
        this.studentSelected = new Student();
    }

    public void editListener(RowEditEvent event) {
        Student student = (Student) event.getObject();
        studentService.update(student);
    }

    public Student getStudentSelected () {return studentSelected;}

    public void setStudentSelected(Student studentSelected){
        this.studentSelected = studentSelected;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void add(){
        this.studentService.save(studentSelected);
        this.students.add(studentSelected);
        this.studentSelected = null;
    }

    public void remove(){
        this.studentService.delete(studentSelected);
        this.students.remove(this.studentSelected);
        this.studentSelected = null;
    }

    public void restartStudentSelected(){
        this.studentSelected = new Student();
    }

}
