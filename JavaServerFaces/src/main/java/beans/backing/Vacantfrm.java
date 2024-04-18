package beans.backing;

import beans.model.Candidate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class Vacantfrm {

    @Inject
    private Candidate candidate;

    Logger log = LogManager.getRootLogger();

    public void setCandidate(Candidate candidate){
        this.candidate = candidate;
    }

    //public Candidate getCandidate(){
      //  return candidate;
    //}

    public String send(){
        if(this.candidate.getName().equals("NameTest")){
            log.info("Into success case");
            return "success";
        }
        else {
            log.info("Into error case");
            return "error";
        }
    }

}
