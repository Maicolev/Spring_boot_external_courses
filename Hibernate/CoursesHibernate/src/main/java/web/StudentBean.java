package web;

import domain.Address;
import domain.Contact;
import domain.Student;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
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
        this.studentSelected.setAddress(new Address());
        this.studentSelected.setContact(new Contact());
    }

    public void editListener(RowEditEvent event) {
        logger.info("Edited Student logger" + " start row edit");
        Student student = (Student) event.getObject();
        logger.info("Edited Student logger" + student.toString());
        studentService.update(student);
    }

    public Student getStudentSelected () {
        return studentSelected;
    }

    public void setStudentSelected(Student studentSelected) {
        this.studentSelected = studentSelected;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void add() {
        logger.info("into add method");

        // Verificar que los objetos Address y Contact estén correctamente inicializados
        if (studentSelected.getAddress() != null && studentSelected.getContact() != null) {
            logger.info("street: "     + studentSelected.getAddress().getStreet());
            logger.info("Id contact: " + studentSelected.getContact().getId());
            logger.info("email contact: " + studentSelected.getContact().getEmail());
            logger.info("Id address: " + studentSelected.getAddress().getId());

            // Guarda el estudiante
            this.studentService.save(studentSelected);
            this.students.add(studentSelected);

            // Reiniciar para la siguiente adición
            this.studentSelected = new Student();
            this.studentSelected.setAddress(new Address());
            this.studentSelected.setContact(new Contact());
        } else {
            logger.error("Address or Contact is not initialized.");
        }
    }


    public void remove() {
        this.studentService.delete(studentSelected);
        this.students.remove(this.studentSelected);
        this.studentSelected = null;
    }

    public void restartStudentSelected() {
        this.studentSelected = new Student();
        this.studentSelected.setAddress(new Address());
        this.studentSelected.setContact(new Contact());
    }
}
