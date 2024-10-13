package web;

import domain.Student;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.OneToMany;
import org.primefaces.event.RowEditEvent;
import service.interfaces.StudentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Named("studentBean")
@RequestScoped
public class StudentBean {

    private static Logger logger = LoggerFactory.getLogger(StudentBean.class);

    @Inject
    private StudentService studentService;

    private Student studentSelected;

    List<Student> students;

    @PostConstruct
    public void initialize() {
        logger.info("Edited Student logger" + "start initialize");
        students = studentService.findAll();
        this.studentSelected = new Student();
    }

    public void editListener(RowEditEvent event) {
        logger.info("Edited Student logger" + " start row edit");
        Student student = (Student) event.getObject();
        logger.info("Edited Student logger" + student.toString());
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
