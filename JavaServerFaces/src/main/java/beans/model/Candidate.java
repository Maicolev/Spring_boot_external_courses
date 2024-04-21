package beans.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Candidate {

    private String name;
    private String lastName;
    private int desiredSalary;

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
}