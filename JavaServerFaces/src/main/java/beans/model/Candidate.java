package beans.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Candidate {

    private String name = "Introduce your name";
    Logger log = LogManager.getRootLogger();

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
        log.info("setting name property " + this.name);
    }
}