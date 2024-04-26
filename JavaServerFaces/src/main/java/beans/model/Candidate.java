package beans.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.Date;

@Named
@RequestScoped
public class Candidate {

    private String name;
    private String lastName;
    private int desiredSalary;
    private Date bornDate;
    private int postalCode;
    private String neighborhood;
    private String city;
    private String commentary;

    Logger log = LogManager.getRootLogger();

    public Candidate(){}

    public Candidate(String name, String lastName, int desiredSalary) {
        this.name = name;
        this.lastName = lastName;
        this.desiredSalary = desiredSalary;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
        log.info("setting name property " + this.name);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDesiredSalary() {
        return desiredSalary;
    }

    public void setDesiredSalary(int desiredSalary) {
        this.desiredSalary = desiredSalary;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }
}