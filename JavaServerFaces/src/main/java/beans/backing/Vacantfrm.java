package beans.backing;

import beans.model.Candidate;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class Vacantfrm {

    @Inject
    private Candidate candidate;

    public void setCandidate(Candidate candidate){
        this.candidate = candidate;
    }

    public Candidate getCandidate(){
        return candidate;
    }

    public String send(){
        if(this.candidate.getName().equals("NameTest")){
            return "success";
        }
        else {
            return "error";
        }
    }

}
