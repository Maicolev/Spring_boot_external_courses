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
    private String gender;
    private int desiredSalary;
    private Date bornDate;
    private int postalCode;
    private int neighborhoodId;
    private String city;
    private String commentary;

    Logger log = LogManager.getRootLogger();

    public Candidate(){}

    public Candidate(String name, String lastName, int desiredSalary) {
        this.name = name;
        this.lastName = lastName;
        this.desiredSalary = desiredSalary;
    }

    public Candidate(String name, String lastName, String gender, int desiredSalary, Date bornDate, int postalCode, int neighborhoodId, String city, String commentary) {
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.desiredSalary = desiredSalary;
        this.bornDate = bornDate;
        this.postalCode = postalCode;
        this.neighborhoodId = neighborhoodId;
        this.city = city;
        this.commentary = commentary;
    }

    public void setName(String name){
        this.name = name;
        log.info("setting name property " + this.name);
    }

    public String getName(){
        return name;
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

    public int getNeighborhoodId() {
        return neighborhoodId;
    }

    public void setNeighborhoodId(int neighborhoodId) {
        this.neighborhoodId = neighborhoodId;
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

    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }
}