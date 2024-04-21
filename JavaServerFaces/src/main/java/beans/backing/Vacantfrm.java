package beans.backing;

import beans.model.Candidate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
        if(this.candidate.getName().equals("Karol")){
            if(this.candidate.getLastName().equals("Trujillo")){
                String msg = "Thanks, but Karol Trujillo is already working with us";
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
                FacesContext facesContext = FacesContext.getCurrentInstance();
                String componentId = null; // this is a global message
                facesContext.addMessage(componentId, facesMessage);
                return "index";
            }
            log.info("Into success case");
            return "success";
        }
        else {
            log.info("Into error case");
            return "error";
        }
    }

}
