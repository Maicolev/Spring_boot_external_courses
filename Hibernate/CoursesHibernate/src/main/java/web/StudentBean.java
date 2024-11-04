package web;

import domain.Address;
import domain.Contact;
import domain.Student;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.primefaces.event.RowEditEvent;
import service.interfaces.AddressService;
import service.interfaces.ContactService;
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

    @Inject
    private AddressService addressService;

    @Inject
    private ContactService contactService;

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

    public Student getStudentSelected() {
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
            //logger.info("street: "     + studentSelected.getAddress().getStreet());

            // Persistir Address y Contact si no están ya persistidos

            if (studentSelected.getContact().getId() == null) {
                logger.info("pre contact id: "     + studentSelected.getContact().getId());
                contactService.save(studentSelected.getContact());
                logger.info("post contact id: "     + studentSelected.getContact().getId());
            }

            if (studentSelected.getAddress().getId() == null) {
                logger.info("pre address id: "     + studentSelected.getAddress().getId());
                addressService.save(studentSelected.getAddress());
                logger.info("post address id: "     + studentSelected.getAddress().getId());
            }

            //studentSelected.setAddress(studentSelected.getAddress());

            // Guarda el estudiante
            this.studentService.save(studentSelected);
            this.students.add(studentSelected);

            logger.info("post save address id: "     + studentSelected.getAddress().getId());

        } else {
            logger.error("Address or Contact is not initialized.");
        }
        restartStudentSelected();
    }

    public void restartStudentSelected() {
        this.studentSelected = new Student();
        this.studentSelected.setAddress(new Address());
        this.studentSelected.setContact(new Contact());
    }
}